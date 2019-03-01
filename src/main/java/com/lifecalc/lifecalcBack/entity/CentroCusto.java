package com.lifecalc.lifecalcBack.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the centro_custo database table.
 * 
 */
@Entity
@Table(name="centro_custo")
@NamedQuery(name="CentroCusto.findAll", query="SELECT c FROM CentroCusto c")
public class CentroCusto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double base;
	
	@Column(name="base_date")
	private String baseDate;

	private String description;

	private String name;

	//bi-directional many-to-one association to Operation
	@OneToMany(mappedBy="centroCustoBean")
	@JsonBackReference
	private List<Operation> operations;

	public CentroCusto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBase() {
		return this.base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public String getBaseDate() {
		return this.baseDate;
	}

	public void setBaseDate(String string) {
		this.baseDate = string;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Operation addOperation(Operation operation) {
		getOperations().add(operation);
		operation.setCentroCustoBean(this);

		return operation;
	}

	public Operation removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setCentroCustoBean(null);

		return operation;
	}

}