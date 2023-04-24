package com.yachtclub.web.controller;

import com.yachtclub.domain.dto.CaptainDTO;
import com.yachtclub.domain.service.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/captains")
public class CaptainController {

    @Autowired
    private CaptainService captainService;

    @GetMapping("/all")
    public ResponseEntity<List<CaptainDTO>> getAll(){
        return new ResponseEntity<>(captainService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaptainDTO> getById(@PathVariable("id") String id){
        return captainService.getCaptain(id).map(captainDTO -> {
            return new ResponseEntity<>(captainDTO, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<CaptainDTO> save(@RequestBody CaptainDTO captainDTO){
        return new ResponseEntity<>(captainService.save(captainDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")String id){
        if(captainService.delete(id)) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
