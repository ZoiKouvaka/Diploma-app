package myy803.diplomas_mgt_app_skeleton_test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import myy803.diplomas_mgt_app_skeleton.Professor;
import myy803.diplomas_mgt_app_skeleton.Student;
import myy803.diplomas_mgt_app_skeleton.Subject;
import myy803.diplomas_mgt_app_skeleton.Thesis;

class TestThesis {

    Thesis thesis;

	@BeforeEach
	public void setUp() {
	    thesis = new Thesis();
	}
	@Test
    public void testSetAndGetStudent() {
        Student student = new Student();
        thesis.setStudent(student);
        assertEquals(student, thesis.getStudent());
    }

    @Test
    public void testSetAndGetSupervisor() {
        Professor professor = new Professor();
        thesis.setSupervisor(professor);
        assertEquals(professor, thesis.getSupervisor());
    }

    @Test
    public void testSetAndGetSubject() {
        Subject subject = new Subject();
        thesis.setSubject(subject);
        assertEquals(subject, thesis.getSubject());
    }

    @Test
    public void testSetAndGetImplementationGrade() {
        double implementationGrade = 9.0;
        thesis.setImplementation_grade(implementationGrade);
        assertEquals(implementationGrade, thesis.getImplementation_grade(), 0.0);
    }

    @Test
    public void testSetAndGetReportGrade() {
        double reportGrade = 8.0;
        thesis.setReport_grade(reportGrade);
        assertEquals(reportGrade, thesis.getReport_grade(), 0.0);
    }

    @Test
    public void testSetAndGetPresentationGrade() {
        double presentationGrade = 10.0;
        thesis.setPresentation_grade(presentationGrade);
        assertEquals(presentationGrade, thesis.getPresentation_grade());
    }

    @Test
    public void testSetAndGetTotalGrade() {
        double totalGrade = 9.0;
        thesis.setTotal_grade(totalGrade);
        assertEquals(totalGrade, thesis.getTotal_grade());
    }

    @Test
    public void testCalculateDiplomaGrade() {
        double reportGrade = 8.0;
        double implementationGrade = 9.0;
        double presentationGrade = 10.0;
        thesis.setGrades(reportGrade, implementationGrade, presentationGrade);
        thesis.calculateDiplomaGrade(presentationGrade, presentationGrade, presentationGrade);
        double expectedTotalGrade = 0.7 * implementationGrade + 0.15 * reportGrade + 0.15 * presentationGrade;
        assertEquals(9.0, expectedTotalGrade);
    }

}