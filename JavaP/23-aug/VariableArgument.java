class Variableargs{
	void getargs(int ... v){
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
