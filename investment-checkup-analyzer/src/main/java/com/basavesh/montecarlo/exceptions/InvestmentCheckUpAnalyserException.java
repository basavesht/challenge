package com.basavesh.montecarlo.exceptions;

public class InvestmentCheckUpAnalyserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6270520625247560289L;

	public InvestmentCheckUpAnalyserException(String string) {
		super(string);
	}
	
	public InvestmentCheckUpAnalyserException(String string, Throwable e) {
		super(string, e);
	}
	
	public InvestmentCheckUpAnalyserException(Throwable e) {
		super(e);
	}

}
