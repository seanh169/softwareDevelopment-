package prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapChallenge {

	 public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        Map<String, Integer> phones = new HashMap<String, Integer>();
	        int n = in.nextInt();
	        in.nextLine();
	        for(int i = 0; i < n; i++){
	            String name = in.next();
	            int phone = in.nextInt();
	            phones.put(name, phone);
	            in.nextLine();
	        }
	        while(in.hasNext()){
	            String s = in.next();
//	            System.out.println(phones.values());
	            if(phones.containsKey(s)) {
	            	System.out.println(s + " = " + phones.get(s));
	            }
	            else {
	            	System.out.println("Not found");
	            }
	            
	            
	            
	            
	            
//	            for(String key : phones.keySet()){
//	            	if(key.equals(s)) {
//	            		System.out.println(key + " = " + phones.get(key));
//	            	}
//	            	else{
//	            		System.out.println("Not found");
//	            	}
//	            }
	        }
	        
	        in.close();
	       
	    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

