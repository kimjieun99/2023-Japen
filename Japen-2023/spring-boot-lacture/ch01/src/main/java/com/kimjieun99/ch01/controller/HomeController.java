package com.kimjieun99.ch01.controller;

import com.kimjieun99.ch01.dto.Member;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("name", "김지은");
    return "/index/index";
  }

  @GetMapping("/member/list")
  public String list(Model model) {
    ArrayList<Member> memberList = new ArrayList<>();
    memberList.add(new Member("01", "김지은", "파주"));
    memberList.add(new Member("02", "김지은", "파주"));
    memberList.add(new Member("03", "김지은", "파주"));
    model.addAttribute("memberList", memberList);
    return "/member/list";
  }

  @GetMapping("/mv")
  public ModelAndView home02() {
    ModelAndView mav = new ModelAndView();
    mav.addObject("subject", "제목을 실어서 보냅니다.");
    mav.setViewName("/index/index02");
    return mav;
  }
}
