package org.jspider.springmvccrud.controller;

import domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class BookController {
    List<Book> bookList = new ArrayList<>();
    Map<String,String>  map=new HashMap<>();

    {
        bookList.add(new Book(1, "Java", 2000, "Education"));
        bookList.add(new Book(2, "SQL", 2050, "Education"));
        bookList.add(new Book(3, "HTML", 2500, "Education"));
        bookList.add(new Book(4, "Python", 2600, "Education"));
        map.put("pm28","12345678");
        map.put("pramod","pramod2");
        map.put("pmk","pt123");
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookList);
        return "books";
    }

    @GetMapping("/addbook")
    public String showAddBookForm() {
        return "addbook";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") Book book) {
        bookList.add(book);
        return "redirect:/";
    }

    @GetMapping("/updatebook/{id}")
    public String showUpdateBookForm(@PathVariable int id, Model model) {
        Book foundBook = null;

        for (Book book : bookList) {
            if (book.getBookId() == (id)) {
                model.addAttribute("book", book);
                break;
            }
        }


        return "updatebook";
    }

    @PostMapping("/modifybook")
    public String modifyBook(Book b) {
        for (int i = 0; i < bookList.size(); i++) {
            Book b1 = bookList.get(i);
            if (b1.getBookId() == b.getBookId()) {
                bookList.set(i, b);
            }
        }

return "redirect:/";
    }
    @GetMapping("/deletebook/{id}")
    public String deleteBook( @PathVariable  int id) {

        Iterator<Book> itr=bookList.iterator();
        while (itr.hasNext()){
            Book b=itr.next();
            if(b.getBookId()==id){
                itr.remove();
            }

        }



        return "redirect:/";
    }

}
