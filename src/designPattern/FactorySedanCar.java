package designPattern;

public class FactorySedanCar extends FactoryCar {

	public FactorySedanCar() {
		super(FactoryCarType.SEDAN);
	}

	@Override
	protected void construct() {
		System.out.println("Building Sedan Car");
		
	}

	
}
