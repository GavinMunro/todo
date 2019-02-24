package com.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.todo.controllers.ToDoController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testBalBraces() {
		String exp1 = "()[]{}";
		String exp2 = "[}]{";
		String exp3 = "dagfd";
		String exp4 = "{f{gh}[ew4]}()";
		System.out.println(ToDoController.validateBrackets(exp1));
		System.out.println(ToDoController.validateBrackets(exp2));
		System.out.println(ToDoController.validateBrackets(exp3));
		System.out.println(ToDoController.validateBrackets(exp4));
	}

}
