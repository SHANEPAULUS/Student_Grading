package com.shane.student;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Controller("studentValidator")
public class StudentValidator implements Validator {
   
   @Override
   public boolean supports(final Class<?> newClass){
      return newClass.equals(Student.class);
   }
   
   
   @Override
   public void validate(final Object object, final Errors errors){
      if(object == null){
         errors.reject("error.value.mandatory", new Object[]{new DefaultMessageSourceResolvable("Student")}, "error.value.mandatory");
      }else{
         final Student student = (Student)object;
         
         if(StringUtils.isEmpty(student.getFirstName())){
            errors.rejectValue("firstName", "error.value.mandatory", new Object[]{new DefaultMessageSourceResolvable("FirstName")}, "error.value.mandatory");
         }
      }
   }
   
   
   /*private boolean isEmptyString(final String stringToCheck){
      return stringToCheck == null || stringToCheck.trim().equals("");
   }*/
}
