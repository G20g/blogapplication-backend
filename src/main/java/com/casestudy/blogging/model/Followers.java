package com.casestudy.blogging.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User users;

    @ManyToOne
    private User users1;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUsers() {
        return users;
    }
    public void setUsers(User users) {
        this.users = users;
    }
    public User getUsers1() {
        return users1;
    }
    public void setUsers1(User users1) {
        this.users1 = users1;
    }


    @Override
    public String toString() {
        return "Followers{" +
                "id=" + id +
                ", users=" + users +
                ", users1=" + users1 +
                '}';
    }
}
