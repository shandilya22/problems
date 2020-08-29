package cars.problem;

public class CarDetail {
	
	private String name;
	private String origin;
	private double horsePower;
	
	public CarDetail() {
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public double getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(double horsePower) {
		this.horsePower = horsePower;
	}
	
	@Override
	public String toString() {
		return (name + "," + origin + "," + horsePower);
	}
	
}
