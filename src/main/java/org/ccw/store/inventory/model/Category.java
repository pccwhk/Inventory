package org.ccw.store.inventory.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="INV_CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CATEGORY_ID")
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinColumn(name="PARENT_CATEGORY_ID")
    @JsonManagedReference
    private Category parentCategory;

    @OneToMany(mappedBy="parentCategory")
    @JsonBackReference
    private List<Category> subcategory;

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<Category> subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId.equals(category.categoryId) &&
                name.equals(category.name) &&
                Objects.equals(parentCategory, category.parentCategory) &&
                Objects.equals(subcategory, category.subcategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, parentCategory, subcategory);
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", parentCategory=" + parentCategory +
                '}';
    }
}
