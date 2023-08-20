package com.dsu.stack;

import java.util.Vector;

public class DeleteContinousSequence {

	public static void main(String[] args)
    {
        Vector<String> v = new Vector<>();
 
        v.addElement("tom"); v.addElement("jerry");
        v.addElement("jerry");v.addElement("tom");
 
        System.out.println(removeConsecutiveSame(v));
    }

	private static int removeConsecutiveSame(Vector<String> v) {
		// TODO Auto-generated method stub
		
		int  n = v.size();
		int i = 0;
		while(i < n-1) {
			if(v.get(i).equals(v.get(i+1))) {
				v.remove(i);
				v.remove(i);
				
				if(i > 0) i--;
				
				n = n -2;
			} else {
				i++;
			}
		}
		return v.size();
	}
}
