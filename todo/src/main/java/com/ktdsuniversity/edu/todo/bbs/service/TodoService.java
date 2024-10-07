package com.ktdsuniversity.edu.todo.bbs.service;

import com.ktdsuniversity.edu.todo.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.bbs.vo.WriteTodoVO;

public interface TodoService {

	public TodoListVO getAllTodo();
	
	public boolean creatNewTodo(WriteTodoVO writeTodoVO);
	
	public boolean updateChangeToComplete(int id);
	
	public boolean deleteOneTodo(int id);
}
