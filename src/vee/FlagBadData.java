package vee;

import java.util.List;
import java.util.Map;

public class FlagBadData {
	public Map<Long, String> recordVeeType(List<Double> valuesOrigin,
			List<Double> valuesEs, List<Long> times, Map<Long, String> records,
			String recordsContent) {
		for (int i = 0; i < times.size(); i++) {
			String content = "";
			Long time = times.get(i);
			if (valuesOrigin.get(i).isNaN() && !valuesEs.get(i).isNaN()) {
				if (records.keySet().contains(time)) {
					content = records.get(time) + "," + recordsContent;
				} else {
					content = "missing-data" + "," + recordsContent;
				}
				records.put(time, content);
			}

			if (!valuesOrigin.get(i).isNaN() && valuesEs.get(i).isNaN()) {
				content = recordsContent;
				records.put(time, content);
			}
		}

		return records;
	}
}
