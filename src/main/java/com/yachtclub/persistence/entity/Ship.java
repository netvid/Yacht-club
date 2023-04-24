package com.yachtclub.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ships")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ship {

    // =================== ATRIBUTES  ===================
    @Id
    @Column(name = "ship_id", unique = true, nullable = false)
    private String shipId;

    @Column(name = "ship_name")
    private String shipName;

    @Column(name = "ship_num_moorage")
    private Long shipNumMoorage;

    @Column(name = "ship_price")
    private BigDecimal shipPrice;

    @Column(name = "part_id")
    private String partId;

    // =================== RELATIONS ===================
    @ManyToOne
    @JoinColumn(name = "part_id", insertable = false, updatable = false)
    private Partner partner;

    @OneToMany(mappedBy = "ship")
    private List<Departure> departures;
}
