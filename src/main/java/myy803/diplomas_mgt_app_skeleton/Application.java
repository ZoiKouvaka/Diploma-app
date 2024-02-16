package myy803.diplomas_mgt_app_skeleton;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name = "Application")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
    
	
	@ManyToOne
	@JoinColumn(name="subject")
	private Subject subject=null; 
	
	@ManyToOne 
	@JoinColumn(name="student")
	private Student student=null;
	
	
    private boolean isrejected=false;
    
    public Application()
    {
    	
    }
    
	public Application(Student appl_student,Subject des_subject) {
		this.student=appl_student;
		this.subject=des_subject;
	}
	
	public void setStudent(Student student)
	{
		this.student=student;
	}
	
	public void setSubject(Subject subject)
	{
		this.subject=subject;
	}
	
	public Student getStudent()
	{
		return student;
	}
	
	public Subject getSubject()
	{
		return subject;
	}

	public Object getId() {
	
		return id;
	}

}