package com.yachtclub.domain.repository;


import com.yachtclub.domain.dto.CaptainDTO;

import java.util.List;
import java.util.Optional;


public interface ICaptainDTORepository{
    CaptainDTO save(CaptainDTO captainDTO);
    Optional<CaptainDTO> getCaptain(String id);
    List<CaptainDTO> getALl();
    void delete(String id);
}
