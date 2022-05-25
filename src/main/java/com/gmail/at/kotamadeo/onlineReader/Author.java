package com.gmail.at.kotamadeo.onlineReader;

import com.gmail.at.kotamadeo.utils.Utils;

import java.util.List;

public class Author {
    private String surname;
    private String name;
    private String citizenship;
    private String yearOfBorn;
    private String yearOfDeath;

    /**
     * Конструктор, необходимый для первичной инициализации и вызова методов без извращений через Arraylist.get().метод
     **/
    public Author() {
    }

    public Author(String surname, String name, String citizenship, String yearOfBorn, String yearOfDeath) {
        this.surname = surname;
        this.name = name;
        this.citizenship = citizenship;
        this.yearOfBorn = yearOfBorn;
        this.yearOfDeath = yearOfDeath;
    }

    public boolean isAuthorAlive(Author author) {
        if ("по настоящее время".equalsIgnoreCase(yearOfDeath) || "".equals(yearOfDeath)) {
            System.out.printf("%sАвтор %s %s жив! Год рождения: %s%s%n", Utils.ANSI_CYAN, surname, name,
                    yearOfBorn, Utils.ANSI_RESET);
            return true;
        } else {
            System.out.printf("%sГод рождения автора: %s%nК сожалению, автор %s %s умер в %s году.%s%n",
                    Utils.ANSI_RED, yearOfBorn, surname, name, yearOfDeath, Utils.ANSI_RESET);
            return false;
        }
    }

    public void printAuthorsList(List<Author> authors) {
        if (!authors.isEmpty()) {
            for (var i = 0; i < authors.size(); i++) {
                System.out.println((i + 1) + ": " + authors.get(i));
                Utils.printDelim();
            }
        } else {
            System.out.println(Utils.ANSI_RED + "Список авторов пуст!" + Utils.ANSI_RESET);
        }
    }

    public void printAuthorsListWithoutDate(List<Author> authors) {
        for (var i = 0; i < authors.size(); i++) {
            System.out.println((i + 1) + ": " + authors.get(i).surname + " " + authors.get(i).name);
            Utils.printDelim();
        }
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return surname + " " + name + " имеет гражданство/этничность: " + citizenship + " Годы жизни: " + yearOfBorn +
                "-" + yearOfDeath + ".";
    }
}
