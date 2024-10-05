package org.example.action.factory;

import com.google.gson.Gson;
import org.example.TrackerTask;
import org.example.action.IAction;
import org.jetbrains.annotations.Nullable;
import utils.GsonReadAndWriteArray;

import java.util.ArrayList;

/**
 * @author 96361
 */
public class UpdateAction implements IAction {

    Gson gson;
    int targetId = 0;

    public UpdateAction(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void performFromInput(String[] input, @Nullable String addName) {

        // [ "task-cli", "update", "1" ]
        if (input.length == 3) {
            targetId = Integer.parseInt(input[2]);
        }
        ArrayList<TrackerTask> trackerTasks = GsonReadAndWriteArray.readTasks();
        if (targetId - 1 >= 0 && targetId - 1 <= trackerTasks.size()) {
            TrackerTask trackerTask = trackerTasks.get(targetId - 1);
            trackerTask.setName(addName == null ? "null" : addName);
            System.out.println(this.getClass().getName() + "performFromInput");
            trackerTasks.forEach(System.out::println);
            GsonReadAndWriteArray.writeTasks(trackerTasks);
        } else {
            System.out.println(this.getClass().getName() + "performFromInput FAIL");
        }
    }
}
