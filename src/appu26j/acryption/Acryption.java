package appu26j.acryption;

public class Acryption
{
    private Acryption()
    {
    }
    
    public static String encrypt(String regularText, String key)
    {
        if (key.length() < regularText.length())
        {
            key = wrap(key, regularText.length(), true);
        }
        
        StringBuilder encryptedText = new StringBuilder();
        int index = 0;
        
        for (char character : regularText.toCharArray())
        {
            encryptedText.append((char) (character + key.charAt(index)));
            index++;
        }
        
        return encryptedText.toString();
    }
    
    public static String decrypt(String encryptedText, String key)
    {
        if (key.length() < encryptedText.length())
        {
            key = wrap(key, encryptedText.length(), true);
        }
        
        StringBuilder regularText = new StringBuilder();
        int index = 0;
        
        for (char character : encryptedText.toCharArray())
        {
            regularText.append((char) (character - key.charAt(index)));
            index++;
        }
        
        return regularText.toString();
    }
    
    private static String wrap(String text, int letters, boolean reverse)
    {
        char[] charArray = text.toCharArray();
        
        for (int i = 0; i < charArray.length; i++)
        {
            char character = charArray[reverse ? (charArray.length - 1 - i) : i];
            text += character;
            
            if (text.length() == letters)
            {
                return text;
            }
        }
        
        return wrap(text, letters, !reverse);
    }
}
