package com.shane.domain;

import java.util.List;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

public interface AbstractDAO<T> {
   
   T save(T t);
   T update(T t);
   T delete(T t);
   T findOne(int pk);
   List<T> findAll();
   List<T> findByName(String lookupName);
   // Since the com.shane.grade package was deleted, we no longer need to have an abstract interface as it defeats the purpose.
   // TODO: delete the AbstractDAO interface, DomainObject interface since we are working with Student as the core object.
}
