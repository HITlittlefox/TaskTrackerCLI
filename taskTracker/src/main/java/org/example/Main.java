package org.example;

import org.example.action.ActionFactory;
import org.example.action.IAction;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 96361
 */
public class Main {
    public static String COMMAND_PRE = "task-cli";

    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        String s = "123";
//        System.out.println(s.length());

        Scanner scanner = new Scanner(System.in);
        // nextLine():结束符只是Enter键，即nextLine()方法返回的是Enter键之前的所有字符
        String i = scanner.nextLine();
        String[] str = i.split("\"");

        /**
         * task-cli add "Buy groceries"
         * task-cli update 1 "Buy groceries and cook dinner"
         */
        if (str.length >= 2) {
            // 代表着add或者update
            String addOrUpdateName = str[1];
            System.out.println("str");
//            Arrays.stream(str).toList().forEach(System.out::println);

            String[] strPre = str[0].split(" ");
            System.out.println("strPre");
//            Arrays.stream(strPre).toList().forEach(System.out::println);

            IAction action = new ActionFactory().getIAction(strPre);
            action.performFromInput(strPre, addOrUpdateName);

        } else {
            // 代表着非add
            // delete
            String[] strNotAdd = i.split(" ");
            System.out.println("Not Add");
//            Arrays.stream(strNotAdd).toList().forEach(System.out::println);
            IAction action = new ActionFactory().getIAction(strNotAdd);
            action.performFromInput(strNotAdd, null);
        }
//
//
//        if (str[0].toLowerCase().equals(COMMAND_PRE)) {
//
//        } else {
//
//        }
    }
}