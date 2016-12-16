package ru.ifmo.ctd.se.dmukhutdinov.lab4.model;

/**
 * @author flyingleafe
 */
public class Todo {
    private int id;
    private int listId;
    private String description;
    private boolean done;

    public Todo() {
        id = -1;
        listId = -1;
        description = "";
        done = false;
    }

    public Todo(int id, int listId, String description) {
        this.id = id;
        this.listId = listId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return id == todo.id && listId == todo.listId && done == todo.done && description.equals(todo.description);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + listId;
        result = 31 * result + description.hashCode();
        result = 31 * result + (done ? 1 : 0);
        return result;
    }
}
