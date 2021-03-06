package com.todo.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todo.model.ToDoItem;
import com.todo.service.ToDoService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

@RestController
public class ToDoController {

	private static final String template = "TODO: #" + "%s: %s created at %s";
	
	@Autowired
	private ToDoService todoService;

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/tasks/validateBrackets")
	public static boolean validateBrackets(@RequestParam(value = "exprn", defaultValue = "") String exprn){
		if(exprn == null || exprn.length() % 2 != 0) return false;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < exprn.length(); i++){
			char c = exprn.charAt(i);
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			} else if(c == ')' || c == '}' || c == ']'){
				if(!stack.isEmpty()){
					char last = stack.pop();
					if(last == '(' && c != ')'){
						return false;
					} else if(last == '{' && c != '}'){
						return false;
					} else if(last == '[' && c != ']'){
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}


	@PostMapping("/todo")
	public String create_todo(@RequestParam(value = "text", defaultValue = "Job") String text)
			throws IllegalArgumentException, IOException {
        return todoService.validateMarkers(text);
	}

	@GetMapping("/todo_list")
	public String get_list() {
		return "Soon I will return all the todo items from the DB";
	}

	@GetMapping("/todo/{id}")
	public String get_item(@PathVariable(value = "id") int id) {
		return "Soon I will return the todo item: " + id;
	}

	@PutMapping("/todo/{id}")
	public ResponseEntity<ToDoItem> edit_item(
			@PathVariable(value = "id") int id, 
			@RequestBody ToDoItem item
	) {
		return new ResponseEntity<ToDoItem>(item, HttpStatus.OK);
	}
}
