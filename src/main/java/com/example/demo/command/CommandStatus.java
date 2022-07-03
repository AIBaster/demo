package com.example.demo.command;

public enum CommandStatus {
    NEW(1,"NEW"),
    LINKED(2,"LINKED"),
    FAILED(3,"FAILED");

    private final int value;
    private final String name;

    CommandStatus(int value,String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
