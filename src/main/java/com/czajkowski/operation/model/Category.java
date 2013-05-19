package com.czajkowski.operation.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String category_id;

	private String category_desc;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="category")
	private List<Operation> operations;

	public Category() {
	}

	public String getCategory_id() {
		return this.category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_desc() {
		return this.category_desc;
	}

	public void setCategory_desc(String category_desc) {
		this.category_desc = category_desc;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}