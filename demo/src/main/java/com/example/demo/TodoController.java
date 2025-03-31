package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
 public class TodoController {


 private static List<Todo> todos;
 private static List<Todo> todoList;


 @Autowired
 @Qualifier("anotherTodoService")
 private  TodoService todoService;

  public TodoController( ){
    todos = new ArrayList<>();
   todos.add(new Todo(1, false, "Todo 1", 1));
   todos.add(new Todo(2, true, "Todo 2", 2));
   this.todoService=new FakeTodoService();
   
  }
 @GetMapping("/todos")
 public List<Todo> getTodos(@RequestParam String isCompleted) {
  System.out.println("incomming params "+ isCompleted +" "+this.todoService.doSomething());
   return todos;
 }

 @PostMapping("/todos")
 public Todo createTodo(@RequestBody Todo newTodo) {
  todos.add(newTodo);
  return  newTodo ;
 }

}
