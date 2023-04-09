package com.example.crud.entity;

import java.io.Serializable;

public class Task implements Serializable {

    private Integer idTask;
    private String title;
    private String task;

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "idTask:" + idTask +
                ", title:'" + title + '\'' +
                ", task:'" + task;
    }
}
