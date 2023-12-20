package Assignment1;

public class Computer {

	private String brand;
	private String model;
	private double price;
	private long serialNumber;
    private long serialnumbercounter = 1000000;
	private static int numOfComp = 0;

	public Computer(String br, String md, double pr) {
		brand = br;
		model = md;
		price = pr;
		serialNumber = serialnumbercounter;
		serialnumbercounter++;
		numOfComp++;

	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String br) {
		brand = br;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String md) {
		model = md;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double pr) {
		price = pr;
	}

	public long getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "brand: " + brand + " \n" 
	            + "model : " + model + "\n" 
				+ "price :" + price + "\n"
				+ "serialNumber : " + serialNumber;

	}

	public int findNumberOfCreatedComputers() {
		return numOfComp;
	}

	public boolean equal(Computer c) {
		System.out.println(brand+c.brand);
		if (brand == c.brand && model == c.model && price == c.price) {
			return true;
		} else {
			return false;
		}
	}

	public static int getNumOfComp() {
		// TODO Auto-generated method stub
		return numOfComp;
	}

}
