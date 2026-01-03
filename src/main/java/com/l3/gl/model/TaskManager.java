package com.l3.gl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE = "tasks.txt";

    public TaskManager() {
        load();
    }

    public void addTask(Task task) {
        tasks.add(task);
        save();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        save();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Task t : tasks) {
                pw.println(t.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(Task.fromFileString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}