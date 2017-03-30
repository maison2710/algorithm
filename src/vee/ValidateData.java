package vee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateData {

	public Map<Long, Double> addMissingDataTime(
			Map<Long, Double> timeValuePairs, Long fromTime, Long toTime,
			Long resolution) {
		List<Long> times = new ArrayList<Long>();
		times.addAll(timeValuePairs.keySet());
		Collections.sort(times);

		List<Long> timesRef = range(fromTime, toTime + resolution, resolution);

		for (int i = 0; i < timesRef.size(); i++) {
			Long time = timesRef.get(i);
			if (!times.contains(time)) {
				timeValuePairs.put(time, Double.NaN);
			}
		}

		return timeValuePairs;
	}

	private List<Long> range(Long start, Long stop, Long step) {
		List<Long> result = new ArrayList<Long>();
		Long i = start;
		while (i < stop) {
			result.add(i);
			i += step;
		}
		return result;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, List> getTimesValues(Map<Long, Double> timeValuePairs,
			Integer mode) {
		Map<String, List> result = new HashMap<String, List>();
		List<Long> times = new ArrayList<Long>();
		times.addAll(timeValuePairs.keySet());
		Collections.sort(times);

		List<Double> values = new ArrayList<Double>();
		List<Double> origValues = new ArrayList<Double>();

		if (mode == null) {
			mode = 1;
		}

		for (int i = 0; i < times.size(); i++) {
			Long time = times.get(i);
			if (mode == 2) {
				origValues.add(timeValuePairs.get(time));
			}

			values.add(timeValuePairs.get(time));
		}

		if (mode == 2) {
			result.put("values_orig", origValues);
		}

		result.put("times", times);
		result.put("values", values);

		return result;

	}

	public Map<Long, Double> getTimeValuePairs(List<Long> times,
			List<Double> values) {
		Map<Long, Double> result = new HashMap<Long, Double>();
		for (int i = 0; i < times.size(); i++) {
			result.put(times.get(i), values.get(i));
		}
		return result;
	}

	public Map<Long, Double> backupData1(Map<Long, Double> data) {
		Map<Long, Double> dataNew = new HashMap<Long, Double>();
		for (Long time : data.keySet()) {
			dataNew.put(time, data.get(time));
		}
		return dataNew;
	}

	public List<Double> backupData2(List<Double> data) {
		List<Double> dataNew = new ArrayList<Double>();
		for (Double dataValue : data) {
			dataNew.add(dataValue);
		}
		return dataNew;
	}

	public List<Double> removeNegativeValues(List<Double> values) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i++) {
			Double value = values.get(i);
			if (value < 0) {
				value = Double.NaN;
			}

			result.add(value);
		}

		return result;
	}

	public List<Double> removePositiveValues(List<Double> values) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i++) {
			Double value = values.get(i);
			if (value > 0) {
				value = Double.NaN;
			}

			result.add(value);
		}

		return result;
	}

	public List<Double> removeOverBoundaryValues(List<Double> values,
			Double upperBoundary, Double lowerBoundary) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i++) {
			Double value = values.get(i);
			if (value != null && !value.isNaN()) {
				if (value > upperBoundary || value < lowerBoundary) {
					value = Double.NaN;
				}
			}

			result.add(value);
		}
		return result;
	}

	public List<Double> removeExtremeValues(List<Double> values,
			Double upperThres, Double lowerThres) {
		List<Double> result = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i++) {
			Double value = values.get(i);
			if (value != null && !value.isNaN()) {
				if (value > upperThres || value < lowerThres) {
					value = Double.NaN;
				}
			}

			result.add(value);
		}
		return result;
	}
}
