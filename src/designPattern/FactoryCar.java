package designPattern;

public abstract class FactoryCar {

	public FactoryCar(FactoryCarType model){
		this.carModel = model;
	}
	
	protected abstract void construct();
	
	public FactoryCarType getCarModel() {
		return carModel;
	}

	public void setCarModel(FactoryCarType carModel) {
		this.carModel = carModel;
	}

	private FactoryCarType carModel;
	
	
}
