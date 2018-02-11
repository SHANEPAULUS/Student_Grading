package com.shane.student;

import java.util.LinkedList;
import java.util.List;

import com.shane.domain.AbstractDAO;
import com.shane.domain.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Service("studentService")
public class StudentService implements AbstractService<Student> {
   
   //private static final Log logger = LogFactory.getLog(StudentService.class);
   
   private final AbstractDAO<Student> studentDAO;
   
   
   @Autowired
   public StudentService(final AbstractDAO<Student> studentDAO){
      this.studentDAO = studentDAO;
   }
   
   
   @Override
   public Student read(final Integer pk){
      return this.studentDAO.findOne(pk);
   }
   
   @Override
   public Student save(final Student newStudent){
      return this.studentDAO.save(newStudent);
   }
   
   
   @Override
   public Student update(final Student newStudent){
      return this.studentDAO.update(newStudent);
   }
   
   @Override
   public Student delete(final Student newStudent){
      return this.studentDAO.delete(newStudent);
   }
   
   @Override
   public List<Student> findAll(){
      return this.studentDAO.findAll();
   }
   
   public List<Student> findByName(final String lookupName){
      return this.studentDAO.findByName(lookupName);
   }
   
   public boolean checkIfFirstNameAlreadyExist(final String lookupName){
      List<Student> studentList = new LinkedList<>(findByName(lookupName));
      return studentList.stream().anyMatch(s -> isStringMatch(s.getFirstName(), lookupName));
   }
   
   
   private boolean isStringMatch(final String string1, final String string2){
      return string1 != null && string2 != null && string1.trim().equalsIgnoreCase(string2.trim());
   }
}
