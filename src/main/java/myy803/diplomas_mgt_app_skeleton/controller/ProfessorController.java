package myy803.diplomas_mgt_app_skeleton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import myy803.diplomas_mgt_app_skeleton.Application;
import myy803.diplomas_mgt_app_skeleton.Grades;
import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;
import myy803.diplomas_mgt_app_skeleton.Threshold;
import myy803.diplomas_mgt_app_skeleton.service.ProfessorService;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import myy803.diplomas_mgt_app_skeleton.service.SubjectService;

@Controller
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	StudentService studentService;
	

    @RequestMapping("/professor/dashboard")
    public String getprofessorHome(){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
        return "professor/dashboard";
    }
    
    @RequestMapping("/professor/setProfile")
    public String setstudProfile(Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
    	if(professorService.getProfessor(currentPrincipalName)==null)
    	{
    		model.addAttribute("professor", new Professor());
        	return "profile/profprofile";
    	}
    	model.addAttribute("successMessage", "Profile has been set up before!");
    	return "professor/dashboard";
    	
    }
    
    @RequestMapping("/save/profprofile")
    public String setProfileOfProfessor(@ModelAttribute("professor") Professor professor, Model model)
    {
    	 
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 		 String currentPrincipalName = authentication.getName();
 		 System.err.println(currentPrincipalName);
    	 professor.setUsername(currentPrincipalName);
         professorService.saveProfessor(professor);
         model.addAttribute("successMessage", "Profile set successfully!");

         return "professor/dashboard";
    }
    
    @RequestMapping("/professor/seeSubjects")
    public String seeSubjects(Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		if(professorService.getProfessor(currentPrincipalName)==null)
		{
			model.addAttribute("successMessage", "Please set up your personal profile first");
			return "professor/dashboard";
		}
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	model.addAttribute("subjectsList",professorService.seeSubjects(currentProfessor));
    	return "professor/seesubjects";
    }
    
    
    @RequestMapping("/addSubject")
    public String addSubject(Model model)
    {
    	model.addAttribute("newSubject", new Subject());
    	return "professor/addsubject"; 
    }
    
    @RequestMapping("/save/newSubject")
    public String saveNewSubject(@ModelAttribute("newSubject") Subject newSubject, Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	newSubject.setSupervisor(currentProfessor);
    	subjectService.saveSubject(newSubject);
    	model.addAttribute("successMessage", "New lesson has been added!");
    	model.addAttribute("subjectsList",professorService.seeSubjects(currentProfessor));
    	return "professor/seesubjects";
    }
    
    @RequestMapping("/deleteSubject")
    public String deleteSubject(@RequestParam("subjectId") int theId,Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	Subject theSubject=subjectService.findById(theId);
    	if(professorService.findThesisBySubject(theSubject)==null)
    	{
    		subjectService.deleteSubject(theSubject);
        	model.addAttribute("successMessage", "Subject was deleted successfully.");
    	}
    	else 
    	{
    		model.addAttribute("successMessage", "Subject cannot be deleted, there is a thesis on it. Don't worry students will not be able to see it");
    	}
    	model.addAttribute("subjectsList",professorService.seeSubjects(currentProfessor));
    	return "professor/seesubjects";
    }
    
    @RequestMapping("/seeApplications")
    public String seeApplicants(Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		if(professorService.getProfessor(currentPrincipalName)==null)
		{
			model.addAttribute("successMessage", "Please set up your personal profile first");
			return "professor/dashboard";
		}
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);

		model.addAttribute("applList",professorService.seeApplications(currentProfessor));
		return "professor/seeApplications";
		
    }
    
    @RequestMapping("/seeApplicants")
    public String seeApplicants(@RequestParam("subjectId") int theId,Model model)
    {

		model.addAttribute("subjectId", theId);
		model.addAttribute("applList",subjectService.findAllBySubject(subjectService.findById(theId)));
		return "professor/seeApplicants";
		
    }
    
    @RequestMapping("/seeRandom")
    public String chooseRandomly(@RequestParam("subjectId") int theId ,Model model)
    {
    	List<Application> applList =subjectService.findAllBySubject(subjectService.findById(theId));
		model.addAttribute("subjectId", theId);
    	if(!applList.isEmpty())
    	{
    		model.addAttribute("student",professorService.getRandomStudent(applList));
        	return "professor/seeFinalApplicant";
    	}
		model.addAttribute("successMessage", "Sorry, there are no applicants to choose from");
		model.addAttribute("applList", applList);
		return "professor/seeApplicants";
    	
    }
    
    @RequestMapping("/seeBestGrade")
    public String chooseBestGrade(@RequestParam("subjectId") int theId ,Model model)
    {
    	List<Application> applList =subjectService.findAllBySubject(subjectService.findById(theId));
    	model.addAttribute("subjectId", theId);
    	if(!applList.isEmpty())
    	{
    		model.addAttribute("student",professorService.getBestGradeStudent(applList));
        	return "professor/seeFinalApplicant";
    	}
    	model.addAttribute("successMessage", "Sorry, there are no applicants to choose from");
		model.addAttribute("applList", applList);
		return "professor/seeApplicants";
    	
    }
    
    @RequestMapping("/seeFewestCourses")
    public String chooseFewestCourses(@RequestParam("subjectId") int theId ,Model model)
    {
    	List<Application> applList =subjectService.findAllBySubject(subjectService.findById(theId));
		model.addAttribute("subjectId", theId);
		if(!applList.isEmpty())
		{
			model.addAttribute("student",professorService.getFewestCoursesStudent(applList));
	    	return "professor/seeFinalApplicant";
		}
		model.addAttribute("successMessage", "Sorry, there are no applicants to choose from");
		model.addAttribute("applList", applList);
		return "professor/seeApplicants";
    	
    	 
    }
    @RequestMapping("/setThreshold")
    public String setThreshold(@RequestParam("subjectId") int theId ,Model model)
    {
    	model.addAttribute("subjectId", theId);
    	model.addAttribute("th", new Threshold());

    	return "professor/setThreshold"; 
    }
    
    @RequestMapping("/seeThresholdBestGrade")
    public String chooseThBestGrade(@ModelAttribute("th") Threshold th,@RequestParam("subjectId") int theId ,Model model)
    {
    	double th1=th.getTh1();
    	double th2=th.getTh2();
    	List<Application> applList =subjectService.findAllBySubject(subjectService.findById(theId));
    	Student student=professorService.getThresholdGradeStudent(applList,th1,th2);
    	if (student!=null)
    	{
    		model.addAttribute("student",student);
    		model.addAttribute("subjectId", theId);
        	return "professor/seeFinalApplicant";
    	}
    	model.addAttribute("successMessage", "No student found based on these creteria");
    	model.addAttribute("subjectId", theId);
		model.addAttribute("applList",subjectService.findAllBySubject(subjectService.findById(theId)));
		return "professor/seeApplicants";

    }
    
    @RequestMapping("/assignThesis")
    public String assignThesis(@RequestParam("subjectId") int theId,@ModelAttribute("studentUsername") String studentUsername,Model model)
    {
    	Subject subject=subjectService.findById(theId);
    	
    	Student student=studentService.getStudent(studentUsername);
    	if(professorService.findThesisByStudent(student)==null&&professorService.findThesisBySubject(subject)==null)
    	{
    		Thesis thesis=new Thesis(subject.getSupervisor(),student,subject);
        	professorService.saveThesis(thesis);
        	model.addAttribute("successMessage","Thesis assigned successfully" );
        	return "professor/dashboard";
    	}
    	model.addAttribute("successMessage","Sorry student is assigned with a thesis already or another student has been assigned with this subject!" );
    	return "professor/dashboard";
    }
    
    @RequestMapping("/seeThesis")
    public String seeThesis(Model model)
    {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		if(professorService.getProfessor(currentPrincipalName)==null)
		{
			model.addAttribute("successMessage", "Please set up your personal profile first");
			return "professor/dashboard";
		}
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	model.addAttribute("thesisList", professorService.seeThesis(currentProfessor));
    	return "professor/seeThesis";
    }
    
    @RequestMapping("/setGrades")
    public String String(@RequestParam("thesisId") int theId,Model model)
    {
    	System.err.println(theId);
    	model.addAttribute("thesisId", theId);
    	model.addAttribute("grades", new Grades());
    	return "professor/setGrades";
    }
    
    @RequestMapping("/saveNewThesis")
    public String String(@RequestParam("thesisId") int theId,@ModelAttribute("grades") Grades grades,Model model)
    {

    	Thesis thesis= professorService.findThesisById(theId);
    	Subject subject=thesis.getSubject();
    	professorService.removeThesis(thesis);
    	thesis.setGrades(grades.getRep(),grades.getImpl(), grades.getPres());
    	professorService.saveThesis(thesis);
    	thesis=professorService.findThesisBySubject(subject);
    	theId=thesis.getId();
    	model.addAttribute("thesisId", theId);
    	model.addAttribute("successMessage", "Thesis grades have been saved successfully! (Thesis id changed)");
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	model.addAttribute("thesisList", professorService.seeThesis(currentProfessor));
    	return "professor/seeThesis";
    }
    
    @RequestMapping("/calculateTotalGrade")
    public String calculateTotalGrade(@RequestParam("thesisId") int theId,Model model)
    {
    	Thesis thesis= professorService.findThesisById(theId);
    	double totalGrade=thesis.calculateDiplomaGrade(thesis.getImplementation_grade(),thesis.getReport_grade(),thesis.getPresentation_grade());
    	model.addAttribute("successMessage","Total Grade of this thesis is: "+ totalGrade);
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.err.println(currentPrincipalName);
		Professor currentProfessor= professorService.getProfessor(currentPrincipalName);
    	model.addAttribute("thesisList", professorService.seeThesis(currentProfessor));
    	return "professor/seeThesis";
    	
    }
}
