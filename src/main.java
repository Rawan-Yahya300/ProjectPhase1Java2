
import java.util.Scanner;

public class main {
	public static void printMenu() { //method to display the menu
		  System.out.println("1-add family\n2-add member\n3-remove member\n4-remove family\n5-search for family by name\n"
	        		+ "6-search for member\n7-update family\n8-calculate total martyr\n9-calculate total orphans\n10-calculate total live person"
	        		+ "\n11-calculate family statistics\n12-calculate global statistics\n13-Check whether two families are equal in number of martyrs+"
	        		+ "\n14-Displays all family\n15-exit");
	  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		
          printMenu();  
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a process");
		int process = input.nextInt();
		while (process != 15) {
			
			switch (process) {
			case 1: {  //to add new family
				System.out.println("enter the family name: ");  //ask the user to enter the family name
				String familyName = input.next();
				Family family = new Family(familyName);  //create the family
				if (manager.addFamily(family)) { //if the adding of family is true , ask about mom and dad
					System.out.println("The process is done");

					System.out.println("Does Mom Martyr or Live Person?\nif she is Martyr enter number 1 , if she is Live Person enter number 2");//ask if the mom martyr or live person
					int statusMum = input.nextInt();  //Enter mom information
					System.out.println("Enter ID: "); 
					String IDMom = input.next();
					System.out.println("Enter Name: ");
					String NameMom = input.next();
					System.out.println("Enter Age: ");
					int AgeMom = input.nextInt();
					String GenderMom = "Female";
					System.out.println("Enter Address: ");
					String AddressMom = input.next();
					System.out.println("Enter Contact Information: ");
					String contactInfoMom = input.next();

					switch (statusMum) { 
					case 1: { //if the mom is martyr ask for mor information 
						System.out.println("Enter Date of Martyrdom: ");
						String DateOfMartyrdom = input.next();
						System.out.println("Enter Cause of Death: ");
						String CauseOfDeath = input.next();
						System.out.println("Enter Place of Death: ");
						String PlaceOfDeath = input.next();
						Martyr martyr = new Martyr(IDMom, NameMom, AgeMom, GenderMom, AddressMom, contactInfoMom,
								DateOfMartyrdom, CauseOfDeath, PlaceOfDeath);
						
						if (family.addMember(martyr, "mom")) { // add the mom to the family as martyr
							System.out.println("The process is done ");
						} else {
							System.out.println("The process is fail");
						}
						break;
					}
					case 2: //if the mom is live person
						 {
						LivePerson livePerson = new LivePerson(IDMom, NameMom, AgeMom, GenderMom, AddressMom,
								contactInfoMom);
						
						if (family.addMember(livePerson, "mom")) { //add the mom to the family as live person
							System.out.println("The process is done ");
						} else {
							System.out.println("The process is fail");
						}
						break;
					}

					}
					System.out.println(
							"Does Dad Martyr or Live Person?\nif he is Martyr enter number 1 , if she is Live Person enter number 2");//ask about the dad
					int statusDad = input.nextInt(); //Ask about his information
					System.out.println("Enter ID: ");
					String IDDad = input.next();
					System.out.println("Enter Name: ");
					String NameDad = input.next();
					System.out.println("Enter Age: ");
					int AgeDad = input.nextInt();
					String GenderDad = "Male";
					System.out.println("Enter Address: ");
					String AddressDad = input.next();
					System.out.println("Enter Contact Information: ");
					String contactInfoDad = input.next();
					
					switch (statusDad) {
					case 1: {  //if the dad is martyr ask about more information
						System.out.println("Enter Date of Martyrdom: ");
						String DateOfMartyrdom = input.next();
						System.out.println("Enter Cause of Death: ");
						String CauseOfDeath = input.next();
						System.out.println("Enter Place of Death: ");
						String PlaceOfDeath = input.next();
						Martyr martyr = new Martyr(IDDad, NameDad, AgeDad, GenderDad, AddressDad, contactInfoDad,
								DateOfMartyrdom, CauseOfDeath, PlaceOfDeath);
						if (family.addMember(martyr, "dad")) { //add the dad as martyr
							System.out.println("The process is done ");
						} else {
							System.out.println("The process is fail");
						}
						break;
					}
					case 2: //if the dad is live person
						 {
						LivePerson livePerson = new LivePerson(IDDad, NameDad, AgeDad, GenderDad, AddressDad,
								contactInfoDad);
						
						if (family.addMember(livePerson, "dad")) { //add the dad to the family as a live person
							System.out.println("The process is done ");
						} else {
							System.out.println("The process is fail");
						}
						break;
					}

					}

				} else {
					System.out.println("the process is fail");
				}
				break;
			}
			case 2: { //to add member
				System.out.println("The member is Martyr or Live Person?if he/she is Martyr enter number 1 ,if he/she is Live Person enter number 2");//ask the user if the member is martyr or live person
				int status = input.nextInt();
				System.out.println("All families: ");
				System.out.println(manager.toString());
				System.out.println("Enter the family number you want to add member to it: ");//ask about family number that the user want to add member to it
				int familyNum = input.nextInt();
				if(familyNum-1>=manager.getFamilies().size()) { //if the family does not exist,stop
					System.out.println("fail,the family does not exist"); 
					break; 
				}
				System.out.println("The member is son or daughter, if son enter 1,if daugther enter number 2:"); //Ask the user if the member is son or daughter
				int sOd = input.nextInt();  //son or daughter
				System.out.println("Enter ID: "); //Ask for information
				String ID = input.next();
				System.out.println("Enter Name: ");
				String Name = input.next();
				System.out.println("Enter Age: ");
				int Age = input.nextInt();
				System.out.println("Enter Gender");
				String Gender = input.next();
				System.out.println("Enter Address: ");
				String Address = input.next();
				System.out.println("Enter Contact Information: ");
				String contactInfo = input.next();

				switch (status) {
				case 1: { //if the member is martyr ask about more information 
					System.out.println("Enter Date of Martyrdom: ");
					String DateOfMartyrdom = input.next();
					System.out.println("Enter Cause of Death: ");
					String CauseOfDeath = input.next();
					System.out.println("Enter Place of Death: ");
					String PlaceOfDeath = input.next();
					Martyr martyr = new Martyr(ID, Name, Age, Gender, Address, contactInfo, DateOfMartyrdom,
							CauseOfDeath, PlaceOfDeath);
                     if(sOd==1) {   //if the member is son , add him to the family as martyr and son
					if (familyNum-1 < manager.getFamilies().size()
							& manager.getFamilies().get(familyNum - 1).addMember(martyr, "son")) {
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
                     }
                     else if(sOd==2) { //if the member is daughter , add him to the family as martyr and daughter
     					if (familyNum < manager.getFamilies().size()
     							& manager.getFamilies().get(familyNum - 1).addMember(martyr, "daughter")) {
     						System.out.println("The process is done ");
     					} else {
     						System.out.println("The process is fail");
     					}
                          }
					break;
				}
				case 2: { 
					LivePerson livePerson = new LivePerson(ID, Name, Age, Gender, Address, contactInfo);
                  if(sOd==1) {//if the member is son , add him to the family as live person and son
					if (familyNum < manager.getFamilies().size()
							& manager.getFamilies().get(familyNum - 1).addMember(livePerson, "son")) {
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
                  }
                  else if(sOd==2) { //if the member is daughter , add him to the family as live person and daughter
  					if (familyNum-1 < manager.getFamilies().size()
  							& manager.getFamilies().get(familyNum - 1).addMember(livePerson, "daughter")) {
  						System.out.println("The process is done ");
  					} else {
  						System.out.println("The process is fail");
  					}
                    }
					break;
				}

				}
				break;
			}
			case 3:{ //to remove member
				System.out.println("All families: ");  //display all families
				System.out.println(manager.toString());
				System.out.println("Enter the family number you want to remove member from it: "); //Ask user to enter the number of family to add the member from it
				int familyNum = input.nextInt();
				boolean is = false;
				if(familyNum-1<manager.getFamilies().size()) { //if the family is exist
					System.out.println(manager.getFamilies().get(familyNum-1).toStringWithId()); //display the family members with their ID
					System.out.println("Enter the ID for the member you want to delete: ");//Ask the user to enter the ID for member to remove it
					String IDtoRemove = input.next();
					for(int i=0; i<manager.getFamilies().get(familyNum-1).getMembers().size();i++) { //looking for about the member and if the member exist remove it
						  if(IDtoRemove.equals(manager.getFamilies().get(familyNum-1).getMembers().get(i).getID())) {
							  is = true; 
							  manager.getFamilies().get(familyNum-1).removeMember(manager.getFamilies().get(familyNum-1).getMembers().get(i));
							  System.out.println("done");
							  System.out.println(manager.getFamilies().get(familyNum-1).toString());
						  }
						  
					}
					if(is==false) {
						System.out.println("The member does not exist");
					}
				}
				else {
					System.out.println("The family does not exist");
				}
				break;
			}
			case 4:{ //to remove family
				System.out.println("All families: "); //display all families
				System.out.println(manager.toString());
				System.out.println("Enetr the family name you want  to delete: "); //Ask the user to enter the number of family to remove it
				String familyName = input.next();
				if(manager.deleteFamily(familyName)) { //if the family exist remove it
					System.out.println("The process is done");
					System.out.println(manager.toString());
				}
				else {
					System.out.println("Fail,the family does not exist ");
				}
				break;
			}
			case 5:{ //to search by family use its name
				System.out.println("Enter thefamily name: "); //ask user to enter the family name
				String familyName = input.next();
				if(manager.searchByName(familyName) != null) //if the family exist display it
					System.out.println(manager.searchByName(familyName));
					else
						System.out.println("The family does not exist");
				break;
			} 
			case 6:{ //to search for member using ID
				System.out.println("Enter the ID for member: "); //ask the user to enter ID for person to remove him
				String ID = input.next();
				if(manager.searchPersonByID(ID) != null) //if the member exist display him
					System.out.println(manager.searchPersonByID(ID));
				else
					System.out.println("The member does not exist");
				
				break;	
			}
			case 7:{ //baaaaaaaack
				System.out.println("Enter the family name you want to update it: ");//ask the user to enter the name family to update it
				String familyName = input.next();
                   boolean isExist=false;
                   for(int i=0;i<manager.getFamilies().size();i++) { //search if the family exist
                	   if(manager.getFamilies().get(i).getFamilyName().equals(familyName)) {
                		   isExist=true;
                	   }
                   }
                   if(isExist==false) { //if the family does not exist , stop
                	   System.out.println("fails,the family does not exist");
                	   break;
                   }
				System.out.println("Enter the name of new family: "); //Ask about the name of new family and its dad and mom
				String familyNameNew = input.next();
				Family family = new Family(familyNameNew);
				System.out.println("Does Mom Martyr or Live Person?\nif she is Martyr enter number 1 , if she is Live Person enter number 2");//ask if the mom martyr or live person
				int statusMum = input.nextInt();  //Enter mom information
				System.out.println("Enter ID: "); 
				String IDMom = input.next();
				System.out.println("Enter Name: ");
				String NameMom = input.next();
				System.out.println("Enter Age: ");
				int AgeMom = input.nextInt();
				String GenderMom = "Female";
				System.out.println("Enter Address: ");
				String AddressMom = input.next();
				System.out.println("Enter Contact Information: ");
				String contactInfoMom = input.next();

				switch (statusMum) { 
				case 1: { //if the mom is martyr ask for more information 
					System.out.println("Enter Date of Martyrdom: ");
					String DateOfMartyrdom = input.next();
					System.out.println("Enter Cause of Death: ");
					String CauseOfDeath = input.next();
					System.out.println("Enter Place of Death: ");
					String PlaceOfDeath = input.next();
					Martyr martyr = new Martyr(IDMom, NameMom, AgeMom, GenderMom, AddressMom, contactInfoMom,
							DateOfMartyrdom, CauseOfDeath, PlaceOfDeath);
					
					if (family.addMember(martyr, "mom")) { // add the mom to the family as martyr
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
					break;
				}
				case 2: //if the mom is live person
					 {
					LivePerson livePerson = new LivePerson(IDMom, NameMom, AgeMom, GenderMom, AddressMom,
							contactInfoMom);
					
					if (family.addMember(livePerson, "mom")) { //add the mom to the family as live person
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
					break;
				}

				}
				System.out.println(
						"Does Dad Martyr or Live Person?\nif he is Martyr enter number 1 , if she is Live Person enter number 2");//ask about the dad
				int statusDad = input.nextInt(); //Ask about his information
				System.out.println("Enter ID: ");
				String IDDad = input.next();
				System.out.println("Enter Name: ");
				String NameDad = input.next();
				System.out.println("Enter Age: ");
				int AgeDad = input.nextInt();
				String GenderDad = "Male";
				System.out.println("Enter Address: ");
				String AddressDad = input.next();
				System.out.println("Enter Contact Information: ");
				String contactInfoDad = input.next();
				
				switch (statusDad) {
				case 1: {  //if the dad is martyr ask about more information
					System.out.println("Enter Date of Martyrdom: ");
					String DateOfMartyrdom = input.next();
					System.out.println("Enter Cause of Death: ");
					String CauseOfDeath = input.next();
					System.out.println("Enter Place of Death: ");
					String PlaceOfDeath = input.next();
					Martyr martyr = new Martyr(IDDad, NameDad, AgeDad, GenderDad, AddressDad, contactInfoDad,
							DateOfMartyrdom, CauseOfDeath, PlaceOfDeath);
					if (family.addMember(martyr, "dad")) { //add the dad as martyr
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
					break;
				}
				case 2: //if the dad is live person
					 {
					LivePerson livePerson = new LivePerson(IDDad, NameDad, AgeDad, GenderDad, AddressDad,
							contactInfoDad);
					
					if (family.addMember(livePerson, "dad")) { //add the dad to the family as a live person
						System.out.println("The process is done ");
					} else {
						System.out.println("The process is fail");
					}
					break;
				}

				}

				
				
				
				
				if(manager.updateFamily(familyName, family)) {
					System.out.println("The process is done");
				}
				else {
					System.out.println("The process is fail , family Does not Exist");
				}
				break;
			}
			case 8 :{ //to calculate total martyr 
				System.out.println("Total Martyr= "+manager.calculateTotalMartyrs()); //invoke the method
				break;
			}
			case 9:{ //to calculate the total orphans
				System.out.println("Total Orphans= "+manager.calculateTotalOrphans()); //invoke method
				break;
			}
			case 10:{ //calculate total live person
				System.out.println("Total Live Person= "+manager.calculateTotalLivePersons()); //invoke method
				break;
			}
			case 11:{ //to calculate family statistics
				System.out.println("Enter the family name to clculate its Statistics: ");//enter the family name
				String familyName = input.next();
				boolean isExist = false; 
				for(int i=0;i<manager.getFamilies().size();i++) { //if the family exists display its statistics
					if(manager.getFamilies().get(i).getFamilyName().equals(familyName)) {
						isExist=true;
						System.out.println(manager.calculateFamilyStatistics(familyName)+" :");
						System.out.println("The number of Martyr in this family= "+manager.calculateFamilyStatistics(familyName).get(0)); 
						System.out.println("The number of Orphans in this family= "+manager.calculateFamilyStatistics(familyName).get(1));
						System.out.println("The number of Live Person in this family= "+manager.calculateFamilyStatistics(familyName).get(2));
						
					}
				}
				if(isExist==false) {
					System.out.println("The family does not exist");
				}
				break;
				
			}
			case 12:{ //calculate global statistics
				System.out.println("Glopal Statistics: "+manager.calculateGlobalStatistics()); //invoke method
				System.out.println("Total Martyr="+manager.calculateGlobalStatistics().get(0));
				System.out.println("Total Orphans="+manager.calculateGlobalStatistics().get(1));
				System.out.println("Total Live Person="+manager.calculateGlobalStatistics().get(2));
				break;
			}
			case 13:{ //to test if the two family are equal in number of martyr
				System.out.println("All families: "); //display all family 
				System.out.println(manager.toString());
				System.out.println("Enter the number of family1: ");   //ask user to enter the two families numbers
				int numOfFamily1=input.nextInt();
				System.out.println("Enter the number of family2: ");
				int numOfFamily2=input.nextInt();
				if(numOfFamily1-1<manager.getFamilies().size()&&numOfFamily2-1<manager.getFamilies().size() ) { //if the two families are exist invoke the method
					if(manager.getFamilies().get(numOfFamily1-1).equals(manager.getFamilies().get(numOfFamily2-1))) {
						System.out.println("The two families are equal in number of martyrs");
					}
					else {
						System.out.println("The two families are not equal in number of martyrs");
					}
				}
				else {
					System.out.println("fails,families do not exist");
				}
				
				break;
			}
			case 14:{//to display all family
				System.out.println("All families: ");
				System.out.println(manager.toString());
				break;
			}
			default:
				System.out.println("The process does not exist , Enter anothe process");
				
			
			}
			
			printMenu(); //print menu
			System.out.println("Enter a process");
			process = input.nextInt();
		}
		if(process==15) { // if the process is 15 stop
			System.out.println("Good Buy");
		}
	}


}
