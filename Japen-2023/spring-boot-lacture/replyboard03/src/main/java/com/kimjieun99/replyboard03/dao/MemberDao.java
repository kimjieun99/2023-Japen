package com.kimjieun99.replyboard03.dao;

import com.kimjieun99.replyboard03.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
  public int insertMember(MemberDto memberDto);

  public MemberDto loginMember(MemberDto memberDto);
}
