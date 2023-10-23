package com.example.spring.account_ms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gmail")
public class Gmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password", length = 256)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinTable(
            name = "account_gmail",
            joinColumns = @JoinColumn(name = "gmail_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<ManagedAccount> managedAccount;

    public Gmail(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
