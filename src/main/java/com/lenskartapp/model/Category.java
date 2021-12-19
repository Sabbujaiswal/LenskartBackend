package com.lenskartapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @Column(name = "categoryid")
    @GeneratedValue(generator = "brand_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_sequence", initialValue = 151, allocationSize = 1)
    private Integer categoryId;
    @Column(name = "categoryname")
    private String categoryName;
    private String material;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Frame> frames;

    public Category(String categoryName, String material) {
        this.categoryName = categoryName;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
