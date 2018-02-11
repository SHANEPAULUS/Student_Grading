package com.shane.student;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.shane.domain.DomainObject;
import com.shane.domain.GenericController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Controller("studentViewController")
public class ViewController extends GenericController {
   
   private final StudentService studentService;
   
   
   @Autowired
   public ViewController(final StudentService studentService){
      this.studentService = studentService;
   }
   
   
   @GetMapping("/studentView.htm")
   public ModelAndView studentView(final HttpServletRequest request){
      ModelAndView modelAndView;
      final int pk = ServletRequestUtils.getIntParameter(request, "pk", DomainObject.NEW_OBJECT_PK);
      final boolean isOnStudentListView = ServletRequestUtils.getBooleanParameter(request, "isOnStudentListView", false);
      
      if(pk != DomainObject.NEW_OBJECT_PK){
         final Student student = this.studentService.read(pk);
         this.model.put("student", student);
         this.model.put("isOnStudentListView", isOnStudentListView);
         
         modelAndView = new ModelAndView("student/studentView", this.model);
      }else{
         modelAndView = new ModelAndView("redirect:/notFound.htm?pk=" + pk + "&isStudent=true");
      }
      
      return modelAndView;
   }
   
   
   @GetMapping("/studentSearch.htm")
   public ModelAndView searchStudent(final HttpServletRequest request){
      final String studentName = ServletRequestUtils.getStringParameter(request, "studentName", "");
      
      if(!studentName.trim().equals("")){   // We are definitely looking for a student...
         List<Student> studentList = this.studentService.findByName(studentName);
      }
      
      return new ModelAndView("student/studentSearch", this.model);
   }
   
   
   @GetMapping("/studentListView.htm")
   public ModelAndView studentListView(){
      this.model.put("studentList", this.studentService.findAll());
      
      return new ModelAndView("student/studentListView", this.model);
   }
   
   @GetMapping("/deleteStudent.htm")
   public ModelAndView deleteStudent(final HttpServletRequest request) throws UnsupportedEncodingException{
      ModelAndView modelAndView;
      final int pk = ServletRequestUtils.getIntParameter(request, "pk", DomainObject.NEW_OBJECT_PK);
      final boolean isOnStudentListView = ServletRequestUtils.getBooleanParameter(request, "isOnStudentListView", false);
      
      if(pk != DomainObject.NEW_OBJECT_PK){
         final Student student = this.studentService.read(pk);
         
         if(student != null){
            final String studentName = student.getFirstName() + " " + student.getLastName();
            String notificationMessage;
            String appropriateView;
            final boolean deleted = this.studentService.delete(student) == null;
            
            if(deleted){
               notificationMessage = "Successfully deleted " + studentName;
               appropriateView = isOnStudentListView ? "studentListView.htm" : "home.htm";
            }else{
               notificationMessage = "Failed to delete " + studentName;
               appropriateView = "studentView.htm?pk=" + pk;
            }
            
            notificationMessage = URLEncoder.encode(notificationMessage, "UTF-8");
            modelAndView = new ModelAndView("redirect:/" + appropriateView + "?notificationMessage=" + notificationMessage);
         }else{
            modelAndView = new ModelAndView("redirect:/home.htm", this.model);
         }
      }else{
         modelAndView = new ModelAndView("redirect:/notFound.htm?pk" + pk + "&isStudent=true");
      }
      
      return modelAndView;
   }
}
