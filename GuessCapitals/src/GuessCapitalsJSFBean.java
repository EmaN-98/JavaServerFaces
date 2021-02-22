import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean(name="guessCapitals")
@SessionScoped
public class GuessCapitalsJSFBean implements Serializable{
	
	private String randomCountry;
	private String randomCapital;	
	private String guessCapital;

	private static final ArrayList<Capital> capitalsList=new ArrayList<Capital>(Arrays.asList(new Capital("Romania","Bucharest"),
				new Capital("Spain","Madrid"),
				new Capital("Italy","Rome"),
				new Capital("France","Paris"),
				new Capital("Russia","Moscow"),
				new Capital("United Kingdom","London"),
				new Capital("Australia","Sidney"),
				new Capital("United States of America","Washington"),
				new Capital("Greece","Athens"),
				new Capital("Germany","Berlin"),
				new Capital("China","Beiging"),
				new Capital("Egypt","Cairo"),
				new Capital("Senegal","Dakar"),
				new Capital("Qatar","Doha"),
				new Capital("Indonesia","Jakarta"),
				new Capital("Monaco","Monaco"),
				new Capital("Singapore","Singapore")));

	
	public GuessCapitalsJSFBean() {
		getRandom();
	}
	
	public void getRandom() {
		int index=(int)(Math.random() * (capitalsList.size() - 1));
		randomCountry=capitalsList.get(index).getCountry();
		randomCapital=capitalsList.get(index).getCapital();
	}
	
	public String getRandomCountry() {
		return randomCountry;
	}

	public void setRandomCountry(String randomCountry) {
		this.randomCountry = randomCountry;
	}

	public static ArrayList<Capital> getCapitalslist() {
		return capitalsList;
	}

	public String getRandomCapital() {
		return randomCapital;
	}

	public void setRandomCapital(String randomCapital) {
		this.randomCapital = randomCapital;
	}

	public String getGuessCapital() {
		return guessCapital;
	}

	public void setGuessCapital(String guessCapital) {
		this.guessCapital = guessCapital;
	}

	public String getResponse() {
		
		if (guessCapital.equals(randomCapital))
			return "Correct";
		return "No, the capital of "+this.getRandomCountry()+" is "+this.getRandomCapital()+".";
	}
	
	public String processSubmit() {
		if (guessCapital!=null)
			return "GuessCapitalsStatus";
		else
			return "";
		}
/*
	public static void removeViewScopedBean(String beanName) 
    {
      FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(beanName);
    }
*/	
	public String next() {
		getRandom();
		return "GuessCapitals";
	}
}
