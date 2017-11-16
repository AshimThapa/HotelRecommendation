
public class FindCheapestRoom {
	//method to find cheapest room
		public void FindCheapest(Hotel[] h) {
		//variable declaration and initialization
			int cheapest=Integer.MAX_VALUE;
			int rPrice=0,sPrice,maxOpp=0,star=0;
			int vMaxOpp=0,vRPrice=0,vStar=0;
			String hotelName=null,address=null,roomType=null;
			String vHotelName=null,vAddress=null,vRoomType=null;
		  
			//iterate through each hotel
			for(int i=0;i<h.length;i++)
			{
			   int roomnum=h[i].getNumRoomTypes();//get hotel room types number
			   hotelName=h[i].getName();//get hotel address
			   address=h[i].getAddress();//get hotel address
			   star=h[i].getStarRatings();
			   
			   //iterate through each room type of hotel
			   for(int a=0;a<roomnum;a++)
			   {
				   rPrice=h[i].getRoomTypes(a).getRegularPrice();//get regular price
				   sPrice=h[i].getRoomTypes(a).getSalePrice();//get sale price
				   roomType=h[i].getRoomTypes(a).getName();//get room type name
				   maxOpp=h[i].getRoomTypes(a).getMaximumOccupancy();//get maximum occupancy
				   
				 //compare if the sale price of this hotel is cheaper then the value hold at cheapest variable
					   if(sPrice<cheapest)
					   {
						   cheapest=sPrice;//assign cheapest sale price
						   //assign hotel and room type details
						   vHotelName=hotelName;
						   vAddress=address;
						   vRoomType=roomType;
						   vMaxOpp=maxOpp;
						   vRPrice=rPrice;
						   vStar=star;
					   }
			    }
			  
			  }
			//print
			  System.out.printf("The cheapest rate available in any hotel is at "+vHotelName+","+vAddress+" ");
			 //print * depending on star rating 
			  for(int l=0;l<vStar;l++) {System.out.printf("*");}
			  System.out.printf("\nRoom Type: "+vRoomType+"\n"+"Maximum Occupancy: "+vMaxOpp+"\n");
			  System.out.printf("Regular Price $"+vRPrice+" "+"Sale Price $"+cheapest+"\n\n");
			
		}

}
