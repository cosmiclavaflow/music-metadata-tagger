package com.music.tagger.persistence.entity;

import com.music.tagger.persistence.entity.superclass.MarkedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "users")
@Entity(name = "User")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends MarkedEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "encoded_password")
    private String password;

    @Column(name = "isEnabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
}
