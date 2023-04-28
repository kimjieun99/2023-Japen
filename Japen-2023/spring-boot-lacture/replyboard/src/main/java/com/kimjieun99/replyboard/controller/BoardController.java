package com.kimjieun99.replyboard.controller;

import com.kimjieun99.replyboard.dto.ReplyBoardDto;
import com.kimjieun99.replyboard.service.ReplyBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.insertBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @PostMapping("/replyProcess")
  public String replyProcess(ReplyBoardDto replyBoardDto) {
    replyBoardService.insertReplyBoard(replyBoardDto);
    return "redirect:/board/list";
  }

  @GetMapping("/list")
  public String list(Model model) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllReplyBoard();
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/reply")
  public String reply(int no) {
    return "/board/reply";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    ReplyBoardDto boardDto = replyBoardService.getSelectedBoard(no);
    replyBoardService.updateHit(no);
    model.addAttribute("boardDto", boardDto);
    return "/board/view";
  }
}
