package myy803.diplomas_mgt_app_skeleton;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table(name = "Subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "objectives")
	private String objectives;
	
	@OneToMany
	@JoinColumn(name="subject")
	private List<Application> applications;
	
	@ManyToOne
	@JoinColumn(name="supervisor")
	private Professor supervisor=null;
	
	private boolean isAvailable=true;


	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public void setSupervisor(Professor supervisor) {
		this.supervisor = supervisor;
	}
	public Professor getSupervisor()
	{
		return supervisor;
	}
	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	public int getId()
	{
		return id;
	}

	public void setIsavailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setId(int id) {
		this.id = id;
	}

}