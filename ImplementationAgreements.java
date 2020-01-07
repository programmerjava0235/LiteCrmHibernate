package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ImplementationAgreements extends AbstractEntity {

	
	private java.sql.Date dateStart;
	private java.sql.Date dateEnd;
	private float hoursContract;
	private boolean isContract;

	

	public java.sql.Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(java.sql.Date dateStart) {
		this.dateStart = dateStart;
	}

	public java.sql.Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(java.sql.Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public float getHoursContract() {
		return hoursContract;
	}

	public void setHoursContract(float hoursContract) {
		this.hoursContract = hoursContract;
	}

	public boolean isContract() {
		return isContract;
	}

	public void setContract(boolean isContract) {
		this.isContract = isContract;
	}

}
