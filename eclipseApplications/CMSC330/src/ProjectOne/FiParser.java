package ProjectOne;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * 
 * File Name : FiParser.java
 * Author : Sean Hamilton
 * Date: 09/09/2019
 * Purpose of program: Project 1 CMSC 330 UMUC. This class holds all the methods to parse the file, perform recursive descent, and implement lexical analysis of converting characters into a sequence of tokens. 
 * 
 * 
 *
 */

public class FiParser {
	
	//Private variables.

	private PossibleToken possibleEnum;
    private PossibleToken singleEnum;
    private JFrame jFrame;
    private String grammarPunct = ":,).;(";
    char[] chars = grammarPunct.toCharArray();
    private PossibleToken[] possiblePunctEnums = {  PossibleToken.COLON, PossibleToken.COMMA, PossibleToken.RIGHT_PARENTHESIS, PossibleToken.PERIOD, PossibleToken.SEMICOLON, PossibleToken.LEFT_PARENTHESIS };
    private StreamTokenizer st;
    private String returnString;
    private ButtonGroup bGroup;
                   
    
    
   
    //Constructor. 
    public FiParser(String fileName) throws InvalidInputException, IOException { 
    
    	st = new StreamTokenizer(new FileReader(fileName));
    	st.quoteChar('"');
    	st.ordinaryChar('.');
    	singleEnum = this.iterateToken();
        if (constructGUI()) {
            jFrame.setVisible(true);
        } else {
            throw new InvalidInputException("INCORRECT TOKEN: " + singleEnum);
        }
        
    }
      
    // Iterates over the next token.

    public PossibleToken iterateToken() throws InvalidInputException, IOException
    {
        int nextToken = st.nextToken();
        
        if(nextToken == StreamTokenizer.TT_NUMBER) {
        	 	return PossibleToken.NUMBER;
        }else if(nextToken == StreamTokenizer.TT_EOF) {
        		return PossibleToken.EOF;
        }else if(nextToken == '"') {
        	 	return PossibleToken.STRING;
        }else if(nextToken == StreamTokenizer.TT_WORD) {
    			for (PossibleToken tokenRunner : PossibleToken.values()) {
	
	                if (tokenRunner.ordinal() == 12)
	                    break;
	                if (tokenRunner.name().equals(st.sval.toUpperCase()))
	                    return tokenRunner;
	            }
	            throw new InvalidInputException("INCORRECT TOKEN: " + st.lineno());
        }else{
        	 
        		for (int i = 0; i < grammarPunct.length(); i++) {
        			if (nextToken == grammarPunct.charAt(i))
                     return possiblePunctEnums[i];
        		}
            
        }
        return PossibleToken.EOF;
    }
    //Evaluate tokens and construct GUI.
    private boolean constructGUI() throws IOException, InvalidInputException {
    	
    		int heightGUI;
        int widthGUI;
        
        if (compareCurrentToken(PossibleToken.WINDOW)) {
        	
            if (compareCurrentToken(PossibleToken.STRING)) {
                jFrame = new JFrame(returnString);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel main = new JPanel();
                if (compareCurrentToken(PossibleToken.LEFT_PARENTHESIS)) {
                    if (compareCurrentToken(PossibleToken.NUMBER)) {
                        widthGUI = (int) st.nval;
                        singleEnum = this.iterateToken();
                        if (compareCurrentToken(PossibleToken.COMMA)) {
                            if (compareCurrentToken(PossibleToken.NUMBER)) {
                                heightGUI = (int) st.nval;
                                singleEnum = this.iterateToken();
                                if (compareCurrentToken(PossibleToken.RIGHT_PARENTHESIS)) {
                                    jFrame.setSize(widthGUI,heightGUI);
                                    main.setSize(widthGUI,heightGUI);
                                    jFrame.add(main);
                                    if (containerLayout(main)) {
                                        if (convertWidgets(main)) {
                                            if (compareCurrentToken(PossibleToken.END)) {
                                                return compareCurrentToken(PossibleToken.PERIOD);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    //Compare token to Enums. 
    private boolean compareCurrentToken(PossibleToken inputToken) throws IOException, InvalidInputException {
        if (singleEnum == inputToken) {
            switch (singleEnum) {
	            case TEXTFIELD:
	            case WINDOW:
	            case COMMA:
	            case COLON:
                case BUTTON:
                case LAYOUT:
                case PANEL:
                case RADIO:
                case LEFT_PARENTHESIS:
                case RIGHT_PARENTHESIS:
                case END:
                case FLOW:
                case GRID:
                case LABEL:
                    singleEnum = this.iterateToken();
                    break;
                case GROUP:
                    bGroup = new ButtonGroup();
                    singleEnum = this.iterateToken();
                    break;
                case STRING:
                    returnString = st.sval;
                    singleEnum = this.iterateToken();
                    break;
                case SEMICOLON:
                    singleEnum = this.iterateToken();
            }
            return true;
        } else {
            possibleEnum = inputToken;
            return false;
        }
    }
    
    //Methods below are used to a pass a container type to the different parsing methods to generate all necessary GUI components per project requirements. 
    private boolean containerLayout(Container inputContainer) throws IOException, InvalidInputException {
        if (compareCurrentToken(PossibleToken.LAYOUT)) {
            if (convertLayout(inputContainer)) {
                return compareCurrentToken(PossibleToken.COLON);
            }
        }
        return false;
    }
    
    private boolean convertLayout(Container inputContainer) throws IOException, InvalidInputException {
    		
    		int horizontalGap;
        int verticalGap;
        int numberOfRows;
        int numberOfcolumns;
        
        if (compareCurrentToken(PossibleToken.FLOW)) {
            inputContainer.setLayout(new FlowLayout());
            return true;
        }
        else if (compareCurrentToken(PossibleToken.GRID)) {
            if (compareCurrentToken(PossibleToken.LEFT_PARENTHESIS)) {
                if (compareCurrentToken(PossibleToken.NUMBER)) {
                    numberOfRows = (int) st.nval;
                    singleEnum = this.iterateToken();
                    if (compareCurrentToken(PossibleToken.COMMA)) {
                        if (compareCurrentToken(PossibleToken.NUMBER)) {
                            numberOfcolumns = (int) st.nval;
                            singleEnum = this.iterateToken();
                            if (compareCurrentToken(PossibleToken.RIGHT_PARENTHESIS)) {
                                inputContainer.setLayout(new GridLayout(numberOfRows,numberOfcolumns));
                                return true;
                            }
                            else if (compareCurrentToken(PossibleToken.COMMA)) {
                                if (compareCurrentToken(PossibleToken.NUMBER)) {
                                    horizontalGap = (int) st.nval;
                                    singleEnum = this.iterateToken();
                                    if (compareCurrentToken(PossibleToken.COMMA)) {
                                        if (compareCurrentToken(PossibleToken.NUMBER)) {
                                            verticalGap = (int) st.nval;
                                            singleEnum = this.iterateToken();
                                            if (compareCurrentToken(PossibleToken.RIGHT_PARENTHESIS)) {
                                                inputContainer.setLayout(new GridLayout(numberOfRows,numberOfcolumns,horizontalGap,verticalGap));
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private boolean convertWidgets(Container inputContainer) throws IOException, InvalidInputException {
        if (convertSingleWidget(inputContainer)) {
            if (convertWidgets(inputContainer)) {
                return true;
            }
            return true;
        }
        return false;
    }
    
    private boolean convertSingleWidget(Container inputContainer) throws IOException, InvalidInputException {
        int columns;
        if (compareCurrentToken(PossibleToken.BUTTON)) {
            if (compareCurrentToken(PossibleToken.STRING)) {
                if (compareCurrentToken(PossibleToken.SEMICOLON)) {
                    inputContainer.add(new JButton(returnString));
                    return true;
                }
            }
        }
        else if (compareCurrentToken(PossibleToken.GROUP)) {
            if (convertRadio(inputContainer)) {
            	 if (compareCurrentToken(PossibleToken.END)) {
                     return compareCurrentToken(PossibleToken.SEMICOLON);
                 }
                 return false;
            }
        }
        else if (compareCurrentToken(PossibleToken.LABEL)) {
            if (compareCurrentToken(PossibleToken.STRING)) {
                if (compareCurrentToken(PossibleToken.SEMICOLON)) {
                    inputContainer.add(new JLabel(returnString));
                    return true;
                }
            }
        }
        else if (compareCurrentToken(PossibleToken.PANEL)) {
            inputContainer.add(inputContainer = new JPanel());
            if (containerLayout(inputContainer)) {
                if (convertWidgets(inputContainer)) {
                	 if (compareCurrentToken(PossibleToken.END)) {
                         return compareCurrentToken(PossibleToken.SEMICOLON);
                     }
                     return false;
                }
            }
        }
        else if (compareCurrentToken(PossibleToken.TEXTFIELD)) {
            if (compareCurrentToken(PossibleToken.NUMBER)) {
                columns = (int) st.nval;
                singleEnum = this.iterateToken();
                if (compareCurrentToken(PossibleToken.SEMICOLON)) {
                    inputContainer.add(new JTextField(columns));
                    return true;
                }
            }
        }
        return false;
    }
    

    private boolean convertRadio(Container inputContainer) throws IOException, InvalidInputException {
        if (convertSingleRadio(inputContainer)) {
            if (convertRadio(inputContainer)) {
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean convertSingleRadio(Container inputContainer) throws IOException, InvalidInputException {
        if (compareCurrentToken(PossibleToken.RADIO)) {
            if (compareCurrentToken(PossibleToken.STRING)) {
                if (compareCurrentToken(PossibleToken.SEMICOLON)) {
                    JRadioButton radioBut = new JRadioButton(returnString);
                    inputContainer.add(radioBut);
                    bGroup.add(radioBut);
                    return true;
                }
            }
        }
        return false;
    }
   
    
}
