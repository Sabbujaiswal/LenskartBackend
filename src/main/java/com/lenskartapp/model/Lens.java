package com.lenskartapp.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Lens {
    @Id
    @Column(name = "lensid")
    @GeneratedValue(generator = "lens_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "lens_seq", sequenceName = "lens_sequence", initialValue = 50, allocationSize = 1)
    private Integer lensId;
    @Column(length = 20)
    private String brand;
    @Column(name = "lenspower", length = 20)
    private double lensPower;

    public Lens(String brand, double lensPower) {
        this.brand = brand;
        this.lensPower = lensPower;
    }
}
