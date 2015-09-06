package com.basavesh.montecarlo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.basavesh.montecarlo.service.portfolio.Portfolio;

public class InvestmentCheckupRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5350568757368226054L;

	private BigDecimal investableAmountPerYear = null;
	private BigDecimal investedAmount = null;
	private Portfolio portfolio = null;
	private double inflation;
	private int noOfYearsToSimulate;

	public int getNoOfYearsToSimulate() {
		return noOfYearsToSimulate;
	}
	public void setNoOfYearsToSimulate(int noOfYearsToSimulate) {
		this.noOfYearsToSimulate = noOfYearsToSimulate;
	}
	public BigDecimal getInvestableAmountPerYear() {
		return investableAmountPerYear;
	}
	public void setInvestableAmountPerYear(BigDecimal investableAmountPerYear) {
		this.investableAmountPerYear = investableAmountPerYear;
	}
	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}
	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}
	public Portfolio getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	public double getInflation() {
		return inflation;
	}
	public void setInflation(double inflation) {
		this.inflation = inflation;
	}

	@Override
	public String toString() {
		return "InvestmentCheckupRequest [investableAmountPerYear="
				+ investableAmountPerYear + ", investedAmount="
				+ investedAmount + ", portfolio=" + portfolio + ", inflation="
				+ inflation + "]";
	}


}
