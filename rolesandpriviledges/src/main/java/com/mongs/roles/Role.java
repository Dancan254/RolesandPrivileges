package com.mongs.roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
    @ManyToMany
    @JoinTable(
            name = "Role_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "privileges_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "NULL", referencedColumnName = "NULL"))
    private Collection<Privilege> privileges;

    public Role(String name) {
        this.name = name;
    }
}
