package com.pe.nttdata.business.impl;

import com.pe.nttdata.business.EmpresarialService;
import com.pe.nttdata.dao.EmpresarialDao;
import com.pe.nttdata.model.entity.Empresarial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *Implement EmpresaServiceImpl. <br/>
 *<b>Class</b>: {@link EmpresarialServiceImpl}<br/>
 *<b>Copyright</b>: &Copy; 2024 NTTDATA Per&uacute;. <br/>
 *<b>Company</b>: NTTDATA del Per&uacute;. <br/>
 *
 *@author NTTDATA Per&uacute;. (EVE) <br/>
 *<u>Developed by</u>: <br/>
 *<ul>
 *<li>Hugo Oliveros Monti</li>
 *</ul>
 *<u>Changes</u>:<br/>
 *<ul>
 *<li>feb. 29, 2024 (acronym) Creation class.</li>
 *</ul>
 *@version 1.0
 */

@Service
@Slf4j
public class EmpresarialServiceImpl implements EmpresarialService {

  @Autowired
  private EmpresarialDao empresarialDao;

  @Override
  public Flux<Empresarial> findAll() {
    return empresarialDao.findAll();
  }

  @Override
  public Mono<Empresarial> findById(String id) {
    return empresarialDao.findById(id);
  }

  @Override
  public Mono<Empresarial> save(Empresarial empresa) {
    return empresarialDao.save(empresa);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return empresarialDao.deleteById(id);
  }

}