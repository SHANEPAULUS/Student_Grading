package com.shane.student;

import static junit.framework.TestCase.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

public class StudentTest {


   private static StudentValidator studentValidator;
   private static Student student;
   
   
   private static void test(final String testingScenario, final boolean errorExpected){   // TODO: implement the field and error code specific test lookups..
      BindingResult result = new BeanPropertyBindingResult(student, "student");
      studentValidator.validate(student, result);
      
      assertEquals(testingScenario, result.hasErrors(), errorExpected);
   }
   
   
   @Before
   public void setupBefore(){
      studentValidator = new StudentValidator(null);
      student = new Student();
   }
   
   
   @After
   public void cleanup(){
      student = null;
   }
   
   @Test
   public void testStudentObjectNotInitialized(){
      student = null;
      test("Student object not yet initialized", true);
   }
   
   
   @Test
   public void testStudentFirstNameNull(){
      student.setFirstName(null);
      test("Student first name is equal to null", true);
      assertEquals("Student first name is equal null", student.getFirstName(), null);
   }
}
