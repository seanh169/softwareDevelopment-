package prac;

import java.util.HashMap;
import java.util.Map;

public class DictionariesMaps {
	
	public static void main(String[] args) {
		//English to Spanish Dictionary
		Map<String,String> englSpanDictionary = new HashMap<String, String>();
		englSpanDictionary.put("Monday", "Lunes");
		englSpanDictionary.put("Tuesday", "Martes");
		englSpanDictionary.put("Wednesday", "Miércoles");
		englSpanDictionary.put("Thursday", "Jueves");
		englSpanDictionary.put("Friday", "Viernes");
		
//		System.out.println(englSpanDictionary.get("Monday"));
//		System.out.println(englSpanDictionary.get("Tuesday"));
//		System.out.println(englSpanDictionary.get("Wednesday"));
//		System.out.println(englSpanDictionary.get("Thursday"));
//		System.out.println(englSpanDictionary.get("Friday"));
		
		Map<String, Boolean> shoppingList = new HashMap<String, Boolean>();
		//Put some stuff in dictionary
		shoppingList.put("Ham", true);
		shoppingList.put("Bread", Boolean.TRUE);
		shoppingList.put("Oreos", Boolean.FALSE);
		shoppingList.put("Sugar", Boolean.FALSE);
		shoppingList.remove("Oreos");
		shoppingList.replace("Bread", Boolean.FALSE);
		System.out.println(shoppingList.toString().replaceAll("\\{|\\}|\\,|\\=", ""));
	}
	
	public DictionariesMaps() {};
}
