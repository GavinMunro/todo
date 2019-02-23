package com.todo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ToDoController {

	private static final String template = "TODO "
			+ "  %s, with priority %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/tasks/validateBrackets")
	public boolean validateBrackets(String exprn) {
		return true;
	}

    @PostMapping("/todo")
    public String create_todo(@RequestParam(value = "name", defaultValue = "Job") String name,
                             @RequestParam(value = "priority", defaultValue = "Medium") String priority) {
        return String.format(template, name, priority);
    }

    @GetMapping("/todo_list")
    public String getlist() {
        return  "Soon I will return all the todo items from the DB";
    }

    @GetMapping("/todo/{id}")
    public String get(@PathVariable(value = "id") int id) {
        return  "Soon I will return the todo item: " + id;
    }
}