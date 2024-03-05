package com.pe.nttdata.util;

import com.google.gson.Gson;

/**
 *Implement MapperUtils. <br/>
 *<b>Class</b>: {@link MapperUtils}<br/>
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
public class MapperUtils {

  /**
   * Converts a source object to a destination with fields with the same name.
   *
   * @param <D>     the type parameter
   * @param destino la clase destino a convertir
   * @param origen  objeto origen a transformar
   * @return el objeto de destino de la clase <code>destino</code>
   */
  public static <D> D mapper(Class<D> destino, Object origen) {
    if (origen == null) {
      return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(gson.toJson(origen), destino);
  }


  /**
   * Converts a json string to a target with fields with the same name..
   *
   * @param <D>     the type parameter
   * @param destino la clase destino a convertir
   * @param json    string json a transformar
   * @return el objeto de destino de la clase <code>destino</code>
   */
  public static <D> D mapper(Class<D> destino, String json) {
    if (json == null) {
      return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(json, destino);
  }

}
