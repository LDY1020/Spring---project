package hello.bookmanagement.controller;



import hello.bookmanagement.domain.Book;
import hello.bookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    // 도서 등록 폼
    @GetMapping("/books/new")
    public String createForm(){
        return "books/createBookForm";
    }

    // 도서 등록 처리
    @PostMapping("/books/new")
    public String create(BookForm form){
        Book book = new Book();
        book.setTitle(form.getTitle());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        bookService.register(book);

        return "redirect:/";
    }

    // 도서 목록
    @GetMapping("/books")
    public String list(Model model){
        List<Book> books = bookService.findBook();
        model.addAttribute("books", books);
        return "books/bookList";
    }
}
