import java.io.File;
import java.text.SimpleDateFormat;
//this program will print all the model numbers and operator combinations
public class StartEndDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String ModelnoFolder=args[0];
		String Mno,Op,SDate,EDate;
		String yearStr;
		
		File modelnoFolder = new File(ModelnoFolder);
		File[] listOfModelno = modelnoFolder.listFiles();
		for( int i=0 ; i < listOfModelno.length ; i++ ) {
			Mno = listOfModelno[i].getName();//displaying number of models
			System.out.println(Mno);
			
			File operator = new File(ModelnoFolder+"\\"+Mno);
			File[] listOfOperators = operator.listFiles();
			for ( int j=0 ; j < listOfOperators.length ; j++) {
				Op = listOfOperators[j].getName();
				System.out.println(Op);
			
				File Dfolder = new File(ModelnoFolder+"\\"+Mno+"\\"+Op);
				File[] listOfDateFolder = Dfolder.listFiles();
				SDate = listOfDateFolder[0].getName();
				EDate = listOfDateFolder[(listOfDateFolder.length-1)].getName();
				
				yearStr = returnYear(Dfolder);
				formatedDate(SDate,yearStr);
				formatedDate(EDate,yearStr);
				
			}
			System.out.println("+++++++++");
		}
	}
	
	public static String returnYear(File Dfolder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(Dfolder.lastModified());
	}
	public static void formatedDate(String Date,String year) {
		String VarForDateFormating[]=Date.split("_");
		String month = VarForDateFormating[0];
		String day = VarForDateFormating[1];
		if(month.equals("01"))
			month="JAN";
		else if(month.equals("02"))
			month="FEB";
		else if(month.equals("03"))
			month="MAR";
		else if(month.equals("04"))
			month="APR";
		else if(month.equals("05"))
			month="MAY";
		else if(month.equals("06"))
			month="JUN";
		else if(month=="07")
			month="JUL";
		else if(month.equals("08"))
			month="AUG";
		else if(month.equals("09"))
			month="SEP";
		else if(month.equals("10"))
			month="OCT";
		else if(month.equals("11"))
			month="NOV";
		else if(month.equals("12"))
			month="DEC";
		//System.out.println(day+"/"+month+"/"+year+"_"+VarForDateFormating[2]+"_"+VarForDateFormating[3]+"_"+VarForDateFormating[4]);
		System.out.println(day+"/"+month+"/"+year);
		
	}
}
