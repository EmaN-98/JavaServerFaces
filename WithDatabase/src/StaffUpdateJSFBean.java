import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.*;
import java.io.Serializable;

//import javax.faces.bean.ManagedBean;

@ManagedBean(name = "staffUpdate")
@ApplicationScoped
public class StaffUpdateJSFBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String lastName;
	private String firstName;
	private String mi;
	private String address;
	private String city;
	private String state;
	private String telephone;
	private String email;
	private String status = "Nothing stored";
	// Use a prepared statement to store a student into the database
	private PreparedStatement pstmt;
	Connection conn;

	public StaffUpdateJSFBean() {
		initializeJdbc();
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/*private boolean isRquiredFieldsFilled() {
		return !(lastName == null || firstName == null
				|| lastName.trim().length() == 0
				|| firstName.trim().length() == 0);
	}*/
////////////////////////////////////////
	/*public String processView() {
		if (id!=null)
			return "ConfirmAddress";
		else
			return "";
	}*/

	/*public String getRequiredFields() {
		if (isRquiredFieldsFilled())
			return "";
		else
			return "Last Name and First Name are required";
	}*/

	/*public String getInput() {
		return "<p style=\"color:red\">You entered <br />"
				+ "Last Name: " + lastName + "<br />"
				+ "First Name: " + firstName + "<br />"
				+ "MI: " + mi + "<br />"
				+ "Telephone: " + telephone + "<br />"
				+ "Email: " + email + "<br />"
				+ "City: " + city + "<br />"
				+ "Address: " + address + "<br />"
				+ "State: " + state + "<br />"
				+ "Id: " + id + "</p>";
	}*/

	/** Initialize database connection */
	private void initializeJdbc() {
		try {
			// Explicitly load a MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");

			// Establish a connection
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsf", "emanuelan", "passemanuela");

			// Create a Statement
			pstmt = conn.prepareStatement("insert into staff (id,lastName,"
					+ " firstName, mi, address, city, "
					+ "state, telephone,email) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/** Store an address to the database */
	public String insertStaff() {
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, lastName);
			pstmt.setString(3, firstName);
			pstmt.setString(4, mi);
			pstmt.setString(5, address);
			pstmt.setString(6, city);
			pstmt.setString(7, state);
			pstmt.setString(8, telephone);
			pstmt.setString(9, email);
			
			pstmt.executeUpdate();
			status = firstName + " " + lastName
					+ " is now registered in the database.";
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return "";
	}
	
	public String viewStaff() {
		try {
			pstmt = conn.prepareStatement("select * from staff where id=?");
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				status=new Staff(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)).toString();
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return "";
	}
	
	public String updateStaff() {
		try {
			pstmt = conn.prepareStatement("UPDATE staff SET  lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id= ? ", Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setString(3, mi);
			pstmt.setString(4, address);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, telephone);
			pstmt.setString(8, email);
			pstmt.setString(9, id);
			pstmt.executeUpdate();
			ResultSet rs=pstmt.getGeneratedKeys();
			status="Successfully updated";
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return "";
	}


	public String getStatus() {
		return status;
	}
	
	public String getClear() {
		return "";
	}
}