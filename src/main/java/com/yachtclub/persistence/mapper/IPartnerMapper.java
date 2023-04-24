package com.yachtclub.persistence.mapper;

import com.yachtclub.domain.dto.PartnerDTO;
import com.yachtclub.persistence.entity.Partner;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IPartnerMapper {
    @Mappings({
            @Mapping(source = "partId", target = "id"),
            @Mapping(source = "partName", target = "name"),
            @Mapping(source = "partLastName",target = "lastName")
    })
    PartnerDTO toPartnerDTO(Partner partner);

    @InheritInverseConfiguration
    @Mapping(target = "partBirthDate", ignore = true)
    Partner toPartner(PartnerDTO partnerDTO);
}
