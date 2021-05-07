package co.saimyr.bookstore.persistence.entity;

import javax.persistence.*;
@Entity
@Table(name = "BOOKS")
public class BookEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int isbn;
        private String name;
        private String author;
        private String publisher;
        private String genre;

        public int getIsbn() {
            return isbn;
        }
        public void setIsbn(int isbn) {
            this.isbn = isbn;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAuthor() {
            return author;
        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public String getPublisher() {
            return publisher;
        }
        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }
        public String getGenre() {
            return genre;
        }
        public void setGenre(String genre) {
            this.genre = genre;
        }
}

