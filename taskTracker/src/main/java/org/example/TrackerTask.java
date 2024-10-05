package org.example;


/**
 * object class
 *
 * @author 96361
 */
public class TrackerTask {
    int id;
    String name;
    TaskStatus status;
    boolean gone;

    public TrackerTask(int id, String name, TaskStatus status, boolean gone) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.gone = gone;
    }

    public TrackerTask(String name, TaskStatus status, boolean gone) {
        // if id == -1 ,need go to the addAppropriateIdFromGivenTrackerTask
        this.id = -1;
        this.status = status;
        this.name = name;
        this.gone = gone;
    }

    public static TrackerTask addAppropriateIdFromGivenTrackerTask(TrackerTask task, int maxId) {
        if (maxId == 0) {
            task.id = 1;
        } else {
            task.id = maxId + 1;
        }
        return task;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{TrackerTask ").append("id: ").append(id).append(", name: ").append(name).append(", status: ").append(status.toString()).append(", gone: ").append(gone).append("}").toString();
    }

    public boolean isGone() {
        return gone;
    }

    public void setGone(boolean gone) {
        this.gone = gone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
