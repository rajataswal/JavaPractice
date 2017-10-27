class A{
	void show(){
		System.out.println("A's show function");
	}
}
class B extends A{
	void show(){
		System.out.println("B's show function");
	}
}
class C extends B{
	void show(){
		//super.show();
		System.out.println("C's show function");
	}
}

class dynamic_method_dis{
	public static void main(String args[]){
		
		//char ch='A';
		//char ch='B';
		char ch='C';
		//notice that different show() methods are being called, just by using the same statement objA.show(). Depending on the value stored in ch 
		//This is called dynamic method dispatch, this works, as followes:- two things are used
		//1.you are familiar with method overriding, in it the function with same name in super class gets hidden. 
		//2.we know that super class variable can always refference a sub class object, so super class reference variable will hold any refference to different subclass
		//and that sub class function will be called in whose reference is stored in super class variable.
		A objA=new A();
		B objB=new B();
		C objC=new C();

		if(ch=='A'){
			objA=objA;
			objA.show();
		}
		if(ch=='B'){
			objA=objB;
			objA.show();
		}
		if(ch=='C'){
			objA=objC;
			objA.show();
		}
	}
}
