	class A{
		int i,j;
		void show(){
			System.out.println("i & j ="+i+","+j);
		}
		A(int i, int j){
			this.i=i;
			this.j=j;
		}
	}

	class B extends A{
		int k;
		void show(){
			super.show();
			System.out.println("k ="+k);
		}
		B(int i,int j,int k){
			super(i,j);
			this.k=k;
		}
	}
	
class override_example{
	public static void main(String args[]){
		B objb = new B(1,2,3);
		//System.out.println("i , j, k="+objb.i+','+objb.j+','+objb.k);
	
		objb.show();
	}
}
