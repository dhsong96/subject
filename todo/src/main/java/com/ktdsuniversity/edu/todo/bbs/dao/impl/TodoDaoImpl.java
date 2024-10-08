package com.ktdsuniversity.edu.todo.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.todo.bbs.dao.TodoDao;
import com.ktdsuniversity.edu.todo.bbs.vo.TodoVO;
import com.ktdsuniversity.edu.todo.bbs.vo.WriteTodoVO;
@Repository
public class TodoDaoImpl extends SqlSessionDaoSupport implements TodoDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int deleteTodo(int id) {
		return this.getSqlSession().delete("com.ktdsuniversity.edu.todo.bbs.dao.TodoDao.deleteTodo", id);
	}
	@Override
	public int insertNewTodo(WriteTodoVO writeTodoVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.todo.bbs.dao.TodoDao.insertNewTodo", writeTodoVO);
	}
	@Override
	public List<TodoVO> selectAllTodo() {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.todo.bbs.dao.TodoDao.selectAllTodo");
	}
	@Override
	public int updateTodo(int id) {
		return this.getSqlSession().update("com.ktdsuniversity.edu.todo.bbs.dao.TodoDao.updateTodo", id);
	}
	
}
