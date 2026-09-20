package com.project.ToDo_Lists.Service;

import com.project.ToDo_Lists.Repository.TodoRepo;
import com.project.ToDo_Lists.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    public void saveTodo(Todo todo){
        todoRepo.save(todo);
    }

    public List<Todo> getAll() {
       // System.out.println("in service layer..");
        return todoRepo.findAll();
    }

    public void updateTodo(long id, Todo newTodo) {
        Optional<Todo> oldbox = todoRepo.findbyId(id);
        Todo oldTodo = null;
        if (oldbox.isPresent()) {
            oldTodo = oldbox.get();
            oldTodo.setTask(newTodo.getTask());
            oldTodo.setStatus(newTodo.getStatus());
            todoRepo.update(oldTodo);
        }
    }

    public void delete(long id) {
        todoRepo.delete(id);
    }
}
