package main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ClientsGroups extends AbstractEntity {

	private String nameGroup;

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	@OneToMany
	@JoinColumn(name = "client_groups_id")
	private List<Client> client;

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

}
