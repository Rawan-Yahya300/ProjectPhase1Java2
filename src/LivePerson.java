

public class LivePerson extends Person {

	public LivePerson() {
		super();
	
	}

	public LivePerson(String ID, String Name, int Age, String Gender, String Address, String ContactInfo) {
		super(ID, Name, Age, Gender, Address, ContactInfo);
		
	}
   public String toString() {
	   return " ID:"+getID()+"  Name:"+getName()+"  Age:"+getAge()+"  Gender:"+getGender()+"  Address:"+getAddress()+"  ContactInfo:"+getContactInfo();
   }
}

