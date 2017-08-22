import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class roughwork {

	public static void main(String[] args) throws IOException{
		
		String Excellfolder = args[0];
		String StartDate = args[1];
		String EndDate = args[2];
		String GlobalSheetPath_xlsx = "WeaklyData\\"+args[3];
		//System.out.println(Excellfolder);
		int Globalrow = 1;
		File folder = new File(Excellfolder);
		File[] listOfFiles = folder.listFiles();
		int VI,count=0;
		
		Map<String, Integer> mapinitial = new HashMap<String,Integer>(); //Create map
		
		//creating an empty global sheet with heading
		mapinitial = create_first_line(GlobalSheetPath_xlsx);
		
		//System.out.println("1111111111***"+mapinitial.get("IMS_VoWiFi_07"));
		
		for (int i = 0; i < listOfFiles.length; i++) {
		    	if (listOfFiles[i].isDirectory()) {
		    		System.out.println(i + "Directory " + listOfFiles[i].getName());
		    		//dirlist[i]=listOfFiles[i].getName();
		    		
		    		//if(VI=valid_invalid_folder(StartDate,EndDate,listOfFiles[i].getName())) {
		    		VI = valid_invalid_folder(StartDate,EndDate,listOfFiles[i].getName());
		    		
		    		if(VI == 1) {
				    	count ++;			    		
		    			String excellpath = Excellfolder+"\\"+listOfFiles[i].getName();
		    			File folder2 = new File(excellpath);
		    			File[] listOfFiles2 = folder2.listFiles();
		    			
		    			for(int j=0; j< listOfFiles2.length; j++) {
		    				if (listOfFiles2[j].isFile()  && listOfFiles2[j].getName().endsWith(".xls")) {
		    					//Globalrow+=1; 
			    			    //System.out.println("File " + listOfFiles2[j].getName());
		    					String FullXlsPath = Excellfolder+"\\"+ listOfFiles[i].getName()+"\\"+listOfFiles2[j].getName();
		    					//open excell sheet as input stream
		    					
		    					//--------------------opening xlsx for writing and creating cells**********************************
		    					FileInputStream file = new FileInputStream(GlobalSheetPath_xlsx);
		    					Workbook wab = new XSSFWorkbook(file);
		    					
		    					//below line for creating cell style
		    					CellStyle cellStyleGreen = wab.createCellStyle();
		    					CellStyle cellStyleRed = wab.createCellStyle();
		    			        
		    					cellStyleGreen = wab.createCellStyle();
		    			        cellStyleGreen.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    			        cellStyleGreen.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    			        
		    			        cellStyleRed = wab.createCellStyle();
		    			        cellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
		    			        cellStyleRed.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    			        
		    			        
		    					Sheet plain = wab.getSheetAt(0);
		    					Row OutputRow;
		    					OutputRow = plain.createRow(++Globalrow);//Global row of xlsx sheet. index for row itteration-----------------------------------------------------------
		    					Cell cellforsummaryPlusSerialno;
		    					cellforsummaryPlusSerialno = OutputRow.createCell(0);
		    					cellforsummaryPlusSerialno.setCellValue(Globalrow-1);//puting serialno in xlsx
		    					
		    					
		    			        
		    			        
		    					
				    			FileInputStream inputStream = new FileInputStream(new File(FullXlsPath));
				    			HSSFWorkbook InputWorkbook = new HSSFWorkbook(inputStream);
				    			HSSFSheet summary = InputWorkbook.getSheetAt(0);
				    			HSSFSheet precheck = InputWorkbook.getSheetAt(1);
				    			    
		    			        Row InputRow = summary.getRow(1);
			    			    Cell column = InputRow.getCell(3);
			    			    String modelno = column.getStringCellValue();
			    			    //System.out.println("here---"+modelno);
			    			    cellforsummaryPlusSerialno = OutputRow.createCell(1);
			    			    cellforsummaryPlusSerialno.setCellValue(modelno);
			    			   
			    			    
		    			     	InputRow = summary.getRow(2);
		    			     	column = InputRow.getCell(3);
		    			     	String softVersion = column.getStringCellValue();
		    			     	cellforsummaryPlusSerialno = OutputRow.createCell(2);
		    			     	cellforsummaryPlusSerialno.setCellValue(softVersion);
		    			     
			    			    InputRow = summary.getRow(3);
			    			    column = InputRow.getCell(3);
			    			    String country_operator_region_binaryt = column.getStringCellValue();
			    			    System.out.println("000000000000"+country_operator_region_binaryt);
			    			    String[] C_O_R_Bt = country_operator_region_binaryt.split(",");
			    				//1,2,3,4
		    			     	String country = C_O_R_Bt[0];
		    					String operator = C_O_R_Bt[1];
		    					String region = C_O_R_Bt[2];
		    					//String binaryt = C_O_R_Bt[3]; not required
		    				
		    					cellforsummaryPlusSerialno = OutputRow.createCell(3);
			    			    cellforsummaryPlusSerialno.setCellValue(country);
			    			     
			    			    cellforsummaryPlusSerialno = OutputRow.createCell(4);
			    			    cellforsummaryPlusSerialno.setCellValue(operator);
			    			    
			    			    cellforsummaryPlusSerialno = OutputRow.createCell(5);
			    			    cellforsummaryPlusSerialno.setCellValue(region);
			    			    
			    			    //working	System.out.println("11111111"+country+operator+region+binaryt);
		    				
			    				InputRow = summary.getRow(4);
				    			column = InputRow.getCell(3);
				    			//5
			    				
				    			
				    			try {
				    			//int celltype;
			    				//celltype = column.getCellType();
			    				//System.out.println("celltype  =  " +celltype);
			    				String sim_prop=column.getStringCellValue();
			    				cellforsummaryPlusSerialno = OutputRow.createCell(6);
			    			    cellforsummaryPlusSerialno.setCellValue(sim_prop);
			    			    System.out.println(sim_prop);
				    			
				    			InputRow = summary.getRow(5);
					    		column = InputRow.getCell(3);
					    		//6
				    			
					    		
					    		String Device_NT_code = column.getStringCellValue();
				    			cellforsummaryPlusSerialno = OutputRow.createCell(7);
			    			    cellforsummaryPlusSerialno.setCellValue(Device_NT_code);
			    			    System.out.println("ntcode= "+Device_NT_code);
		    			    
			    			    InputRow = summary.getRow(6);
			    			    column = InputRow.getCell(3);
			    			    //7
					    		String Tested_on = column.getStringCellValue();
					    		cellforsummaryPlusSerialno = OutputRow.createCell(8);
			    			    cellforsummaryPlusSerialno.setCellValue(Tested_on);
			    			    System.out.println("Tested_on= "+Tested_on);
			    			    
			    			    //System.out.println("totototot"+Tested_on);
			    			    
						    	InputRow = summary.getRow(6);
							    column = InputRow.getCell(3);
							    //8
						    	String RF_calibration = column.getStringCellValue();
						    	cellforsummaryPlusSerialno = OutputRow.createCell(9);
			    			    cellforsummaryPlusSerialno.setCellValue(RF_calibration);
			    			    System.out.println("rf-calibration= "+RF_calibration);
		    			    
							    InputRow = summary.getRow(6);
								column = InputRow.getCell(3);
								//9
								String HW_version = column.getStringCellValue();
								cellforsummaryPlusSerialno = OutputRow.createCell(10);
								cellforsummaryPlusSerialno.setCellValue(HW_version);
								System.out.println("hardware-version"+HW_version);
				    			}

				    			catch(IllegalStateException e1)
				    			{
				    				//String general_prop="--";
				    				//cellforsummaryPlusSerialno = OutputRow.createCell(6);
				    			    //cellforsummaryPlusSerialno.setCellValue(general_prop);
				    			    System.out.println("exception handled "+e1.getMessage());
					    		}
				    			
				    			
								//10 space left for tested by cell..................  
				    			   
				    			   
								//------------------------------------------------------
								//-----------------precheck sheet-----------------------	   
								Row InputRow2;
								//Row OutputRow;
			    			    Cell TCid;
			    			    Cell PassFail;
			    			    Cell cell5;
			    			    String passfail;
			    			    int TC_COLindex_in_GlobalSheet;	 	
		    				 
			    			    for(int k=1 ; k < precheck.getPhysicalNumberOfRows() ; k++) {
			    			    	 InputRow2 = precheck.getRow(k);
			    			    	 TCid = InputRow2.getCell(1);
			    			    	 PassFail=InputRow2.getCell(5);
			    			    	 passfail= PassFail.getStringCellValue();
			    			    	 try{
				    			    		 TC_COLindex_in_GlobalSheet = mapinitial.get(TCid.getStringCellValue());
				    			    		 cell5 = OutputRow.createCell(TC_COLindex_in_GlobalSheet);
					    			    	 
					    			    	 cell5.setCellValue(passfail);
					    			    	 if ( passfail.equals("Pass"))
					    			    	 	 cell5.setCellStyle(cellStyleGreen);
					    			    	 
					    			    	 else if(passfail.equals("Fail"))
					    			    		 cell5.setCellStyle(cellStyleRed);
					    			    	 
					    			    	 System.out.println("*******__________k="+k+ "  "+TC_COLindex_in_GlobalSheet);
			    			    	 	}
			    			    	 catch (Exception NullPointerException){
				    			    		 System.out.println("heheh null pointer exception handled, check the Test case name in respective sheet");
				    		    	 	}
		    			        }
		    			    
			    			    //FileOutputStream fostream = new FileOutputStream(new File(GlobalSheetPath_xlsx));
			    			    FileOutputStream fostream = new FileOutputStream(new File(GlobalSheetPath_xlsx));
				    			   
			    			    wab.write(fostream);
			    			    fostream.close();
			    				  
								InputWorkbook.close();
			    			    inputStream.close();
			    				    			 		
		    			   	}//if ends
		    				
		    			}
				    }
		    		else if(VI == 0) {
		    			System.out.println("returned 0 not valid folder");
		    		}
		    		else if(VI == 2) {
		    			System.out.println("returned 2 some exceptional case");
		    		}
		    	}
		
		}//folder for loop end
		System.out.println("count of valid folders== "+ count);
	 }
	
	static Map<String, Integer> create_first_line(String path_xls_with_first_line) throws IOException {
		
		
		FileOutputStream file = new FileOutputStream(new File(path_xls_with_first_line));
		
		Workbook wb = new XSSFWorkbook();
		
		Sheet plain = wb.createSheet("Sheet1");
		
		String arr[]= {"SL No","Model Name","Software Version","Country","Operator","Region","SIM Properties","Device NT Code","Tested On","RF Calibration","HW Version","Tested By","VoLTE_Registration_02","VoLTE_Registration_03","VoLTE_Registration_04","VoLTE_Registration_Language_change_05","VoLTE Call_06","VoLTE Call_07","VoLTE Call_11","Video Call_12","Video Call_13","Video Call_14","Video Call_17","VoLTE_Conference_20","VoLTE_SMS_21","VoLTE_SS_22","VoLTE_DDS_23","VoWiFi_Registration_01","VoWiFi_Registration_Language_change","VoWiFi Call_03","VoWiFi Call_04","VoWiFi Call_07","VoWiFi_Video Call_08","VoWiFi_Video Call_09","VoWiFi_Video Call_10","VoWiFi_Video Call_13","VoWiFi_Conference_17","VoWiFi_Conference_18","VoWiFi_Conference_19","VoWiFi_SMS_20","VoWiFi_SS_21","VoLTE_DDS_22","Total Test Cases Coverage"};

		Map<String, Integer> map = new HashMap<String,Integer>(); //Create map
		
		CellStyle cellStyle1 = wb.createCellStyle();
        cellStyle1 = wb.createCellStyle();
        cellStyle1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cellStyle1.setFillPattern(CellStyle.SOLID_FOREGROUND);
       
      //  XSSFFont font = (XSSFFont) wb.createFont();
       // font.setBoldweight(Font.BOLD);
       // cellStyle1.setFont(font);
        
        plain.setColumnWidth(0,1500);
		
		map.put(" IMS_VoLTE_02",12);
		map.put(" IMS_VoLTE_03",13);
		map.put(" IMS_VoLTE_04",14);
		map.put(" IMS_VoLTE_05",15);
		map.put(" IMS_VoLTE_06",16);
		map.put(" IMS_VoLTE_07",17);
		//map.put("IMS_VoLTE_08",12);
		//map.put("IMS_VoLTE_09",12);
		//map.put("IMS_VoLTE_10",12);
		map.put(" IMS_VoLTE_11",18);
		map.put(" IMS_VoLTE_12",19);
		map.put(" IMS_VoLTE_13",20);
		map.put(" IMS_VoLTE_14",21);
		//map.put("IMS_VoLTE_15",12);
		//map.put("IMS_VoLTE_16",12);
		map.put(" IMS_VoLTE_17",22);
		//map.put("IMS_VoLTE_2",12);
		//map.put("IMS_VoLTE_2",12);
		map.put(" IMS_VoLTE_20",23);
		map.put(" IMS_VoLTE_21",24);
		map.put(" IMS_VoLTE_22",25);
		map.put(" IMS_VoLTE_23",26);
		
		map.put(" IMS_VoWiFi_01",27);
		map.put(" IMS_VoWiFi_02",28);//not sure
		map.put(" IMS_VoWiFi_03",29);
		map.put(" IMS_VoWiFi_04",30);
		map.put(" IMS_VoWiFi_07",31);
		map.put(" IMS_VoWiFi_08 ",32);
		map.put(" IMS_VoWiFi_09 ",33);
		map.put(" IMS_VoWiFi_10",34);
		map.put(" IMS_VoWiFi_13",35);
		map.put(" IMS_VoWiFi_17",36);
		map.put(" IMS_VoWiFi_18",37);
		map.put(" IMS_VoWiFi_19",38);
		map.put(" IMS_VoWiFi_20",39);
		map.put(" IMS_VoWiFi_21",40);
		map.put(" IMS_VoWiFi_22",41);
		//map.put("IMS_VoWiFi_07",12);
		
		
		Row row1 = plain.createRow(1);

		for (int j = 0; j < 43 ; j++ ) {
			Cell cell1 = row1.createCell(j);
			cell1.setCellValue(arr[j]);
			cell1.setCellStyle(cellStyle1);
		}
		
		wb.write(file);
		wb.close();
		file.close();
		return map;
	
	}
	//below function will return 1 if folder is valid else 0
	static int valid_invalid_folder(String StartDate,String EndDate,String FolderName) {
		
		String[] SD = StartDate.split("_");
		int smonth = Integer.parseInt(SD[0]);
		int sdd = Integer.parseInt(SD[1]);
		int shh = Integer.parseInt(SD[2]);
		int smm = Integer.parseInt(SD[3]);
		int sss = Integer.parseInt(SD[4]);
		int startarr[]= {smonth,sdd,shh,smm,sss};
		
		String[] ED = EndDate.split("_");
		int emonth = Integer.parseInt(ED[0]);
		int edd = Integer.parseInt(ED[1]);
		int ehh = Integer.parseInt(ED[2]);
		int emm = Integer.parseInt(ED[3]);
		int ess = Integer.parseInt(ED[4]);
		int endarr[]= {emonth,edd,ehh,emm,ess};
		
		
		String[] FN = FolderName.split("_");
		int fmonth = Integer.parseInt(FN[0]);
		int fdd = Integer.parseInt(FN[1]);
		int fhh = Integer.parseInt(FN[2]);
		int fmm = Integer.parseInt(FN[3]);
		int fss = Integer.parseInt(FN[4]);
		int farr[]= {fmonth,fdd,fhh,fmm,fss};
		
		//startarr endarr farr
		int i=0,j=100;
		while(i < 5 ) {
			if (j==3) {
				i+=1;
				if(i==5) return 1;
				j=check_valid_digit(0,endarr[i],farr[i]);
			}
			else {
				j=check_valid_digit(startarr[i],endarr[i],farr[i]);
			}
			
			
			System.out.println("j="+j);
			if (j==-1)
				return 0;
			else if (j==1)
				return 1;
			else if (j==0)
				i++;
			
		}
		if (i==5)
			return 1;
		
		return 2;
	}
	
	static int check_valid_digit(int s,int e,int m) {
		System.out.println("s= " + s + " e= "+ e +" m= "+ m);
		if ( m < s ) {
			//System.out.println("m<s is true");
			return -1;
		}
		if (m > e) {
			//System.out.println("m>e is true");
			return -1;
		}	
		if (s < m && m < e) {
			//System.out.println("s<m && m<e is true");
			return 1;
		}	
		if (m == s && m < e) {
			//System.out.println("m==s && m<e is true");
			return 1;
		}	
		if( m == s && m > e) {
			//System.out.println("m==s && m>e is true");
			return -1;
		}	
		if (m==s && m==e) { 
			//System.out.println("m==s && m==e is true");
			return 0;
		}	
		if (m==e && m < s) {
			//System.out.println("m==e && m<s is true");
			return -1;
		}	
		if (m==e && m>s ) {
			//System.out.println("m==e && m>s is true");//**
			return 3;
		}

		else
			return 2;
	}

}