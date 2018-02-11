package com.shane.student;

import org.springframework.beans.factory.annotation.Autowired;
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
   
   private StudentService studentService;
   
   
   @Autowired
   public StudentValidator(final StudentService newStudentService){
      this.studentService = newStudentService;
   }
   
   
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
         }else if(this.studentService.nameAlreayExists(student.getFirstName())){
            errors.rejectValue("firstName", "error.unique.value.required", new Object[]{new DefaultMessageSourceResolvable("FirstName")}, "error.unique.value.required");
         }
      }
   }
   
   
   /*private boolean isEmptyString(final String stringToCheck){
      return stringToCheck == null || stringToCheck.trim().equals("");
   }*/
}
