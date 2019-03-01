package com.lifecalc.lifecalcBack.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


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

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produto")
	@JsonBackReference
	private Produto produtoBean;

	//bi-directional many-to-one association to CentroCusto
	@ManyToOne
	@JoinColumn(name="centro_custo")
	@JsonBackReference
	private CentroCusto centroCustoBean;
	
	public String month;
	public Double total;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

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

	public Produto getProdutoBean() {
		return this.produtoBean;
	}

	public void setProdutoBean(Produto produtoBean) {
		this.produtoBean = produtoBean;
	}

	public CentroCusto getCentroCustoBean() {
		return this.centroCustoBean;
	}

	public void setCentroCustoBean(CentroCusto centroCustoBean) {
		this.centroCustoBean = centroCustoBean;
	}

}