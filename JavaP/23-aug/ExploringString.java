import java.lang.*;
class ExploringString{
	public static void main(String[] args){

		String str="1234";
		System.out.println("1234".length());//it will print length as 4, everything between " " is an string object
		System.out.println(str.length());//it will also print length as 4
	
		if( "1234".equals(str)){//this statement is true
			System.out.println("strings are equal");
		}
	}
}
