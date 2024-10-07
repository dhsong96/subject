package com.ktdsuniversity.edu.todo.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.todo.bbs.service.TodoService;
import com.ktdsuniversity.edu.todo.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo.bbs.vo.WriteTodoVO;

@Controller
public class todoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo/list")
	public String viewTodoList(Model model) {
		TodoListVO todoListVO = this.todoService.getAllTodo();
		model.addAttribute("todoListVO", todoListVO);
		return "todo/todoList";
	}
	
	@GetMapping("/todo/create")
	public String viewCreateTodo() {
		return "todo/todowrite";
	}
	
	@PostMapping("/todo/create")
	public String doCreateTodo(Model model, WriteTodoVO writeTodoVO) {
		boolean isCreated = this.todoService.creatNewTodo(writeTodoVO);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping("/todo/success/{id}")
	public String viewUpdateTodo(@PathVariable int id) {
		
		boolean updateTodo = this.todoService.updateChangeToComplete(id);
		
		return "redirect:/todo/list";
	}
	
	@GetMapping("/todo/delete/{id}")
	public String doDeleteTodo(@PathVariable int id) {
		this.todoService.deleteOneTodo(id);
		return "redirect:/todo/list";
	}
	
}
