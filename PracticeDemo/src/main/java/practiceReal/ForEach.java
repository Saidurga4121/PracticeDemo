package practiceReal;

import java.util.Arrays;
import java.util.List;

public class ForEach 
{
	 public static void main(String[] args)
	 {
		 List<Integer> list= Arrays.asList(4,5,6,7,8);
		 
//		 for(int i=0;i<list.size();i++)
//		 {
//			 System.out.println(list.get(i));
//		 }
		 for(int i : list)
		 {
			 System.out.println(i);
		 }
		 
	 }
}
