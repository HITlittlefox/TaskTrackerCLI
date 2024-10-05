package org.example.action.factory;


import com.google.gson.Gson;
import org.example.TaskStatus;
import org.example.TrackerTask;
import org.example.action.IAction;
import org.jetbrains.annotations.Nullable;
import utils.GsonReadAndWriteArray;

/**
 * 使用方法：task-cli add "Buy groceries"
 */
public class AddAction implements IAction {

    Gson gson;

    public AddAction(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void performFromInput(String[] input, @Nullable String addName) {
        GsonReadAndWriteArray.readAndWrite(new TrackerTask(addName, TaskStatus.TODO, false));
    }
}
