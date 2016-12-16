package ru.ifmo.ctd.se.dmukhutdinov.lab4.dao;

import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.Todo;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.TodoList;

import java.util.List;
import java.util.Optional;

/**
 * @author flyingleafe
 */
public interface TodoDao {
    int addTodoList(TodoList todoList);
    Optional<TodoList> getTodoList (int id);
    List<TodoList> getTodoLists();
    int deleteTodoList(int id);

    int addTodo(Todo todo);
    Optional<Todo> getTodo(int id);
    List<Todo> getTodos(int listId);
    int setTodoDone(int id);
}
