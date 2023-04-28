package com.kimjieun99.jpl.controller;

import com.kimjieun99.jpl.entity.TodoJpa;
import com.kimjieun99.jpl.service.TodoJpaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class TodoController {

  @Autowired
  TodoJpaService todoJpaService;

  @GetMapping("/insert")
  public String insert(TodoJpa todoJpa) {
    return "/todo/insert";
  }

  @PostMapping("/insert")
  public String insertProcess(TodoJpa todoJpa) {
    todoJpaService.insertTodo(todoJpa);
    return "redirect:/list";
  }

  @PostMapping("/modifyProcess")
  public String modifyProcess(TodoJpa todoJpa) {
    log.info("modify===" + todoJpa);
    todoJpaService.insertTodo(todoJpa);
    return "redirect:/list";
  }

  @GetMapping("/list")
  public String list(Model model) {
    List<TodoJpa> todoList = todoJpaService.getAllTodo();
    model.addAttribute("todoList", todoList);
    return "/todo/list";
  }

  @GetMapping("/modify")
  public String modify(int no, Model model) {
    TodoJpa todoJpa = todoJpaService.getOnetTodo(no);
    model.addAttribute("todoJpa", todoJpa);
    return "/todo/modify";
  }

  @GetMapping("/view")
  public String view(int no, Model model) {
    TodoJpa todoJpa = todoJpaService.getOnetTodo(no);
    model.addAttribute("todoJpa", todoJpa);
    return "/todo/view";
  }
}
