package org.ccw.store.inventory.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVENTORY_ID")
    private Long inventoryId;

    @Column(name="QTY")
    private Long quantity;

    @Column(nullable = false)
    private String name;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", insertable = false, updatable = false)
    @JsonManagedReference
    private Category subcategory;

    public Inventory(){}

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Category subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return inventoryId.equals(inventory.inventoryId) &&
                quantity.equals(inventory.quantity) &&
                name.equals(inventory.name) &&
                subcategory.equals(inventory.subcategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, quantity, name, subcategory);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", subcategory=" + subcategory +
                '}';
    }
}
