package sample;

import java.util.ArrayList;

public class swapTest {

	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<String>();
		str.add("one");
		str.add("two");
		str.add("three");
		str.add("one");
		str.add("two");
		str.add("three");
		str.add("one");
		str.add("two");
		str.add("three");
		
		Conversion2 numWordToNumReal = new Conversion2<String, Integer>() {

			@Override
			public Integer convert(String toConvert) {
				int x = 0;
				
				switch(toConvert) {
					case "one":
					x = 1;
					break;
					
					case "two":
					x = 2;
					break;
					
					case "three":
					x = 3;
					break;
					
							
				}
				return x;
			}
			
		};
		
		System.out.println(convertList(str, numWordToNumReal));

	}
	public ArrayList<Integer> convert(ArrayList<String> s, Conversion f) {
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (String a : s) {
			newArray.add(f.convert(a));
		}
		return newArray;
	}
	
	public static <O, F> ArrayList<F> convertList(ArrayList<O> s, Conversion2<O, F> f){
		ArrayList<F> newArray = new ArrayList<F>();
		for (O a : s) {
			newArray.add(f.convert(a));
		}
		return newArray;
		
	}
	
	

}
