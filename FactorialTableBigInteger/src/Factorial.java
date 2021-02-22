import java.math.BigInteger;

public class Factorial {

	
	private int number;
	private BigInteger factorial;
	  
	
	public Factorial(int number, BigInteger factorial) {
		this.number = number;
		this.factorial = factorial;
	}
	
	public Factorial() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigInteger getFactorial() {
		return factorial;
	}

	public void setFactorial(BigInteger factorial) {
		this.factorial = factorial;
	}

	
	  
}
