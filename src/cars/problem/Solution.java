package cars.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			if (args.length == 3) {
				String dataSetPath = args[0];
				int    n           = Integer.parseInt(args[1]);
				String o           = args[2];
				
				br = new BufferedReader(new FileReader(dataSetPath));
				br.readLine();
				
				String                       line;
				Map<String, List<CarDetail>> dataMap = new HashMap<>();
				CarDetail                    record  = null;
				
				if (n <= 0) {
					System.out.println("N can't be zero or negative. Please provide positive value only");
					return;
				}
				String[] input = null;
				while ((line = br.readLine()) != null) {
					input = line.split(",");
					
					if (input.length == 3) {
						record = new CarDetail();
						record.setName(input[0]);
						record.setOrigin(input[1]);
						record.setHorsePower(Double.parseDouble(input[2]));
						
						if (!dataMap.containsKey(record.getOrigin())) {
							dataMap.put(record.getOrigin(), new ArrayList<>());
						}
						dataMap.get(record.getOrigin()).add(record);
					} else {
						System.out.println(line
						        + " - This data is in incorrect format. It will not be considered for result evaluation");
					}
				}
				List<CarDetail> sameOriginCarsList = dataMap.get(o);
				if (sameOriginCarsList == null) {
					System.out.println("Origin : " + o + " doesn't exist in dataset");
					return;
				}
				
				double avgHorsePower = 0;
				
				// calculating average horse power of all CarDetail objects of given origin
				for (CarDetail carDetail : sameOriginCarsList) {
					avgHorsePower += carDetail.getHorsePower();
				}
				avgHorsePower /= sameOriginCarsList.size();
				
				// sorting list of CarDetail objects based on its horse power in decreasing
				// order
				sameOriginCarsList.sort(Comparator.comparing(CarDetail::getHorsePower).reversed());
				
				int index = 0;
				while (n-- > 0) {
					if (index < sameOriginCarsList.size()) {
						CarDetail output = sameOriginCarsList.get(index);
						if (output.getHorsePower() > avgHorsePower) {
							System.out.println(output);
						}
						index += 1;
					}
				}
			} else {
				System.out.println(
				        "Invalid number of command line arguments. Please provide 3 args only; dataset path, number of records to fetch(N) and origin(O)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}