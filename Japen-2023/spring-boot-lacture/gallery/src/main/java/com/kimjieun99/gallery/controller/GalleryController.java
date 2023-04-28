package com.kimjieun99.gallery.controller;

import com.kimjieun99.gallery.Service.GalleryService;
import com.kimjieun99.gallery.dto.GalleryDto;
import com.kimjieun99.gallery.dto.ReplyDto;
import java.util.List;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class GalleryController {

  @Autowired
  GalleryService galleryService;

  @GetMapping({ "/", "/list" })
  public String list(Model model) {
    List<GalleryDto> galleryList = galleryService.getAllList();
    model.addAttribute("galleryList", galleryList);
    return "/gallery/list";
  }

  @GetMapping("/listJson")
  @ResponseBody
  public List<GalleryDto> listJson() {
    List<GalleryDto> galleryList = galleryService.getAllList();
    log.info(galleryList);
    //model.addAttribute("galleryList", galleryList);
    return galleryList;
  }

  @GetMapping("/insert")
  public String insert() {
    return "/gallery/insert";
  }

  @PostMapping("/insert")
  public String insertProcess(GalleryDto galleryDto) {
    galleryService.insertGallery(galleryDto);
    return "redirect:/";
  }

  @GetMapping("/view/{no}")
  public String view(@PathVariable("no") int no, Model model) {
    GalleryDto galleryDto = galleryService.viewGallery(no);
    model.addAttribute("galleryDto", galleryDto);
    return "/gallery/view";
  }

  @PostMapping("/getReply/{no}")
  @ResponseBody
  public List<ReplyDto> getReply(@PathVariable("no") int no, Model model) {
    List<ReplyDto> replyList = galleryService.getAllReply(no);
    return replyList;
  }

  @PostMapping("/insertReply")
  @ResponseBody
  public List<ReplyDto> insertReply(ReplyDto replyDto) {
    int result = galleryService.insertReply(replyDto);
    List<ReplyDto> replyList = galleryService.getAllReply(
      replyDto.getGalleryId()
    );
    if (result > 0) {
      return replyList;
    } else {
      return replyList;
    }
  }
}
