package org.example.action.factory;

import com.google.gson.Gson;
import org.example.TaskStatus;
import org.example.TrackerTask;
import org.example.action.IAction;
import org.jetbrains.annotations.Nullable;
import utils.GsonReadAndWriteArray;

import java.util.ArrayList;

/**
 * @author 96361
 */
public class ListDoneAction implements IAction {

    Gson gson;
    int targetId = 0;
    TaskStatus targetStatus = TaskStatus.TODO;

    public ListDoneAction(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void performFromInput(String[] input, @Nullable String addName) {
        // task-cli list todo
        if (input.length == 3) {
            targetStatus = TaskStatus.valueOf(input[2].toUpperCase());
        }
        ArrayList<TrackerTask> res = new ArrayList<>();
        ArrayList<TrackerTask> trackerTasks = GsonReadAndWriteArray.readTasks();
        for (TrackerTask t : trackerTasks) {
            if (t.getStatus() == TaskStatus.DONE) {
                res.add(t);
            }
        }
        System.out.println(this.getClass().getName() + "performFromInput");
        res.forEach(System.out::println);
    }
}
