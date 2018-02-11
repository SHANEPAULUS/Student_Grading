package com.shane.student;

import javax.servlet.http.HttpServletRequest;

import com.shane.domain.DomainObject;
import com.shane.domain.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Controller("studentEditController")
public class EditController extends GenericController {
   
   private final StudentService studentService;
   private final StudentValidator validator;
   
   @Autowired
   public EditController(final StudentService studentService, final StudentValidator validator){
      this.studentService = studentService;
      this.validator = validator;
   }
   
   
   @GetMapping("/studentEdit.htm")
   public ModelAndView userEdit(final HttpServletRequest request){
      final Integer pk = ServletRequestUtils.getIntParameter(request, "pk", DomainObject.NEW_OBJECT_PK);
      Student student;
      
      if(pk != 0){
         student = this.studentService.read(pk);
      }else{
         student = new Student();
      }
      
      loadModelProperties(student);
      return new ModelAndView("student/studentEdit", this.model);
   }
   
   
   @GetMapping("/studentScoreCapture.htm")
   public ModelAndView studentScoreEdit(final HttpServletRequest request){
      final int pk = ServletRequestUtils.getIntParameter(request, "pk", DomainObject.NEW_OBJECT_PK);
      final Student student = this.studentService.read(pk);
      this.model.put("student", student);
      this.model.put("oldScore", student.getScore());
      
      return new ModelAndView("student/studentScoreEdit", this.model);
   }
   
   @GetMapping("/submitStudentScore.htm")
   public ModelAndView submitStudentScore(final HttpServletRequest request){
      final Double oldScore = ServletRequestUtils.getDoubleParameter(request, "oldScore", 0.0);
      final Double newScore = ServletRequestUtils.getDoubleParameter(request, "newScore", 0.0);
      final Student student = this.studentService.read(ServletRequestUtils.getIntParameter(request, "pk", DomainObject.NEW_OBJECT_PK));
      
      System.out.println("oldScore >> " + oldScore + "\tnewScore >> " + newScore);
      
      student.setScore(newScore);
      this.studentService.update(student);
      
      this.model.put("student", student);
      
      if(student.getScore() != null){
         String scoreMessage;
         
         if(oldScore.compareTo(student.getScore()) == 0){
            scoreMessage = "The score for " + student.getFirstName() + " is the same.";
         }else if(oldScore.compareTo(student.getScore()) < 0){
            scoreMessage = "The score for " + student.getFirstName() + " has improved from " + oldScore + " to " + student.getScore();
         }else{
            scoreMessage = "The score for " + student.getFirstName() + " has worsened from " + oldScore + " to " + student.getScore();
         }
         
         this.model.put("notificationMessage", scoreMessage);
      }
      
      return new ModelAndView("student/studentView", this.model);
   }
   
   
   @PostMapping
   public ModelAndView submitStudent(@ModelAttribute(value="student") final Student student, final BindingResult bindingResult){
      ModelAndView modelAndView;
      this.validator.validate(student, bindingResult);
      
      if(bindingResult.hasErrors()){
         loadModelProperties(student);
         modelAndView = new ModelAndView("redirect:/studentEdit.htm?pk=" + student.getPk(), this.model);
      }else{
         final Student savedStudent = this.studentService.save(student);
         
         if(savedStudent != null && savedStudent.getPk() != DomainObject.NEW_OBJECT_PK){   // We know that student has saved successfully.
            modelAndView = new ModelAndView("redirect:/studentView.htm?pk=" + student.getPk());
         }else{
            modelAndView = new ModelAndView("redirect:/error.htm", this.model);
         }
      }
      
      return modelAndView;
   }
   
   
   private void loadModelProperties(final Student student){
      this.model.put("student", student);
   }
}
