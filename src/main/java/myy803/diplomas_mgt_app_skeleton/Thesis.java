package myy803.diplomas_mgt_app_skeleton;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Table(name = "Thesis")
public class Thesis implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="student")
	private Student student=null;
	
	@ManyToOne
	@JoinColumn(name="supervisor")
	private Professor supervisor=null;
	
	@OneToOne
	@JoinColumn(name="subject")
    private Subject subject=null;
    
	@Column(name = "implementation_grade")
    private double implementation_grade;
	@Column(name = "report_grade")
    private double report_grade;
    @Column(name = "presentation_grade")
    private double presentation_grade;
    @Column(name = "total_grade")
    private double total_grade;
    
    public Thesis()
    {
    	
    }
	public Thesis(Professor supervisor,Student student,Subject subject)
	{
		this.supervisor=supervisor;
		this.student=student;
		this.subject=subject;
	}
	public void setGrades(double report_grade,double implementation_grade,double presentation_grade) {
		this.report_grade=report_grade;
		this.implementation_grade=implementation_grade;
		this.presentation_grade=presentation_grade;
	}
    public double calculateDiplomaGrade(double implementation_grade,double report_grade,double presentation_grade) {
		return 0.7*implementation_grade+0.15*report_grade+0.15*presentation_grade;
	}
	public static void main(String[] args) {
	
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Professor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Professor supervisor) {
		this.supervisor = supervisor;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public double getTotal_grade() {
		return total_grade;
	}
	public void setTotal_grade(double total_grade) {
		this.total_grade = total_grade;
	}
	public double getImplementation_grade() {
		return implementation_grade;
	}
	public void setImplementation_grade(double implementation_grade) {
		this.implementation_grade = implementation_grade;
	}
	public double getReport_grade() {
		return report_grade;
	}
	public void setReport_grade(double report_grade) {
		this.report_grade = report_grade;
	}
	public double getPresentation_grade() {
		return presentation_grade;
	}
	public void setPresentation_grade(double presentation_grade) {
		this.presentation_grade = presentation_grade;
	}
	public int getId()
	{
		return id;
	}
}