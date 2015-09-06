package com.basavesh.montecarlo.service.investment;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

import com.basavesh.montecarlo.exceptions.InvestmentCheckUpAnalyserException;
import com.basavesh.montecarlo.model.InvestmentCheckupRequest;
import com.basavesh.montecarlo.model.InvestmentCheckupResponse;
import com.basavesh.montecarlo.utilities.InvestmentCheckupUtils;

public class InvestmentCheckupAnalyserImpl implements InvestmentCheckupAnalyser {

	public InvestmentCheckupResponse analyseProbabaleFutureReturs(InvestmentCheckupRequest request) throws InvestmentCheckUpAnalyserException 
	{
		// validate the request 
		if(InvestmentCheckupUtils.isValid(request)) {
			throw new InvestmentCheckUpAnalyserException(" invalid input recieved..");
		}

		return executeWorkflow(request);
	}

	private InvestmentCheckupResponse executeWorkflow(InvestmentCheckupRequest request) throws InvestmentCheckUpAnalyserException {
		Set<Double> monteCarlpSimulations = new TreeSet<Double>();
		for(int i = 0 ; i < 10_000 ; i ++) {
			monteCarlpSimulations.add(computeFutureReturn(request));
		}

		InvestmentCheckupResponse response = analyseAndPrepareResponse(monteCarlpSimulations);
		return response;
	}

	private Double computeFutureReturn(InvestmentCheckupRequest request) 
	{
		// variables
		double returnValue = request.getPortfolio().getReturnValue();
		double riskValue = request.getPortfolio().getRisk();
		double inflation = request.getInflation();
		int years = request.getNoOfYearsToSimulate();
		BigDecimal investedAmntTillDate = request.getInvestedAmount();
		BigDecimal investableAmountPerYear = request.getInvestableAmountPerYear();
		
		// compute
		for (int i = 0 ; i < years ; i++) {
			RandomGenerator rg = new JDKRandomGenerator();
			NormalDistribution nd = new NormalDistribution(rg, returnValue, riskValue, inflation);
			double returnInvestmentValue = nd.sample();

			BigDecimal interestAmount = investedAmntTillDate.multiply(new BigDecimal(Math.abs(returnInvestmentValue)/100));
			investedAmntTillDate = investedAmntTillDate.add(interestAmount).add(investableAmountPerYear);
		}
		
		return investedAmntTillDate.doubleValue();
	}

	private InvestmentCheckupResponse analyseAndPrepareResponse(Set<Double> monteCarlpSimulations) {
		InvestmentCheckupResponse response = new InvestmentCheckupResponse();
		response.setMedian(InvestmentCheckupUtils.computeMedian(monteCarlpSimulations));
		response.set_90Percentile(InvestmentCheckupUtils.compute90Percentile(monteCarlpSimulations));
		response.set_10Percentile(InvestmentCheckupUtils.compute10Percentile(monteCarlpSimulations));
		return response;
	}
}
