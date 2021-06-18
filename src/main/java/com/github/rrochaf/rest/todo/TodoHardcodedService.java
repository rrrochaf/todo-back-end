package com.github.rrochaf.rest.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static Long idCounter = 0L;
	
	static {
		todos.add(new Todo(++idCounter, "ricardo", "Learn to code", false, new Date()));
		todos.add(new Todo(++idCounter, "ricardo", "Learn to java", false, new Date()));
		todos.add(new Todo(++idCounter, "ricardo", "Learn to angular", false, new Date()));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = this.findById(id);
		if(todo != null) {
			todos.remove(todo);
			return todo;
		}
		return null;
	}
	
	
	public Todo findById(long id) {
		for (Todo t : todos) {
			if(id == t.getId()) {
				return t;
			}
		}
		return null;
	}
}
