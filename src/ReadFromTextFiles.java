import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromTextFiles {
	//method to read from room types text file	
	public RoomType[] ReadFromRoomFile(RoomType[] newRooms,Hotel[] H) throws FileNotFoundException 
	{
		//variable deceleration and initialization
		String temp,hotel;
		String[] arrTemp;
		boolean status;
		int k=0;
		int regularPrice,salePrice,maxOccp,nRoom,nVaccancy;
		
		//the input source is set to text file
		File readFile=new File("RoomTypes.txt");
		Scanner sc=new Scanner(readFile);
		
		while(sc.hasNextLine())//condition there is record for next line in file
		{
			temp=sc.nextLine();
			arrTemp=temp.split(",");//split the values are strings and store in an Array
			//assign values to array
			hotel=arrTemp[0];  //assign hotel name
			
			//convert string to integer
			regularPrice=Integer.parseInt(arrTemp[2]);
			salePrice=Integer.parseInt(arrTemp[3]);
			maxOccp=Integer.parseInt(arrTemp[4]);
			nRoom=Integer.parseInt(arrTemp[5]);
			nVaccancy=Integer.parseInt(arrTemp[6]);
			
			//asssign the array value to an array of roomtype object
			newRooms[k]=new RoomType(arrTemp[1],regularPrice,salePrice,maxOccp,nRoom,nVaccancy);
			
			//depending on hotel name assign the hotel room objects to that hotel
			switch(hotel)
			{
			case "El Grando":
				status=H[0].setRoomType(newRooms[k]);//return boolean value
				if(!status)System.out.print("Cannot add the room\n");//print message to user
				break;
			case "Ivory Tower":
				status=H[1].setRoomType(newRooms[k]);
				if(!status)System.out.print("Cannot add the room\n");
				break;
			case "Elite":
				status=H[2].setRoomType(newRooms[k]);
				if(!status)System.out.print("Cannot add the room\n");
				break;
			case "Fleabox Motel":
				status=H[3].setRoomType(newRooms[k]);	
				if(!status)System.out.print("Cannot add the room\n");
				break;
			}
			k++;//increase array index of room type object to store another object
		} 
		
		sc.close();//close scanner
		return newRooms;//return roomtype object array
		
	}
	
	//method to read from hotel text file 	
	public Hotel[] ReadFromHotelFile(Hotel[] H) throws FileNotFoundException
	{
		//variable deceleration and initialization
		String temp;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		String[] arrTemp;
		int i=0;
		int rating,numRoom;
		
		//the input source is set to text file
		File readFile=new File("Hotels.txt");
		Scanner sc=new Scanner(readFile);
		
		//condition there is record for next line in file
		while(sc.hasNextLine())
		{
			temp=sc.nextLine();
			arrTemp=temp.split(":");//split the values are strings and store in an Array with delimiter :
			
			//convert string to integer
			rating=Integer.parseInt(arrTemp[2]);
			numRoom=Integer.parseInt(arrTemp[3]);;
			
			//assign to hotel object
			H[i]=new Hotel(arrTemp[0],arrTemp[1], rating,numRoom);
			
			i++;//increase Hotel object Array index
		}
		
		sc.close();//close scanner
		return H;//return Hotel object array
		
	}
}



