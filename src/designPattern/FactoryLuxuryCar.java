package designPattern;

public class FactoryLuxuryCar extends FactoryCar {

	public FactoryLuxuryCar() {
		super(FactoryCarType.LUXURY);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void construct() {
		System.out.println("Building Luxury Car");
		
	}

}
