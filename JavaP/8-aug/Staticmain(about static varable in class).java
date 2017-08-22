class Statictest{
	static int a;
	int b;
	
}
class Staticmain{
	public static void main(String[] args){
		Statictest.a=1;//static variable can be used without creating the object of class, we 
		Statictest.b=3;//error because we cannot use non static variable without creating its object

	}
}
