package com.pe.nttdata.dao.repository;

import com.pe.nttdata.model.entity.Personal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends ReactiveMongoRepository<Personal, String> {


}
