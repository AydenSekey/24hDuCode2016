package fr.soprasteria;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello java 8 world !");
		
		List<String> strs = new LinkedList<String>();
		strs.add("str1");
		strs.add("str2");
		strs.forEach(t -> System.out.println("lambda : " + t));
		LocalDate date = LocalDate.now();
		System.out.println(date);
    }
}
