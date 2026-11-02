import java.util.Scanner;
abstract class Appliance{
	private String applianceName;
	private String brand;
	private int powerConsumption;
	
	Appliance(String brand,int powerConsumption){
		this.applianceName=applianceName;
		this.brand=brand;
		this.powerConsumption=powerConsumption;
	}
	public String getbrand(){
		return brand;
	}
	public String getapplianceName(){
		return applianceName;
	}
	public int getpowerConsumption(){
		return powerConsumption;
	}
	void applianceDetails(){
		
		System.out.println("Brand : "+brand);
		System.out.println("Power Consumption : "+powerConsumption);
	}
	abstract double calculateEnergyUsage();
}

class Light extends Appliance{
	private int brigthnessLevel;
	int hours;
	public void sethours(int hours){
		this.hours=hours;
	}
	Light(String brand,int powerConsumption,int brigthnessLevel){
		super(brand,powerConsumption);
		this.brigthnessLevel=brigthnessLevel;
	}
	@Override
	void applianceDetails(){
		
		System.out.println("Appliance Brand : "+getbrand());
		System.out.println("Appliance Power Consumption : "+getpowerConsumption());
		System.out.println("Brightness Level : "+brigthnessLevel);
	}
	@Override
	double calculateEnergyUsage(){
		return (getpowerConsumption() * (brigthnessLevel / 100.0) * hours) / 1000.0;
	}
}
class Fan extends Appliance{
	private int SpeedLevel;
	int hours;
	public void sethours(int hours){
		this.hours=hours;
	}
	Fan(String brand,int powerConsumption,int SpeedLevel){
		super(brand,powerConsumption);
		this.SpeedLevel=SpeedLevel;
	}
	@Override
	void applianceDetails(){
		
		System.out.println("Appliance Brand : "+getbrand());
		System.out.println("Appliance Power Consumption : "+getpowerConsumption());
		System.out.println("Speed Level : "+SpeedLevel);
	}
	@Override
	double calculateEnergyUsage(){
		return (getpowerConsumption()*(SpeedLevel/5.0)*hours)/1000;
	}
}
class Airconditioner extends Appliance{
	private int temprature;
	int hours;
	public void sethours(int hours){
		this.hours=hours;
	}
	Airconditioner(String brand,int powerConsumption,int temprature){
		super(brand,powerConsumption);
		this.temprature=temprature;
	}
	@Override
	void applianceDetails(){
		
		System.out.println("Appliance Brand : "+getbrand());
		System.out.println("Appliance Power Consumption : "+getpowerConsumption());
		System.out.println("temprature : "+temprature);
	}
	@Override
	double calculateEnergyUsage(){
		return (getpowerConsumption()*hours)/1000;
	}
}
class SmartHomeSystem{
	
	double findPrice(double units) {
    double cost = 0;

    if (units<= 30) {
        cost=units * 1.90;
    } 
	else if (units <= 90) {
        cost = (30 * 1.90) + (units - 30) * 4.50;
    }
	else if (units <= 120) {
        cost = (30 * 1.90) + (60 * 4.50) + (units - 90) * 6.75;
    } 
	else {
        cost = (30 * 1.90) + (60 * 4.50) + (30 * 6.75) + (units - 120) * 7.50;
    }
    return cost;
}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Lights Details");
		
		System.out.print("Enter Brand: ");
		String brand = sc.next();

		System.out.print("Enter Power: ");
		int power = sc.nextInt();

		System.out.print("Enter Brightness: ");
		int brightness = sc.nextInt();

		System.out.print("Enter Hours: ");
		int hours = sc.nextInt();

		Light light = new Light(brand, power, brightness);

		light.sethours(hours);
		light.applianceDetails();

		System.out.printf("Energy Usage: "+"%.2f kWh%n%n" , light.calculateEnergyUsage());

		System.out.println("Enter Fan Details");
			
		System.out.print("Enter Brand: ");
		String fanBrand = sc.next();

		System.out.print("Enter Power: ");
		int fanPower = sc.nextInt();

		System.out.print("Enter Speed Level: ");
		int speed = sc.nextInt();

		System.out.print("Enter Hours: ");
		int fanHours = sc.nextInt();

		Fan fan = new Fan(fanBrand, fanPower, speed);

		fan.sethours(fanHours);
		fan.applianceDetails();

		System.out.printf("Energy Usage: "+"%.2f kWh%n%n"
        , fan.calculateEnergyUsage() );
	
		System.out.println("Enter Air Conditioner Details");

		System.out.print("Enter Brand: ");
		String acBrand = sc.next();

		System.out.print("Enter Power: ");
		int acPower = sc.nextInt();

		System.out.print("Enter Temperature: ");
		int temperature = sc.nextInt();

		System.out.print("Enter Hours: ");
		int acHours = sc.nextInt();

		Airconditioner ac = new Airconditioner(
				acBrand, acPower, temperature);

		ac.sethours(acHours);
		ac.applianceDetails();

		System.out.printf("Energy Usage:"+"%.2f kWh%n%n"
				, ac.calculateEnergyUsage() );
		
		double totalUnits=light.calculateEnergyUsage()+fan.calculateEnergyUsage()+ac.calculateEnergyUsage();
		SmartHomeSystem sh =new SmartHomeSystem();
		System.out.printf("Total Energy Consumption : %.2f kWh%n%n  ",totalUnits);
		System.out.printf("Total cost for Day : Rs. %.2f%n",sh.findPrice(totalUnits));
		System.out.printf("Total units for month : %.2f kWh%n",totalUnits*30);
		System.out.printf("Total cost for Month : %.2f%n",sh.findPrice(totalUnits*30));
	}
}
