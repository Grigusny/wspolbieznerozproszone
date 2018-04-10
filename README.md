# package sortowanie;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

    	Random r = new Random();
    	int rozmiar = 1000;
		int watek = 4;
		int[] tabela = new int[rozmiar];
    	for (int i=0; i < rozmiar; i++) {
    		Random rand = new Random();
			tabela[i]=rand.nextInt(1000);
    	}
    	
   
	 Thread watek1 = new Thread(new SortThread(tabela, 0, tabela.length/2-1));
     Thread watek2 = new Thread(new SortThread(tabela, tabela.length/2, tabela.length-1));
     Thread watek3 = new Thread(new SortThread(tabela, 0, tabela.length-1));
       	watek1.start();
       	watek2.start();
       	watek3.start();

       System.out.println("size: " + tabela.length);
       for (int i = 0; i < tabela.length; i++) {
       System.out.println(tabela[i]);
        }
    }
}





package sortowanie;
public class SortThread implements Runnable {

    private int[] list;
    private int start;
    private int stop;
    public SortThread(int[] list, int start, int stop){
        this.list = list;
        this.start = start;
        this.stop = stop;
    }
    public synchronized void run(){
        //System.out.println(start + " " + stop);

     int n = stop+1;
  do {
            for (int index = start; index < stop; index++) {
          if (index+1 <= stop) {
        	  
          if (list[index] > list[index + 1]) {
        	  
          int temp = list[index];
          
          list[index] = list[index + 1];
          list[index + 1] = temp;
        }
     }
  }
           n = n - 1;
     } 
   while (n > 1);
  }
}
