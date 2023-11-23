import service.DataProcessing;
import service.ReadJSON;
import sructure.TitleJSON;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ReadJSON read = new ReadJSON();
        DataProcessing convert = new DataProcessing(read.getBooks("C:\\Users\\Алёна\\OneDrive\\Рабочий стол\\Практика\\Stream\\src\\main\\resources\\books.json"));

        int option = 1;
        while (option != 0){
            option = ChangeMethod(in);
            in.nextLine();
            switch (option){
                case 1:{
                    System.out.println("\n" +convert.toString());
                    break;
                }
                case 2: {
                    List<TitleJSON> books = convert.sortByYear();
                    System.out.println("\n" + convert.listToString(books));
                    break;
                }
                case 3:{
                    System.out.print("Введите фамилию автора: ");
                    String author = in.nextLine();
                    try {
                        List<TitleJSON> books = convert.filterByAuthors(author);
                        System.out.println("\n" + convert.listToString(books));
                    }
                    catch (Exception e){
                        System.out.println("Введите корректную фамилию!");
                    }
                    break;
                }
                case 4:{
                    System.out.print("Введите жанр: ");
                    String genre = in.nextLine();
                    System.out.println();
                    for (String book : convert.getBooksOfGenre(genre))
                        System.out.println(book);
                    System.out.println();
                    break;
                }
                case 5:{
                    System.out.println();
                    for (String book : convert.getGenres())
                        System.out.println(book);
                    System.out.println();
                    break;
                }
            }
        }
    }
    private static int ChangeMethod(Scanner in){
        System.out.println("1) Вывести список книг.\n" +
                "2) Отсортировать книги по году выпуска.\n" +
                "3) Фильтр книг по Автору.\n" +
                "4) Вывести книги, написанные в данном жанре.\n" +
                "5) Получить отсортированный список жанров.\n" +
                "0) Завершение программы.");
        System.out.print("Вариант: ");
        return in.nextInt();
    }
}