package com.basavesh.montecarlo.utilities;

public enum PortfolioType 
{
	AGGRESIVE ("Assertive"),
	CONSERVATIVE ("Conservative");

	String type;
	private PortfolioType (String name) {
		this.type = name;
	}

	public String getType() {
		return this.type;
	}
}
