package com.yachtclub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartureDTO {
    private Long id;

    private String destination;

    private Calendar startDate;

    private Calendar endDate;

    private String shipId;

    private String capId;

}

