package com.yachtclub.persistence.crud;

import com.yachtclub.persistence.entity.Captain;
import org.springframework.data.repository.CrudRepository;

/**
 * this class is which interacts with the database using the real Entitys
 */
public interface ICaptainCrudRepository extends CrudRepository<Captain,String> {
}
