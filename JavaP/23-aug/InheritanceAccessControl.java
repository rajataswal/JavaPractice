class A{
	int i;
	private	int z;

	void showiz(){
		System.out.println("i="+i+" "+"z="+z);
	}
}


class B extends A{//since class B extends A, so in this class we can directly use the members of A using dot operator. i,z and showiz() are members of A
	int j;

	void sum(){
		int k=i+z+j;//here i and z member of class A is directly used
		System.out.println("k="+k);
	}
}

class Inheritance{
	public static void main(String[] args){
		
		B ObjOfB = new B();
		
		ObjOfB.i=4;
		ObjOfB.z=7;
		
		ObjOfB.showiz();
		
		

		ObjOfB.j=5;
		
		ObjOfB.sum();
	}
}
//java does not support inheretence of mutiple superclass into single subclass
//we can create hirarchy of classes
//we can not inherit from same class
