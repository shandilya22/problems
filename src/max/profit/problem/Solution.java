package max.profit.problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) {
		List<Stock> dataList = new ArrayList<>();
		Stock       i1       = new Stock("02:00", 7.5);
		dataList.add(i1);
		Stock i2 = new Stock("03:30", 7.9);
		dataList.add(i2);
		Stock i3 = new Stock("04:00", 8.0);
		dataList.add(i3);
		Stock i4 = new Stock("05:30", 6.8);
		dataList.add(i4);
		Stock i5 = new Stock("10:00", 9.01);
		dataList.add(i5);
		maxProfit(dataList);
	}
	
	// Greedy approach
	public static void getMaxProfit(List<Stock> dataList) {
		double     profit       = 0;
		Stock       minValueItem = null;
		List<Stock> tmpList      = new ArrayList<>(dataList);
		
		tmpList.sort(Comparator.comparing(Stock::getValue));
		minValueItem = tmpList.get(0);
		
		int indexOfMinValue = dataList.indexOf(minValueItem);
		
		int i = 0;
		for (i = indexOfMinValue; i < dataList.size(); i++) {
			if (dataList.get(i).getValue() < minValueItem.getValue()) {
				break;
			}
		}
		Stock maxValueItem = dataList.get(i - 1);
		profit = maxValueItem.getValue() - minValueItem.getValue();
		
		System.out.println("Buy at : " + minValueItem.getTime() + " and Sell at : " + maxValueItem.getTime() + ", profit : " + profit);
	}
	
	// Brute-force method - worst case time complexity : O(n2), space : O(n2)
	public static void findMaxProfit(List<Stock> dataList) {
		List<Profit> allPairs = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			for (int j = i + 1; j < dataList.size(); j++) {
				allPairs.add(new Profit((dataList.get(j).getValue() - dataList.get(i).getValue()), dataList.get(i), dataList.get(j)));
			}
		}
		allPairs.sort(Comparator.comparing(Profit::getProfit).reversed());
		System.out.println("Buy at : " + allPairs.get(0).getBuyPoint().getTime() + " and sell at : "
		        + allPairs.get(0).getSellPoint().getTime() + " and profit : " + allPairs.get(0).getProfit());
	}
	
	// Brute-force method - optimized space complexity - O(1), time complexity -
	// O(n2) i.e order of n-square
	public static void maxProfit(List<Stock> dataList) {
		Stock   buyAt     = dataList.get(0);
		Stock   sellAt    = dataList.get(0);
		double profit    = sellAt.getValue() - buyAt.getValue();
		double maxProfit = profit;
		
		for (int i = 0; i < dataList.size(); i++) {
			for (int j = i + 1; j < dataList.size(); j++) {
				profit = dataList.get(j).getValue() - dataList.get(i).getValue();
				
				if (profit > maxProfit) {
					maxProfit = profit;
					buyAt     = dataList.get(i);
					sellAt    = dataList.get(j);
				}
			}
		}
		System.out.println("Buy at : " + buyAt.getTime() + " and sell at : " + sellAt.getTime() + " ; profit : " + maxProfit);
	}
}
