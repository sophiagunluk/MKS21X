public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
    private int[] data;

    public static String name(){
	return "09.Gunluk.Sophia"; 
    }

    public Sorts(int[] d){
	data = d;
	selectionSort(data);
    }
  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */
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

    public String toString(){
        String fin = "[";
        for(int i = 0 ;i < data.length - 1; i++){
            fin += data[i] + ", ";
        }
        return fin + data[data.length - 1] +  "]";
    }


    public static void main(String[] arrgg){
	int[] tester = {64, 25, 12, 22, 11};
	Sorts test1 = new Sorts(tester);
	//System.out.println(test1);
    }
	
}
