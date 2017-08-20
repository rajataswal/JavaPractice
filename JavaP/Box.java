class Box{
	double height;
	double length;
	double breadth;

	Box(){
		height=1;
		length=1;
		breadth=1;
	}

	void setdim(double height,double length,double breadth){
		this.height=height;
		this.length=length;
		this.breadth=breadth;
	}
	double volume(){
		return (height*length*breadth);
	}

}


