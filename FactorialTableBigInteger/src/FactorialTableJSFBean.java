import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

  @ManagedBean(name = "factorialTable")
  @SessionScoped
public class FactorialTableJSFBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int number;
	  private int factorial;
	  
	  private static final ArrayList<Factorial> factorialList=new ArrayList<Factorial>(Arrays.asList(new Factorial(0,calc_factorial(BigInteger.valueOf(0))),
			  																				new Factorial(1,calc_factorial(BigInteger.valueOf(1))),
			  																				new Factorial(12,calc_factorial(BigInteger.valueOf(12))),
			  																				new Factorial(20,calc_factorial(BigInteger.valueOf(20))),
			  																				new Factorial(25,calc_factorial(BigInteger.valueOf(25))),
			  																				new Factorial(30,calc_factorial(BigInteger.valueOf(30))),
			  																				new Factorial(35,calc_factorial(BigInteger.valueOf(35))),
			  																				new Factorial(40,calc_factorial(BigInteger.valueOf(40))),
			  																				new Factorial(45,calc_factorial(BigInteger.valueOf(45))),
			  																				new Factorial(50,calc_factorial(BigInteger.valueOf(50))),
			  																				new Factorial(100,calc_factorial(BigInteger.valueOf(100)))));
	  
	
	  public static BigInteger calc_factorial(BigInteger n) 
	    { 
	        if (n == BigInteger.ONE || n == BigInteger.ZERO)
				return BigInteger.ONE;
			else
				return n.multiply( calc_factorial(n.subtract(BigInteger.ONE))); 
	    } 


	public ArrayList<Factorial> getFactorialList() {
		return factorialList;
	}


	
	  
}
