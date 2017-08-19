import java.lang.Double;
class Boxdemo{
	public static void main(String[] args){
		Box mybox = new Box();
		
//		System.out.println("initial volume= "+mybox.volume());
//		
//		mybox.setdim(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]));
//		
//		System.out.println("h== "+ mybox.volume());
//
//		Box a= new Box();
//
//		Box b;
//		a.setdim(1,2,3);
//		System.out.println("volumme a"+a.volume());
//		System.out.println("setting b=a");
//		b=a;
//		
//		System.out.println("volume b= "+b.volume());
//		b.setdim(2,2,2);
//		a.setdim(3,3,3);
//
//
//		System.out.println("volume a= "+a.volume()+"vol b= "+b.volume());
		
		mybox.setdim(2,2,2);
		System.out.println(mybox.volume());
	
	}

}
