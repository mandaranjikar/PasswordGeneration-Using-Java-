import java.util.*;
import java.io.*;
public class PasswordGeneration {
	

	    
	    public static String passGen (String in){
	        Random rnd = new Random();
	        StringBuilder sb = new StringBuilder(in);
	        for(int i=0; i<in.length(); i++){
	            sb.append(in.charAt(rnd.nextInt(in.length()))); 
	        }
	        return sb.toString();

	    }
	    public static void checkStrength (String in){
	        int n = in.length();
	        boolean hasLower = false, hasUpper = false,
	                hasDigit = false, specialChar = false;
	        Set<Character> set = new HashSet<Character>(
	            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
	                          '*', '(', ')', '-', '+'));
	        for (char i : in.toCharArray())
	        {
	            if (Character.isLowerCase(i))
	                hasLower = true;
	            if (Character.isUpperCase(i))
	                hasUpper = true;
	            if (Character.isDigit(i))
	                hasDigit = true;
	            if (set.contains(i))
	                specialChar = true;
	        }
	        System.out.print("Strength of password:- ");
	        if (hasDigit && hasLower && hasUpper && specialChar
	            && (n >= 8))
	            System.out.print(" Strong");
	        else if ((hasLower || hasUpper || specialChar)
	                 && (n >= 6))
	            System.out.print(" Moderate");
	        else
	            System.out.print(" Weak");
	        System.out.println();
	    }
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the input to generate your password");
	        String inputpass = sc.nextLine();
	        String randPass = passGen(inputpass);
	        checkStrength(randPass);
	        System.out.println("Your Password - "+randPass);
	        
	        //To save the password in a text file 
	        File output = new File("output.txt");
	        FileWriter writer;
			try {
				writer = new FileWriter(output);
				writer.write(randPass);
				writer.flush();
		        writer.close();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

	     

	    }
	}
