package com.belhard.bookstore;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+");

        while (true) {
            printMenu();

            String userInput = scanner.nextLine();
            Matcher matcher = pattern.matcher(userInput);
            String command = "";
            long id = 0;
            if (matcher.find()) {
                command = matcher.group();
                id = Long.parseLong(command);
                command = matcher.replaceAll("");
            }

            if (!usingMenu(userInput, id, command, scanner)) {
                return;
            }
        }
    }

    private static void printMenu() {
        String commandAll = "\u001B[35m" + "/all" + "\u001B[0m\n";
        String commandGet = "\u001B[35m" + "/get{id}" + "\u001B[0m\n";
        String commandDelete = "\u001B[35m" + "/delete{id}" + "\u001B[0m\n";
        String commandExit = "\u001B[35m" + "/exit" + "\u001B[0m\n";
        String commandCreate = "\u001B[35m" + "/create" + "\u001B[0m\n";
        System.out.print("-------Menu-------\n" +
                "~To view all the books, enter: " + commandAll +
                "~To display detailed information about the book, enter: " + commandGet +
                "~To delete a book, enter: " + commandDelete +
                "~To create a book, enter: " + commandCreate +
                "~To exit, enter: " + commandExit);
    }

    private static boolean usingMenu(String userInput, Long id, String command, Scanner scanner) {
        BookDao bookDao = new BookDaoRealization();
        if (userInput.equals("/all")) {
            List<Book> books = bookDao.readAll();
            for (Book book : books) {
                System.out.println(book.toString());
            }
        } else if (userInput.equals("/exit")) {
            return false;
        } else if (id > 0 && "/get{}".equals(command)) {
            Book book = bookDao.readById(id);
            System.out.println(book);
        } else if (id > 0 && "/delete{}".equals(command)) {
            boolean deleted = bookDao.delete(id);
            System.out.println(deleted);
        } else if (userInput.equals("/create")) {
            Book book = createBookWithoutID(scanner);
            Book createdBook = bookDao.create(book);
            System.out.println(createdBook.toString());

        } else {
            System.out.println("Incorrect command!");
        }
        return true;
    }

    private static Book createBookWithoutID(Scanner scanner) {
        Book book = new Book();
        System.out.print("Enter the ISBN of the book: ");
        book.setIsbn(scanner.nextLine());
        System.out.print("Enter the author of the book: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Enter the title of the book: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter the number of pages of the book: ");
        while (true) {
            int pages = scanner.nextInt();
            if (pages > 0) {
                book.setPages(pages);
                break;
            }
            System.out.println("Incorrect input! Enter it again!");
        }
        System.out.print("Enter the genre of the book: ");
        book.setGenre(scanner.nextLine());
        System.out.print("Enter the language of the book: ");
        book.setLanguage(scanner.nextLine());
        System.out.print("Enter the price of the book: ");
        while (true) {
            double price = scanner.nextInt();
            if (price > 0) {
                book.setPrice(price);
                break;
            }
            System.out.println("Incorrect input! Enter it again!");
        }
        return book;
    }
}