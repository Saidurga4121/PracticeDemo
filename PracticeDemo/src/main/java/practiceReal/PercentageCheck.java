package practiceReal;

public class PercentageCheck 
{
	public static void main(String[] args) {
		String x = "49";
		Boolean flag = Character.isAlphabetic(x.charAt(0));
		System.out.println(flag);
        //
        if(!flag) {
        	float d = Float.parseFloat(x);
    		System.out.println(d + " the value of float");
    		//
    		if (x.contains(".")) 
    		{
    			System.out.println("error");
    		} 
    		else if (d > 50) 
    		{
    			System.out.println("do nothing");
    		}
    		else
    		{
    			System.out.println("iam printing");
    		}
        }
        else {
           System.out.println("'"+ x.charAt(0)+"' is a letter");
        }
	}



}

