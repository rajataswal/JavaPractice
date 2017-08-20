class OverloadDemo{

	void test(){
		System.out.println("no parameter");
	} 
	void test(int a){
		System.out.println("1 int parameter= "+a); 
	}
	
	void test(double a){
		System.out.println("1 double parameter= "+a); 
	}


}

class Overload{
	
	public static void main(String[] args){
		OverloadDemo d1=new OverloadDemo();
		d1.test();
		d1.test(1);
		d1.test(2);
		d1.test(2.3);
	}


}

