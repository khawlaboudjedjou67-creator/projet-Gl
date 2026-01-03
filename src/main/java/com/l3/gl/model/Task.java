package com.l3.gl.model;

public class Task {
    private String title;
    private String date;
    private String time;

    public Task(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String toFileString() {
        return title + ";" + date + ";" + time;
    }

    @Override
    public String toString() {
        return title + " | " + date + " | " + time;
    }

    public static Task fromFileString(String line) {
        String[] parts = line.split(";");
        return new Task(parts[0], parts[1], parts[2]);
    }
}