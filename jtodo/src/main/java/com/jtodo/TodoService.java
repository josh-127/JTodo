package com.jtodo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoEntryRepository todoEntryRepository;

    public List<TodoEntry> getTodoEntries() {
        List<TodoEntry> entries = new ArrayList<TodoEntry>();
        for (TodoEntry todoEntry : todoEntryRepository.findAll())
            entries.add(todoEntry);
        return entries;
    }

    public TodoEntry getTodoEntryById(int id) {
        return todoEntryRepository.findById(id).orElse(null);
    }

    public List<TodoEntry> getUnfinishedTodoEntries() {
        List<TodoEntry> entries = new ArrayList<TodoEntry>();
        for (TodoEntry todoEntry : todoEntryRepository.findByStatus(TodoStatus.BACKLOGGED))
            entries.add(todoEntry);
        for (TodoEntry todoEntry : todoEntryRepository.findByStatus(TodoStatus.IN_PROGRESS))
            entries.add(todoEntry);
        return entries;
    }

    public void addTodoEntry(TodoEntry entry) {
        todoEntryRepository.save(entry);
    }

    public void updateTodoEntry(TodoStatus newStatus, int id) {
        TodoEntry todoEntry = todoEntryRepository.findById(id).orElse(null);
        if (todoEntry != null) {
            todoEntry.setStatus(newStatus);
            todoEntryRepository.save(todoEntry);
        }
    }

    public void removeTodoEntryById(int id) {
        todoEntryRepository.deleteById(id);
    }
}