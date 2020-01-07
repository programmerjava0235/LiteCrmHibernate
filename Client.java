package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client extends AbstractEntity {

	private String companyName;
	private String nip;
	@OneToMany
	@JoinColumn(name = "client_id")
	private List<Adress> adress;
	@OneToMany(mappedBy = "client")
	private List<Phones> phones;
	@OneToMany(mappedBy = "client")
	private List<Emails> emails;
	@OneToMany(mappedBy = "client")
	private List<ContactPersons> contactPersons;
	@ManyToMany(mappedBy = "client")
	private List<TasksAndActivities> tasks;
	@ManyToMany(mappedBy = "client")
	private List<Meetings> meetings;
	@OneToOne
	private ServiceContracts serviceContracts;
	@OneToOne
	private ImplementationAgreements agreements;

	public static class Builder {

		private String companyName = null;
		private String nip = null;
		private List<Adress> adress = new ArrayList<>();
		private List<Phones> phones = new ArrayList<>();
		private List<Emails> emails = new ArrayList<>();
		private List<ContactPersons> contactPersons = new ArrayList<>();
		/*
		 * private List<TasksAndActivities> tasks = new ArrayList<>(); private
		 * List<Meetings> meetings = new ArrayList<>();
		 */
		private ServiceContracts serviceContracts = new ServiceContracts();
		private ImplementationAgreements agreements = new ImplementationAgreements();

		public Builder companyName(String companyName) {
			this.companyName = companyName;
			return this;
		}

		public Builder nip(String nip) {
			this.nip = nip;
			return this;
		}

		public Builder adress(List<Adress> adress) {
			this.adress = adress;
			return this;
		}

		public Builder phones(List<Phones> phones) {
			this.phones = phones;
			return this;
		}

		public Builder emails(List<Emails> emails) {
			this.emails = emails;
			return this;
		}

		public Builder contactPersons(List<ContactPersons> contactPersons) {
			this.contactPersons = contactPersons;
			return this;
		}

		/*
		 * public Builder tasks(List<TasksAndActivities> tasks) { this.tasks = tasks;
		 * return this; }
		 * 
		 * public Builder meetings(List<Meetings> meetings) { this.meetings = meetings;
		 * return this; }
		 */

		public Builder serviceContracts(ServiceContracts serviceContracts) {
			this.serviceContracts = serviceContracts;
			return this;
		}

		public Builder agreements(ImplementationAgreements agreements) {
			this.agreements = agreements;
			return this;
		}

		public Client build() {
			return new Client(this);
		}
	}

	private Client(Builder builder) {

		this.companyName = builder.companyName;
		this.nip = builder.nip;
		this.adress = builder.adress;
		this.phones = builder.phones;
		this.emails = builder.emails;
		this.contactPersons = builder.contactPersons;
		/*
		 * this.tasks = builder.tasks; this.meetings = builder.meetings;
		 */
		this.serviceContracts = builder.serviceContracts;
		this.agreements = builder.agreements;

	}

	public Client() {

	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public List<Adress> getAdress() {
		return adress;
	}

	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}

	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	public List<Emails> getEmails() {
		return emails;
	}

	public void setEmails(List<Emails> emails) {
		this.emails = emails;
	}

	public List<ContactPersons> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPersons> contactPersons) {
		this.contactPersons = contactPersons;
	}

	/*
	 * public List<TasksAndActivities> getTasks() { return tasks; }
	 * 
	 * 
	 * public void setTasks(List<TasksAndActivities> tasks) { this.tasks = tasks; }
	 * 
	 * public List<Meetings> getMeetings() { return meetings; }
	 * 
	 * public void setMeetings(List<Meetings> meetings) { this.meetings = meetings;
	 * }
	 */

	public ServiceContracts getServiceContracts() {
		return serviceContracts;
	}

	public void setServiceContracts(ServiceContracts serviceContracts) {
		this.serviceContracts = serviceContracts;
	}

	public ImplementationAgreements getAgreements() {
		return agreements;
	}

	public void setAgreements(ImplementationAgreements agreements) {
		this.agreements = agreements;
	}

}
