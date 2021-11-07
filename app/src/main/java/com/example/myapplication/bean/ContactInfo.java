package com.example.myapplication.bean;

public class ContactInfo {
    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private Boolean isFinished;
    private String todoContent;
    private String time;


    public ContactInfo(Boolean ifFinished, String todoContent, String time) {
        this.isFinished = ifFinished;
        this.todoContent = todoContent;
        this.time = time;
    }
}
