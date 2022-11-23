import java.util.*;

class LRU
{
   public static void main(String arg[])
   {
	   Scanner sc = new Scanner(System.in);
	   Stack<Integer> sk = new Stack<Integer>();
	   
	   int flag = 0, pgh = 0, pgf = 0,lc = 0, j, k=0, temp1, temp;
	   
	   int pg[] = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
	   
	   for(int i = 0; i<20; i++)
	   {
		   flag++;
		   if(flag<=3)
		   {
			   if(sk.contains(pg[i]))
			   {
				   System.out.println("Page Hit : "+pg[i]);
				   pgh++;
				   flag--;
				   System.out.println(sk);
			   }
			   else
			   {
				   sk.add(pg[i]);
				   System.out.println("Page Fault : "+pg[i]);
				   pgf++;
				   System.out.println(sk);
			   }
		   }
		   else
		   {
			   if(sk.contains(pg[i]))
			   {
				   System.out.println("Page Hit : "+pg[i]);
				   pgh++;
				   System.out.println(sk);
			   }
			   else
			   {
				   System.out.println("Page fault : "+pg[i]);
				   pgf++;
				   
				while(k<=2)
				{					
				  for(j=i-1; j>=0; j--)
				  {
                    if(sk.get(k) == pg[j])
                    {
						if(k==0)
						{
							lc = j;
						}
						else
						{
							if(lc > j)
							{
								lc = j;
							}
						}
						k++;
						break;
					}					
				  }

				} 
				    temp = pg[lc]; 
					lc = sk.indexOf(temp);
                    sk.remove(lc);
                    sk.insertElementAt(pg[i],lc);
                    System.out.println(sk);		
					lc = 0;
					k = 0;
			   }
		   }
	   }
	   System.out.println("Page Hits : "+pgh);
	   System.out.println("Page Faults : "+pgf);
   }
}