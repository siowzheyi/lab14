package serverside;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	
	/**
	 * This method count the number of characters in a sentence
	 * @author Siow Zhe Yi
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	/**
	 * This method count number of vowel 
	 * @author Siow Zhe Yi
	 * @return 
	 */
	public int countVowel() {
		int vowel = 0;
		 for (char c : sentence.toCharArray()) {
             if (Character.isLetter(c)) {
                 c = Character.toLowerCase(c);
                 if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                	 vowel++;
                 }
             } 
         }
		return vowel;
	}
	
	 /**
	 * This method count number of consonant
	 * @author Siow Zhe Yi
	 * @return
	 */
	public int countConsonant() {
		int consonant = 0;
		 for (char c : sentence.toCharArray()) {
			 if (Character.isLetter(c)) {
                 c = Character.toLowerCase(c);
                 if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                     // ignore
                 } else {
                	 consonant++;
                 }
			 }
         }
		return consonant;
	}


	 /**
	 * This method count number of punctuation
	 * @author Siow Zhe Yi
	 * @return
	 */
	public int countPunctuation() {
		int index = 0;
		 String punctuationMarks = ".,;:!?\"'()[]{}<>";
		 
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
		    if (punctuationMarks.indexOf(ch) != -1) {
		    	index++;
		    }
		}
		return index;
	}
		 
}
