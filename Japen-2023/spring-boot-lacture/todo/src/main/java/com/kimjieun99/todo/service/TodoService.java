package com.kimjieun99.todo.service;

import com.kimjieun99.todo.dto.TodoDto;
import java.util.List;

public interface TodoService {
  public int insertTodo(TodoDto todoDto);

  public List<TodoDto> getAllTodo(String pickedDate);

  public int deleteTodo(int no);

  public int updateTodo(TodoDto todoDto);
}
