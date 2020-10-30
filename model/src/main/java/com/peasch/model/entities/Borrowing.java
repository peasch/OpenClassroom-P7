package com.peasch.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="borrowing")

public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="borrowing_date")
    private String borrowingDate;
    @Column(name="returnDate")
    private String returnDate;
    @Column(name="extended")
    private boolean extended;
    @Column(name="returned")
    private Boolean returned;

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_copy")
    private Copy copy;

    public Borrowing(int id, String borrowingDate, String returnDate, boolean extended, Boolean returned, User user, Copy copy) {
        this.id = id;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.extended = extended;
        this.returned = returned;
        this.user = user;
        this.copy = copy;
    }

    public Borrowing() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(String borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isExtended() {
        return extended;
    }

    public void setExtended(boolean extended) {
        this.extended = extended;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }
}
