package com.kimjieun99.ch02.controller;

import com.kimjieun99.ch02.utils.ScriptWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

  @GetMapping("/write")
  public String write() {
    return "/board/write";
  }

  @GetMapping("/writeProcess")
  public void writeProcess(
    String userId,
    String userPw,
    HttpServletResponse response
  ) throws IOException {
    //log.info("userId={},userPw={}", userId, userPw);

    if (userId.equals("kim") && userPw.equals("1234")) {
      ScriptWriter.alertAndNext(response, "로그인 되었습니다.", "/");
    } else {
      ScriptWriter.alertAndBack(response, "서버 오류");
    }
    //forward
  }

  @GetMapping("/view")
  public String view() {
    return "/board/view";
  }
}
