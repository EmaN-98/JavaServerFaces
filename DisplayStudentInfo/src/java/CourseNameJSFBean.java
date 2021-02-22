import java.io.Serializable;
  import java.sql.*;
  import java.util.ArrayList;
  import javax.enterprise.context.ApplicationScoped;
  import javax.inject.Named;
 
  @Named(value = "courseName")
  //@ApplicationScoped	//cu durata de viata a aplicatiei asa incat bean-ul este creat la lansarea proiectului din server
 public class CourseNameJSFBean implements Serializable{
 private PreparedStatement studentStatement = null; //statement necesar obtinerii datelor dorite din baza de date
 private String choice; // Selected course //cursul ales
 private String[] titles; // Course titles //numele cursurilor
 ResultSet resultSet;
 /** Creates a new instance of CourseName */
 public CourseNameJSFBean() {
 initializeJdbc();	//se incarca driver-ul sql necesar pt conectarea la baza de date, metoda ce o definim in continuare
 }

 /** Initialize database connection */
 private void initializeJdbc() {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 System.out.println("Driver loaded");

 // Connect to the sample database
 Connection connection = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/jsf", "emanuelan", "passemanuela");

 // Get course titles
 PreparedStatement statement = connection.prepareStatement(
 "select Course from displaystudent");

  resultSet = statement.executeQuery();//obtinem titlurile cursurilor

 // Store resultSet into array titles
 ArrayList<String> list = new ArrayList<>(); //si le stocam intr-un arrayLIst
 while (resultSet.next()) {
 list.add(resultSet.getString(1));
 }
 titles = new String[list.size()]; // Array for titles
 list.toArray(titles); // Copy strings from list to array
System.out.println("titles"+titles.toString());
 // Define a SQL statement for getting students
 studentStatement = connection.prepareStatement(
 "select * from displaystudent "
 + "where Course = ? "
);
 }
 catch (Exception ex) {
 ex.printStackTrace();
 }
 }

//metoda de obtinere a numelor cursurilor pt a afisa lista din care utilizatorul sa il aleaga pe cel dorit
 public String[] getTitles() {
 return titles;
 }
//metoda de obtinere a alegerii utilizatorului
 public String getChoice() {
 return choice;
 }
//si cea de setare
 public void setChoice(String choice) {
 this.choice = choice;
 }

 public ResultSet getStudents() throws SQLException {
 if (choice == null) { //daca nu a fost ales niciun curs, nu avem ce afisa
 if (titles.length == 0)
 return null;
 else
 studentStatement.setString(1, titles[0]);
 }
 else {
 studentStatement.setString(1, choice); // Set course title
 }

 // Get students for the specified course
 return studentStatement.executeQuery(); //returnam lista studentilor cautati
  }
  }