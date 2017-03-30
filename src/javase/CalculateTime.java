package javase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateTime {

	public static void main(String[] args) {
		BufferedReader br = null;
		List<String> times = new ArrayList<>();

		try {

			String sCurrentLine;

			br = new BufferedReader(
					new FileReader(
							"/home/maison/Downloads/es-index-consumer/archive/catalina-20161026-999.log"));

			while ((sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.contains("typeName=")) {
					int l1 = sCurrentLine.indexOf("typeName=");
					int l2 = sCurrentLine.indexOf("]", l1);
					String t = sCurrentLine.substring(l1 - 1, l2);
					// System.out.println(t.split("=")[1]);
					times.add(t.split("=")[1]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		Map<String, Integer> result = new HashMap<String, Integer>();
		for (String type : times) {
			if (result.containsKey(type)) {
				int count = result.get(type);
				result.put(type, count + 1);
			} else {
				result.put(type, 1);
			}
		}
		System.out.println(times.size());
		System.out.println(result);

	}

}
