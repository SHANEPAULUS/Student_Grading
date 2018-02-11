package com.shane.domain;

/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

public interface DomainObject {
   
   int NEW_OBJECT_PK = 0;
   
   
   int getPk();
   void setPk(int newPk);
}
