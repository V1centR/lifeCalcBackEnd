package com.lifecalc.lifecalcBack.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
@Table(name="operation")
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//@Temporal(TemporalType.TIMESTAMP)
	private String date;

	private String location;

	private double value;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="category")
	private Categoria categoria;

	//bi-directional many-to-one association to CentroCusto
	@ManyToOne
	@JoinColumn(name="centro_custo")
	@JsonBackReference
	private CentroCusto centroCustoBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	@JsonBackReference
	private User userBean;

	public Operation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CentroCusto getCentroCustoBean() {
		return this.centroCustoBean;
	}

	public void setCentroCustoBean(CentroCusto centroCustoBean) {
		this.centroCustoBean = centroCustoBean;
	}

	public User getUserBean() {
		return this.userBean;
	}

	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}

}