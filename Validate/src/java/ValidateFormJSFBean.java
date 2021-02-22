
  import javax.enterprise.context.RequestScoped;
  import javax.inject.Named;
 
  @Named(value = "validateForm")
  @RequestScoped
  public class ValidateFormJSFBean { 
  private String name;
 private String ssn;
 private String ageString;
 private String heightString;
		//getter-e si setter-e pt toate proprietatile
 public String getName() {
 return name;
 }

 public void setName(String name) {
 this.name = name;
 }

 public String getSsn() {
 return ssn;
 }

 public void setSsn(String ssn) {
 this.ssn = ssn;
 }

 public String getAgeString() {
 return ageString;
 }

 public void setAgeString(String ageString) {
 this.ageString = ageString;
 }

 public String getHeightString() {
 return heightString;
 }
 public void setHeightString(String heightString) {
 this.heightString = heightString;
 }

 public String getResponse() { //functia getREsponse() care
	//		in cazul in care vreunul din string-urile introduse
	//		nu respecta formatul impus, returneaza un string null
	//astfel incat daca inputul e invalid, acesta nu e setat beanului
 if (name == null || ssn == null || ageString == null
 || heightString == null) {
 return "";
 }
 else {		//altfel returneaza un string compus din toate datele 				inserate
 return "You entered " +
 " Name: " + name +
 " SSN: " + ssn +
 " Age: " + ageString +
 " Height: " + heightString;
 }
 }
 }