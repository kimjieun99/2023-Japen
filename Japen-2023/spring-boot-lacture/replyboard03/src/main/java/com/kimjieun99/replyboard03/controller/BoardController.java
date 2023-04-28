package com.kimjieun99.replyboard03.controller;

import com.kimjieun99.replyboard03.dto.ReplyBoardDto;
//import com.kimjieun99.replyboard03.dto.ReplyJsonDto;
import com.kimjieun99.replyboard03.service.ReplyBoardService;
import com.kimjieun99.replyboard03.utils.ScriptWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

  @Autowired
  ReplyBoardService replyBoardService;

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @GetMapping("/list")
  public String list(Model model, String category, String searchTxt) {
    List<ReplyBoardDto> boardList = replyBoardService.getAllBoardList(
      category,
      searchTxt
    );
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @GetMapping("/view")
  public String view(Model model, int no, int num) {
    replyBoardService.updateHit(no);
    ReplyBoardDto replyBoardDto = replyBoardService.getSelectOne(no);
    ReplyBoardDto prevBoardDto = replyBoardService.getPrevSelect(num);
    ReplyBoardDto nextBoardDto = replyBoardService.getNextSelect(num);

    model.addAttribute("replyBoardDto", replyBoardDto);
    model.addAttribute("prevBoardDto", prevBoardDto);
    model.addAttribute("nextBoardDto", nextBoardDto);

    return "/board/view";
  }

  @GetMapping("/reply")
  public String reply() {
    return "/board/reply";
  }

  @PostMapping("/writeProcess")
  public String writeProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttribute
  ) {
    replyBoardService.insertBoard(replyBoardDto);
    redirectAttribute.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @PostMapping("/replyProcess")
  public String replyProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    replyBoardService.insertBoard(replyBoardDto);
    redirectAttributes.addFlashAttribute("msg", "글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @GetMapping("/delete")
  public String delete() {
    return "/board/delete";
  }

  @GetMapping("/modify")
  public String modify() {
    return "/board/modify";
  }

  @PostMapping("/deleteProcess")
  public String deleteProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    int result = replyBoardService.deleteReplyBoard(replyBoardDto);
    int no = replyBoardDto.getNo();
    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "삭제되었습니다.");
      return "redirect:/board/list";
    } else {
      redirectAttributes.addFlashAttribute("msg", "비밀번호를 확인해 주세요.");
      return "redirect:/board/delete?no=" + no;
    }
  }

  @GetMapping("/searchList")
  public String search(
    ReplyBoardDto replyBoardDto,
    Model model,
    String searchTxt
  ) {
    log.info("searchTxt==={}", searchTxt);
    List<ReplyBoardDto> boardList = replyBoardService.getSearchBoardList(
      searchTxt
    );
    log.info("boardList==={}", boardList);
    model.addAttribute("boardList", boardList);
    return "/board/list";
  }

  @PostMapping("/deleteAjaxProcess")
  @ResponseBody
  public Map<String, Object> deleteAjaxProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes
  ) {
    int result = replyBoardService.deleteReplyBoard(replyBoardDto);
    int no = replyBoardDto.getNo();
    //ReplyJsonDto replyJsonDto = new ReplyJsonDto();
    Map<String, Object> sendJson = new HashMap<>();
    if (result > 0) {
      //replyJsonDto.setMsg("ok");
      sendJson.put("msg", "ok");
    } else {
      sendJson.put("msg", "fail");
    }
    return sendJson;
  }

  @PostMapping("/modifyProcess")
  public String modifyProcess(
    ReplyBoardDto replyBoardDto,
    RedirectAttributes redirectAttributes,
    HttpServletResponse response
  ) throws IOException {
    int result = replyBoardService.modifyReplyBoard(replyBoardDto);
    if (result > 0) {
      redirectAttributes.addFlashAttribute("msg", "수정되었습니다.");
      return "redirect:/board/list";
    } else {
      //redirectAttributes.addFlashAttribute("msg", "비밀번호를 확인해 주세요.");
      ScriptWriter.alertAndBack(response, "비밀번호를 확인해 주세요.");
      return null;
    }
  }
}
