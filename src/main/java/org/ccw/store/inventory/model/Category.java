package org.ccw.store.inventory.model;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
}
