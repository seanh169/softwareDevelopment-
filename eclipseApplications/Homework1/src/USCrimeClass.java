

/**
 * 
 * @author Sean Hamilton
 * @date 12/11/2018
 * @purpose Class to hold US Crime Statistics objects of related information.
 *
 */


public class USCrimeClass {
	
	//All fields of crime objects
	public short year;
	public long population;
	public int violentCrime;
	public double violentCrimeRate;
	public int  murderNNMS;
	public double murderNNMSrate;
	public int rape;
	public double rapeRate;
	public int robbery;
	public double robberyRate;
	public long aggravateAssault;
	public double aggravateAssaultRate;
	public long propertyCrime;
	public double propertyCrimeRate;
	public long burglary;
	public double burglaryRate;
	public long larcenyTheft;
	public double larcenyTheftRate;
	public long motorVehicleTheft;
	public double motorVehicleTheftRate;
	
	//Constructor to create new Crime Object if all fields are known
	public USCrimeClass(short year, long population, int violentCrime, double violentCrimeRate, int murderNNMS,
			double murderNNMSrate, int rape, double rapeRate, int robbery, double robberyRate, long aggravateAssault,
			double aggravateAssaultRate, long propertyCrime, double propertyCrimeRate, long burglary,
			double burglaryRate, long larcenyTheft, double larcenyTheftRate, long motorVehicleTheft,
			double motorVehicleTheftRate) {
		super();
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
}
