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
public class Frame {
    @Id
    @Column(length = 20, name = "frameid")
    @GeneratedValue(generator = "frame_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "frame_seq", sequenceName = "frame_sequence", initialValue = 1, allocationSize = 1)
    private Integer frameId;
    @Column(length = 20)
    private String name;
    @Column(name = "framesize", length = 20)
    private String frameSize;
    @Column(length = 20)
    private String color;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 10)
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lensid")
    private Lens lens;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "frame_category", joinColumns = @JoinColumn(name = "frameid"), inverseJoinColumns = @JoinColumn(name = "categoryid"))
    private Set<Category> categories;

    public Frame(String name, String frameSize, String color, Gender gender, double price, Lens lens, Brand brand, Set<Category> categories) {
        this.name = name;
        this.frameSize = frameSize;
        this.color = color;
        this.gender = gender;
        this.price = price;
        this.lens = lens;
        this.brand = brand;
        this.categories = categories;

    }

    @Override
    public String toString() {
        return "Frame{" +
                "name='" + name + '\'' +
                ", frameSize='" + frameSize + '\'' +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                ", lens=" + lens +
                ", brand=" + brand +
                ", categories=" + categories +
                '}';
    }
}
