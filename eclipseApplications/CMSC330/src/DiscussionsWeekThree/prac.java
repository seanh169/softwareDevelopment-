package DiscussionsWeekThree;

import ProjectOne.PossibleToken;

public class prac {
//	 public static PossibleToken[] punctuationTokens =
//         {
//                 PossibleToken.COMMA, PossibleToken.COLON, PossibleToken.SEMICOLON, PossibleToken.PERIOD, PossibleToken.LEFT_PARENTHESIS, PossibleToken.RIGHT_PARENTHESIS
//         };
	
	public static void main(String[] args) {
//		System.out.println(punctuationTokens.length);
		PossibleToken x; 
//		System.out.println(x.ordinal(PossibleToken.BUTTON));
		for (PossibleToken aToken : PossibleToken.values())
        {
			System.out.println(aToken);
           System.out.println(aToken.ordinal());
        }
	}

}
