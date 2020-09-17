package com.peasch.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="borrowing")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_copy")
    private Copy copy;

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", borrowingDate='" + borrowingDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", extended=" + extended +
                ", user=" + user +
                ", copy=" + copy +
                '}';
    }
}
