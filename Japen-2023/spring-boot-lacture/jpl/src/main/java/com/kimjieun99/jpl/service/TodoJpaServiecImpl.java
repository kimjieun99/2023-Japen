package com.kimjieun99.jpl.service;

import com.kimjieun99.jpl.entity.TodoJpa;
import com.kimjieun99.jpl.repository.TodoJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoJpaServiecImpl implements TodoJpaService {

  @Autowired
  TodoJpaRepository todoJpaRepository;

  @Override
  public void insertTodo(TodoJpa todoJpa) {
    todoJpaRepository.save(todoJpa);
  }

  @Override
  public List<TodoJpa> getAllTodo() {
    List<TodoJpa> todoList = todoJpaRepository.findAll();
    return todoList;
  }

  @Override
  public TodoJpa getOnetTodo(int no) {
    Optional<TodoJpa> optional = todoJpaRepository.findById(no);
    return optional.get();
  }
}
