package ru.ifmo.ctd.se.dmukhutdinov.lab4.model;

/**
 * @author flyingleafe
 */
public class TodoList {
    private int id;
    private String name;

    public TodoList() {
    }

    public TodoList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoList todoList = (TodoList) o;

        return id == todoList.id && name.equals(todoList.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
