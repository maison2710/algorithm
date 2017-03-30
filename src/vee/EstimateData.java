package vee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class EstimateData {
	public List<Double> interpValues(List<Double> values) {
		List<Double> interpValues = new ArrayList<Double>();

		try {
			List<Double> yl = new ArrayList<Double>();
			List<Double> xl = new ArrayList<Double>();

			if (values.get(0).isNaN()) {
				for (int i = 1; i < values.size(); i++) {
					if (!values.get(i).isNaN()) {
						values.set(0, values.get(i));
					}
				}
			}

			if (values.get(values.size() - 1).isNaN()) {
				for (int i = values.size() - 2; i >= 0; i--) {
					if (!values.get(i).isNaN()) {
						values.set(values.size() - 1, values.get(i));
					}
				}
			}
			System.out.println(values);

			for (int i = 0; i < values.size(); i++) {
				if (!values.get(i).isNaN()) {
					yl.add((double) values.get(i));
					xl.add((double) 2 * i);
				}
			}

			double[] ya = new double[yl.size()];
			double[] xa = new double[xl.size()];
			for (int i = 0; i < xa.length; i++) {
				ya[i] = yl.get(i);
				xa[i] = xl.get(i);
			}

			LinearInterpolator li = new LinearInterpolator();
			PolynomialSplineFunction pf = li.interpolate(xa, ya);

			for (int i = 0; i < values.size(); i++) {
				if (values.get(i).isNaN()) {
					interpValues.add(pf.value(2 * i));
				} else {
					interpValues.add(values.get(i));
				}
			}

		} catch (Exception e) {
			interpValues = values;
		}

		return interpValues;
	}

	public Map<Long, Double> forecastValues(Map<Long, Double> timeValuePairs,
			Map<Long, Double> timeValuePairsClean) {
		if (timeValuePairsClean == null) {
			timeValuePairsClean = new HashMap<Long, Double>();
		}
		if (!timeValuePairsClean.isEmpty()) {
			for (Long time : timeValuePairs.keySet()) {
				timeValuePairsClean.put(time, timeValuePairs.get(time));
			}
		}

		List<Long> timesClean = new ArrayList<Long>();
		timesClean.addAll(timeValuePairsClean.keySet());
		Collections.sort(timesClean);
		Long startTimeClean = timesClean.get(0);
		Long endTimeClean = timesClean.get(timesClean.size() - 1);

		for (Long time : timeValuePairs.keySet()) {
			if (timeValuePairs.get(time).isNaN()) {
				timeValuePairs = forecastValuesMethod(timeValuePairs, time,
						timeValuePairsClean, startTimeClean, endTimeClean);
			}

		}

		return timeValuePairs;
	}

	private Map<Long, Double> forecastValuesMethod(
			Map<Long, Double> timeValuePairs, Long time,
			Map<Long, Double> timeValuePairsClean, Long startTimeClean,
			Long endTimeClean) {
		boolean isValid1 = false;
		boolean isValid2 = false;
		CheckDays cd = new CheckDays();

		try {
			if (cd.isHoliday(time)) {
				long vittime = cd.getHolidayNearWeedend(time);
				long ftime = vittime;
				long stime = vittime - 1 * 24 * 60 * 60 * 1000;

				for (int factor = 0; factor < 4; factor++) {
					ftime -= 7 * 24 * 60 * 60 * 1000 * factor;
					if (!timeValuePairsClean.get(ftime).isNaN()) {
						isValid1 = true;
						break;
					}
				}

				for (int factor = 0; factor < 4; factor++) {
					stime -= 7 * 24 * 60 * 60 * 1000 * factor;
					if (startTimeClean <= stime && stime <= endTimeClean) {
						if (!timeValuePairsClean.get(stime).isNaN()) {
							isValid2 = true;
							break;
						}
					}
				}

				if (isValid1 && isValid2) {
					Double value = 0.7 * timeValuePairsClean.get(ftime) + 0.3
							* timeValuePairsClean.get(stime);
					timeValuePairs.put(time, value);
				} else {
					timeValuePairs.put(time, Double.NaN);
				}
			} else {
				long ftime = time - 1 * 24 * 60 * 60 * 1000;
				long stime = time - 7 * 24 * 60 * 60 * 1000;

				for (int factor = 0; factor < 4; factor++) {
					ftime -= 7 * 24 * 60 * 60 * 1000 * factor;
					if (startTimeClean <= ftime && ftime <= endTimeClean) {

						if (!cd.isHoliday(ftime)
								&& !timeValuePairsClean.get(ftime).isNaN()) {
							isValid1 = true;
							break;
						}
					}
				}

				for (int factor = 0; factor < 4; factor++) {
					stime -= 7 * 24 * 60 * 60 * 1000 * factor;
					if (startTimeClean <= stime && stime <= endTimeClean) {
						if (!cd.isHoliday(stime)
								&& !timeValuePairsClean.get(stime).isNaN()) {
							isValid2 = true;
							break;
						}
					}
				}

				if (isValid1 && isValid2) {
					String dayOfWeek = cd.whichDayOfWeek(time);
					Double value;
					if (dayOfWeek.compareToIgnoreCase("Monday") == 0
							|| dayOfWeek.compareToIgnoreCase("Saturday") == 0) {
						value = 0.3 * timeValuePairsClean.get(ftime) + 0.7
								* timeValuePairsClean.get(stime);
					} else {
						value = 0.7 * timeValuePairsClean.get(ftime) + 0.3
								* timeValuePairsClean.get(stime);
					}

					timeValuePairs.put(time, value);
				}
			}
		} catch (Exception e) {
			timeValuePairs.put(time, Double.NaN);
		}

		return timeValuePairs;
	}

	public static void main(String[] args) {
		EstimateData es = new EstimateData();
		List<Double> values = Arrays.asList(Double.NaN, Double.NaN, Double.NaN,
				Double.NaN, 2.0, 4.0, 5.5, 7.0, 10.0, 11.5, Double.NaN,
				Double.NaN, 21.3, Double.NaN, 70.8, 80.1, Double.NaN,
				Double.NaN, Double.NaN, Double.NaN, Double.NaN);
		List<Double> interpValues = es.interpValues(values);
		System.out.println(interpValues);
	}
}
