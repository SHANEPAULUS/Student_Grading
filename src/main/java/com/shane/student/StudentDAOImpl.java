package com.shane.student;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import com.shane.domain.AbstractDAO;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Repository
@Transactional
public class StudentDAOImpl implements AbstractDAO<Student> {
   
   //private static final Log logger = LogFactory.getLog(StudentDAOImpl.class);

   private final SessionFactory sessionFactory;
   
   
   @Autowired
   public StudentDAOImpl(final SessionFactory sessionFactory){
      this.sessionFactory = sessionFactory;
   }
   
   
   @Override
   public Student save(final Student student){   // TODO: review the way the saving methods are working...
      this.sessionFactory.getCurrentSession().save(student);
      return student;
   }
   
   @Override
   public Student delete(final Student newStudent){
      this.sessionFactory.getCurrentSession().delete(newStudent);
      return findOne(newStudent.getPk());   // The return value should be null..
   }
   
   
   @Override
   public Student findOne(final int pk){
      return (Student)this.sessionFactory.getCurrentSession().get(Student.class, pk);
   }
   
   @Override
   public List<Student> findAll(){
      List<Student> studentList = new LinkedList<>();
   
      for(final Object object : this.sessionFactory.getCurrentSession().createQuery("from Student order by LastName desc").list()){
         Student student = (Student)object;
         studentList.add(student);
      }
      
      return studentList;
   }
   
   
   @Override
   public List<Student> findByName(final String lookupName){
      List<Student> studentList = new LinkedList<>();
      Query query = this.sessionFactory.getCurrentSession().createQuery("from Student where upper(FirstName) like upper('%" + lookupName.trim() + "%') order by LastName desc");
      
      for(final Object object : query.list()){
         Student student = (Student)object;
         studentList.add(student);
      }
      
      return studentList;
   }
}
