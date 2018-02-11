package com.shane.grade;

import java.util.List;

import com.shane.domain.AbstractDAO;

import org.springframework.stereotype.Repository;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

@Repository
public class GradeDAOImpl implements AbstractDAO<Grade> {
   
   @Override
   public Grade save(final Grade newGrade){
      return null;
   }
   
   @Override
   public Grade delete(final Grade newGrade){
      return null;
   }
   
   @Override
   public Grade findOne(final int pk){
      return null;
   }
   
   @Override
   public List<Grade> findAll(){
      return null;
   }
}
