public class Barcode implements Comparable<Barcode>{
   private String zip;
   private int checkDigit;

  public Barcode(String z) {

      if (z.length() != 5){
		throw new IllegalArgumentException("wrong length");
      };
      try{
      	int phi = Integer.parseInt(z);
      }catch(NumberFormatException e){
      	throw new IllegalArgumentException("not all digits");}
      zip = z;
      checkDigit = checkSum(zip);
  }

  public Barcode clone(){
      return new Barcode(zip);
  }

  private static int checkSum(String zipp){
      return (Integer.valueOf(zipp.charAt(0)) + Integer.valueOf(zipp.charAt(1)) + Integer.valueOf(zipp.charAt(2))
        + Integer.valueOf(zipp.charAt(3)) + Integer.valueOf(zipp.charAt(4))) % 10;
  }

  public static String toCode(String str){
  	if (str.length() != 6) {throw new IllegalArgumentException();}
  	String fin = "";
  	for (int i = 0; i < str.length(); i++){
  		char num = str.charAt(i);
  		if (num == '1'){fin += ":::||";}
      	else if (num == '2'){fin += "::|:|";}
      	else if (num == '3'){fin += "::||:";}
      	else if (num == '4'){fin += ":|::|";}
      	else if (num == '5'){fin += ":|:|:";}
      	else if (num == '6'){fin += ":||::";}
      	else if (num == '7'){fin += "|:::|";}
     	else if (num == '8'){fin += "|::|:";}
      	else if (num == '9'){fin += "|:|::";}
      	else if (num == '0'){fin += "||:::";} 
      	else { throw new IllegalArgumentException();}
  	}
  	return fin;      
  }

  public static String toZip(String bcode){
  	String fin = "";
  	if (bcode.length() != 32){throw new IllegalArgumentException("length of barcode isnt 32");}
  	if (bcode.charAt(0) != '|' || bcode.charAt(31) != '|'){throw new IllegalArgumentException("ends arent ||");}
  	String code = bcode.substring(1,31);
  	for (int i = 0; i < code.length()/5; i++){
  		String num = code.substring(i*5, (i+1)*5);
  		if (num.equals(":::||")){fin += "1";}
      	else if (num.equals("::|:|")){fin += "2";}
      	else if (num.equals("::||:")){fin += "3";}
      	else if (num.equals(":|::|")){fin += "4";}
      	else if (num.equals(":|:|:")){fin += "5";}
      	else if (num.equals(":||::")){fin += "6";}
      	else if (num.equals("|:::|")){fin += "7";}
     	else if (num.equals("|::|:")){fin += "8";}
      	else if (num.equals("|:|::")){fin += "9";}
      	else if (num.equals("||:::")){fin += "0";} 
      	else { throw new IllegalArgumentException("DNE");}
  	}
  	if (checkSum(fin.substring(0,5)) != Integer.valueOf(fin.substring(5))) {throw new IllegalArgumentException("checksum is wrong");}
  	return fin;
  }
    
  public String toString(){
      String barcode = new String(zip + checkDigit);
      return barcode + " |" + toCode(barcode) + "|";
  }
  
    public int compareTo(Barcode other){
      int v1 = (Integer.valueOf(zip) * 10 ) + checkDigit;
      int v2 = (Integer.valueOf(other.zip) * 10 ) + other.checkDigit;
      return (v1 - v2);
  }

  public static void main(String args[]){
      Barcode b = new Barcode("08451");
      Barcode c = new Barcode("99999");
      Barcode d = new Barcode("11111");
      /*System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
      System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
      System.out.println(b.compareTo(b)); //0
      System.out.println(c.compareTo(b));
      System.out.println(b.compareTo(d));
      System.out.println(toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
      System.out.println(toZip("|||:::|::|::|::|:|:|::::||||:::|"));
      */
  }
}
