package com.jtodo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("/todo")
    public List<TodoEntry> getTodoEntries() {
        return todoService.getTodoEntries();
    }

    @RequestMapping("/todo/{id}")
    public TodoEntry getTodoEntryById(@PathVariable int id) {
        return todoService.getTodoEntryById(id);
    }

    @RequestMapping("/todo/unfinished")
    public List<TodoEntry> getUnfinishedTodoEntries() {
        return todoService.getUnfinishedTodoEntries();
    }

    @RequestMapping(method=RequestMethod.POST, value="/todo")
    public void addTodoEntry(@RequestBody TodoEntry entry) {
        todoService.addTodoEntry(entry);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/todo/{id}")
    public void updateTodoEntry(@RequestBody TodoStatus newStatus, @PathVariable int id) {
        todoService.updateTodoEntry(newStatus, id);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/todo/{id}")
    public void removeTodoEntryById(@PathVariable int id) {
        todoService.removeTodoEntryById(id);
    }
}