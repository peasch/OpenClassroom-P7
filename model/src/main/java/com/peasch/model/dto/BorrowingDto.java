package com.peasch.model.dto;

import java.io.Serializable;


public class BorrowingDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String borrowingDate;
    private String returnDate;
    private boolean extended;
    private UserDto user;
    private CopyDto copy;
    private Boolean returned;

    public BorrowingDto() {
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

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public CopyDto getCopy() {
        return copy;
    }

    public void setCopy(CopyDto copy) {
        this.copy = copy;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
