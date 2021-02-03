package com.codegym.airbnb.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Roomtype {
    private int id;
    private String name;
    private List<Home> homes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "roomtype", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
}
