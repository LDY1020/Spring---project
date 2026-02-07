package hello.bookmanagement.service;

import hello.bookmanagement.domain.Book;
import hello.bookmanagement.reposity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서등록
    public Long register(Book book) {
        // 중복 도서 검증 (같은 ISBN)
        validateDuplicateBook(book);
        bookRepository.save(book);
        return book.getId();
    }

    private void validateDuplicateBook(Book book){
        bookRepository.findByTitle(book.getTitle())
                .ifPresent(b -> {
                    throw new IllegalStateException("이미 존재하는 도서입니다");
                });
    }

    // 전체 도서 조회
    public List<Book> findBook(){
        return bookRepository.findAll();
    }

    // 도서 한권 조회
    public Optional<Book> findOne(Long bookId){
        return bookRepository.findById(bookId);
    }
}
