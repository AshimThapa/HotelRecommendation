import java.util.Scanner;

public class SetPrice {
	//method to set sale price
public void SetSalePrice(Hotel[] h,Scanner sc) {
				
	//variable declaration and initialization
	int numRoom=0,choice=1,foundIndx=0,newSalePrice=0,chooseIndx=1, maxListRoomType=0;;
	double minSalePrice=0;
	String userHotel;
	boolean found=false,status=false,saleStatus=false;
				
				
	//display message
	System.out.println("\n\nSetting Sale Price\n");
				
	//iterate to loop through hotel name to find a match
	while(!found)
	{
		//ask user to enter hotel name
		System.out.println("Enter hotel name: ");
		userHotel=sc.nextLine();//scan user input and store at string variable
					
		//iterate through each hotel
		for(int i=0;i<h.length;i++)
		{
			if(userHotel.equalsIgnoreCase(h[i].getName())==true)//if two strings  match
			{
				foundIndx=i;//store the index at where it found the match
				found=true;//its found, set boolean to true
				numRoom=h[i].getNumRoomTypes();//get the number of room types
						  
				System.out.print("\n");
				for(int j=0;j<numRoom;j++)
				{//for each room type print its name
					System.out.printf((j+1)+": "+h[i].getRoomTypes(j).getName()+"\n");
				}
			 }
						
		 }
		 if(found==false)
		 {
			 System.out.printf("\nNo hotel matches that name. Please try again.\n");
		 }
	 }//end of while loop
				
	while(!status)
	{
		//ask user to enter room number from the list displayed
		System.out.println("Enter room type number: ");
		choice=sc.nextInt();//scan user input
		maxListRoomType=h[foundIndx].getNumRoomTypes();
		
		if(choice<1 || choice>maxListRoomType)//check condition
		{
			status=false;  //set boolean to false indicating wrong input
			System.out.printf("\nValue must be between 1 and %d. Please try again: ",maxListRoomType);//ask again to enter until condition is met
		}
		else
		{
			status=true;//set boolean to true indicating condition has met
						
			switch(choice)//depending on user input do different tasks
			{
			//display corresponding hotel's user selected room prices
			case 1:
					System.out.printf("Regular Price = $"+h[foundIndx].getRoomTypes(0).getRegularPrice()+" "+"Current Sale price = $"+h[foundIndx].getRoomTypes(0).getSalePrice()+"\n");
					minSalePrice=0.5*h[foundIndx].getRoomTypes(0).getRegularPrice();//calculate 50% of regular price
					chooseIndx=0;  //set this variable as if the index of room type object
					break;
			case 2:
					System.out.printf("Regular Price = $"+h[foundIndx].getRoomTypes(1).getRegularPrice()+" "+"Current Sale price = $"+h[foundIndx].getRoomTypes(1).getSalePrice()+"\n");
					minSalePrice=0.5*h[foundIndx].getRoomTypes(0).getRegularPrice();//calculate 50% of regular price
					chooseIndx=1; //set this variable as if the index of room type object
					break;
			case 3:
					System.out.printf("Regular Price = $"+h[foundIndx].getRoomTypes(2).getRegularPrice()+" "+"Current Sale price = $"+h[foundIndx].getRoomTypes(2).getSalePrice()+"\n");
					minSalePrice=0.5*h[foundIndx].getRoomTypes(0).getRegularPrice();//calculate 50% of regular price
					chooseIndx=2; //set this variable as if the index of room type object
					break;
			case 4:
					System.out.printf("Regular Price = "+h[foundIndx].getRoomTypes(3).getRegularPrice()+" "+"Current Sale price = "+h[foundIndx].getRoomTypes(3).getSalePrice()+"\n");
					minSalePrice=0.5*h[foundIndx].getRoomTypes(0).getRegularPrice();//calculate 50% of regular price
					chooseIndx=3; //set this variable as if the index of room type object
					break;
			}
						
			//ask user to enter new sale price value
			System.out.printf("Enter Sale price: ");
		 
			while(!saleStatus)
			{	
				newSalePrice=sc.nextInt(); //user entered sale price
				if(newSalePrice<minSalePrice || newSalePrice>h[foundIndx].getRoomTypes(chooseIndx).getRegularPrice()) //entered sale price must be between 50% and 100% of regular price
				{
					saleStatus=false;//set boolean to false to indicate condition not met
					//ask user to enter again with displaying error and range of values to be entered
					System.out.println("Value must be between "+minSalePrice+" and "+h[foundIndx].getRoomTypes(chooseIndx).getRegularPrice()+". Please try again:");
				}else
				{
					saleStatus=true;//condition met
					h[foundIndx].getRoomTypes(chooseIndx).setSalePrice(newSalePrice);//update nee sale price
					System.out.println("Sale price Updated.\n\n");
					//System.out.println(h[foundIndx].getRoomTypes(chooseIndx).getSalePrice());  //verify price change
				}
			 }
		 }	
	 }
  }
			
}
