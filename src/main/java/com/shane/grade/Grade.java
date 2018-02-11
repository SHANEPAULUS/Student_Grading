package com.shane.grade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.shane.domain.DomainObject;


/**
 * @author SP1
 * <BR>11-Feb-2018 : Created class (SP1)
 */

@Entity
public class Grade implements DomainObject {
   
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private int pk;
   private Double percentage;
   
   
   public Grade(final Double newPercentage){
      this.percentage = newPercentage;
   }
   
   
   /**
    * Getter for property pk.
    * @return Value of property pk.
    */
   @Override
   public final int getPk(){
      return this.pk;
   }
   
   /**
    * Setter for property pk.
    * @param newPk, the new value for property pk.
    */
   @Override
   public final void setPk(final int newPk){
      this.pk = newPk;
   }
   
   
   /**
    * Getter for property percentage.
    * @return Value of property percentage.
    */
   public final Double getPercentage(){
      return this.percentage;
   }
   
   /**
    * Setter for property percentage.
    * @param newPercentage, the new value for property percentage.
    */
   public final void setPercentage(final Double newPercentage){
      this.percentage = newPercentage;
   }
   
   
   @Override
   public String toString(){
      return "Grade{" + "pk=" + pk + ", percentage=" + percentage + '}';
   }
}
