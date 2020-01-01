package org.ccw.store.inventory.model;

import javax.persistence.*;

public class Subcategory {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parentcategory_id", insertable = false, updatable = false)
    private Category parentCategory;
}
