import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main
{
	static Scanner sc = new Scanner(System.in);
    static int pageFaults(int incomingStream[], int n, int frames)
    {
        System.out.println("Incoming \t Pages");
        HashSet s = new HashSet<>(frames);

        Queue queue = new LinkedList<>();

        int page_faults = 0;

        for (int i=0; i < n; i++)
        {
            if (s.size() < frames)
            {
                if (!s.contains(incomingStream[i]))
                {
                    s.add(incomingStream[i]);
                    page_faults++;
                    queue.add(incomingStream[i]);


                }
            }
            else
            {
                if (!s.contains(incomingStream[i]))
                {
                    int val = (int) queue.peek();

                    queue.poll();

                    s.remove(val);

                    s.add(incomingStream[i]);
                    queue.add(incomingStream[i]);
                    page_faults++;


                }
            }
            System.out.print(incomingStream[i] + "\t");
            System.out.print(queue + " \n");
        }


        return page_faults;
    }

    public static void main(String args[])
    {
        int incomingStream[] = new int [10];//{7, 0, 1, 2, 0 , 3, 0, 4, 2, 3, 0, 3, 2, 1};
        int frames = 3;
          
		for(int i =0; i<10; i++)
		{
			System.out.println(" Enter Pages : ");
			incomingStream[i] = sc.nextInt();
		}			

        int len = incomingStream.length;
        int pageFaults = pageFaults(incomingStream, len, frames);
        int hit = len - pageFaults;

        System.out.println("Page faults: " + pageFaults);
        System.out.println("Page fault Ratio: " + (double) pageFaults/len);
        System.out.println("Hits: " + hit);
        System.out.println("Hit Ratio : " + (double) hit/len);
    }
}