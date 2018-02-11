package com.shane.student;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

public class StudentServiceTest {

   private static StudentService studentService;
   
   
   private Student buildStudent(){
      Student student = new Student();
      student.setPk(1);
      student.setFirstName("Shane");
      student.setLastName("Paulus");
      student.setAge(23);
      
      return student;
   }
   
   
   @Before
   public void setupBefore(){
      studentService = new StudentService(null);
   }
   
   @After
   public void cleanup(){
      studentService = null;
   }
   
   
   @Test
   public void testHasUniqueNameFailure(){
      /*studentService = spy(studentService);
      doReturn(false).when(studentService).*/
   }
   
   @Test
   public void testRead(){
      final Student student = buildStudent();
      studentService = mock(StudentService.class);
      when(studentService.read(student.getPk())).thenReturn(student);
      
      assertEquals("First name of the student should match the one from the service", student.getFirstName(), studentService.read(student.getPk()).getFirstName());
   }
   
   
   
   @Test
   public void hasNoUniqueFirstName(){
      studentService = mock(StudentService.class);
      when(studentService.nameAlreayExists("shane")).thenReturn(true);   // Meaning the name 'shane' is already existing.
      
      assertEquals("Name 'shane' is not unique", true, studentService.nameAlreayExists("shane"));
   }
   
   
   @Test
   public void hasHasUniqueFirstName(){
      studentService = mock(StudentService.class);
      when(studentService.nameAlreayExists("shane")).thenReturn(false);
      
      assertEquals("Name 'shane' is unique", false, studentService.nameAlreayExists("shane"));
   }
}
