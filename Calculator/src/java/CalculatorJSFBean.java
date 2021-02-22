 package jsf2demo;
 
  import javax.inject.Named;
  import javax.enterprise.context.RequestScoped;
 
  @Named(value = "calculator")
  @RequestScoped  //si acum, vrem ca la fiecare request, sa fie procesate date curente inserate in formular
 public class CalculatorJSFBean {
  private Double number1; //avem cele doua numere ca proprietati
 private Double number2;
 private Double result;  //precum si rezultatul ce va fi stocat in atributul result

 public CalculatorJSFBean() { //contructorul
 }
 		//metode de get pt cele 2 nr si rezultat
 public Double getNumber1() {
    return number1;
 }

 public Double getNumber2() {
 return number2;
 }

 public Double getResult() {
 return result;
 }
		//metode de set pt cele 2 nr si rezultat
 public void setNumber1(Double number1) {
 this.number1 = number1;
 }

 public void setNumber2(Double number2) {
 this.number2 = number2;
 }

 public void setResult(Double result) {
 this.result = result;
 }

		//avem metoda care realizeaza adunarea celor 2 nr inserate in calculator
 public void add() {
 result = number1 + number2;
 }
		//scaderea
 public void subtract() {
 result = number1 - number2;
 }
			//impartirea
 public void divide() {
 result = number1 / number2;
 }
			//inmultirea
 public void multiply() {
 result = number1 * number2;
 }  //rezultatul fiecaarei operatii este asignat proprietatii result
 }