package com.lenskartapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Brand {
    @Id
    @Column(name = "brandid")
    @GeneratedValue(generator = "brand_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_sequence", initialValue = 101, allocationSize = 1)
    private Integer brandId;
    @Enumerated(EnumType.STRING)
    private Shape shape;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String brandName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brand")
    Set<Frame> frames;

    public Brand(Shape shape, Type type, String brandName) {
        this.shape = shape;
        this.type = type;
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "shape=" + shape +
                ", type=" + type +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
