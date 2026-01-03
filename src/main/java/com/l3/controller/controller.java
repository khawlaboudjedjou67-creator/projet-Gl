package com.l3.gl;

import com.l3.gl.model.Task;
import com.l3.gl.model.TaskManager;
import com.l3.gl.view.LoginUI;
import com.l3.gl.view.TaskUI;
import java.util.List;

public class Controller {
    private TaskManager taskManager;

    public Controller() {
        taskManager = new TaskManager();
        new LoginUI(this);
    }
    public void showTaskUI() {
        new TaskUI(this);
    }

    public void addTask(Task t) {
        taskManager.addTask(t);
    }
    public void removeTask(Task t) {
        taskManager.removeTask(t);
    }
    public List<Task> getTasks() {
        return taskManager.getTasks();
    }
    public static void main(String[] args) {
        new Controller();
    }
}
