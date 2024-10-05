package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import org.example.TaskStatus;
import org.example.TrackerTask;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GsonReadAndWriteArray {

    public static ArrayList<TrackerTask> readTasks() {
        System.out.println("===readTasks start===");
        // read
        // TODO 需要做异常处理，可能读出错误
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "src/main/resources/TrackerTask.json";
        Path path = new File(fileName).toPath();
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            TrackerTask[] itemsRead = gson.fromJson(reader, TrackerTask[].class);
            ArrayList<TrackerTask> trackerTasks = new ArrayList<>(Arrays.stream(itemsRead).toList());
//            trackerTasks.forEach(System.out::println);
            return trackerTasks;
        } catch (Exception e) {
            // TODO: add
            ArrayList<TrackerTask> trackerTasks = new ArrayList<>();
//            trackerTasks.forEach(System.out::println);
            return trackerTasks;
        } finally {
            System.out.println("===readTasks end===");
        }
    }

    public static void writeTasks(ArrayList<TrackerTask> items) {
        // read
        // TODO 需要做异常处理，可能读出错误
        // write
        String fileName = "src/main/resources/TrackerTask.json";
        try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            new Gson().toJson(items, isr);
        } catch (JsonIOException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAndWrite(TrackerTask trackerTask) {
        // read
        // TODO 需要做异常处理，可能读出错误
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "src/main/resources/TrackerTask.json";
        Path path = new File(fileName).toPath();

        int maxId = 0;

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            TrackerTask[] itemsRead = gson.fromJson(reader, TrackerTask[].class);
            ArrayList<TrackerTask> items = new ArrayList<>(Arrays.stream(itemsRead).toList());
            maxId = items.size();
            // add id加1
            items.add(TrackerTask.addAppropriateIdFromGivenTrackerTask(trackerTask, maxId));
            items.forEach(System.out::println);
            // write
            try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                new Gson().toJson(items, isr);
            }
        } catch (Exception e) {
            // TODO: add
            List<TrackerTask> items = new ArrayList<>();
            items.add(TrackerTask.addAppropriateIdFromGivenTrackerTask(trackerTask, maxId));
            items.forEach(System.out::println);
            // write
            try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                new Gson().toJson(items, isr);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
//            throw new RuntimeException(e);
        }
    }

    public static void readAndWrite(ArrayList<TrackerTask> trackerTasks) {
        // read
        // TODO 需要做异常处理，可能读出错误
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String fileName = "src/main/resources/TrackerTask.json";
        Path path = new File(fileName).toPath();

        int maxId = 0;

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            TrackerTask[] itemsRead = gson.fromJson(reader, TrackerTask[].class);
            ArrayList<TrackerTask> items = new ArrayList<>(Arrays.stream(itemsRead).toList());

            // add id加1
            for (TrackerTask trackerTask : trackerTasks) {
                maxId = items.size();
                items.add(TrackerTask.addAppropriateIdFromGivenTrackerTask(trackerTask, maxId));
            }

            items.forEach(System.out::println);
            // write
            try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                new Gson().toJson(items, isr);
            }
        } catch (Exception e) {
            // TODO: add
            List<TrackerTask> items = new ArrayList<>();
            for (TrackerTask trackerTask : trackerTasks) {
                maxId = items.size();
                items.add(TrackerTask.addAppropriateIdFromGivenTrackerTask(trackerTask, maxId));
            }
            items.forEach(System.out::println);
            // write
            try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                new Gson().toJson(items, isr);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
//            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

//        readTasks();
        generateData();
//        writeTasks(readTasks());
    }

    /**
     * plus x item to file
     */
    public static void generateData() {
        ArrayList<TrackerTask> trackerTasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            trackerTasks.add(new TrackerTask(Integer.toString(i), TaskStatus.TODO, false));
        }
        readAndWrite(trackerTasks);

    }
}

