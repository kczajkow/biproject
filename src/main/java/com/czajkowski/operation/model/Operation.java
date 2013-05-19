package com.czajkowski.operation.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String operation_id;

	private Integer operation_day;

	private Integer operation_month;

	private String operation_partner;

	private String operation_title;

	private Double operation_value;

	private Integer operation_year;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="Category_id")
	private Category category;

	//bi-directional many-to-one association to Owner
	@ManyToOne
	@JoinColumn(name="Owner_id")
	private Owner owner;

	public Operation() {
	}

	public String getOperation_id() {
		return this.operation_id;
	}

	public void setOperation_id(String operation_id) {
		this.operation_id = operation_id;
	}

	public Integer getOperation_day() {
		return this.operation_day;
	}

	public void setOperation_day(Integer operation_day) {
		this.operation_day = operation_day;
	}

	public Integer getOperation_month() {
		return this.operation_month;
	}

	public void setOperation_month(Integer operation_month) {
		this.operation_month = operation_month;
	}

	public String getOperation_partner() {
		return this.operation_partner;
	}

	public void setOperation_partner(String operation_partner) {
		this.operation_partner = operation_partner;
	}

	public String getOperation_title() {
		return this.operation_title;
	}

	public void setOperation_title(String operation_title) {
		this.operation_title = operation_title;
	}

	public Double getOperation_value() {
		return this.operation_value;
	}

	public void setOperation_value(Double operation_value) {
		this.operation_value = operation_value;
	}

	public Integer getOperation_year() {
		return this.operation_year;
	}

	public void setOperation_year(Integer operation_year) {
		this.operation_year = operation_year;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}