
public class DisplayAll {
	
	//method to display all hotels	
		public void DispalyAllHotels(Hotel[] H) {
		//Variable initialization and declaration
			String name=null;
			int maxOccp,rPrice,sPrice,roomnum=0,length=0;
			
			length=H.length;//lenght of Hotel Object Array
			
			//iterate through each hotel 
			for(int i=0;i<length;i++)
			{
				//print
				System.out.printf("========================================================================\n");
				System.out.printf(H[i].getName()+", "+H[i].getAddress()+" ");
				int x=H[i].getStarRatings();//star rating of hotel
				for(int k=0;k<x;k++)//print * depending on integer value x
				{
				System.out.printf("*");
				}
				System.out.printf("\n");
				System.out.printf("========================================================================\n");
				
				//hotel object room type object Array 
				roomnum=H[i].getNumRoomTypes();
				
				//iterate through this hotel's each room
				for(int j=0;j<roomnum;j++)
				{
					//assign values to variables
				name=H[i].getRoomTypes(j).getName();
				maxOccp=H[i].getRoomTypes(j).getMaximumOccupancy();
				rPrice=H[i].getRoomTypes(j).getRegularPrice();
				sPrice=H[i].getRoomTypes(j).getSalePrice();
				
				if(sPrice==rPrice)//compare regular price equals sale price or not
				{
					//print 
				System.out.printf("\nRoom Type: "+name+"\n"+"Maximum Occupancy: "+maxOccp+"\n"+"Regular Price: $"+rPrice+"\n\n");
				}else
				{
					//print
					System.out.printf("\nRoom Type: "+name+"\n"+"Maximum Occupancy: "+maxOccp+"\n"+"Regular Price: $"+rPrice+" "+"Sales Price: $"+sPrice+"\n\n");
				}
				}
			}	
		}

}
