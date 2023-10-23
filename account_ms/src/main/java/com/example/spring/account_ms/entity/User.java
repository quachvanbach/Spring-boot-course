package com.example.spring.account_ms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Blob;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "username")
    private String username;
    @NotBlank
    @Column(name = "password", length = 256)
    private String password;
    @Column(name = "enable")
    private boolean enable;
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotBlank
    @Column(name = "email")
    private String email;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Lob
    @Column(name = "avatar")
    private Blob avatar;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    @ToString.Exclude
    @OneToMany(mappedBy = "user",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.DETACH})
    private List<ManagedAccount> managedAccount;

    public User(String username, String password, boolean enable, String firstName, String lastName, String email, String phonenumber, Blob avatar, Role role, List<ManagedAccount> managedAccount) {
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phonenumber = phonenumber;
        this.avatar = avatar;
        this.role = role;
        this.managedAccount = managedAccount;
    }
}
