package com.ktdsuniversity.edu.todo.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.todo.bbs.vo.TodoVO;
import com.ktdsuniversity.edu.todo.bbs.vo.WriteTodoVO;

public interface TodoDao {

	public List<TodoVO> selectAllTodo();
	
	public int insertNewTodo(WriteTodoVO writeTodoVO);
	
	/**
	 * 완료 상태 변경
	 * @param id
	 * @return
	 */
	public int updateTodo(int id);
	
	/**
	 * Todo 삭제
	 * @param id
	 * @return
	 */
	public int deleteTodo(int id);
}
