package vee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class ProcessData {
	public static final int THRESHOLD = 3;

	@SuppressWarnings("unchecked")
	public Map<Map<Long, Double>, Map<Long, String>> processData(
			Map<Long, Double> timeValuePairs,
			Map<Long, Double> timeValuePairsClean, String sensorType,
			Map<Long, String> records) {
		Map<Map<Long, Double>, Map<Long, String>> result = new HashMap<Map<Long, Double>, Map<Long, String>>();

		ValidateData vd = new ValidateData();
		EstimateData es = new EstimateData();
		FlagBadData fg = new FlagBadData();

		@SuppressWarnings("rawtypes")
		Map<String, List> tmpTv1 = vd.getTimesValues(timeValuePairs, 2);

		List<Long> times = tmpTv1.get("times");
		List<Double> values = tmpTv1.get("values");
		List<Double> valuesOrig = tmpTv1.get("values_orig");

		if (sensorType.compareToIgnoreCase("consumption") == 0) {
			System.out.println("remove negative values for consumption");
			values = vd.removeNegativeValues(values);
			records = fg.recordVeeType(valuesOrig, values, times, records,
					"negative-value");
			valuesOrig = vd.backupData2(values);
		}

		DescriptiveStatistics stats = new DescriptiveStatistics();
		for (Double value : timeValuePairsClean.values()) {
			if (!value.isNaN()) {
				stats.addValue(value);
			}
		}
		Double refMean = stats.getMean();
		Double refStd = stats.getStandardDeviation();
		System.out.println("mean and std of one-month values is " + refMean
				+ " and " + refStd);

		if (refStd > 0) {
			System.out.println("remove extreme large and small values");
			values = vd.removeExtremeValues(values, refMean + THRESHOLD
					* refStd, refMean - THRESHOLD * refStd);
			records = fg.recordVeeType(valuesOrig, values, times, records,
					"multi-spike");
			valuesOrig = vd.backupData2(values);
		}

		timeValuePairs = vd.getTimeValuePairs(times, values);

		System.out.println("forecast values");
		timeValuePairs = es.forecastValues(timeValuePairs, timeValuePairsClean);
		@SuppressWarnings("rawtypes")
		Map<String, List> tmpTv2 = vd.getTimesValues(timeValuePairs, null);
		times = tmpTv2.get("times");
		values = tmpTv2.get("values");
		records = fg.recordVeeType(valuesOrig, values, times, records,
				"forecast");
		valuesOrig = vd.backupData2(values);

		System.out.println("interpolate values");
		values = es.interpValues(values);
		records = fg
				.recordVeeType(valuesOrig, values, times, records, "interp");

		timeValuePairs = vd.getTimeValuePairs(times, values);

		result.put(timeValuePairsClean, records);

		return result;

	}
}
