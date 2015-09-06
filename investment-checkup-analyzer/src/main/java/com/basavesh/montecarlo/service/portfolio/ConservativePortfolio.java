package com.basavesh.montecarlo.service.portfolio;

import com.basavesh.montecarlo.utilities.PortfolioType;

public class ConservativePortfolio implements Portfolio 
{
	private double risk = 6.3438;
	private double returnValue = 6.189;

	@Override
	public void addAssets() {
		// TODO Auto-generated method stub
	}

	@Override
	public PortfolioType getType() {
		return PortfolioType.CONSERVATIVE;
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
