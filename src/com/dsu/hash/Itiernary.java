package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class Itiernary {

	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
		dataSet.put("Chennai", "Banglore");
		dataSet.put("Bombay", "Delhi");
		dataSet.put("Goa", "Chennai");
		dataSet.put("Delhi", "Goa");

		printResult(dataSet);
	}

	private static void printResult(Map<String, String> dataSet) {
		Map<String, String> m = new HashMap<>();

		for(Map.Entry<String, String> i : dataSet.entrySet()) {
			m.put(i.getValue(), i.getKey());
		}
		
		String start ="";
		for(String s: m.keySet()) {
			if(!dataSet.containsKey(s)) {
				start = s;
				break;
			}
		}
		
		String to =  m.get(start);
		
		while(to != null) {
			System.out.print(start+" -> "+ to);
			start = to;
			to = m.get(to);
		}
	}
}
