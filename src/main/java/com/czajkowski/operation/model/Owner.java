package com.czajkowski.operation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the owner database table.
 * 
 */
@Entity
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String owner_id;

	private String owner_desc;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="owner")
	private List<Operation> operations;

	public Owner() {
	}

	public String getOwner_id() {
		return this.owner_id;
	}

	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_desc() {
		return this.owner_desc;
	}

	public void setOwner_desc(String owner_desc) {
		this.owner_desc = owner_desc;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}