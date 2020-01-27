package Homework5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * 
 * 
 * File Name : Homework5.java
 * Author : Sean Hamilton
 * Date: 11/22/2019
 * Purpose of program: Homework 5 CMSC 412 UMUC. Solution. 
 * 
 * Requirements: 
 * 
 *Write a Java, C# or C/C++ program (the choice is yours) for file/directory processing
 *according to the following rules. The program requested for this project must have a text menu
 *like this: ..... Homework5.pdf
 * 
 *
 */

public class Homework5 {
	byte[] ensaltArr = {
			(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03
	};
	Cipher cypherEN;
	Cipher decypherEN;
	int iterationCount = 19;
	static File EDfileOne;
	static File deleteFile;
	static File displayFile;
	static String inputPasswordGlob;
	static String encryptedFileWithXOR;
	
	//default constructor
	public Homework5() {}
	
	
	//Encrypt file with XOR according to requirements.
	public String encryptFileXOR(String ensecretKey, String enplainText) throws InvalidKeySpecException,UnsupportedEncodingException,InvalidKeyException,NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException,NoSuchAlgorithmException,BadPaddingException{
		   KeySpec cyperENKeySpec = new PBEKeySpec(ensecretKey.toCharArray(), ensaltArr, iterationCount);
	       SecretKey cypherENKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(cyperENKeySpec);
	       AlgorithmParameterSpec algorParamSpecification = new PBEParameterSpec(ensaltArr, iterationCount);

	       cypherEN = Cipher.getInstance(cypherENKey.getAlgorithm());
	       cypherEN.init(Cipher.ENCRYPT_MODE, cypherENKey, algorParamSpecification);
	       String cypherENCharacterSet="UTF-8";
	       byte[] cypherEnIn = enplainText.getBytes(cypherENCharacterSet);
	       byte[] cypherEnOut = cypherEN.doFinal(cypherEnIn);
	       String cypherENCStr=new sun.misc.BASE64Encoder().encode(cypherEnOut);
	       return cypherENCStr;
	   }
	//Decrypt the file with XOR according to requirements.
	   public String decryptFileXOR(String ensecretKey, String EencryptedText) throws NoSuchAlgorithmException,InvalidKeyException,UnsupportedEncodingException,NoSuchPaddingException, BadPaddingException,InvalidKeySpecException, InvalidAlgorithmParameterException,IllegalBlockSizeException, IOException{
			       KeySpec cyperENKeySpec = new PBEKeySpec(ensecretKey.toCharArray(), ensaltArr, iterationCount);
			       SecretKey cypherENKey = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(cyperENKeySpec);
			      
			       AlgorithmParameterSpec algorParamSpecification = new PBEParameterSpec(ensaltArr, iterationCount);
			       decypherEN=Cipher.getInstance(cypherENKey.getAlgorithm());
			       decypherEN.init(Cipher.DECRYPT_MODE, cypherENKey,algorParamSpecification);
			       byte[] cypherENDecoder = new sun.misc.BASE64Decoder().decodeBuffer(EencryptedText);
//			       byte[] cypherENDecoder = Base64.getDecoder().decode(EencryptedText);
			       byte[] cypherENutf = decypherEN.doFinal(cypherENDecoder);
			       String cypherENCharacterSet="UTF-8";
			       String cypherENPlain = new String(cypherENutf, cypherENCharacterSet);
			       return cypherENPlain;
		}
	   //Method to Print File output in Hex per requirement option 5
	   private static void printHexFile(String filename) throws IOException{
   		try (FileInputStream fis = new FileInputStream(filename)) {
            int i = 0;
            int counter = 0;
            while ((i = fis.read()) != -1) {
                System.out.printf("%02X ", i);
                counter++;

                if (counter == 16) {
                    System.out.println("");
                    counter = 0;
                }
            }
   			}
		}
	   // Method for listing files per requirements options 2&3
	   public static List<File> cypherEnStrSubDir(File cypherEnFile) {
	       List<File> subdirectories = Arrays.asList(cypherEnFile.listFiles(new FileFilter(){
	           public boolean accept(File cFile){
	               return cFile.isDirectory();
	           }
	       }));
	       subdirectories = new ArrayList<File>(subdirectories);
	       List<File> nextLevelSubDirectories = new ArrayList<File>();
	       for(File subdir : subdirectories){
	           nextLevelSubDirectories.addAll(cypherEnStrSubDir(subdir));
	       }
	       subdirectories.addAll(nextLevelSubDirectories);
	       return subdirectories;
	   }
	   
	   static String readFile(String fileName) throws IOException {
		    BufferedReader br = new BufferedReader(new FileReader(fileName));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append("\n");
		            line = br.readLine();
		        }
		        return sb.toString();
		    } finally {
		        br.close();
		    }
		}
	  
	   // Main method
	   public static void main(String[] args) throws Exception {
	       BufferedReader inputBR = new BufferedReader(new InputStreamReader(System.in));
	       Homework5 h5=new Homework5();
	       
	       try {
	       System.out.println("Choose option: ");
	       while(true) {
	       System.out.println("0 Exit \n"
	       + "1 Select directory \n"
	       + "2 List directory content (first level)\n"
	       + "3 List directory content (all levels) \n"
	       + "4 Delete file \n"
	       + "5 Display file \n"
	       + "6 Encrypt file (XOR with password)\n"
	       + "7 Decrypt file (XOR with password)\n");
	       System.out.println("\nChoose next option: ");
	       int opt = Integer.parseInt(inputBR.readLine());
	      
	   switch(opt) {
	    case 0:
	      System.out.println("Exiting");
          System.exit(0);
          break;
        case 1:
        	System.out.printf("Enter File directory: ");
        	String line = inputBR.readLine();
        	File cypherEnFile = new File(line);
        	if(cypherEnFile.isDirectory()) {
        		EDfileOne = cypherEnFile;
        	}else {
        		EDfileOne = new File("");
        	}
        	System.out.println(EDfileOne.isDirectory());
        	System.out.println();
            continue;
        case 2:
        	if(EDfileOne == null) {
        		throw new Exception("ERROR - directory does not exist or no directory has been selected. Please try again!");
        	}else {
              String[] EDfile1 = EDfileOne.list();
              System.out.println( "List directory content(first level): " );
              for ( String tknafile : EDfile1 ){
                  System.out.println( tknafile );
              }
        	}

            continue;
        case 3:
        	if(EDfileOne == null) {
        		throw new Exception("ERROR - directory does not exist or no directory has been selected. Please try again!");
        	}else {
        		File[] EDselectedFiles = EDfileOne.listFiles();
        		System.out.println( "List directory content(all levels): " );
                for (File EDselectedFile : EDselectedFiles){
                    System.out.println(EDselectedFile.getAbsolutePath());
                }
              
        	}
        	  continue;
        case 4:
        	System.out.printf("Enter File Name to Delete: ");
        	String dfname = inputBR.readLine();
        	File deleteFileName = new File(EDfileOne + "/" + dfname);
        	System.out.println(deleteFileName.exists());
        	if(deleteFileName.exists() && deleteFileName != null && EDfileOne != null) {
        		System.out.println(deleteFileName.delete());
        	}else {
        		throw new Exception("ERROR - File does not exist or a directory was not selected.");
        	}
            continue;
        case 5:
            try {
            	System.out.printf("Enter File Name to display in hexadecimal view: ");
            	String displayFileName = inputBR.readLine();
            	File displayHexFile = new File(EDfileOne + "/" + displayFileName);
            	String fName = EDfileOne + "/" + displayFileName;
            	if(displayHexFile.exists() && EDfileOne != null) {
            		printHexFile(fName);
            	}else {
            		throw new Exception("ERROR - File does not exist or a directory was not selected.");
            	}        
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
            continue;
        case 6:    
        	System.out.printf("Please Enter a password: ");
        	String inputPassword = inputBR.readLine();
        	if(inputPassword.length() * 2 <= 256) {
        		inputPasswordGlob = inputPassword;
        	}else {
        		inputPasswordGlob = "";
        		throw new Exception("ERROR - Password must be less than 256 Bytes");
        	}
        	System.out.printf("Please Enter a filename: ");
        	String displayEncFileName = inputBR.readLine();
        	File displayEncFile = new File(EDfileOne + "/" + displayEncFileName);
//        	System.out.println(readFile(EDfileOne + "/" + displayEncFileName));
        	if(displayEncFile.exists() && EDfileOne != null) {		
        		encryptedFileWithXOR = h5.encryptFileXOR(inputPasswordGlob, readFile(EDfileOne + "/" + displayEncFileName));
        	}else {
        		encryptedFileWithXOR = "";
        		throw new Exception("ERROR - File does not exist or a directory was not selected.");
        	}
        	System.out.println("Encrypted File: " + encryptedFileWithXOR);
        	continue;

        case 7:
        	System.out.printf("Please Enter a password: ");
        	String inputDecPassword = inputBR.readLine();
        	System.out.printf("Please Enter a filename: ");
        	String displayDecFileName = inputBR.readLine();
        	File displayDecFile = new File(EDfileOne + "/" + displayDecFileName);
        	if(displayDecFile.exists() && EDfileOne != null) {		
        		String decFileAft = h5.decryptFileXOR(inputDecPassword, encryptedFileWithXOR);
        		System.out.println("File after decryption: "+ decFileAft);
        	}else {
        		throw new Exception("ERROR - File does not exist or a directory was not selected.");
        	}
        	continue;
               
	   	}
	  }
    } catch(IOException e){
    	
    } catch (NoSuchPaddingException e) {
    	
    } catch (InvalidAlgorithmParameterException e) {
    	
    } catch (NumberFormatException e) {
    	
    } catch (InvalidKeyException e) {
    	
    } catch (NoSuchAlgorithmException e) {
    	
    } catch (BadPaddingException e) {
    	
    } catch (InvalidKeySpecException e) {
    	
    } catch (IllegalBlockSizeException e) {
    	
    }
}

}
