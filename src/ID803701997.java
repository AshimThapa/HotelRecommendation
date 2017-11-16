import java.io.FileNotFoundException;
import java.util.Scanner;

public class ID803701997 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		//variable declaration
		int choice=0;
		
		//Initialization of Class hotel Array
		Hotel[] H=new Hotel[4];
		//Initialization of Class Roomtype Array
		RoomType[] newRooms=new RoomType[11];

		
		//Initialize classes
		DisplayAll D=new DisplayAll();
		FindCheapestRoom findCheapest=new FindCheapestRoom();
		SetPrice setNew=new SetPrice();
		CriteriaSearch findCriteria=new CriteriaSearch();
		ReadFromTextFiles reader=new ReadFromTextFiles();
			
		
		reader.ReadFromHotelFile(H);//Load hotel object with values from text file
		reader.ReadFromRoomFile(newRooms,H);//Load roomtype object with values from test file
		
		
		
		//Initialize welcome class to get welcome message using constructor
		Welcome w=new Welcome();
		System.out.printf("\n****************************************************************************************\n");
		System.out.println(w.toString());
		System.out.printf("\n****************************************************************************************\n\n");
	   //Loop for menu
		while(true)
		{
			Menu m=new Menu();//call constructor to display menu
		
			//Read user selection
			choice=sc.nextInt();
			
				switch(choice)
				{
				case 1:
					//Call method 
					D.DispalyAllHotels(H);
					break;
				case 2:
					//call method 
					findCheapest.FindCheapest(H);				
					break;
				case 3:
					//call method 
					setNew.SetSalePrice(H,sc);
					break;
				case 4:
					//call method 
					findCriteria.FindRoomCriteria(H,sc);
					break;
				case 5:
					System.out.println("Exiting Program...");
					System.exit(0);
					break;
				default :
					//if the input is not between 1 to 5 ,print error message and prompt user to enter correct one
		             System.out.println("This is not a valid Menu Option! Please Select Another\n\n");
		             break;
				}
		}
		
	}
}

	
	
