package com.todo.service;

//import java.time.Clock;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private boolean checkChars(String text) {
		return true; // for now
	}
	
	private static final String template = "TODO: #" + "%s: %s created at %s";
	
	public String validateMarkers(String text) {
		boolean isCompleted;
		String createdAt;
		//LocalDateTime currentTime = LocalDateTime.now(Clock.systemUTC()); // should give timestamp in UTC
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//createdAt = currentTime.format(formatter);
		isCompleted = false;
		if (checkChars(text)) {
			return String.format(template, text, isCompleted, new Date());
		} else {
			throw new IllegalArgumentException("Alpahnumeric only");
		}
		// process for the databbbbbbbbbbbbbbbbbbbbase /
		
		
	}
	


}
