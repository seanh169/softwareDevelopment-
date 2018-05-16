package DayFourExercises;

import java.util.ArrayList;

public class longConverter {
//	ArrayList arguments = new ArrayList();
//	arguments[0] = "one";
	public static void main(String[] arguments) {
//        arguments[0] = "one";
        System.out.println(arguments.length);
        System.out.println(arguments[0].charAt(0));
        System.out.println(arguments[0].charAt(1));
        System.out.println(arguments[0].charAt(arguments[0].length()-1));
//        arguments[2] = "two";
		if (arguments.length > 0) {
            long num = 0;
            char firstChar = arguments[0].charAt(0);
            char secondChar = arguments[0].charAt(1);
            switch (firstChar) {
                case 'o':
                    num = 1L;
                    break;
                case 't':
                    if (secondChar == 'w')
                        num = 2L;
                    if (secondChar == 'h')
                        num = 3L;
                    if (secondChar == 'e')
                        num = 10L;
                    break;
                case 'f':
                    if (secondChar == 'o')
                        num = 4L;
                    if (secondChar == 'i')
                        num = 5L;
                    break;
                case 's':
                    if (secondChar == 'i')
                        num = 6L;
                    if (secondChar == 'e')
                        num = 7L;
                    break;
                case 'e':
                    if (secondChar == 'i')
                        num = 8L;
                    break;
                case 'n':
                    num = 9L;
            }
            
            
            System.out.println("The number is " + num);
        }
    }
}
