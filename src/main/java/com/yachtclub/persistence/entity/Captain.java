package com.yachtclub.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "captains")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Captain {

    // =================== ATRIBUTES  ===================
    @Id
    @Column(name = "cap_id", unique = true, nullable = false)
    private String capId;

    @Column(name = "cap_name")
    private String capName;

    @Column(name = "cap_lastname")
    private String capLastName;

    @Column(name = "cap_birthdate")
    private Calendar capBirthDate;

    // =================== RELATIONS ===================
    @OneToMany(mappedBy = "captain")
    List<Departure> departures;
}
