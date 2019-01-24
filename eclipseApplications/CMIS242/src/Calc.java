/**
* This program will display basic operations with the number inputed and pi.
*
* @author (Reyn Tao)
* @version (19 January 2019)
*/
public class Calc
{

public static void main(String []args){
piOperations num1 = new piOperations(4);
piOperations num2 = new piOperations(8);
piOperations num3 = new piOperations(2.5);

}
}

class piOperations{
double pi = 3.14159;
double add;
double subtract;
double divide;
double multiply;

public piOperations(double x){
add = x + pi;
subtract = x - pi;
divide = x / pi;
multiply = x * pi;

System.out.println("The Pi Operations for " + x + " is add: " + add + " subtract: " + subtract
+ " divide: " + divide + " multiply: " + multiply);
}

}

