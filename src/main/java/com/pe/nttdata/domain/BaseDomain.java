package com.pe.nttdata.domain;


import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


/**
 *Implement BaseDomain. <br/>
 *<b>Class</b>: {@link BaseDomain}<br/>
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
public abstract class BaseDomain {


  /**
   * .
   * LocalDateTime createdDate
   **/
  @CreatedDate
  private LocalDateTime createdDate;

  /**
   * .
   * LocalDateTime lastModifiedDate
   **/
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  /**
   * .
   * String createdByUser
   **/
  @CreatedBy
  private String createdByUser;

  /**
   * .
   * String createdByUser
   **/
  @LastModifiedBy
  private String modifiedByUser;

}
