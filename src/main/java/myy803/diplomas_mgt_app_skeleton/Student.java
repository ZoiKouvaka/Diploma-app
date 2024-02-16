package myy803.diplomas_mgt_app_skeleton;



import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    
    
    @Column(name="username")
    private String username;
    
    @Column
	private User user; 
    
	@Column(name = "name")
    private String name;
    @Column(name = "surname")
	private String surname;
    @Column(name = "yearsofstudies")
	private int yearsofstudies;
    @Column(name = "AM")
	private int AM;
    @Column(name = "currenAvgGrade")
	private double currenAvgGrade;
    @Column(name = "numberRemainingCoursesForGrad")  
	private int numberRemainingCoursesForGrad;
    
    
    @OneToMany
	@JoinColumn(name="application")
    private List<Application> applications;
    
    @OneToOne
    @JoinColumn(name="thesis")
    private Thesis thesis;
    

    
    public User getUser()
    {
    	return user;
    }
    public void setUser(User user)
    {
    	this.user=user;
    }
	public String getName()
	{
		return name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public int getYearsofstudies()
	{
		return yearsofstudies;
	}
	
	public int getAM()
	{
		return AM;
	}
	
	public double getCurrenAvgGrade()
	{
		return currenAvgGrade;
	}
	
	public int getNumberRemainingCoursesForGrad()
	{
		return numberRemainingCoursesForGrad;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setSurname(String surname)
	{
		this.surname=surname;
	}
	
	public void yearsOfStudies(int yearsOfStudies)
	{
		this.yearsofstudies=yearsOfStudies;
	}
	
	public void setAM(int AM)
	{
		this.AM=AM;
	}
	
	public void setCurrenAvgGrade(double currenAvgGrade)
	{
		this.currenAvgGrade=currenAvgGrade;
	}
	
	public void setNumberRemainingCoursesForGrad(int numberRemainingCoursesForGrad)
	{
		this.numberRemainingCoursesForGrad= numberRemainingCoursesForGrad;
	}
	
	public void setYearsofstudies(int yearsofstudies)
	{
		this.yearsofstudies=yearsofstudies;
	}
	
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
    public void accessSubjects(ArrayList<Professor> prof) {
		
	}
    public void seeSubjects(ArrayList<Professor> profList) {
  
    	for(Professor professor:profList)
    	{
    		
    	}
	}
    
    public int getId()
    {
    	return id;
    }
	public void setappl(List<Application> l) {

		this.applications=l;
		
	}
	public List<Application> getappl() {

		return applications;
	}
       
}