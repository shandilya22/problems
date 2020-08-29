package max.profit.problem;

public class Profit {
	private double profit;
	private Stock   buyPoint;
	private Stock   sellPoint;
	
	public Profit(double profit, Stock buyPoint, Stock sellPoint) {
		this.profit    = profit;
		this.buyPoint  = buyPoint;
		this.sellPoint = sellPoint;
	}
	
	public double getProfit() {
		return profit;
	}
	
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	public Stock getBuyPoint() {
		return buyPoint;
	}
	
	public void setBuyPoint(Stock buyPoint) {
		this.buyPoint = buyPoint;
	}
	
	public Stock getSellPoint() {
		return sellPoint;
	}
	
	public void setSellPoint(Stock sellPoint) {
		this.sellPoint = sellPoint;
	}
	
}
