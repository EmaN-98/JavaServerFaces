

import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "quiz")
@SessionScoped		//setam bean-ul la viewScope, acesta traind atat timp cat perspectiva e aceeasi, fiind creat la prima afisare a paginii
public class AdditionQuizzezJSFBean {

	private String UserResultString;
	
	private static final ArrayList<Quiz> quizList=new ArrayList<Quiz>(Arrays.asList(new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber()),
				new Quiz(generateNumber(),generateNumber())));
	
	private static  int generateNumber() {
		return (int)(Math.random() * 100);
		
	}
	//avem metode de get si set pentru numarul inserat de catre utlizator
	
	public String getResponse() { //definim si metoda getREsponse
		if (UserResultString == null)   //care verifica daca s-a inserat vreun numar sau nu
			return ""; // No user input yet

		int guess = Integer.parseInt(guessString); //parseaza input-ul din string in 						integer
		if (guess < number)  //si il compara cu numarul generat din aplicatie
			//determinand daca este corect sau nu
			return "Too low";
		else if (guess == number)
			return "You got it";
		else
			return "Too high";
	}

	public String getUserResultString() {
		return UserResultString;
	}

	public void setUserResultString(String userResultString) {
		UserResultString = userResultString;
	}

	public static ArrayList<Quiz> getQuizlist() {
		return quizList;
	}
}