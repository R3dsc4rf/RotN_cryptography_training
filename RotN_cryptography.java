package HelloWorld;
import java.util.Scanner;                                               // Keyboard Input

public class RotN_cryptography 
{
      /**
       *                RotateText
       * convert input text to char array and
       * rotate the text by n. 
       * so a + 1 = b, z + 1 = a, h + 2 = j and so on
       * Example code: RotateText("abc d", 1) returns "bcd e"
       * @param n       = a natural number (integer)
       * @param text    = a text only letters and whitespace. makes text to LowerCase, too.
       * @return        = converted string only in lower case
       */
      public static String RotateText (int n, String text)              
      {
            n = n%26;                                                   // 26 for every alphabet character
            String sreturn = "Error";
            //int asciiA = (int) 'a';
            text = text.toLowerCase();
            char[] stringToCharArray = text.toCharArray();
            for (int i = 0; i < stringToCharArray.length; i++)
            {

                  if (!Character.isWhitespace(stringToCharArray[i]))          
                  {                          
                        stringToCharArray[i] = (char)(((int)stringToCharArray[i] - (int)'a' + n)%26 + (int)'a');                    
                  }
            }
            sreturn = String.valueOf(stringToCharArray);
            return sreturn;
      }
       public static void main (String[] args)
       {
            Scanner scannerVariable = new Scanner(System.in);
            String s;
            Integer n = 0;
            String text, secrettext;

             System.out.println("-    Welcome to RotN_cryptography  -");
             System.out.println("------------------------------------");
             System.out.println("- This programm converts your text -");
             System.out.println("- into secret code. It just adds   -");
             System.out.println("- your input number to your text to-");
             System.out.println("- make the code unreadable.        -");
             System.out.println("------------------------------------");
             
            // Get Input String
            System.out.println("------------------------------------");
            System.out.println("- Input your secret text:          -");
            s = scannerVariable.nextLine();
            System.out.println("Input Text: " + s);
            while (!s.matches(".*\\w|\\s+.*") || s.matches(".*\\d.*"))                          // If something non-word Charakter is found or a number try again. but whitespace is ok.
            {
                 System.out.println("You did Input something non-alphabetik. Please try again");
                 s = scannerVariable.nextLine();
                 System.out.println("Input a Number: " + s);
            }
            text = s;

             // Get Input Number
             System.out.println("------------------------------------");
             System.out.println("- Input your number:               -");
             s = scannerVariable.nextLine();
             System.out.println("Input Number: " + s);
             while (s.matches(".*\\D.*"))                                              // If a non-Number is found try again
             {
                  System.out.println("You did not Input a Number. Please try again");
                  s = scannerVariable.nextLine();
                  System.out.println("Input a Number: " + s);
             }
             n = Integer.parseInt(s);

             // Rotate Code
             System.out.println("------------------------------------");
             secrettext = RotateText(n, text);
             System.out.println(secrettext);
             System.out.println("------------------------------------");

            scannerVariable.close();
       }
}