package com.basavesh.montecarlo.utilities;

import java.util.Set;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import com.basavesh.montecarlo.model.InvestmentCheckupRequest;

public class InvestmentCheckupUtils {

	public static boolean isValid(InvestmentCheckupRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Assuming the array x is sorted and is of length n:
       If n is odd then the median is x[(n-1)/2].
       If n is even than the median is (x[n/2] + x[(n/2)-1] ) / 2.
	 * @param monteCarloSimulations
	 * @return
	 */
	public static double computeMedian(Set<Double> monteCarloSimulations) {
		double[] investedAmount = (double[])monteCarloSimulations.stream().mapToDouble(Double::doubleValue).toArray();
		int length = monteCarloSimulations.size();
		if(length % 2 == 0) {
			return (investedAmount[length/2] + investedAmount[length/2 - 1])/2;
		}
		else {
			return investedAmount[(length - 1)/2];
		}
	}

	/**
	 * compute 90 percentile
	 * @param monteCarloSimulations
	 * @return
	 */
	public static double compute90Percentile(Set<Double> monteCarloSimulations) {
		double[] investedAmount = (double[])monteCarloSimulations.stream().mapToDouble(Double::doubleValue).toArray();
		Percentile percentile = new Percentile(90);
		return percentile.evaluate(investedAmount);
	}

	/**
	 * compute 10 percentile
	 * @param monteCarloSimulations
	 * @return
	 */
	public static Double compute10Percentile(Set<Double> monteCarloSimulations) {
		double[] investedAmount = (double[])monteCarloSimulations.stream().mapToDouble(Double::doubleValue).toArray();
		Percentile percentile = new Percentile(10);
		return percentile.evaluate(investedAmount);
	}
}
