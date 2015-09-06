package com.basavesh.montecarlo.service.investment;

import com.basavesh.montecarlo.exceptions.InvestmentCheckUpAnalyserException;
import com.basavesh.montecarlo.model.InvestmentCheckupRequest;
import com.basavesh.montecarlo.model.InvestmentCheckupResponse;

public interface InvestmentCheckupAnalyser {
   public InvestmentCheckupResponse analyseProbabaleFutureReturs(InvestmentCheckupRequest request) throws InvestmentCheckUpAnalyserException;
}
