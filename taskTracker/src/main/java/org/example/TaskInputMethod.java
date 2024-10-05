package org.example;

/**
 * @author 96361
 */

public enum TaskInputMethod {
    ADD("add"), UPDATE("update"), DELETE("delete"), MARK_IN_PROGRESS("mark-in-progress"), MARK_DONE("mark-done"), LIST("list"), LIST_DONE("done"), LIST_TODO("todo"), LIST_IN_PROGRESS("in-progress");

    public final String core;

    private TaskInputMethod(String core) {
        this.core = core;
    }

    public String value() {
        return this.core;
    }
}
