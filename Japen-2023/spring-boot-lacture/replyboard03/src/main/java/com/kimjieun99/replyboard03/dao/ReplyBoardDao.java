package com.kimjieun99.replyboard03.dao;

import com.kimjieun99.replyboard03.dto.ReplyBoardDto;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyBoardDao {
  int insertBoard(ReplyBoardDto replyBoardDto);
  List<ReplyBoardDto> getAllBoardList(HashMap<String, Object> hashMap);
  //List<ReplyBoardDto> getSearchBoardList(String searchTxt);
  ReplyBoardDto getSelectOne(int no);
  int updateHit(int no);
  int getMaxReGroup();
  int insertReplyBoard(ReplyBoardDto replyBoardDto);
  int updateReLevel(ReplyBoardDto replyBoardDto);
  int deleteReplyBoard(ReplyBoardDto replyBoardDto);
  List<ReplyBoardDto> getSearchBoardList(String searchTxt);
  int modifyReplyBoard(ReplyBoardDto replyBoardDto);
  ReplyBoardDto getPrevSelect(int num);
  ReplyBoardDto getNextSelect(int num);
}
