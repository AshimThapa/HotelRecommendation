import java.util.Scanner;

public class CriteriaSearch {

	public void FindRoomCriteria(Hotel[] h, Scanner sc) {
		int minOccp = 0,minStar = 0,maxPrice = 0,roomnum=0;
		String[] name = null;
		int[] maxOccp = null,rPrice = null,sPrice = null;
	    int check=0,counter,notfound=0;
	    boolean status=true,statusStar=true,statsuPrice=true;
		
		
		System.out.print("Please enter the Criteria which you require.\n");
		//conditions to verify valid data are entered for each of the three search options 
		while(status)
		{
			System.out.print("Minimum Occupancy required: ");
			minOccp=sc.nextInt();
			if(minOccp<=1 || minOccp>=8)
			{
				System.out.printf("The minumun Occupancy must be between 1 to 8.Please try again.\n");
			}else
			{
				status=false;
			}
		}
		while(statusStar)
		{
			System.out.print("Minimum Star rating required: ");
			minStar=sc.nextInt();
			if(minStar<=1 || minStar>=5)
			{
				System.out.printf("The star rating must be between 1 to 5.Please try again.\n");
			}else
			{
				statusStar=false;
			}
		}
		while(statsuPrice)
		{
			System.out.print("Maximum daily price you are wulling to pay: ");
			maxPrice=sc.nextInt();
			if(maxPrice<1)
			{
				System.out.printf("The maximum daily price cannot be negative or 0,must be greater or equal to 1.Please try again.\n");
			}else
			{
				statsuPrice=false;
			}
		}
		
		
		//
		for(int i=0;i<h.length;i++)
		{
			check=0;
			if(h[i].getStarRatings()>=minStar)
			{
				counter=0;
				roomnum=h[i].getNumRoomTypes();
				//initializa array
				name=new String[roomnum];
				maxOccp=new int[roomnum];
				rPrice=new int[roomnum];
				sPrice=new int[roomnum];
				for(int j=0;j<roomnum;j++)
					{
					
					//check conditon
						if(h[i].getRoomTypes(j).getMaximumOccupancy()>=minOccp && h[i].getRoomTypes(j).getSalePrice()<=maxPrice && h[i].getRoomTypes(j).getNumberOfVacancies()>=1)
						{
							name[counter]=h[i].getRoomTypes(j).getName();
							maxOccp[counter]=h[i].getRoomTypes(j).getMaximumOccupancy();
							rPrice[counter]=h[i].getRoomTypes(j).getRegularPrice();
							sPrice[counter]=h[i].getRoomTypes(j).getSalePrice();
							counter++;
							check++;
							notfound++;
						}
					}
					//print hotel
					if(check>0)
					{
						System.out.printf("========================================================================\n");
						System.out.printf(h[i].getName()+","+h[i].getAddress()+" ");
						int x=h[i].getStarRatings();
						for(int k=0;k<x;k++)
						{
							System.out.printf("*");
						}
						System.out.printf("\n");
						System.out.printf("========================================================================\n");
						//print room details
						for(int j=0;j<counter;j++)
						{
							if(sPrice[j]==rPrice[j])
							{
								System.out.printf("\nRoom Type: "+name[j]+"\n"+"Maximum Occupancy: "+maxOccp[j]+"\n"+"Regular Price: $"+rPrice[j]+"\n\n");
							}else
							{
								System.out.printf("\nRoom Type: "+name[j]+"\n"+"Maximum Occupancy: "+maxOccp[j]+"\n"+"Regular Price: $"+rPrice[j]+" "+"Sales Price: $"+sPrice[j]+"\n\n");
							}
						}
					}
				}
			}	
		if(notfound==0)
		{
			System.out.printf("\nSorry,No hotel found with that daily maximum price.\n\n");
		}
			
	}


}
