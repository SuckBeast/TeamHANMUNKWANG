package Model;

public class MemberVO {
private String Id;
private String Pw;
private String Pwcheck;
private String Name;
private String Address;
private String Phone;

public MemberVO(String id, String pw, String pwcheck, String name, String address, String phone) {
	super();
	Id = id;
	Pw = pw;
	Pwcheck = pwcheck;
	Name = name;
	Address = address;
	Phone = phone;
}

public String getId() {
	return Id;
}

public String getPw() {
	return Pw;
}

public String getPwcheck() {
	return Pwcheck;
}

public String getName() {
	return Name;
}

public String getAddress() {
	return Address;
}

public String getPhone() {
	return Phone;
}




}
