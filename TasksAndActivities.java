package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class TasksAndActivities extends AbstractEntity{

	private int priority;
	private java.sql.Date date;
	private String acctivities;
	private float hoursTask;

	@ManyToMany
	@JoinTable(name = "clients_tasks", joinColumns = { @JoinColumn(name = "id_tasks") }, inverseJoinColumns = {
			@JoinColumn(name = "id_client") })
	private List<Client> client;
	@ManyToMany
	@JoinTable(name = "contactPerson_tasks", joinColumns = { @JoinColumn(name = "id_tasks") }, inverseJoinColumns = {
			@JoinColumn(name = "id_personContact") })
	private List<ContactPersons> contactPersons;
	@ManyToMany
	private List<Users> users;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getAcctivities() {
		return acctivities;
	}

	public void setAcctivities(String acctivities) {
		this.acctivities = acctivities;
	}

	public float getHoursTask() {
		return hoursTask;
	}

	public void setHoursTask(float hoursTask) {
		this.hoursTask = hoursTask;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public List<ContactPersons> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPersons> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
