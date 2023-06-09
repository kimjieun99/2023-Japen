package com.kimjieun99.todo.controller;

import com.kimjieun99.todo.dto.TodoDto;
import com.kimjieun99.todo.service.TodoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TodoController {

  @Autowired
  TodoService todoService;

  @GetMapping("/")
  public String home() {
    return "/todo/index";
  }

  @GetMapping("/list")
  @ResponseBody
  public List<TodoDto> list(String pickedDate) {
    List<TodoDto> todoList = todoService.getAllTodo(pickedDate);
    return todoList;
  }

  @PostMapping("/insert")
  @ResponseBody
  public List<TodoDto> insertTodo(TodoDto todoDto) {
    int result = todoService.insertTodo(todoDto);
    List<TodoDto> todoList = todoService.getAllTodo(todoDto.getPickedDate());
    return todoList;
  }

  @PostMapping("/delete")
  public ResponseEntity<Object> deleteTodo(TodoDto todoDto) {
    log.info("todoDto===" + todoDto);
    log.info("no===" + todoDto.getNo());
    int result = todoService.deleteTodo((todoDto.getNo()));
    Map<String, Integer> resultMap = new HashMap<>();
    resultMap.put("result", result);
    //List<TodoDto> todoList = todoService.getAllTodo(todoDto.getPickedDate());
    return ResponseEntity.status(HttpStatus.OK).body(resultMap);
  }

  @PostMapping("/update")
  public ResponseEntity<Object> updateTodo(TodoDto todoDto) {
    int result = todoService.updateTodo(todoDto);
    Map<String, Integer> resultMap = new HashMap<>();
    if (result > 0) {
      resultMap.put("result", result);
      return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    } else {
      return ResponseEntity.status(500).body(resultMap);
    }
  }
}
