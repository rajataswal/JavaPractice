class Variableargs{
	void getargs(int ... v){// getargs(int a,int j, int ... v) is also correct. int ... v or variable argument should be the last argument
		for (int x : v)
			System.out.println(x);
		System.out.println();
	}
}
class VariableArgument{
	public static void main(String[] args){
		Variableargs varobj= new Variableargs();
		varobj.getargs();
			
		varobj.getargs(1);
		varobj.getargs(1,2);
		varobj.getargs(1,2,3);
		varobj.getargs(1,2,3,4);
	}
}
