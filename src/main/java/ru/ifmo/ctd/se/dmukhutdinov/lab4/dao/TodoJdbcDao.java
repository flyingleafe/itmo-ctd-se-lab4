package ru.ifmo.ctd.se.dmukhutdinov.lab4.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.Todo;
import ru.ifmo.ctd.se.dmukhutdinov.lab4.model.TodoList;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 * @author flyingleafe
 */
public class TodoJdbcDao extends JdbcDaoSupport implements TodoDao {

    public TodoJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }

    @Override
    public int addTodoList(TodoList todoList) {
        String sql = "INSERT INTO Lists (name) VALUES (?)";
        return getJdbcTemplate().update(sql, todoList.getName());
    }

    @Override
    public List<TodoList> getTodoLists() {
        String sql = "SELECT * FROM Lists";
        return getDataByRequest(TodoList.class, sql);
    }

    @Override
    public Optional<TodoList> getTodoList(int id) {
        String sql = "SELECT * FROM Lists WHERE id = ?";
        return getDataByRequest(TodoList.class, sql, id).stream().findFirst();
    }

    @Override
    public int deleteTodoList(int id) {
        String sql = "DELETE FROM Lists WHERE id = ?";
        return getJdbcTemplate().update(sql, id);
    }

    @Override
    public int addTodo(Todo todo) {
        String sql = "INSERT INTO Todos (list_id, desc) VALUES (?, ?)";
        return getJdbcTemplate().update(sql, todo.getListId(), todo.getDescription());
    }

    @Override
    public Optional<Todo> getTodo(int id) {
        String sql = "SELECT * FROM Todos WHERE id = ?";
        return getDataByRequest(Todo.class, sql, id).stream().findFirst();
    }

    @Override
    public List<Todo> getTodos(int listId) {
        String sql = "SELECT * FROM Todos WHERE list_id = ?";
        return getDataByRequest(Todo.class, sql, listId);
    }

    @Override
    public int setTodoDone(int id) {
        String sql = "UPDATE Todos SET done = TRUE WHERE id = ?";
        return getJdbcTemplate().update(sql, id);
    }

    private <D> List<D> getDataByRequest(Class<D> dClass, String sql, Object... args) {
        return getJdbcTemplate().query(sql, args, new BeanPropertyRowMapper<>(dClass));
    }
}
