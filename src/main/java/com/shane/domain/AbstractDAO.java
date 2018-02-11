package com.shane.domain;

import java.util.List;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

public interface AbstractDAO<T> {
   
   T save(T t);
   T delete(T t);
   T findOne(int pk);
   List<T> findAll();
}
