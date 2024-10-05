package org.example.action.factory;

import com.google.gson.Gson;
import org.example.action.IAction;
import org.jetbrains.annotations.Nullable;
import utils.GsonReadAndWriteArray;

/**
 * @author 96361
 */
public class ListAction implements IAction {

    Gson gson;
    int targetId = 0;

    public ListAction(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void performFromInput(String[] input, @Nullable String addName) {
        GsonReadAndWriteArray.readTasks().forEach(System.out::println);
    }
}
