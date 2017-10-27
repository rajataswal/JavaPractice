abstract class figure{
	int dim1,dim2;

	abstract void area(int dim1,int dim2);
}

class Triangle extends figure{

	Triangle(int dim1,int dim2){
		this.dim1=dim1;
		this.dim2=dim2;
	}
	
	void area(){//this function is overriding the area function in above class
		System.out.println("area triangel== ",dim1*dim2/2);
	}
}

class abstract_class{
	public static void main(String[] args){
		figure f1;
		Triangle t1=new Triangle();

		t1.dim1=2;
		t1.dim2=3;
		

	}
}
