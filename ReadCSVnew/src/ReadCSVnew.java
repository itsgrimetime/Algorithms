import java.util.*;
import java.text.*;
import java.io.*;
import java.text.ParseException;

public class ReadCSVnew {
	public static void main(String[] args) throws IOException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate, endDate;
		startDate = sdf.parse(args[0]);
		endDate = sdf.parse(args[1]);
		File file = new File("table.csv");
		Scanner inputfile = new Scanner(file);
		inputfile.next();
		inputfile.next();
		int count ; 
		count = NumRows();
		Date[] date_tr = new Date [count];
		Double[] open = new Double[count];
		Double[] high = new Double[count];
		Double[] low = new Double[count];
		Double[] close = new Double[count];
		int i = 0;
				
		while(inputfile.hasNext()){
			String data_row = inputfile.next();
			String[] data = data_row.split(",");
			date_tr[i]=sdf.parse(data[0]);
			open[i]=Double.parseDouble(data[1]);
			high[i]=Double.parseDouble(data[2]);
			low[i]=Double.parseDouble(data[3]);
			close[i]=Double.parseDouble(data[4]);
			SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println( outFormat.format(date_tr[i]) + " " + open[i] + " " + high[i] + " "+ low[i]+ " " + close[i]);
			i++;
		}
	
	 	 inputfile.close();
		 whiteSoldiers(date_tr,open,high,low,close);
	}
	  public static int NumRows() throws IOException{
		  File file = new File("table.csv");
			Scanner inputfile = new Scanner(file);
			inputfile.next();
			inputfile.next();
			int count = 0; 
			while (inputfile.hasNext()){
				String data_row = inputfile.next();
				count++; 
			}
		inputfile.close();
		return count;
	  }
	 
	  public static void whiteSoldiers(Date[]array, Double[]op, Double[] hi, Double[] lo, Double[] cl) {
        for(int i=0; i< array.length; i++) {
            if   (high[i] - close[i]> 0.5&&// 1st day
                  open[i] - low[i]<0.5&&
                  close[i] - open[i] > 1&&
                  close[i]>open[i]&&

                  high[i+1] - close[i+1]> 0.5&& //2nd day
                  open[i+1] - low[i+1]<0.5&&
                  close[i+1] - open[i+1] > 1&&
                  close[i+1]> open[i+1]&&

                  high[i+2] - close[i+2]> 0.5&& //2nd day
                  open[i+2] - low[i+2]<0.5&&
                  close[i+2] - open[i+2] > 1&&
                  close[i+2]>open[i+2]) {
	        if (high[i+1]> high[i]&&
	        low[i+1]> low[i]&&
	        close[i+1]> close[i]&&
	        open[i+1]> open[i] &&
	      
	         high[i+2]> high[i+1]&&
	         low[i+2]> low[i+1]&&
	         close[i+2]> close[i+1]&&
	         open[i+2]> open[i+1])
			 
	 System.out.println("Pattern: " + date_tr[i]);
	 System.out.println("Pattern: " + date_tr[i+1]);
	 System.out.println("Pattern: " + date_tr[i+2]); 
        }
    }	
  }
}
