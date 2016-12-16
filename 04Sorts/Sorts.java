public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
    private int[] data;

    public static String name(){
	return "09.Gunluk.Sophia"; 
    }

    public Sorts(int[] d){
	data = d;
	//selectionSort(data);
	bubbleSort(data);
    }
  
    public static void selectionSort(int[] data){
    	for (int i = 0; i < data.length-1; i++){
    	    int current = i;
    	    for (int j = i + 1; j < data.length; j++){
        		if (data[current] > data[j]){
        		    current = j;}
    	    }
            int a = data[current];
            data[current] = data[i];
            data[i] = a;
    	}
    }

    public static void insertionSort(int[] data){
    	for (int i = 0; i < data.length; i++){
    		int pp = 0;
			for (int j = 0; j < i; j++){
		   		if (data[i] < data[j]){
					int a = data[i];
            		data[i] = data[j];
            		data[j] = a;
		    	}
			}
		}
    }

    public static void bubbleSort(int[] data){
        boolean done = false;
        while (!done){
        	done = true;
	        for (int j = 0; j < data.length-1; j++){
	        	if (data[j+1] < data[j]){
	            	int swap = data[j+1];
	            	data[j+1] = data[j];
	            	data[j] = swap;
	            	done = false;
	            }
	        }
	    }
    }

    public String toString(){
        String fin = "[";
        for(int i = 0 ;i < data.length - 1; i++){
            fin += data[i] + ", ";
        }
        return fin + data[data.length - 1] +  "]";
    }


    public static void main(String[] arrgg){
	    int[] tester1 = {64, 25, 22, 12, 22, 11};
	    Sorts test1 = new Sorts(tester1);
	    System.out.println(test1);
	    int[] tester2 = {64, 25, 22, 12, 22, 11, -10, 11, 674638230};
	    Sorts test2 = new Sorts(tester2);
	    System.out.println(test2);
	    int[] tester3 = {64, 22, 22, 22, 22, 11};
	    Sorts test3 = new Sorts(tester3);
	    System.out.println(test3);
	    int[] tester4 = {64};
	    Sorts test4 = new Sorts(tester4);
	    System.out.println(test4);
    }
	
}
