package com.example.cascadeonetomany.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @OneToMany(
        cascade = {
        //if no CascadeType.PERSIST - cant perform post method
            CascadeType.PERSIST,
        //if no CascadeType.MERGE - only the parent will be updated
                CascadeType.MERGE,
        //if no CascadeType.REMOVE - only the parent will be removed
            CascadeType.REMOVE,
        },
            fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private List<Story> storyList = new ArrayList<>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", storyList=" + storyList +
                '}';
    }
}
