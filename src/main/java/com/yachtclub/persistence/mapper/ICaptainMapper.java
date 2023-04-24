package com.yachtclub.persistence.mapper;

import com.yachtclub.domain.dto.CaptainDTO;
import com.yachtclub.persistence.entity.Captain;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICaptainMapper {
    @Mappings({
            @Mapping(source = "capId", target = "id"),
            @Mapping(source = "capName", target = "name"),
            @Mapping(source = "capLastName", target = "lastName"),
    })
    CaptainDTO toCaptainDTO(Captain captain);

    List<CaptainDTO> toCaptainsDTO(List<Captain> captains);

    @InheritInverseConfiguration
    @Mapping(target = "capBirthDate", ignore = true)
    Captain toCaptain(CaptainDTO captainDTO);
}
