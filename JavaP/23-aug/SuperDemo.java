// super() function has two forms. one is to used to call super class constructor and other is used to access the members of super class that are hidden by superclass

//1st form-super() function is used to initialize the superclass data members. super function is used in sub class to call the constructor of super class

class Box{
	private double width;
	private double height;
	private double depth;

	Box(double width,double height,double depth){
		this.width=width;//error width have private access in Box
		this.height=height;//error height have private access in Box
		this.depth=depth;//error depth have private access in Box
	}
	Box(Box ob){
		this.width=ob.width;
		this.height=ob.height;
		this.depth=ob.depth;
	}

	void display(){
		System.out.println("widht="+width+" height="+height+" depth="+depth);
	}
}

class BoxWeight extends Box{
	double weight;
	BoxWeight(double width,double height,double depth,double weight){
		//super(-1.0,-1.0,-1.0);
		//super(1,1,1);
		super(width,height,depth);
		this.weight=weight;
		//super(-1.0,-1.0,-1.0);super function should be first statement in constructor
	}
	BoxWeight(BoxWeight ob){
		super(ob);//note here ob is of type BoxWeight, but it is received as Box type in Box constructor
		this.weight=ob.weight;
	}
}

class SuperDemo{
	public static void main(String[] args){
		
		//--below block of code checks that wether the data members have been initialized or not
		//BoxWeight qwer = new BoxWeight(-1.0);
		BoxWeight qwer = new BoxWeight(1,2,3,4);
		qwer.display();
		System.out.println("weight="+qwer.weight);
		//----
		
		//-------------using super() to initialize variable of super
		BoxWeight clone = new BoxWeight(qwer);
		System.out.println("\n\nclone");
		clone.display();
		System.out.println("weight="+clone.weight);

	}
}
