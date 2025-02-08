// import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;  

/**
 * In this assignment, you will implement a simple class called CustomString.  This class represents a more customizable version 
 * of a String, with additional attributes and methods.  
 * For example, the CustomString class has a “reverse” method which returns a new string version of the current string where the 
 * capitalization is reversed (i.e., lowercase to uppercase and uppercase to lowercase) for the alphabetical characters specified 
 * in the given arg.  For CustomString “abc, XYZ; 123.”, calling reverse("bcdxyz@3210.") will return "aBC, xyz; 123.".  
 * 
 * The CustomString class also has a “remove” method which returns a new string version of the current string where the alphabetical 
 * characters specified in the given arg, are removed.  For CustomString "my lucky numbers are 6, 8, and 19.", calling remove("ra6") 
 * will return "my lucky numbes e 6, 8, nd 19.".
 * 
 */
public class CustomString {
	
	//instance variables
	
	/**
	 * Current string.
	 */
	String myString;
	
	/**
	 * Indicates if the current string myString has been set (not null).
	 */
	boolean isSet;
	
	//constructor
	
	/**
	 * Initializes current string myString to null.
	 * Initializes isSet to false.
	 */
	public CustomString() {
		this.myString=null;
        this.isSet=false;
	}

	// methods 
	
    /**
     * Returns the current string.
     * If the current string is null, or has not been set to a value with setString, it should return null.
     * @return current string
     */
	public String getString() {
		
		if(myString!=null){return myString;}
		return null;
	}

	/**
     * Sets the value of the current string and sets this.isSet to true.
     * If the given string is null, sets this.isSet to false.
     * @param string value to be set
     */
	public void setString(String string) {
		if(string==null){
            isSet=false;
        }else{
            myString=string;
            isSet=true;
        }
	}

    /**
     * Returns a new string version of the current string where the alphabetical characters specified in the given arg, are removed.
     *   
     * The alphabetical characters to be removed are case insensitive.  
     * All non-alphabetical characters are unaffected.
     * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
     *
     * Example(s):
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("ra6") would return "my lucky numbes e 6, 8, nd 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("6,.") would return "my lucky numbers are 6, 8, and 19."
     * - For a current string "my lucky numbers are 6, 8, and 19.", calling remove("") would return "my lucky numbers are 6, 8, and 19."
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     * 
     * @param arg the string containing the alphabetical characters to be removed from the current string
     * @return new string in which the alphabetical characters specified in the arg are removed
     */
	public String remove(String arg) {
        String str =this.getString();
        StringBuilder sb=new StringBuilder();
		for(char s : str.toCharArray()){
            int cpt=0;
            for(char a : arg.toCharArray()){
                if(a!=s){
                    cpt++;
                }else{
                    break;
                }
            } 
            if (cpt==arg.length()) {
                sb.append(s);
            }
        }
        
	  	return sb.toString();
	}
	
	/**
	 * Returns a new string version of the current string where the capitalization is reversed (i.e., lowercase to uppercase, 
	 * and uppercase to lowercase) for the alphabetical characters specified in the given arg.
	 *   
	 * All non-alphabetical characters are unaffected.
	 * If the current string is null, empty, or has not been set to a value, this method should return an empty string.
	 *
	 * Example(s):
	 * - For a current string "abc, XYZ; 123.", calling reverse("bcdxyz@3210.") would return "aBC, xyz; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("6,.") would return "abc, XYZ; 123."
	 * - For a current string "abc, XYZ; 123.", calling reverse("") would return "abc, XYZ; 123."
	 * - For a current string "", calling reverse("") would return ""
	 * 
	 * Remember: This method builds and returns a new string, and does not directly modify the myString field.
	 * 
	 * @param arg the string containing the alphabetical characters to have their capitalization reversed in the current string
	 * @return new string in which the alphabetical characters specified in the arg are reversed
	 */
	// public String reverse(String arg) {
    //     String str=getString();
	// 	for(int i = 0 ; i<arg.length() ; i++){
    //         for(int j=0 ; j<str.length(); j++){
    //             if(str.charAt(j)==arg.charAt(i)){
    //                 if (Character.isLowerCase(str.charAt(j))) {
    //                     Character.toUpperCase(str.charAt(j));
    //                 }
    //                 if (Character.isUpperCase(str.charAt(j))) {
    //                     Character.toLowerCase(str.charAt(j));
    //                 }
    //             }
    //         }
    //     }
		
	// 	return str;
	// }


   
        /**
         * Reverses the capitalization of characters in the current string based on the given argument.
         *
         * @param arg the string specifying which characters to consider for capitalization reversal
         * @return a new string with reversed capitalization for specified characters
         */
    public String reverse(String arg) {
            // If myString is null or empty, return an empty string
            if (myString == null || myString.isEmpty()) {
                return "";
            }
    
            // If arg is null, treat it as an empty string
            if (arg == null) {
                arg = "";
            }
    
            // Create a set of characters from arg for fast lookup
            Set<Character> argSet = new HashSet<>();
            for (char c : arg.toCharArray()) {
                argSet.add(c);
            }
    
            // Build the new string
            StringBuilder result = new StringBuilder();
            for (char c : myString.toCharArray()) {
                if (argSet.contains(c)) {
                    // Reverse capitalization for alphabetic characters in argSet
                    if (Character.isLowerCase(c)) {
                        result.append(Character.toUpperCase(c));
                    } else if (Character.isUpperCase(c)) {
                        result.append(Character.toLowerCase(c));
                    } else {
                        result.append(c);
                    }
                } else {
                    // Leave other characters unchanged
                    result.append(c);
                }
            }
    
            return result.toString();
    }
    
        
    


    /**
     * Returns a new string version of the current string where all the letters either >= or <= the given char n, are removed.  
     * 
     * The given letter may be a-z or A-Z, inclusive.
     * The letters to be removed are case insensitive.
     *
     * If 'more' is false, all letters less than or equal to n will be removed in the returned string.
     * If 'more' is true, all letters greater than or equal to n will be removed in the returned string.
     *
     * If the current string is null, the method should return an empty string.
     * If n is not a letter (and the current string is not null), the method should return an empty string.
     *
     * Example(s):
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', false) would return "llo 90, y 2"
     * - For a current string "Abcdefg", calling filterLetters('c', false) would return "defg"
     * - For a current string "Hello 90, bye 2", calling filterLetters('h', true) would return "e 90, be 2"
     * - For a current string "Abcdefg", calling filterLetters('c', true) would return "Ab"
     * 
     * Remember: This method builds and returns a new string, and does not directly modify the myString field.
     *
     * @param n char to compare to
     * @param more indicates whether letters <= or >= n will be removed
     * @return new string with letters removed 
     */
	public String filterLetters(char n, boolean more) {
		String str =getString();
        String stt=str.toLowerCase();
        int asci=(int) n ; StringBuilder sb = new StringBuilder();

        if(more==true){
            for(char s :stt.toCharArray()){
                int ns =(int) s;
                if(ns>= asci){
                    continue;
                }
                sb.append(s);
            }
        }
        if(more==false){
            for(char s :stt.toCharArray()){
                int ns =(int) s;
                if(ns<= asci){
                    continue;
                }
                sb.append(s);
            }
        }
		
		return sb.toString();
	}
}