package com.yachtclub.persistence.mapper;

import com.yachtclub.domain.dto.DepartureDTO;
import com.yachtclub.persistence.entity.Departure;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IDepartureMapper {
    @Mappings({
            @Mapping(source = "depId", target = "id"),
            @Mapping(source = "depDestination",target = "destination"),
            @Mapping(source = "depStartDate",target = "startDate"),
            @Mapping(source = "depEndDate",target = "endDate")
    })
    DepartureDTO toDepartureDTO(Departure departure);

    @InheritInverseConfiguration
    Departure toDeparture(DepartureDTO departureDTO);
}
