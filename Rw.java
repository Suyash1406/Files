import java.util.concurrent.Semaphore;

  class RW
  {
   static int RC = 0;
   static Semaphore RL = new Semaphore(1);
   static Semaphore WL = new Semaphore(1);
	
  static class Read implements Runnable
  {  
    public void run()
    {
	   try
	    { 
	      RL.acquire();
	      RC++;
	
          if(RC == 1)
           WL.acquire();
        
          RL.release();

          System.out.println(Thread.currentThread().getName()+" Is Start Reading");
          Thread.sleep(1000);
          System.out.println(Thread.currentThread().getName()+" Is Stop Reading");		 
		 
		  RL.acquire();
		  RC--;

		  if(RC == 0)
		    WL.release();
                
 		  RL.release(); 
		 
        }
       catch(Exception e)
	   {
		 System.out.println(e);
	   }	  
     }
   }

  static class Write implements Runnable
   {
	 public void run()
	 {
	   try
	    {
		   WL.acquire();
	       System.out.println(Thread.currentThread().getName()+" is start writing");
           Thread.sleep(2500);
           System.out.println(Thread.currentThread().getName()+" is stop writing");
           WL.release();		
	    }
	    catch(Exception e)
	    {
		   System.out.println(e);
	    }
	  }   
   }	
   public static void main(String arg[])
   {
      Read r = new Read();
	  Write w = new Write();
	  Thread t1 = new Thread(r);
	  Thread t2 = new Thread(w);
	  Thread t3 = new Thread(r);
	  Thread t4 = new Thread(r);
	  
	  t1.setName("R1");
	  t2.setName("W1");
	  t3.setName("R2");
	  t4.setName("R3");
	  
	  t1.start();
	  t2.start();
	  t3.start();
	  t4.start();
  }
}

