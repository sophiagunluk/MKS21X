public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
        size = 0;
        data = new String[10];
    }

    public SuperArray(String[] myData){
        data = myData;
        size = data.length;
    }

    public SuperArray(int initialCapacity){
	if (initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
        data = new String[initialCapacity];
        size = 0;
    }

    public SuperArrayIterator iterator(){
        return new SuperArrayIterator(this);
    }

    public int size(){
        return size;
    }

    public String get(int i){
	if (i < 0 || i >= size()){
	    throw new IndexOutOfBoundsException();
	}
        return data[i];
    }

    public boolean add(String str){
	size++;
	if (size == data.length){
	    grow();
	}
	set(size-1, str);
	return true;
    }

    public void clear(){
        size = 0;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void add(int place, String element){
	size++;
	if (place < 0 || place > size()){
	    throw new IndexOutOfBoundsException();
	}
        if (size == data.length){
	    grow();
	}
	String[] newA = new String[data.length];
	for (int i = 0; i < place; i++){
	    newA[i]=data[i];
	}
	newA[place] = element;
	for (int i = place+1; i < size; i++){
	    newA[i]=data[i-1];
	}
	data = newA;
    }		

    public String remove(int place){
	if (place < 0 || place >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String fin = data[place];
        for(int i = place+1; i < size; i++){
            data[i-1] = data[i];
        }
	size--;
	return fin;
    }

    public String set(int index, String element){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
        String fin = data[index];
        data[index] = element;
        return fin;
    }

    public String[] toArray(){
        String[] fin = new String[size];
        for(int i = 0; i < size; i++){
            fin[i] = data[i];
        }
        return fin;
    }

    public int indexOf(String element){
	int fin = -1;
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String element){
        for(int i = size - 1; i < size; i--){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    private void grow(){
        String[] fin = new String[data.length * 2];
        for(int i = 0; i < data.length; i++){
            fin[i] = data[i];
        }
        data = fin;
    }
    private void trimToSize(){
	String[] fin = new String[size];
	for(int i = 0; i < size; i++){
	    fin[i] = data[i];
	}
	data = fin;
    }

    public String toString(){
        String fin = "[";
        for(int i = 0 ;i < size-1; i++){
            fin += data[i] + ", ";
        }
        fin += data[size-1]+ "]";
	return fin;
    }

    public String toStringDebug(){
        String fin = "[";
        for(int i = 0; i < data.length; i++){
            if(i < size){
                fin += data[i] + ", ";
            }
            else{
                fin += "_, ";
            }
        }
	if (size == data.length){
	    fin += data[size-1];
	}
	else {
	    fin += "_";
	}
        fin += "]";
	return fin;
    }
    /*
    public static void main(String[] argg){
	SuperArray test1 = new SuperArray();
        test1.add("hello");
        test1.add("there there");
        test1.add("Waffles");
        test1.add("Pancakes");
        test1.add("French Toast");
        System.out.println(test1);
	test1.add(2,"Cereal");
        System.out.println(test1);
        test1.set(3,"Sausage");
        System.out.println(test1);
        System.out.println(test1.get(4));
        System.out.println(test1.indexOf("French Toast"));
        test1.add("hello");
        System.out.println(test1.lastIndexOf("hello"));
    }
    */
}
