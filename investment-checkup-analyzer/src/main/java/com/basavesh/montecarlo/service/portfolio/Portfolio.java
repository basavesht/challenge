package com.basavesh.montecarlo.service.portfolio;

import com.basavesh.montecarlo.utilities.PortfolioType;

public interface Portfolio {
  public void addAssets();
  public PortfolioType getType();
  public double getRisk();
  public double getReturnValue();
}
