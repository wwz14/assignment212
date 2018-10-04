package week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counter {
	private Filter filter;
	
	public static void main(String[] args){
		Counter counter = new Counter();
		try {
			Map<String,Integer> map =	
					counter.countTerm("src/pride-and-prejudice.txt", "src/stop_words.txt");
			for(String key:map.keySet()) {
				System.out.println(key+"-"+map.get(key));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<String,Integer> countTerm(String input, String stopWord) throws IOException {
		Map<String,Integer> map = new HashMap<>();
		filter = new Filter();
		List<String> stopWordsList = filter.stopWordFilter(stopWord);
		
		BufferedReader fileReader = new BufferedReader(new FileReader(input));
	    String line = "";
	    while((line = fileReader.readLine()) != null) {
	    	String[] words = line.split(" ");
	    	for(String str:words) {
	    		String trimed = triming(str);
	    		if(trimed.length() >=2 && !stopWordsList.contains(trimed)){
	    			if(map.containsKey(trimed)) {
	    				map.put(trimed,map.get(trimed)+1);
	    			}else {
	    				map.put(trimed,1);
	    			}
	    		}
	    	}
	    }
	    return map;
	}

	
	//remove none characters at the begining or end of the word
	private String triming(String str){
		str.trim();
		String res = "";
		if(str.length() == 0)
			return "";
		else {
			char[] cs = str.toCharArray();
			for(Character c: cs) {
				if((c >='A')&&(c <= 'Z')){
					c = (char) (c-('A'-'a'));
				}
				
				if((c>='a')&&(c<='z')){
					res+=c+"";
				}
			}
			return res;
		}
	}
}
