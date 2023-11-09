package com.codewithsowmiya.demo.Controller;


import com.codewithsowmiya.demo.Model.Todo;
import com.codewithsowmiya.demo.Repositary.TodoRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TodoController {

    @Autowired
    private TodoRepositary todoRepositary;
    @RequestMapping("/todo/all")
    public List<Todo> getallTodo(){
        return todoRepositary.findAll();
    }

    @PostMapping("/todo")//requestbody-->from postman write item in body
    public List<Todo> addTodo(@RequestBody Todo todo){
        return  todoRepositary.insert(todo);
    }

    @PutMapping("/todo/edit")
    public List<Todo> editTodo(@RequestBody Todo todo){
        return todoRepositary.update(todo);
    }

    @DeleteMapping("todo/delete/{id}")
    public  List<Todo> deleteTodo(@PathVariable int id){
        return todoRepositary.delete(id);
    }


}
