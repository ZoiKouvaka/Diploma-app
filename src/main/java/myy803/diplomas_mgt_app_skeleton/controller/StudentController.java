package myy803.diplomas_mgt_app_skeleton.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	@Autowired 
	SubjectService subjectService;

	
	
	
    @RequestMapping("/student/dashboard")
    public String getstudentHome(){

		
        return "student/dashboard";
    }
    
    @RequestMapping("/student/setProfile")
    public String setProfile(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		if(studentService.getStudent(currentPrincipalName)==null)
		{
			model.addAttribute("student", new Student());
	        return "profile/studentprofile";
		}
		model.addAttribute("successMessage", "Profile has been already set up!");
        return "student/dashboard";
    }
    
    @RequestMapping("/save/studentprofile")
    public String setProfileOfStudent(@ModelAttribute("student") Student student, Model model)
    {
    	 if(studentService.isStudentPresent(student)){
             model.addAttribute("successMessage", "Student with this AM already exists");
             return "student/dashboard";
         }
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 		 String currentPrincipalName = authentication.getName();
    	 student.setUsername(currentPrincipalName);
         studentService.saveStudent(student);
         model.addAttribute("successMessage", "Profile set successfully!");

         return "student/dashboard";
    }
    
    @RequestMapping("/student/seeSubjects")
    public String seeSubjects(Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String currentPrincipalName = authentication.getName();
    	if(studentService.getStudent(currentPrincipalName)==null)
		{
			model.addAttribute("successMessage", "Please set up your personal profile first");
			return "student/dashboard";
		}
    	model.addAttribute("subjectsList",subjectService.findAvailableSubjects());
    	return "student/seesubjects";
    }
    
    @RequestMapping("/seemore")
    public String seemore(@RequestParam("subjectId") int theId,Model model)
    {
    	Subject subject=subjectService.findById(theId);
    	Professor professor=subject.getSupervisor();
    	model.addAttribute("subject", subject);
    	model.addAttribute("professor", professor);
    	return "student/seemore";
    }
    @RequestMapping("/apply")
    public String apply(@RequestParam("subjectId") int theId,Model model)
    {
    	Subject subject=subjectService.findById(theId);
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Student currentStudent=studentService.getStudent(currentPrincipalName);
		Application application=new Application(currentStudent,subject);
		studentService.saveApplication(application);
    	model.addAttribute("successMessage", "Application saved successfully!");
    	model.addAttribute("subjectsList",subjectService.findAvailableSubjects());
    	return "student/seesubjects";  
    }
    
 
}
