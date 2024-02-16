package myy803.diplomas_mgt_app_skeleton;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@Entity
@Table(name = "Professor")
@SpringBootApplication
public class Professor implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
		
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "name")
	private String name;
	@Column(name = "specialty")
	private String specialty;
	
		
	@OneToMany
	@JoinColumn(name="thesis")
	private List<Thesis> thesis=null;
	
	@OneToMany
	@JoinColumn(name="subject")
	private List<Subject> subjects=null;
	
	private User user; 
	

	public void setProfile(String name,String surname,String specialty) { //p1
		this.name=name;
		this.surname=surname;
		this.specialty=specialty;

	}
	public void printProfile() {
		System.out.println("Professor "+surname+" "+name);
		System.out.println("Specialized in  "+specialty);
	}
	public void addSubject(Subject subject) { //p3
		subjects.add(subject);
	}
	public void deleteSubject(Subject subject) { //p4
		subjects.remove(subject);
	}
	public void seeAplications() { //p5
		
	}
    public void accessAvailableSubjects() { //p2
		
	}
    public void assignDiploma() { //p6
		
	}
    public void accessAssignedDiploma() { //p7
		
	}

	public List<Thesis> getThesis() {
		return thesis;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty)
	{
		this.specialty=specialty;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setThesis(List<Thesis> thesis) {
		this.thesis = thesis;
		
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
		
	}
}