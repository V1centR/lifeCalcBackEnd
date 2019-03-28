package com.lifecalc.lifecalcBack.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the centro_custo_actions database table.
 * 
 */
@Entity
@Table(name="centro_custo_actions")
@NamedQuery(name="CentroCustoAction.findAll", query="SELECT c FROM CentroCustoAction c")
public class CentroCustoAction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private double value;

	//bi-directional many-to-one association to CentroCusto
	@ManyToOne
	@JoinColumn(name="centro_custo")
	private CentroCusto centroCustoBean;

	public CentroCustoAction() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public CentroCusto getCentroCustoBean() {
		return this.centroCustoBean;
	}

	public void setCentroCustoBean(CentroCusto centroCustoBean) {
		this.centroCustoBean = centroCustoBean;
	}

}