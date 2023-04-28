package com.kimjieun99.replyboard.service;

import com.kimjieun99.replyboard.dao.ReplyBoardDao;
import com.kimjieun99.replyboard.dto.ReplyBoardDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReplyBoardServiceImpl implements ReplyBoardService {

  @Autowired
  ReplyBoardDao replyBoardDao;

  public ReplyBoardServiceImpl() {
    log.info("==ReplyBoardService==");
  }

  public List<ReplyBoardDto> getAllReplyBoard() {
    return replyBoardDao.getAllReplyBoard();
  }

  public int insertBoard(ReplyBoardDto replyBoardDto) {
    int maxReGroup = getMaxReGroup();
    replyBoardDto.setReGroup(maxReGroup + 1);
    replyBoardDto.setReLevel(1);
    replyBoardDto.setReStep(1);
    return replyBoardDao.insertBoard(replyBoardDto);
  }

  public int replyBoard(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.replyBoard(replyBoardDto);
  }

  public int getMaxReGroup() {
    return replyBoardDao.getMaxReGroup();
  }

  public ReplyBoardDto getSelectedBoard(int no) {
    return replyBoardDao.getSelectedBoard(no);
  }

  public int insertReplyBoard(ReplyBoardDto replyBoardDto) {
    int reGroup = replyBoardDto.getReGroup();
    int reLevel = replyBoardDto.getReLevel();
    int reStep = replyBoardDto.getReStep();

    updateRelevel(replyBoardDto);

    replyBoardDto.setReGroup(reGroup);
    replyBoardDto.setReLevel(reLevel + 1);
    replyBoardDto.setReStep(reStep + 1);

    return replyBoardDao.insertReplyBoard(replyBoardDto);
  }

  public void updateHit(int no) {
    replyBoardDao.updateHit(no);
  }

  public int updateRelevel(ReplyBoardDto replyBoardDto) {
    return replyBoardDao.updateRelevel(replyBoardDto);
  }
}
