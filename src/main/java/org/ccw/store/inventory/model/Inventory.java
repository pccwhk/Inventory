package org.ccw.store.inventory.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private long id;

    private long quantity;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "subcategory_id", insertable = false, updatable = false)
    private Subcategory subcategory;

    public Inventory(){};


}
