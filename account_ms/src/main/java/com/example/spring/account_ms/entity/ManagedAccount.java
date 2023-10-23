package com.example.spring.account_ms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "managed_account")
public class ManagedAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 256)
    private String password;
    @Column(name = "two_fa")
    private String twoFA;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "phonenumber")

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinTable(
            name = "account_phonenumber",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "phonenumber_id")
    )
    private List<Phonenumber> phonenumbers;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinTable(
            name = "account_gmail",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "gmail_id")
    )
    private List<Gmail> gmail;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinColumn(name = "user_id")
    private User user;

    public ManagedAccount(String accountType, String username, String password, String twoFA, String firstName, String lastName, Date dob, List<Phonenumber> phonenumbers, List<Gmail> gmail, User user) {
        this.accountType = accountType;
        this.username = username;
        this.password = password;
        this.twoFA = twoFA;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phonenumbers = phonenumbers;
        this.gmail = gmail;
        this.user = user;
    }
}
