package com.kimjieun99.replyboard03.service;

import com.kimjieun99.replyboard03.dao.MemberDao;
import com.kimjieun99.replyboard03.dto.MemberDto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberServicelmpl implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Value("${file.path}")
  public String uploadFolder;

  public int insertMember(MemberDto memberDto) {
    UUID uuid = UUID.randomUUID();
    String originalFile = memberDto.getOriginalFile().getOriginalFilename();
    String renameFile = uuid + "_" + originalFile;
    Path imgFilePath = Paths.get(uploadFolder + renameFile);

    memberDto.setOriginalFilePath(originalFile);
    memberDto.setRenameFilePath(renameFile);

    try {
      Files.write(imgFilePath, memberDto.getOriginalFile().getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }

    int result = memberDao.insertMember(memberDto);
    return result;
  }

  @Override
  public MemberDto loginMember(MemberDto memberDto) {
    MemberDto loginMemberDto = memberDao.loginMember(memberDto);
    return loginMemberDto;
  }
}
