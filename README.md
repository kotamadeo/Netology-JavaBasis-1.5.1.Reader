# **Задачи № 1-3 Онлайн-читалка**

## **Цель**:

1. Создать класс **Book** с выбранными полями и методами, которые будут полезны в онлайн-читалке. Добавить метод
   *toString()* для этого класса, который будет выводить название каждого поля и его значение через запятую.
2. Создать класс **Author**, описывающий систему авторов.
3. Создать класс **User**, который будет считать количество пользователей онлайн, с полями: электронная почта и ФИО.

### *Пример*:

``` Пример 1
0 или выход: чтобы выйти из программы.
1: вывести список книг.
2: добавить книгу в список.
3: оценить книгу.
4: напечать книгу.
5: узнать годы жизни автора:
6: удалить книгу из списка.
7: вывести информацию об авторах.
8: вывести список пользователей.
9: Добавить пользователя.
10: удалить пользователя.
11: вывести список активных пользователей старше введеного количества лет.
12: демонстрация.
>>>>>>>
1
Толкиен Джон Рональд Руэл. Братство Кольца. Властелин Колец.
Жанр книги: эпическое фентези
Количество страниц: 423
Год публикации: 1954
Рейтинг редакции: 5

2
Введите данные автора (фамилия, имя, национальность/гражданство, год рождения, год смерти) через запятую:
Толстой, Лев, русский, 1828, 1910

Введите данные книги через запятую (название, название цикла, жанр, количество страниц, год издания, рейтинг издательства:
Война и мир, нет, роман-эпопея, 1300, 1865, 3

3
Выберите книгу и оценку от 1 до 5 через пробел: 
5 2

Толстой Лев. Война и мир. нет.
Жанр книги: роман-эпопея
Количество страниц: 1300
Год публикации: 1865
Рейтинг редакции: 3
Пользовательский рейтинг: 2

5
Выберите автора, чтобы узнать годы его жизни: 
5
Год рождения автора: 1828
К сожалению, автор Толстой Лев умер в 1910 году.

8
1: Пользователь:Эрик Темницкий
Возраст: 25
e-mail: kotamadeo@gmail.com
Сейчас читает: Толкиен Джон Рональд Руэл. Братство Кольца. Властелин Колец.
Жанр книги: эпическое фентези
Количество страниц: 423
Год публикации: 1954
Рейтинг редакции: 5
*********************************************
2: Пользователь:Мария Петрова
Возраст: 17
e-mail: petrova@list.com
Сейчас читает: Майер Стефани Морган. Сумерки. Сумерки.
Жанр книги: молодежный роман
Количество страниц: 544
Год публикации: 2005
Рейтинг редакции: 3
*********************************************
3: Пользователь:Джейн Доу
Возраст: 30
e-mail: jane@gmail.com
Сейчас читает: Кентаро Миура. Берсерк vol.40. Берсерк.
Жанр книги: темное фентези
Количество страниц: 176
Год публикации: 2019
Рейтинг редакции: 5
*********************************************
4: Пользователь:Джек Доу
Возраст: 18
e-mail: jack@bing.com
Сейчас читает: Джордан Роберт. Нож сновидений. Колесо Времени.
Жанр книги: эпическое фентези
Количество страниц: 784
Год публикации: 2005
Рейтинг редакции: 5
*********************************************


11
Введите возраст, чтобы вывести пользователей старше этой цифры:
26
3: Доу Джейн возраст: 30
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов:

* **Program** - отвечающий за запуск программы, путем инициирования метода *start()* (с инициированием внутри себя
  вспомогательного метода *printMenu()*);

#### Класс **Program**:
``` java
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
```

* **Author** - описывающий отдельно взятого автора. Имеет ```boolean``` метод *isAuthorAlive()*, позволящий узнать годы
  жизни автора. ```void``` методы использующие интерфейс ```list```, в реализации ```ArrayList``` для вывод списка
  авторов в консоль *printAuthorsList()* и *printAuthorsListWithoutDate()*. Также используется переопределение метода
  *toString()* для корректного вывода.

#### Класс **Author**:
``` java   
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
```

* **Book** - описывающий отдельно взятую книгу. Имеет ```void``` метод *setUserRating()*, позволяющий задать
  пользовательский рейтинг книги. ```void``` метод *printBook()*, позволяющий напечать выбранную книгу. ```void```
  метод использующий интерфейс ```list```, в реализации ```ArrayList``` для вывод списка книг в консоль
  *printBooksList()*. Также используется переопределение метода *toString()* для корректного вывода.

#### Класс **Book**:
```java
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
```

* **User** - описывающий отдельно взятого пользователя. Имеет ```void``` метод *printUsersElderThanInput()*, позволяющий
  вывести список пользователей старше опреденного возраста. Имеет ```void``` методы использующие интерфейс ```list```, в
  реализации ```ArrayList``` для вывод списка пользователей в консоль *printUsersList()* и *printUsersListWithoutAge()*.
  Также используется переопределение метода *toString()* для корректного вывода.

#### Класс **User**:
```java
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
```

2. Использовал кодирование цвета текста (ANSI).

#### Класс **Utils**:
``` java
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }
}
```

3. Использовал ```try-catch```, чтобы избежать падение программы в исключения.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
Добро пожаловать в онлайн-читалку!
Возможные команды программы:
0 или выход: чтобы выйти из программы.
1: вывести список книг.
2: добавить книгу в список.
3: оценить книгу.
4: напечать книгу.
5: узнать годы жизни автора:
6: удалить книгу из списка.
7: вывести информацию об авторах.
8: вывести список пользователей.
9: Добавить пользователя.
10: удалить пользователя.
11: вывести список активных пользователей старше введеного количества лет.
12: демонстрация.
>>>>>>>
```