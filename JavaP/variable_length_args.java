class Variable_len_args{
	static void func(int ... arr){
		for(int i=0; i<arr.length ; i++){
			System.out.print(" "+arr[i]);
		}	
		System.out.println();
	}

	public static void main(String args[]){
		func(0,98,3,4);
		func(1,2,3,4,5,6);

	}
}	
