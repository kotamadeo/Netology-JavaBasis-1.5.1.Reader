package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.onlineReader.Author;
import com.gmail.at.kotamadeo.onlineReader.Book;
import com.gmail.at.kotamadeo.onlineReader.User;
import com.gmail.at.kotamadeo.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    private final Author author = new Author();
    private final Book book = new Book();
    private final User user = new User();
    private final Scanner scanner = new Scanner(System.in);
    private final List<Author> authors = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    /**
     * Метод start() реализует общение с пользователем. Если при проверке вам не захочется тратить время на ввод данных,
     * который собственно работает как нужно, то необходимо использовать <b>case 12<b>, а после уже любые другие
     * действия.
     **/
    public void start() {
        String input;
        String[] lineInput;
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("выход") || input.equals("0")) {
                    scanner.close();
                    break;
                } else {
                    var operationNumber = Integer.parseInt(input);
                    switch (operationNumber) {
                        case 1:
                            book.printBooksList(books);
                            break;
                        case 2:
                            System.out.println(Utils.ANSI_BLUE + "Введите данные автора (фамилия, имя, " +
                                    "национальность/гражданство, год рождения, год смерти) через запятую:" +
                                    Utils.ANSI_RESET);
                            lineInput = scanner.nextLine().split(", ");
                            String surnameInput = lineInput[0];
                            String nameInput = lineInput[1];
                            String citizenshipInput = lineInput[2];
                            String yearOfBornInput = lineInput[3];
                            String yearOfDeathInput = lineInput[4];
                            authors.add(new Author(surnameInput, nameInput, citizenshipInput, yearOfBornInput,
                                    yearOfDeathInput));
                            System.out.println(Utils.ANSI_BLUE + "Введите данные книги через запятую (название, " +
                                    "название цикла, жанр, количество страниц, год издания, рейтинг издательства:" +
                                    Utils.ANSI_RESET);
                            lineInput = scanner.nextLine().split(", ");
                            String titleInput = lineInput[0];
                            String cycleTittleInput = lineInput[1];
                            String genreInput = lineInput[2];
                            var numbersOfPagesInput = Integer.parseInt(lineInput[3]);
                            var yearOfPublicationInput = Integer.parseInt(lineInput[4]);
                            var ratingInput = Integer.parseInt(lineInput[5]);
                            var counter = 0;
                            for (var i = 0; i < authors.size(); i++) {
                                counter = i;
                            }
                            books.add(new Book(authors.get(counter), titleInput, cycleTittleInput, genreInput,
                                    numbersOfPagesInput, yearOfPublicationInput, ratingInput));
                            break;
                        case 3:
                            System.out.println(Utils.ANSI_BLUE + "Выберите книгу и оценку от 1 до 5 через пробел: " +
                                    Utils.ANSI_RESET);
                            book.printBooksList(books);
                            lineInput = scanner.nextLine().split(" ");
                            var bookInput = Integer.parseInt(lineInput[0]) - 1;
                            var userRatingInput = Integer.parseInt(lineInput[1]);
                            books.get(bookInput).setUserRating(books.get(bookInput), userRatingInput);
                            break;
                        case 4:
                            System.out.println(Utils.ANSI_BLUE + "Выберите книгу, которую хотите напечатать: " +
                                    Utils.ANSI_RESET);
                            book.printBooksList(books);
                            input = scanner.nextLine();
                            var printNumber = Integer.parseInt(input) - 1;
                            books.get(printNumber).printBook(books.get(printNumber));
                            break;
                        case 5:
                            System.out.println(Utils.ANSI_BLUE + "Выберите автора, чтобы узнать годы его " +
                                    "жизни: " + Utils.ANSI_RESET);
                            author.printAuthorsListWithoutDate(authors);
                            input = scanner.nextLine();
                            var authorNumber = Integer.parseInt(input) - 1;
                            authors.get(authorNumber).isAuthorAlive(authors.get(authorNumber));
                            break;
                        case 6:
                            System.out.println(Utils.ANSI_BLUE + "Выберите книгу, которую хотите удалить: " +
                                    Utils.ANSI_RESET);
                            book.printBooksList(books);
                            input = scanner.nextLine();
                            var bookRemoveNumber = Integer.parseInt(input) - 1;
                            System.out.println(Utils.ANSI_RED + "Книга удалена!\n" + books.remove(bookRemoveNumber) +
                                    Utils.ANSI_RESET);
                            break;
                        case 7:
                            author.printAuthorsList(authors);
                            break;
                        case 8:
                            user.printUsersList(users);
                            break;
                        case 9:
                            book.printBooksList(books);
                            System.out.println(Utils.ANSI_BLUE + "Введите данные пользователя через запятую " +
                                    "(номер книги, фамилия, имя, возраст, e-mail) :" + Utils.ANSI_RESET);
                            lineInput = scanner.nextLine().split(", ");
                            var userBookInput = Integer.parseInt(lineInput[0]) - 1;
                            var userSurnameInput = lineInput[1];
                            var userNameInput = lineInput[2];
                            var userAgeInput = Integer.parseInt(lineInput[3]);
                            var emailInput = lineInput[4];
                            users.add(new User(books.get(userBookInput), userSurnameInput, userNameInput, userAgeInput,
                                    emailInput));
                            break;
                        case 10:
                            System.out.println(Utils.ANSI_BLUE + "Выберите пользователя, которого хотите " +
                                    "удалить:" + Utils.ANSI_RESET);
                            user.printUsersListWithoutAge(users);
                            input = scanner.nextLine();
                            var userRemoveNumber = Integer.parseInt(input) - 1;
                            System.out.println(Utils.ANSI_RED + "Пользователь удален!\n" +
                                    users.remove(userRemoveNumber) + Utils.ANSI_RESET);
                            break;
                        case 11:
                            System.out.println(Utils.ANSI_BLUE + "Введите возраст, чтобы вывести пользователей " +
                                    "старше этой цифры:" + Utils.ANSI_RESET);
                            input = scanner.nextLine();
                            var ageInput = Integer.parseInt(input);
                            user.printUsersElderThanInput(users, ageInput);
                            break;
                        case 12:
                            demonstration();
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(Utils.ANSI_RED + "Неверный ввод!" + Utils.ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Добро пожаловать в онлайн-читалку!" + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные команды программы:" + Utils.ANSI_RESET);
        System.out.println("0 или выход: чтобы выйти из программы.");
        System.out.println("1: вывести список книг.");
        System.out.println("2: добавить книгу в список.");
        System.out.println("3: оценить книгу.");
        System.out.println("4: напечать книгу.");
        System.out.println("5: узнать годы жизни автора:");
        System.out.println("6: удалить книгу из списка.");
        System.out.println("7: вывести информацию об авторах.");
        System.out.println("8: вывести список пользователей.");
        System.out.println("9: Добавить пользователя.");
        System.out.println("10: удалить пользователя.");
        System.out.println("11: вывести список активных пользователей старше введеного количества лет.");
        System.out.println("12: демонстрация.");
        System.out.print(">>>>>>>");
    }

    private void demonstration() {
        authors.add(new Author("Толкиен", "Джон Рональд Руэл", "англичанин", "1892", "1973"));
        authors.add(new Author("Майер", "Стефани Морган", "американка", "1973", "по настоящее время"));
        authors.add(new Author("Кентаро", "Миура", "японец", "1966", "2021"));
        authors.add(new Author("Джордан", "Роберт", "американец", "1948", "2007"));
        books.add(new Book(authors.get(0), "Братство Кольца", "Властелин Колец", "эпическое фентези", 423,
                1954, 5));
        books.add(new Book(authors.get(1), "Сумерки", "Сумерки", "молодежный роман", 544, 2005, 3));
        books.add(new Book(authors.get(2), "Берсерк vol.40", "Берсерк", "темное фентези", 176, 2019, 5));
        books.add(new Book(authors.get(3), "Нож сновидений", "Колесо Времени", "эпическое фентези",
                784, 2005, 5));
        users.add(new User(books.get(0), "Темницкий", "Эрик", 25, "kotamadeo@gmail.com"));
        users.add(new User(books.get(1), "Петрова", "Мария", 17, "petrova@list.com"));
        users.add(new User(books.get(2), "Доу", "Джейн", 30, "jane@gmail.com"));
        users.add(new User(books.get(3), "Доу", "Джек", 18, "jack@bing.com"));
    }
}
