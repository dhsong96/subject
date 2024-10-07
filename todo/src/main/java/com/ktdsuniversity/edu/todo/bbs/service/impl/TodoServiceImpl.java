package com.ktdsuniversity.edu.todo.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.todo.bbs.dao.TodoDao;
import com.ktdsuniversity.edu.todo.bbs.service.TodoService;
import com.ktdsuniversity.edu.todo.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.bbs.vo.TodoVO;
import com.ktdsuniversity.edu.todo.bbs.vo.WriteTodoVO;
@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public TodoListVO getAllTodo() {
		
		List<TodoVO> todoList = this.todoDao.selectAllTodo();
		
		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoList(todoList);
		
		return todoListVO;
	}

	@Override
	public boolean creatNewTodo(WriteTodoVO writeTodoVO) {
		
		int insertCount = this.todoDao.insertNewTodo(writeTodoVO);
		
		return insertCount > 0;
	}

	@Override
	public boolean updateChangeToComplete(int id) {
		
		int updateCount = this.todoDao.updateTodo(id);
		
		return updateCount > 0;
	}

	@Override
	public boolean deleteOneTodo(int id) {
		int deleteCount = this.todoDao.deleteTodo(id);
		
		return deleteCount > 0;
	}

}
