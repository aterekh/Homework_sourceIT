package homework5;

import java.util.ArrayList;
import java.util.List;
/*
 * Book: id, Название, Автор (ы), Издательство, Год издания, Количество стра-
ниц, Цена, Тип переплета.
Создать массив объектов. Вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством; c) список книг, выпущенных после заданного года.
 */

public class BlinovTask5 {


    public static void main(String[] args) {

        List<Book> books = new ArrayList<Book>();

        books.add(new Book.BookBuilder("Философия Java").addAuthors("Гурин").addAuthors("Ващенко").setCountPage(800).setPublishDate(2010).build());
        books.add(new Book.BookBuilder("Библиотека профессионала").addAuthors("Лисименко").addAuthors("Гурин").setCountPage(100).setPublishHouse("Питер").build());
        books.add(new Book.BookBuilder("Экономика предприятия").addAuthors("Чалдаева").setCountPage(411).setPublishDate(2013).setPublishHouse("Юрайт").setTypeBinding("Кожанный").setCost(200L).build());
        books.add(new Book.BookBuilder("Язык программирования Java").addAuthors("Арнольд").addAuthors("Гослинг").addAuthors("Холмс").setCountPage(624).setPublishDate(2001).setPublishHouse("Вильямс").build());
        
        System.out.println("Список книг заданного автора");
        UtilsBook.printList(UtilsBook.getListByAuthor(books, "Арнольд"));

        System.out.println("Список книг, выпущенных заданным издательством");
        UtilsBook.printList(UtilsBook.getListByPublishHouse(books, "Питер"));

        System.out.println("Список книг, выпущенных после заданного года");

        UtilsBook.printList(UtilsBook.getListAfterYear(books, 2010));
    }

}

class UtilsBook {
    public static ArrayList<Book> getListAfterYear(List<Book> bookList, int year) {
        ArrayList<Book> list = new ArrayList<Book>();
        for (Book book : bookList) {
            if (book.getPublishDate() >= year)
                list.add(book);
        }
        return list;
    }


    public static ArrayList<Book> getListByPublishHouse(List<Book> bookList, String namePublish) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : bookList) {
            if (book.getPublishHouse().equalsIgnoreCase(namePublish))
                books.add(book);
        }
        return books;
    }

    public static ArrayList<Book> getListByAuthor(List<Book> bookList, String nameAuthor) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (Book book : bookList) {
            for (String name : book.getAuthors()) {
                if (name.equalsIgnoreCase(nameAuthor))
                    books.add(book);
            }
        }
        return books;
    }

    public static void printList(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}

class Book {

    private static int meter = 1;
    private int id = meter;
    private String name;
    private List<String> authors;
    private String publishHouse;
    private int publishDate;
    private int countPage;
    private Long cost;
    private String typeBinding;

    private Book(BookBuilder builder) {
        this.id = meter++;
        this.name = builder.name;
        this.authors = builder.authors;
        this.publishHouse = builder.publishHouse;
        this.publishDate = builder.publishDate;
        this.countPage = builder.countPage;
        this.cost = builder.cost;
        this.typeBinding = builder.typeBinding;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public List<String> getAuthors() {
        return authors;
    }

   
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", publishHouse='").append(publishHouse).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append(", countPage=").append(countPage);
        sb.append(", cost=").append(cost);
        sb.append(", typeBinding='").append(typeBinding).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class BookBuilder {
        private String name;
        private List<String> authors = new ArrayList<String>();
        private String publishHouse = "";
        private int publishDate = 0;
        private int countPage = 0;
        private Long cost = 0L;
        private String typeBinding = "";

        public BookBuilder(String name) {
            this.name = name;
        }

        public BookBuilder addAuthors(String author) {
            this.authors.add(author);
            return this;
        }

        public BookBuilder setPublishHouse(String publishHouse) {
            this.publishHouse = publishHouse;
            return this;
        }

        public BookBuilder setPublishDate(int publishDate) {
            this.publishDate = publishDate;
            return this;
        }

        public BookBuilder setCountPage(int countPage) {
            this.countPage = countPage;
            return this;
        }

        public BookBuilder setCost(Long cost) {
            this.cost = cost;
            return this;
        }

        public BookBuilder setTypeBinding(String typeBinding) {
            this.typeBinding = typeBinding;
            return this;
        }

        public Book build() {
            return new Book(this);

        }
    }
}