package main;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Users extends AbstractEntity {

	private String firstName;
	private String lastName;

	@ManyToMany
	@JoinTable(name = "clients_users", joinColumns = { @JoinColumn(name = "id_users") }, inverseJoinColumns = {
			@JoinColumn(name = "id_client") })
	private List<Client> client;
	@ManyToMany
	@JoinTable(name = "users_tasks", joinColumns = { @JoinColumn(name = "id_users") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tasks") })
	private List<TasksAndActivities> tasks;
	@ManyToMany
	@JoinTable(name = "users_meetings", joinColumns = { @JoinColumn(name = "id_users") }, inverseJoinColumns = {
			@JoinColumn(name = "id_meetings") })
	private List<Meetings> meetings;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public List<TasksAndActivities> getTasks() {
		return tasks;
	}

	public void setTasks(List<TasksAndActivities> tasks) {
		this.tasks = tasks;
	}

	public List<Meetings> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Meetings> meetings) {
		this.meetings = meetings;
	}

}
