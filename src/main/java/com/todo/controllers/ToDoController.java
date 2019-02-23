package com.todo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

	private static final String template = "TODO "
			+ "  %s, with priority %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/tasks/validateBrackets")
	public boolean balBrackets(String exprn) {
		return true;
	}

	
}