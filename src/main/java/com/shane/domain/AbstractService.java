package com.shane.domain;

import java.util.List;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */


public interface AbstractService<T> {

   T read(Integer pk);
   T save(T t);
   T delete(T t);
   List<T> findAll();
}
