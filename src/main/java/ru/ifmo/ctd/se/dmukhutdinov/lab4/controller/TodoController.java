package ru.ifmo.ctd.se.dmukhutdinov.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.dao.TodoDao;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.Todo;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.TodoList;

import java.util.List;
import java.util.Optional;

/**
 * @author flyingleafe
 */
@Controller
public class TodoController {
    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public String getProducts(ModelMap map) {
        map.addAttribute("lists", todoDao.getTodoLists());
        map.addAttribute("todoList", new TodoList());
        return "index";
    }

    @RequestMapping(value = "/lists/add", method = RequestMethod.POST)
    public String addTodoList(@ModelAttribute("todoList") TodoList todoList) {
        todoDao.addTodoList(todoList);
        return "redirect:/lists";
    }

    @RequestMapping(value = "/lists/{listId}/delete", method = RequestMethod.POST)
    public String deleteTodoList(@PathVariable("listId") int listId) {
        todoDao.deleteTodoList(listId);
        return "redirect:/lists";
    }

    @RequestMapping(value = "/todos-{listId}", method = RequestMethod.GET)
    public String getTodos(@PathVariable("listId") int listId, ModelMap map) {
        map.addAttribute("list", todoDao.getTodoList(listId).orElseThrow(NotFoundException::new));
        map.addAttribute("todos", todoDao.getTodos(listId));
        map.addAttribute("todo", new Todo());
        return "todos";
    }

    @RequestMapping(value = "/todos-{listId}/add", method = RequestMethod.POST)
    public String addTodo(@PathVariable("listId") int listId, @ModelAttribute("todo") Todo todo) {
        todo.setListId(listId);
        todoDao.addTodo(todo);
        return "redirect:/todos-" + Integer.toString(listId);
    }

    @RequestMapping(value = "/todos-{listId}/{todoId}/update", method = RequestMethod.POST)
    public String setTodoDone(@PathVariable("listId") int listId, @PathVariable("todoId") int todoId) {
        todoDao.setTodoDone(todoId);
        return "redirect:/todos-" + Integer.toString(listId);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private class NotFoundException extends RuntimeException {
    }
}
