package com.kimjieun99.replyboard.dao;

import com.kimjieun99.replyboard.dto.ReplyBoardDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  List<ReplyBoardDto> getAllReplyBoard();
  int insertBoard(ReplyBoardDto replyBoardDto);
  ReplyBoardDto getSelectedBoard(int no);
  int getMaxReGroup();
  int replyBoard(ReplyBoardDto replyBoardDto);
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  void updateHit(int no);
  int updateRelevel(ReplyBoardDto replyBoardDto);
}
