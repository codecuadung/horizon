package com.example.ducnmph32798fpteduvn_assignment;

public class Task {
    private String name;
    private String status;
    private String startDate;
    private String endDate;

    public Task(String name, String status, String startDate, String endDate) {
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}