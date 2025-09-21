package io.granix.user.entity;

import io.granix.user.entity.utils.RoleNames;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

import java.util.NoSuchElementException;

@Entity
@Table(name = "pz_role")
public class Role extends PanacheEntity {
    @Enumerated(EnumType.STRING)
    public RoleNames name;

    public Role(){ }

    public Role(RoleNames name) {
        this.name = name;
    }

    public static Role findByRoleName(RoleNames name)
    {
        try{
            return (Role) list("name", name).getFirst();
        } catch (NoSuchElementException e)
        {
            System.out.println("Warning: "+e.getMessage());
            return null;
        }
    }

    @Transactional
    public static Role findOrCreate(RoleNames name)
    {
        var role = Role.findByRoleName(name) != null ? Role.findByRoleName(name) : null;

        if(role == null) {
            role = new Role(name);
            role.persistAndFlush();
        }

        return role;
    }
}
