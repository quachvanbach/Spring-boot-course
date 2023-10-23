package com.example.spring.account_ms.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "phonenumber")
public class Phonenumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "source")
    private String source;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    @JoinTable(
            name = "account_phonenumber",
            joinColumns = @JoinColumn(name = "phonenumber_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<ManagedAccount> managedAccount;

    @Override
    public String toString() {
        return phonenumber + "(" + source + ") \n";
    }
}
