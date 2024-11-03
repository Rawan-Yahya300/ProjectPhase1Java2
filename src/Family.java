import java.util.ArrayList;

public class Family {
	private String familyName;
	private ArrayList<Person> members = new ArrayList<>();
	private ArrayList<Person> parents = new ArrayList<>();

	public Family() {

	}

	public Family(String familyName) {
		this.familyName = familyName;
	}
    
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyName() { // getter for family name
		return familyName;
	}

	public ArrayList<Person> getMembers() { // getter for members
		return members;
	}

	public ArrayList<Person> getParents() { // getter for parents
		return parents;
	}

	public boolean addMember(Person member, String role) { //add member to family

		for (int i = 0; i < members.size(); i++) {   //search for person using ID and if the the person is exists do not add him
			if (member.getID().equals(members.get(i).getID()))
				return false;
		}
		if (role.equals("son") || role.equals("daughter")) { //if the person does not exist ,check if the member is son or daughter and add to the family
			members.add(member);
			return true;
		} else if (role.equals("mom") || role.equals("dad")) {//check if the member is mom or dad and add to the family

			members.add(member);
			boolean isExistInParents = false;   //  and if mom/dad does not exist in the person array , add him/her
			for (int i = 0; i < parents.size(); i++) {
				if (parents.get(i).getID().equals(member.getID())) {
					isExistInParents = true;
				}
			}
			if (isExistInParents == false) {
				parents.add(member);
			}

			return true;

		} else
			return false;

	}

	public boolean removeMember(Person member) { 
		for (int i = 0; i < members.size(); i++) { //search for person using ID , if the person exists remove him
			if (member.getID().equals(members.get(i).getID())) {
				members.remove(i);
				for(int j=0; j<parents.size();j++) { //if the person exist in the parent array ,also remove him from it
					if (member.getID().equals(parents.get(j).getID())) {
						parents.remove(j);
					}
				}
				

				return true;
			}

		}
		return false;
	}

	public boolean addParent(Person parent) {


		for (int i = 0; i < parents.size(); i++) {   //search for parent using ID and if the the person is exists do not add him
			if (parent.getID().equals(parents.get(i).getID()))
				return false;
		}
		parents.add(parent); //if parent does not exist ,add him
		boolean isExistInMember=false;
		for (int i = 0; i < members.size(); i++) {   //if the parent does not exist on members array , add him to it
			if (parent.getID().equals(members.get(i).getID()))
				isExistInMember=true;
		}
		if(isExistInMember==false) {
			members.add(parent);
		}
           return true;
	}

	public boolean removeParent(Person parent) {
		for (int i = 0; i < parents.size(); i++) {  //search for parent using ID ,if the parent exists remove it
			if (parent.getID().equals(parents.get(i).getID())) {
				parents.remove(i);
				for(int j=0; j<members.size();j++) {  //and if parent exists on members array , remove him from it
					if (parent.getID().equals(members.get(j).getID())) {
						members.remove(j);
					}
				}
				
				return true;
			}
		}
		return false;
	}

	public String toString() { //to put the members of family in string

		String s = "Family name is " + familyName + ", family members:";

		for (int i = 0; i < members.size(); i++) {
			s += " " + members.get(i).getName(); 
		}
		return s;
	}

	public String toStringWithId() { // to put the members of family in string with their ID
		String s = "Family name is " + familyName + ", family members:";

		for (int i = 0; i < members.size(); i++) {
			s += " Name:" + members.get(i).getName() + " ID:" + members.get(i).getID() + " ,";
		}
		return s;
	}

	public boolean equals(Object obj) {// to check if two families have the same number of martyrs
		int martyrOfThisFamily1 = 0;
		int martyrOfNewFamily = 0;
		for (int i = 0; i < members.size(); i++) { //calculate the number of martyrs of family 1
			if (members.get(i) instanceof Martyr) {
				martyrOfThisFamily1++;
			}
		}

		for (int i = 0; i < ((Family) obj).getMembers().size(); i++) { //calculate the number of martyrs of family 2
			if (((Family) obj).getMembers().get(i) instanceof Martyr) {
				martyrOfNewFamily++;
			}
		}

		return martyrOfThisFamily1 == martyrOfNewFamily; //if they have the same number , return true
	}

}
