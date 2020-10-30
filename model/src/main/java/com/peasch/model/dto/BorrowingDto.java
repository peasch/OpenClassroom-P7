package com.peasch.model.dto;

import com.peasch.model.entities.Copy;
import com.peasch.model.entities.User;
import lombok.*;

import java.io.Serializable;


public class BorrowingDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String borrowingDate;
    private String returnDate;
    private boolean extended;
    private User user;
    private Copy copy;
    private Boolean returned;

    public BorrowingDto() {
    }

    public BorrowingDto(int id, String borrowingDate, String returnDate, boolean extended, User user, Copy copy, Boolean returned) {
        this.id = id;
        this.borrowingDate = borrowingDate;
        this.returnDate = returnDate;
        this.extended = extended;
        this.user = user;
        this.copy = copy;
        this.returned = returned;
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

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
