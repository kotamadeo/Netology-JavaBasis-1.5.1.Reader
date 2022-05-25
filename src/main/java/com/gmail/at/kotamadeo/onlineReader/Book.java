package com.gmail.at.kotamadeo.onlineReader;

import com.gmail.at.kotamadeo.utils.Utils;

import java.util.List;

public class Book {
    private Author author;
    private String title;
    private String cycleTittle;
    private String genre;
    private int numbersOfPages;
    private int yearOfPublication;
    private int rating;
    private int userRating;

    /**
     * Конструктор, необходимый для первичной инициализации и вызова методов без извращений через Arraylist.get().метод
     **/
    public Book() {
    }

    public Book(Author author, String title, String cycleTittle, String genre, int numbersOfPages,
                int yearOfPublication, int rating) {
        this.author = author;
        this.title = title;
        this.cycleTittle = cycleTittle;
        this.genre = genre;
        this.numbersOfPages = numbersOfPages;
        this.yearOfPublication = yearOfPublication;
        if (rating > 0 && rating <= 5) {
            this.rating = rating;
        } else {
            if (rating <= 0) {
                this.rating = 1;
            } else {
                this.rating = 5;
            }
        }
    }

    public void setUserRating(Book book, int input) {
        if (input > 0 && input <= 5) {
            this.userRating = input;
            System.out.println(book);
        } else {
            userRating = getRating();
            System.out.println(Utils.ANSI_RED + "Ошибка ввода рейтинга!" + Utils.ANSI_RESET);
            System.out.println(book + "\nВаш рейтинг ассоцированный с рейтингом редакции: " + userRating);
        }
    }

    public void printBooksList(List<Book> books) {
        if (!books.isEmpty()) {
            for (var i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ": " + books.get(i));
                Utils.printDelim();
            }
        } else {
            System.out.println(Utils.ANSI_RED + "Список книг пуст!" + Utils.ANSI_RESET);
        }
    }

    public void printBook(Book book) {
        System.out.println(Utils.ANSI_CYAN + "начинаем печать..." + Utils.ANSI_RESET);
        var stringBuilder = new StringBuilder();
        for (var i = 0; i < numbersOfPages; i++) {
            if (i % (numbersOfPages / 100) == 0) {
                var hundredPercent = i / (numbersOfPages / 100);
                if (hundredPercent <= 100) {
                    System.out.println(Utils.ANSI_PURPLE + (i / (numbersOfPages / 100) + "%..." + Utils.ANSI_RESET));
                    stringBuilder.append(".");
                }
            }
        }
        System.out.printf("%sПечать книги %s, которая имеет %s стр. Завершена!%s%n", Utils.ANSI_GREEN, title,
                numbersOfPages, Utils.ANSI_RESET);
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        if (userRating != 0) {
            return author.getSurname() + " " + author.getName() + ". " + title + ". " + cycleTittle +
                    ".\nЖанр книги: " + genre + "\nКоличество страниц: " + numbersOfPages + "\nГод публикации: " +
                    yearOfPublication + "\nРейтинг редакции: " + rating + "\nПользовательский рейтинг: " + userRating;
        } else {
            return author.getSurname() + " " + author.getName() + ". " + title + ". " + cycleTittle +
                    ".\nЖанр книги: " + genre + "\nКоличество страниц: " + numbersOfPages + "\nГод публикации: " +
                    yearOfPublication + "\nРейтинг редакции: " + rating;
        }
    }
}
