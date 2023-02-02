package chapter02.item3.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

public class Book implements Externalizable {

    private static final long serialVersionUID = -3157775710403758143L;

    private String isbn;

    private String title;

    private String author;

    private LocalDate published;

    private transient int numberOfSold;

    public Book() {
    }

    public Book(String isbn, String title, String author, LocalDate published) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published=" + published +
                ", numberOfSold=" + numberOfSold +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public void setNumberOfSold(int numberOfSold) {
        this.numberOfSold = numberOfSold;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(isbn);
        out.writeUTF(title);
        out.writeUTF(author);
        out.writeInt(numberOfSold); // transient 직렬화 가능
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        this.isbn = in.readUTF();
        this.title = in.readUTF();
        this.author = in.readUTF();
        this.numberOfSold = in.readInt();
    }
}