package com.yachtclub.persistence.mapper;

import com.yachtclub.domain.dto.ShipDTO;
import com.yachtclub.persistence.entity.Ship;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IShipMapper {
    @Mappings({
            @Mapping(source = "shipId", target = "id"),
            @Mapping(source = "shipName", target = "name"),
            @Mapping(source = "shipPrice",target = "price")
    })
    ShipDTO toShipDTO(Ship ship);

    @InheritInverseConfiguration
    @Mapping(target = "shipNumMoorage", ignore = true)
    Ship toShip(ShipDTO shipDTO);
}
