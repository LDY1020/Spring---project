package hello.bookmanagement.domain;

public class Book {

    private long id; // 도서 고유 번호
    private String title; // 책 제목
    private String author; // 작가
    private String isbn; // 국제표준도서번호


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
