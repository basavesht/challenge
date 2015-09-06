package com.basavesh.montecarlo.model;

import java.io.Serializable;

public class InvestmentCheckupResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158330452753515429L;
    private Double median;
    private Double _90Percentile;
    private Double _10Percentile;
    
	public Double getMedian() {
		return median;
	}
	public void setMedian(Double median) {
		this.median = median;
	}
	public Double get_90Percentile() {
		return _90Percentile;
	}
	public void set_90Percentile(Double _90Percentile) {
		this._90Percentile = _90Percentile;
	}
	public Double get_10Percentile() {
		return _10Percentile;
	}
	public void set_10Percentile(Double _10Percentile) {
		this._10Percentile = _10Percentile;
	}
	
	@Override
	public String toString() {
		return "InvestmentCheckupResponse [median=" + median
				+ ", _90Percentile=" + _90Percentile + ", _10Percentile="
				+ _10Percentile + "]";
	}
	
}
