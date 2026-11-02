abstract class Appliance {
	private String appliancename;
	private String brand;
	private int powerconsumption;
	
	public String getappliancename(){
		return appliancename;
	}
	
	public String getbrand(){
		return brand;
	}
	
	public int getpowerconsumption(){
		return powerconsumption;
	}
	
	Appliance(String appliancename,String brand,int powerconsumption){
		this.appliancename=appliancename;
		this.brand=brand;
		this.powerconsumption=powerconsumption;
	}
	public void appliancedatails(){
		System.out.println("Name :"+appliancename);
		System.out.println("Brand :"+brand));
		System.out.println("powerconsumption :"+powerconsumption);
	}
	
	abstract  double calculateenergyusage();
}

class Light extends Appliance {
	private int brightnesslevel;
	int hours;
	
	public void sethours(int hours){
		this.hours=hours;
	}
	
	
	Light(String appliancename,String brand,int powerconsumption,int brightnesslevel){
		super(appliancename,brand,powerconsumption);
		this.brightnesslevel=brightnesslevel;
	}
	@override
	public void appliancedatails(){
		System.out.println("Name :"+appliancename);
		System.out.println("Brand :"+brand));
		System.out.println("powerconsumption :"+powerconsumption);
		System.out.println("brightnesslevel :"+brightnesslevel);
	}
	
	@override
	double calculatenergyusage(){
		return (powerconsumption*(brightnesslevel/100.0)*hours)/1000.0;
	}
}

class Fan extends Appliance{
	private int Speedlevel;
	
	int hours;
	public void sethours(int hours){
		this.hours=hours;
	}
	
	Fan(String appliancename,String brand,int powerconsumption,int speedlevel){
		super(appliancename,brand,powerconsumption);
		this.speedlevel=speedlevel;
		
	}
	@override
	public void appliancedatails(){
		System.out.println("Name :"+appliancename);
		System.out.println("Brand :"+brand));
		System.out.println("powerconsumption :"+powerconsumption);
		System.out.println("speedlevel :"+speedlevel);
	}
	@override
	double calculatenergyusage(){
		return (powerconsumption*(speedlevel/5.0)*hours)/1000.0;
	}
	
}

class Airconditioner extends Appliance{
	private	int temperature;
	int hours;
	
	public void sethours(int hours){
		this.hours=hours;
	}
	
	Airconditioner(String appliancename,String brand,int powerconsumption,int temperature){
		super(appliancename,brand,powerconsumption);
		this.temperature=temperature;
	}
	@override
	public void appliancedatails(){
		System.out.println("Name :"+appliancename);
		System.out.println("Brand :"+brand));
		System.out.println("powerconsumption :"+powerconsumption);
		System.out.println("temperature :"+temperature);
	}
	@override
	double calculatenergyusage(){
		return (powerconsumption*hours)/1000.0;
	}
}

class SmartHomeSystem1{
	
	public double findprice(double units){
		double cost=0;
		
	if(units<=30){
		cost=units*1.90;
	}
	else if(units>30 || units<=90){
		cost=(30*1.90)+(units-30)*4.50;
	}
	else if(units>90 || units<=120){
		cost=(30*1.90)+(60*4.50)+(units-90)*6.75;
	}
	else if(units>120 || units<=180){
		cost=(30*1.90)+(60*4.50)+(30*6.75)+(units-120)*7.5;
	}
	else{
		return 0;
	}
	return cost;
	}
	public static void main(String[] args){
	
	System.out.println("Energy report for all home appliances.");	
	Light light=new Light("Light","Philips",100,80);
	light.sethours(10);
	light.appliancedatails();
	System.out.println("Energy usage :"+calculatenergyusage());
	
	System.out.println("Energy report for all home appliances.");	
	Fan fan=new Fan("Fan","LG",200,5);
	fan.sethours(15);
	fan.appliancedatails();
	System.out.println("Energy usage :"+calculatenergyusage());

	System.out.println("Energy report for all home appliances.");	
	Airconditioner ac=new Airconditioner("AC","Samsung",500,20);
	fan.sethours(10);
	fan.appliancedatails();
	System.out.println("Energy usage :"+calculatenergyusage());
	
	
}
	
}