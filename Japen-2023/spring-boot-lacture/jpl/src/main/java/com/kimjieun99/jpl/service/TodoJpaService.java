package com.kimjieun99.jpl.service;

import com.kimjieun99.jpl.entity.TodoJpa;
import java.util.List;

public interface TodoJpaService {
  public void insertTodo(TodoJpa todoJpa);

  public List<TodoJpa> getAllTodo();

  public TodoJpa getOnetTodo(int no);
}
