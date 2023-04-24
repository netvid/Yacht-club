package com.yachtclub.persistence;

import com.yachtclub.domain.dto.CaptainDTO;
import com.yachtclub.domain.repository.ICaptainDTORepository;
import com.yachtclub.persistence.crud.ICaptainCrudRepository;
import com.yachtclub.persistence.entity.Captain;
import com.yachtclub.persistence.mapper.ICaptainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public class CaptainRepository implements ICaptainDTORepository{

    @Autowired
    private ICaptainCrudRepository captainCrudRepository;

    @Autowired
    private ICaptainMapper mapper;


    @Override
    public Optional<CaptainDTO> getCaptain(String id) {
        return captainCrudRepository.findById(id)
                .map(captain -> mapper.toCaptainDTO(captain));
    }

    @Override
    public List<CaptainDTO> getALl() {
        return mapper.toCaptainsDTO((List<Captain>) captainCrudRepository.findAll());
    }

    @Override
    public void delete(String id) {
        captainCrudRepository.deleteById(id);
    }

    @Override
    public CaptainDTO save(CaptainDTO captainDTO) {
        Captain captain = mapper.toCaptain(captainDTO);
        return mapper.toCaptainDTO(captainCrudRepository.save(captain));
    }
}
