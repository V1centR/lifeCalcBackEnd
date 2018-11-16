package com.lifecalc.entity;

import java.io.Serializable;
import javax.persistence.*;


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

	private int date;

	private String location;

	private double value;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produto")
	private Produto produtoBean;

	//bi-directional many-to-one association to CentroCusto
	@ManyToOne
	@JoinColumn(name="centro_custo")
	private CentroCusto centroCustoBean;

	public Operation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDate() {
		return this.date;
	}

	public void setDate(int date) {
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