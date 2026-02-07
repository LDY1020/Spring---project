package hello.bookmanagement.reposity;

import hello.bookmanagement.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Book save(Book book); // 책 저장

    Optional<Book> findById(long id); // ID로 찾기

    Optional<Book> findByTitle(String title); // 제목으로 찾기

    List<Book> findAll(); // 전체 조회
}
