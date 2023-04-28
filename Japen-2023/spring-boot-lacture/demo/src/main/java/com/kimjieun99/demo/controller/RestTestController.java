package com.kimjieun99.demo.controller;

import com.kimjieun99.demo.dto.Member;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

  //@Cotroller 는 파일로 응답 .jsp,.html 등 파일로 리턴 (web)
  //@RestController 는 body 에 응답 (json)

  @GetMapping("/txt01")
  public String returnTxt() {
    return "hello";
  }

  @GetMapping("/json01")
  public String returnJson01() {
    return "{\"name\":\"kimjieun\"}";
  }

  @GetMapping("/json02")
  public HashMap<String, String> returnJson02() {
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("name", "kimjieun");
    hashMap.put("weight", "40");
    hashMap.put("age", "25");
    return hashMap;
  }

  @GetMapping("/json03")
  public Member returnJson03() {
    Member member = new Member();
    member.setUserId("kimjieun99");
    member.setUserName("김지은");
    member.setAddr("지구");
    return member;
  }

  @GetMapping("/json04")
  public ArrayList returnJson04() {
    ArrayList<Member> arrayList = new ArrayList<>();
    Member member01 = new Member();
    member01.setUserId("kimjieun99");
    member01.setUserName("김지은");
    member01.setAddr("지구");

    arrayList.add(member01);

    Member member02 = new Member();
    member02.setUserId("kimjieun");
    member02.setUserName("고소영");
    member02.setAddr("한남동");

    arrayList.add(member02);

    Member member03 = new Member();
    member03.setUserId("kimjieun01");
    member03.setUserName("장동건");
    member03.setAddr("청담동");

    arrayList.add(member03);

    return arrayList;
  }
}
