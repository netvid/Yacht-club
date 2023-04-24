package com.yachtclub.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Entity
@Table(name = "departures")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Departure {
    // =================== ATRIBUTES  ===================
    @Id
    @Column(name = "dep_id", unique = true, nullable =  false)
    private Long depId;

    @Column(name = "dep_destination")
    private String depDestination;

    @Column(name = "dep_startdate")
    private Calendar depStartDate;

    @Column(name = "dep_enddate")
    private Calendar depEndDate;

    @Column(name = "ship_id")
    private String shipId;

    @Column(name = "cap_id")
    private String capId;

    // =================== RELATIONS ===================
    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "cap_id", insertable = false, updatable = false)
    private Captain captain;
}
