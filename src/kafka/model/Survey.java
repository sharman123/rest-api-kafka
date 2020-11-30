package kafka.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Survey  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int surveyId;
	
	private String fName, lName, streetAddress, city, state, phonenumber, email, howYouHeard, recommendation, rafflenumbers, comments;
	int zipcode;
	String surveydate;
	
    private String likereasons;
	
	public Survey(){
		
	}
	
	public Survey(String fName, String lName, String surveydate) {
		// TODO Auto-generated constructor stub
		this.fName= fName;
		this.lName = lName;
		this.surveydate=surveydate;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surverId) {
		this.surveyId = surverId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHowYouHeard() {
		return howYouHeard;
	}

	public void setHowYouHeard(String howYouHeard) {
		this.howYouHeard = howYouHeard;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getRafflenumbers() {
		return rafflenumbers;
	}

	public void setRafflenumbers(String rafflenumbers) {
		this.rafflenumbers = rafflenumbers;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getSurveydate() {
		return surveydate;
	}

	public String getLikereasons() {
		return likereasons;
	}
	public void setLikereasons(String likereasons) {
		this.likereasons = likereasons;
	}
	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}

	

}

