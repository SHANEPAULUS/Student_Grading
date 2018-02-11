package com.shane.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.shane.domain.DomainObject;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Entity
public class Student implements DomainObject {
   
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
   private int pk;
   private String firstName;
   private String lastName;
   private Integer age;
   private Double score;
   
   
   public Student(){
   }
   
   
   /**
    * Getter for property pk.
    * @return Value of property pk.
    */
   public final int getPk(){
      return this.pk;
   }
   
   /**
    * Setter for property pk.
    * @param newPk, the new value for property pk.
    */
   public final void setPk(final int newPk){
      this.pk = newPk;
   }
   
   /**
    * Getter for property firstName.
    * @return Value of property firstName.
    */
   public final String getFirstName(){
      return this.firstName;
   }
   
   /**
    * Setter for property firstName.
    * @param newFirstName, the new value for property firstName.
    */
   public final void setFirstName(final String newFirstName){
      this.firstName = newFirstName;
   }
   
   /**
    * Getter for property lastName.
    * @return Value of property lastName.
    */
   public final String getLastName(){
      return this.lastName;
   }
   
   /**
    * Setter for property lastName.
    * @param newLastName, the new value for property lastName.
    */
   public final void setLastName(final String newLastName){
      this.lastName = newLastName;
   }
   
   /**
    * Getter for property age.
    * @return Value of property age.
    */
   public final Integer getAge(){
      return this.age;
   }
   
   /**
    * Setter for property age.
    * @param newAge, the new value for property age.
    */
   public final void setAge(final Integer newAge){
      this.age = newAge;
   }
   
   /**
    * Getter for property score.
    * @return Value of property score.
    */
   public final Double getScore(){
      return this.score;
   }
   
   /**
    * Setter for property score.
    * @param newScore, the new value for property score.
    */
   public final void setScore(final Double newScore){
      this.score = newScore;
   }
   
   
   @Override public String toString(){
      return "Student{" + "pk=" + this.pk + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", age=" + this.age + '}';
   }
}
