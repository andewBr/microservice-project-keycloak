package com.example.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column
    private String email;

    @Column
    private String password;

//    @Getter
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @Setter
//    @Getter
//    private UserProfile profile;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
//        return Objects.equals(id, user.id) && Objects.equals(uuid, user.uuid) && Objects.equals(email, user.email)
//               && Objects.equals(password, user.password) && Objects.equals(roles, user.roles);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, uuid, email, password, roles);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//               "id=" + id +
//               ", uuid=" + uuid +
//               ", email='" + email + '\'' +
//               ", password='" + password + '\'' +
//               ", roles=" + roles +
//               '}';
//    }
}
