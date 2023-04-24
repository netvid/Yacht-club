package com.yachtclub.domain.service;

import com.yachtclub.domain.dto.CaptainDTO;
import com.yachtclub.domain.repository.ICaptainDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaptainService {

    @Autowired
    private ICaptainDTORepository captainRepository;

    public Optional<CaptainDTO> getCaptain(String captainId){
        return captainRepository.getCaptain(captainId);
    }

    public List<CaptainDTO> getAll(){
        return (List<CaptainDTO>) captainRepository.getALl();
    }

    public CaptainDTO save(CaptainDTO captainDTO){
        return captainRepository.save(captainDTO);
    }

    /**
     * Check if the Captain exists before to delete using the Optional list to map the object and if it is possible map the object it means that it exists;
     * @param captainId
     * @return
     */
    public boolean delete(String captainId){
        return getCaptain(captainId).map(captainDTO -> {
            this.captainRepository.delete(captainId);
            return true;
        }).orElse(false);
    }

}
