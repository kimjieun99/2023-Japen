package com.kimjieun99.ch04.service;

import com.kimjieun99.ch04.dao.BoardDao;
import com.kimjieun99.ch04.dto.BoardDto;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//3-tir
@Service
@Slf4j
public class BoardService {

  //실질적 코드 작성
  @Autowired
  BoardDao boardDao;

  public BoardService() {
    log.info("===boardService===");
  }

  public ArrayList<BoardDto> getAllBoard() {
    ArrayList<BoardDto> boardList = boardDao.getAllBoard();
    log.info("boardList==={}", boardList);
    return boardList;
  }

  public void insertBoard(BoardDto boardDto) {
    boardDao.insertBoard(boardDto);
  }

  public BoardDto getView(int no) {
    BoardDto boardDto = boardDao.getView(no);
    return boardDto;
  }

  public void modifyBoard(BoardDto boardDto) {
    boardDao.modifyBoard(boardDto);
  }

  public void deleteBoard(BoardDto boardDto) {
  }
}
