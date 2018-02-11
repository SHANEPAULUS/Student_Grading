package com.shane.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

public abstract class GenericController {
   
   protected static final Log logger = LogFactory.getLog(GenericController.class);
   
   protected Map<String, Object> model;
   
   
   public GenericController(){
      this.model = new HashMap<>();
   }
}
