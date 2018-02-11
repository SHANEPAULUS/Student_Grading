package com.shane.home;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import com.shane.domain.DomainObject;
import com.shane.domain.GenericController;
import com.shane.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author SP1
 * <BR>10-Feb-2018 : Created class (SP1)
 */

@Controller("homeViewController")
@RequestMapping({"/", "/home.htm"})
public class ViewController extends GenericController {
   
   private final StudentService studentService;
   
   
   @Autowired
   public ViewController(final StudentService newStudentService){
      this.studentService = newStudentService;
   }
   
   
   @GetMapping
   public ModelAndView home(final HttpServletRequest request) throws UnsupportedEncodingException{
      final String notificationMessage = URLDecoder.decode(ServletRequestUtils.getStringParameter(request, "notificationMessage", ""), "UTF-8");
      
      this.model.put("NEW_OBJECT_PK", DomainObject.NEW_OBJECT_PK);
      this.model.put("hasStudentsCaptured", this.studentService.findAll().size() > 0);
      this.model.put("notificationMessage", notificationMessage);
      
      return new ModelAndView("home", this.model);
   }
}
