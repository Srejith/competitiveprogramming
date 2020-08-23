/**
 * String = "xyz"
 * key = 2
 *
 * Result = "zab"
 */

public class Encryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        char[] result = new char[str.length()];
        for(int i=0;i<str.length();i++) {

            char character = str.charAt(i);
            int ascii = (int) character;
            ascii+=(key%26);
            if(ascii>=123){
                ascii= (ascii % 123) + 97;
            }
            character = (char) ascii;
            result[i] = (char) character;

        }
        return new String(result);
    }
}
