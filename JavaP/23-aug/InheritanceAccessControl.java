//conlusion --
//1. Refference of sub class can be given to super class. and super class can be used normally, with the data passed to the variable of super class
//2. Public members of super class can be used in subclass directly, as if those members are part of subclass itself
class A{
	int i;
	//private	int z; if this is uncommented then error will come as it cannot be used in sum() function of B class
	int z;
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

class InheritanceAccessControl{
	public static void main(String[] args){
		B ObjOfB = new B();
			
		ObjOfB.i=4;
		ObjOfB.z=7;
		
		ObjOfB.showiz();//here also showiz() which is function of class A is directly used, as if it is member of class B
		
		//--	in this block we are giving refference of sub class to super class..all the data variable that objofB contain will be passed to super class object i.e objofA
		A objofA = new A();
		objofA = ObjOfB;//here we are giving refference of sub class to super class
		System.out.println();
		
		System.out.println("asdf");
		objofA.showiz();


		//--
		//
		ObjOfB.j=5;
		
		ObjOfB.sum();
	}
}
//java does not support inheretence of mutiple superclass into single subclass
//we can create hirarchy of classes
//we can not inherit from same class
