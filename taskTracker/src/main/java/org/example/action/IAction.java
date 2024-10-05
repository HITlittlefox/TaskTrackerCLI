package org.example.action;

import org.jetbrains.annotations.Nullable;

public interface IAction {
    void performFromInput(String[] input, @Nullable String addName);
}
