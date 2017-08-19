class Box {
	double h;
	double w;
	double b;
	
	double volume(){
		//System.out.println("volume is ");
		return (h*w*b);
	}

//	void setdim(double height,double width,double breadth){
//	
//		h=height;
//		w=width;
//		b=breadth;
//	}	
	void setdim(double height,double width,double bredth){
		h = height;
		w = width;
		b = bredth;
	}

	Box(){
		h=1;w=1;b=1;
		//System.out.println("inside constructor");
	}
}
