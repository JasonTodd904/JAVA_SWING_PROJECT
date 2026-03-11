
import java.util.HashMap;

public class MorseCodeController
{
    private HashMap<Character,String> morseMap;
    public MorseCodeController()
    {
        morseMap=new HashMap<>();

         // uppercase
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");

        // lowercase
        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");

        // numbers
        morseMap.put('0', "-----");
        morseMap.put('1', ".----");
        morseMap.put('2', "..---");
        morseMap.put('3', "...--");
        morseMap.put('4', "....-");
        morseMap.put('5', ".....");
        morseMap.put('6', "-....");
        morseMap.put('7', "--...");
        morseMap.put('8', "---..");
        morseMap.put('9', "----.");

        // special characters
        morseMap.put(' ', "/");
        morseMap.put(',', "--..--");
        morseMap.put('.', ".-.-.-");
        morseMap.put('?', "..--..");
        morseMap.put(';', "-.-.-.");
        morseMap.put(':', "---...");
        morseMap.put('(', "-.--.");
        morseMap.put(')', "-.--.-");
        morseMap.put('[', "-.--.");
        morseMap.put(']', "-.--.-");
        morseMap.put('{', "-.--.");
        morseMap.put('}', "-.--.-");
        morseMap.put('+', ".-.-.");
        morseMap.put('-', "-....-");
        morseMap.put('_', "..--.-");
        morseMap.put('"', ".-..-.");
        morseMap.put('\'', ".----.");
        morseMap.put('/', "-..-.");
        morseMap.put('\\', "-..-.");
        morseMap.put('@', ".--.-.");
        morseMap.put('=', "-...-");
        morseMap.put('!', "-.-.--");
    }

    public String translate(String ToTranslate)
    {
        StringBuilder translatedText=new StringBuilder();
        for(Character letter :ToTranslate.toCharArray())
            translatedText.append(morseMap.get(letter)+" ");

        return translatedText.toString();
    }
}
