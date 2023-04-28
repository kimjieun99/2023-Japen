package com.kimjieun99.replyboard.service;

import com.kimjieun99.replyboard.dto.ReplyBoardDto;
import java.util.List;

public interface ReplyBoardService {
  public List<ReplyBoardDto> getAllReplyBoard();

  int insertBoard(ReplyBoardDto replyBoardDto);
  ReplyBoardDto getSelectedBoard(int no);
  int getMaxReGroup();
  int replyBoard(ReplyBoardDto replyBoardDto);
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  void updateHit(int no);
  int updateRelevel(ReplyBoardDto replyBoardDto);
}
