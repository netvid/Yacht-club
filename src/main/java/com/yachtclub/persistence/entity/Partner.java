package com.yachtclub.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "partners")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Partner {
    // =================== ATRIBUTES  ===================
    @Id
    @Column(name = "part_id", unique = true, nullable = false)
    private String partId;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "part_lastname")
    private String partLastName;

    @Column(name = "part_birthdate")
    private Calendar partBirthDate;

    // =================== RELATIONS ===================

    @OneToMany(mappedBy = "partner")
    private List<Ship> ships;
}
