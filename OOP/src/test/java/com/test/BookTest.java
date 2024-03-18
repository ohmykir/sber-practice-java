package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void toStringTest1(){
        Author author = new Author("Александр Пушкин", "мужчина", "PushkinAS@yandex.ru");
        Book book = new Book("Капитанская дочка", author, 1836);

        assertEquals("Book {Name = 'Капитанская дочка', author = Александр Пушкин, year = 1836}", book.toString());
    }

    @Test
    public void toStringTest2(){
        Author author = new Author("Брюс Эккель", "мужчина", "EckelBruce@yandex.ru");
        Book book = new Book("Философия Java", author, 2006);

        assertEquals("Book {Name = 'Философия Java', author = Брюс Эккель, year = 2006}", book.toString());
    }
}
