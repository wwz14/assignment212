package week1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Filter {
	private static List<String> stop_words = new ArrayList<>();
	
//	public static void main(String[] args) {
//		try {
//			
//			reader("src/stop_word.txt");
//			for(String str:stop_words) {
//				System.out.println(str);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public List<String> stopWordFilter(String file_path) throws IOException{
		reader(file_path);
		return stop_words;
	}
	
	private static void reader(String file_path) throws IOException {
	    BufferedReader fileReader = new BufferedReader(new FileReader(file_path));
	    String line = "";
	    while((line = fileReader.readLine()) != null) {
	    	String[] words = line.split(",");
	    	for(String str:words) {
	    		if(!str.equals(" ")) {
	    			stop_words.add(str);
	    		}
	    	}
	    }
	}

}


