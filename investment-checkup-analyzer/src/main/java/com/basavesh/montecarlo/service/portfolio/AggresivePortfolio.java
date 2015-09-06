package com.basavesh.montecarlo.service.portfolio;

import com.basavesh.montecarlo.utilities.PortfolioType;

public class AggresivePortfolio implements Portfolio 
{
	private double risk = 15.675 ;
	private double returnValue = 9.4324;

	@Override
	public void addAssets() {
		// TODO Auto-generated method stub

	}

	@Override
	public PortfolioType getType() {
		return PortfolioType.AGGRESIVE;
	}

	@Override
	public double getRisk() {
		return risk;
	}

	@Override
	public double getReturnValue() {
		return returnValue;
	}

}
