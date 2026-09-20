package com.project.ToDo_Lists.Controller;


import com.project.ToDo_Lists.Service.TodoService;
import com.project.ToDo_Lists.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("/")
    public String getAll(Model model){
       List<Todo> lists= todoService.getAll();
       // System.out.println(Arrays.toString(lists.toArray()));
       model.addAttribute("lists",lists);
       return "task";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String createTodo(@ModelAttribute Todo todo){
        todoService.saveTodo(todo);
        return "success";
    }

    @RequestMapping(value="/update/{id}")
    public String updateTodo(@PathVariable("id") long id,@ModelAttribute Todo todo) {
        todoService.updateTodo(id,todo);
        return "redirect:/";
    }

    @RequestMapping(value ="/delete/{id}")
    public String delete(@PathVariable("id") long id){
        todoService.delete(id);
        return "redirect:/";
    }



}
