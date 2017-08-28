class Figure{
	double dim1;
	double dim2;
	
	Figure(double a,double b){
		this.dim1=a;
		this.dim2=b;
	}

	double area(){
		System.out.println("Figure. area not defined");	
		return -1;
	}

}

class Rectangle	extends Figure{
	Rectangle(double a,double b){
		super(a,b);

	}
	double area(){
		return dim1*dim2;
	}
}

class Triangle extends Figure{
	Triangle(double a,double b){
		super(a,b);		
	}
	
	double area(){
		return (dim1*dim2/2);
	}
}

class Inheritance_with_poly{
	public static void main(String args[]){

		Figure fig= new Figure(2,3.0);

		Rectangle r = new Rectangle(2,4);
		Triangle t = new Triangle(2,5);
	
		System.out.println("fig area ="+fig.area());
	
		Figure newfig ;
		newfig = r ;
		System.out.println("area rect=="+newfig.area());

		newfig= t ;
		newfig.area();
		System.out.println("area traingle=="+newfig.area());
	}

}
