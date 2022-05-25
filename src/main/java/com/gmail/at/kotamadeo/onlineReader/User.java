package com.gmail.at.kotamadeo.onlineReader;

import com.gmail.at.kotamadeo.utils.Utils;

import java.util.List;

public class User {
    private Book book;
    private String surname;
    private String name;
    private String email;
    private int age;
    private static int counter;

    /**
     * Конструктор, необходимый для первичной инициализации и вызова методов без извращений через Arraylist.get().метод
     **/
    public User() {
    }

    public User(Book book, String surname, String name, int age, String email) {
        this.book = book;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.email = email;
        counter++;
    }

    public void printUsersList(List<User> users) {
        if (!users.isEmpty()) {
            for (var i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ": " + users.get(i));
                Utils.printDelim();
            }
            System.out.println(Utils.ANSI_PURPLE + "Пользователей онлайн: " + counter);
        } else {
            System.out.println(Utils.ANSI_RED + "Список пользователей пуст!" + Utils.ANSI_RESET);
        }
    }

    public void printUsersListWithoutAge(List<User> users) {
        for (var i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ": " + users.get(i).name + " " + users.get(i).surname);
            Utils.printDelim();
        }
        System.out.println(Utils.ANSI_PURPLE + "Пользователей онлайн: " + counter);
    }

    public void printUsersElderThanInput(List<User> users, int age) {
        System.out.printf("%sПользователи старше %s лет:%s%n", Utils.ANSI_CYAN, age, Utils.ANSI_RESET);
        for (var i = 0; i < users.size(); i++) {
            if (users.get(i).age > age) {
                System.out.println((i + 1) + ": " + users.get(i).name + " " + users.get(i).surname +
                        " возраст: " + users.get(i).age);
                Utils.printDelim();
            }
        }
    }

    @Override
    public String toString() {
        return "Пользователь:" + name + " " + surname + "\nВозраст: " + age + "\ne-mail: " + email +
                "\nСейчас читает: " + book;
    }
}
