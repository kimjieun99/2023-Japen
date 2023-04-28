package com.kimjieun99.jpl.repository;

import com.kimjieun99.jpl.entity.TodoJpa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoJpa, Integer> {
  List<TodoJpa> findAllByOrderByNoDesc();
}
