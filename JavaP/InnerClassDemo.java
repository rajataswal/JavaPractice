// we can access outer class members from inner class directly
class Outer{
	int outer_x=100;

	void test(){
		
	}
	class Inner{
		int inner_x=200;
	}
}
class InnerClassDemo{
	public static void main(String[] args){
		Outer a = new Outer();
		a.inner_x=300;//this is error, as we cannot access members of inner class from object of outer class, only inner object can be used to access inner members

	}
}
