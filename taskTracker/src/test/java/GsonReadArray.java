import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {

    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("{User").append("First name: ").append(firstName).append(", Last name: ").append(lastName).append("}").toString();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}

public class GsonReadArray {

    public static void main(String[] args) throws IOException {

        // read
        // TODO 需要做异常处理，可能读出错误
        Gson gson = new GsonBuilder().create();

        String fileName = "src/main/resources/users.json";
        Path path = new File(fileName).toPath();

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            User[] users = gson.fromJson(reader, User[].class);

            ArrayList<User> list = new ArrayList<>(Arrays.stream(users).toList());

            // add
            list.add(new User("1", "2"));

            list.forEach(System.out::println);
//l
//            Arrays.stream(users).forEach(System.out::println);
//
//            Arrays.stream(users).forEach(e -> {
//                System.out.println(e.getFirstName() + e.getLastName());
//            });


            // write
            try (FileOutputStream fos = new FileOutputStream(fileName); OutputStreamWriter isr = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                new Gson().toJson(list, isr);
            }
        }
    }
}

