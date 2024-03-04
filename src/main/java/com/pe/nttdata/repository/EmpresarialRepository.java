package com.pe.nttdata.repository;


import com.pe.nttdata.entity.Empresarial;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresarialRepository extends ReactiveMongoRepository<Empresarial, String> {


}
