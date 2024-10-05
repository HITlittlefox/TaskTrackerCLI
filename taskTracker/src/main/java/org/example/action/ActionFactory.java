package org.example.action;


import com.google.gson.Gson;
import org.example.TaskInputMethod;
import org.example.action.factory.*;

import java.util.Objects;

/**
 * @author 96361
 */
public class ActionFactory {


    String actionFlag = TaskInputMethod.ADD.core;
    String actionListFlag = TaskInputMethod.LIST_DONE.core;
    Gson gson;

    public IAction getIAction(String[] input) {

        /**
         * add
         * update
         * delete
         * mark-in-progress
         * mark-done
         * list
         */
        // 这是task-cli的下一位：
        actionFlag = input[1];
        if (Objects.equals(actionFlag, TaskInputMethod.ADD.core)) {
            return new AddAction(gson);
        } else if (Objects.equals(actionFlag, TaskInputMethod.UPDATE.core)) {
            return new UpdateAction(gson);
        } else if (Objects.equals(actionFlag, TaskInputMethod.DELETE.core)) {
            return new DeleteAction(gson);
        } else if (Objects.equals(actionFlag, TaskInputMethod.MARK_IN_PROGRESS.core)) {
            return new MarkInProgressAction(gson);
        } else if (Objects.equals(actionFlag, TaskInputMethod.MARK_DONE.core)) {
            return new MarkDownAction(gson);
        } else if (Objects.equals(actionFlag, TaskInputMethod.LIST.core)) {
            if (input.length == 2) {
                return new ListAction(gson);
            } else {
                actionListFlag = input[2];
                if (Objects.equals(actionListFlag, TaskInputMethod.LIST_DONE.core)) {
                    return new ListDoneAction(gson);
                } else if (Objects.equals(actionListFlag, TaskInputMethod.LIST_TODO.core)) {
                    return new ListTodoAction(gson);
                } else if (Objects.equals(actionListFlag, TaskInputMethod.LIST_IN_PROGRESS.core)) {
                    return new ListInProgressAction(gson);
                }
            }
        }

        return null;
    }
}
