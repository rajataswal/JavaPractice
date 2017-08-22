class Test{
	int a,b;private int c;
	Test(int a,int b){
		this.a=a;this.b=b;
	}
	Test(Test obj){
		this.a = obj.a;
		this.b=obj.b;
	}

	boolean equalto(Test obj){
		if(this.a == obj.a && this.b==obj.b) return true;
		else return false;
	}
}

class PassingObjAsParameter{
	public static void main(String[] args){
		Test obj1=new Test(1,2);
		
		Test obj2=new Test(obj1);//initializing obj2 using obj1
//		obj2.c=45;	
//		obj1=obj2;
//		if(obj1==obj2) System.out.println("true");
//		else System.out.println("false");
		
		System.out.println(obj1.equalto(obj2));
	}

}
