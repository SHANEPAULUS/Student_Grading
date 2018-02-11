package com.shane.grade;

import java.util.List;

import com.shane.domain.AbstractDAO;
import com.shane.domain.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

@Service("gradeService")
public class GradeService implements AbstractService<Grade> {

   private final AbstractDAO<Grade> gradeDAO;
   
   
   @Autowired
   public GradeService(final AbstractDAO<Grade> newGradeDAO){
      this.gradeDAO = newGradeDAO;
   }
   
   
   @Override
   public Grade read(final Integer pk){
      return this.gradeDAO.findOne(pk);
   }
   
   @Override
   public Grade save(final Grade newGrade){
      return this.gradeDAO.save(newGrade);
   }
   
   @Override
   public Grade delete(final Grade newGrade){
      return null;
   }
   
   @Override
   public List<Grade> findAll(){
      return this.gradeDAO.findAll();
   }
}
