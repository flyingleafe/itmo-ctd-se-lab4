package ru.ifmo.ctd.se.dmukhutdinov.lab4.dao;

import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.Todo;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.TodoList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author flyingleafe
 */
public class TodoInMemoryDao implements TodoDao {
    private final AtomicInteger lastListId = new AtomicInteger(0);
    private final AtomicInteger lastTodoId = new AtomicInteger(0);

    private final Map<Integer, TodoList> lists = new ConcurrentHashMap<>();
    private final Map<Integer, Todo> todos = new ConcurrentHashMap<>();

    @Override
    public int addTodoList(TodoList todoList) {
        int newId = lastListId.incrementAndGet();
        todoList.setId(newId);
        lists.put(newId, todoList);
        return newId;
    }

    @Override
    public Optional<TodoList> getTodoList(int id) {
        return Optional.ofNullable(lists.get(id));
    }

    @Override
    public List<TodoList> getTodoLists() {
        return new ArrayList<>(lists.values());
    }

    @Override
    public int deleteTodoList(int id) {
        return lists.remove(id) == null ? 0 : 1;
    }

    @Override
    public int addTodo(Todo todo) {
        int newId = lastTodoId.incrementAndGet();
        todo.setId(newId);
        todos.put(newId, todo);
        return newId;
    }

    @Override
    public Optional<Todo> getTodo(int id) {
        return Optional.ofNullable(todos.get(id));
    }

    @Override
    public List<Todo> getTodos(int listId) {
        return todos.values().stream()
                    .filter(todo -> todo.getListId() == listId)
                    .collect(Collectors.toList());
    }

    @Override
    public int setTodoDone(int id) {
        return todos.computeIfPresent(id, (tid, todo) -> {
            todo.setDone(true);
            return todo;
        }) == null ? 0 : 1;
    }
}
