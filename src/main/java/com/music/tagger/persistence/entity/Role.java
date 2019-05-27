package com.music.tagger.persistence.entity;

import com.music.tagger.persistence.entity.superclass.MarkedEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity(name = "Role")
@Table(name = "roles")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Role extends MarkedEntity {

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id",
            referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id",
            referencedColumnName = "id"))
    private List<Privilege> privileges;

    public Role(String name){
        setName(name);
    }
}
