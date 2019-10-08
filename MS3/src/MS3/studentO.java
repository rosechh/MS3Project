/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MS3;

/**
 *
 * @author Rojaleen
 */
class studentO {
    private String firstname;
	private String lastname;
	private String email;
	private String gender;
	private String imgcode;
	private String cardtype;
	private float tax;
	private boolean c1;
	private boolean c2;
	private String country;
	
	public studentO(String firstname,String lastname,String email,String gender,String imgcode,String cardtype,float tax,boolean c1,boolean c2,String country) {
		
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.gender=gender;
		this.imgcode=imgcode;
		this.cardtype=cardtype;
		this.tax=tax;
		this.c1=c1;
		this.c2=c2;
		this.country=country;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getimgcode() {
		return imgcode;
	}

	public void setimgcode(String imgcode) {
		this.imgcode = imgcode;
	}
	public String getcardtype() {
		return cardtype;
	}

	public void setcardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public float gettax() {
		return tax;
	}

	public void settax(float tax) {
		this.tax = tax;
	}
	public boolean getc1() {
		return c1;
	}

	public void setc1(boolean c1) {
		this.c1 = c1;
	}
	public boolean getc2() {
		return c2;
	}

	public void setc2(boolean c2) {
		this.c2 = c2;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
