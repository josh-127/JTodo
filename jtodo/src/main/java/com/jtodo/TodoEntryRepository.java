package com.jtodo;

import org.springframework.data.repository.CrudRepository;

public interface TodoEntryRepository extends CrudRepository<TodoEntry, Integer> {
    Iterable<TodoEntry> findByStatus(TodoStatus todoStatus);
}