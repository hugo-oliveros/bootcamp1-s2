package com.pe.nttdata.dao.repository;

import com.pe.nttdata.model.entity.Empresarial;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresarialRepository extends ReactiveMongoRepository<Empresarial, String> {


}
