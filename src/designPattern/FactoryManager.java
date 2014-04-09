package designPattern;

public class FactoryManager {

	public static FactoryCar buildCar(FactoryCarType model){
		FactoryCar car = null;
		
		switch(model){
		case SMALL:
			car = new FactorySmallCar();
			break;
			
		case SEDAN:
			car = new FactorySedanCar();
			break;
			
		case LUXURY:
			car = new FactoryLuxuryCar();
			break;
		}
		
		return car;
	}
}
