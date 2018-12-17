import java.util.List;

public class USCrimeClass {
	
	public static short year;
	public static long population;
	public static int violentCrime;
	public static double violentCrimeRate;
	public static int  murderNNMS;
	public static double murderNNMSrate;
	public static int rape;
	public static double rapeRate;
	public static int robbery;
	public static double robberyRate;
	public static long aggravateAssault;
	public static double aggravateAssaultRate;
	public static long propertyCrime;
	public static double propertyCrimeRate;
	public static long burglary;
	public static double burglaryRate;
	public static long larcenyTheft;
	public static double larcenyTheftRate;
	public static long motorVehicleTheft;
	public static double motorVehicleTheftRate;
	
//	public short year;
//	public long population;
//	public int violentCrime;
//	public double violentCrimeRate;



	public USCrimeClass(short year, long population, int violentCrime, double violentCrimeRate, int murderNNMS, double murderNNMSrate, int rape, double rapeRate, int robbery, double robberyRate, long aggravateAssault, double aggravateAssaultRate, long propertyCrime, double propertyCrimeRate, long burglary, double burglaryRate, long larcenyTheft, double larcenyTheftRate, long motorVehicleTheft, double motorVehicleTheftRate) {
		this.year = year;
		this.population = population;
		this.violentCrime = violentCrime;
		this.violentCrimeRate = violentCrimeRate;
		this.murderNNMS = murderNNMS;
		this.murderNNMSrate = murderNNMSrate;
		this.rape = rape;
		this.rapeRate = rapeRate;
		this.robbery = robbery;
		this.robberyRate = robberyRate;
		this.aggravateAssault = aggravateAssault;
		this.aggravateAssaultRate = aggravateAssaultRate;
		this.propertyCrime = propertyCrime;
		this.propertyCrimeRate = propertyCrimeRate;
		this.burglary = burglary;
		this.burglaryRate = burglaryRate;
		this.larcenyTheft = larcenyTheft;
		this.larcenyTheftRate = larcenyTheftRate;
		this.motorVehicleTheft = motorVehicleTheft;
		this.motorVehicleTheftRate = motorVehicleTheftRate;
	}
	
	
	
	public static short getYear() {
		return year;
	}







	public static void setYear(short year) {
		USCrimeClass.year = year;
	}







	public static long getPopulation() {
		return population;
	}







	public static void setPopulation(long population) {
		USCrimeClass.population = population;
	}







	public static int getViolentCrime() {
		return violentCrime;
	}







	public static void setViolentCrime(int violentCrime) {
		USCrimeClass.violentCrime = violentCrime;
	}







	public static double getViolentCrimeRate() {
		return violentCrimeRate;
	}







	public static void setViolentCrimeRate(double violentCrimeRate) {
		USCrimeClass.violentCrimeRate = violentCrimeRate;
	}







	public static int getMurderNNMS() {
		return murderNNMS;
	}







	public static void setMurderNNMS(int murderNNMS) {
		USCrimeClass.murderNNMS = murderNNMS;
	}







	public static double getMurderNNMSrate() {
		return murderNNMSrate;
	}







	public static void setMurderNNMSrate(double murderNNMSrate) {
		USCrimeClass.murderNNMSrate = murderNNMSrate;
	}







	public static int getRape() {
		return rape;
	}







	public static void setRape(int rape) {
		USCrimeClass.rape = rape;
	}







	public static double getRapeRate() {
		return rapeRate;
	}







	public static void setRapeRate(double rapeRate) {
		USCrimeClass.rapeRate = rapeRate;
	}







	public static int getRobbery() {
		return robbery;
	}







	public static void setRobbery(int robbery) {
		USCrimeClass.robbery = robbery;
	}







	public static double getRobberyRate() {
		return robberyRate;
	}







	public static void setRobberyRate(double robberyRate) {
		USCrimeClass.robberyRate = robberyRate;
	}







	public static long getAggravateAssault() {
		return aggravateAssault;
	}







	public static void setAggravateAssault(long aggravateAssault) {
		USCrimeClass.aggravateAssault = aggravateAssault;
	}







	public static double getAggravateAssaultRate() {
		return aggravateAssaultRate;
	}







	public static void setAggravateAssaultRate(double aggravateAssaultRate) {
		USCrimeClass.aggravateAssaultRate = aggravateAssaultRate;
	}







	public static long getPropertyCrime() {
		return propertyCrime;
	}







	public static void setPropertyCrime(long propertyCrime) {
		USCrimeClass.propertyCrime = propertyCrime;
	}







	public static double getPropertyCrimeRate() {
		return propertyCrimeRate;
	}







	public static void setPropertyCrimeRate(double propertyCrimeRate) {
		USCrimeClass.propertyCrimeRate = propertyCrimeRate;
	}







	public static long getBurglary() {
		return burglary;
	}







	public static void setBurglary(long burglary) {
		USCrimeClass.burglary = burglary;
	}







	public static double getBurglaryRate() {
		return burglaryRate;
	}







	public static void setBurglaryRate(double burglaryRate) {
		USCrimeClass.burglaryRate = burglaryRate;
	}







	public static long getLarcenyTheft() {
		return larcenyTheft;
	}







	public static void setLarcenyTheft(long larcenyTheft) {
		USCrimeClass.larcenyTheft = larcenyTheft;
	}







	public static double getLarcenyTheftRate() {
		return larcenyTheftRate;
	}







	public static void setLarcenyTheftRate(double larcenyTheftRate) {
		USCrimeClass.larcenyTheftRate = larcenyTheftRate;
	}







	public static long getMotorVehicleTheft() {
		return motorVehicleTheft;
	}







	public static void setMotorVehicleTheft(long motorVehicleTheft) {
		USCrimeClass.motorVehicleTheft = motorVehicleTheft;
	}







	public static double getMotorVehicleTheftRate() {
		return motorVehicleTheftRate;
	}







	public static void setMotorVehicleTheftRate(double motorVehicleTheftRate) {
		USCrimeClass.motorVehicleTheftRate = motorVehicleTheftRate;
	}







	public USCrimeClass() {}
	
}
