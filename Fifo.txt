import java.util.*;

class Fifo
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String arg[])
	{
	   int lc = 0,pg,pgh=0,pgf=0,flag=0;
	     char ch;
	   Stack<Integer> sk = new Stack<Integer>();
	   
	   do
	   {
		   System.out.println("Add Page : ");
		   pg = sc.nextInt();
		   
           flag++;
		   
		   if(flag<=3)
		   {
			   if(sk.contains(pg))
			   {
				   System.out.println("Page hit Occurs");
				   pgh++;
				   flag--;
				   System.out.println(sk);
			   }
			   else
			   {
				   sk.push(pg);
				   System.out.println(sk);
			   }
		   }
		   else
		   {			   
			   if(sk.contains(pg))
			   {
				   System.out.println("Page hit Occurs");
				   pgh++; 
				   System.out.println(sk);
			   }
			   else
			   {
				   System.out.println("Page fault Ouccurs");
				   sk.remove(lc);
				   sk.insertElementAt(pg,lc);
				   System.out.println(sk);
				   lc++;
				   pgf++;
			   }
			   
			   if(lc==3)
				   lc=0;
		   }
		 
        System.out.println("Do you want to add more pages Y/N");
        ch = sc.next().charAt(0);		
		   
	   }while(ch == 'Y'|| ch=='y');
	
	  System.out.println("Total Page Hits = "+pgh);
      System.out.println("Total Page Faults = "+pgf);
	}

   
}	