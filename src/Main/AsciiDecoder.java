package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AsciiDecoder {
    public static String decode(List<Integer> arr) {

        ArrayList<Character> wordToReturn = new ArrayList<>();
        HashMap<Integer, Character> asciiMap = new HashMap<>();
        asciiMap.put(32, ' ');
        asciiMap.put(66, 'B');
        asciiMap.put(65, 'A');
        asciiMap.put(67, 'C');
        asciiMap.put(68, 'D');
        asciiMap.put(69, 'E');
        asciiMap.put(70, 'F');
        asciiMap.put(71, 'G');
        asciiMap.put(72, 'H');
        asciiMap.put(73, 'I');
        asciiMap.put(74, 'J');
        asciiMap.put(75, 'K');

        asciiMap.put(76, 'L');
        asciiMap.put(77, 'M');
        asciiMap.put(78, 'N');
        asciiMap.put(79, 'O');
        asciiMap.put(80, 'P');
        asciiMap.put(81, 'Q');
        asciiMap.put(82, 'R');
        asciiMap.put(83, 'S');
        asciiMap.put(84, 'T');
        asciiMap.put(85, 'U');
        asciiMap.put(86, 'V');

        asciiMap.put(87, 'W');
        asciiMap.put(88, 'X');
        asciiMap.put(89, 'Y');
        asciiMap.put(90, 'Z');
        asciiMap.put(97, 'a');
        asciiMap.put(98, 'b');
        asciiMap.put(99, 'c');
        asciiMap.put(100, 'd');
        asciiMap.put(101, 'e');
        asciiMap.put(102, 'f');
        asciiMap.put(103, 'g');

        asciiMap.put(104, 'h');
        asciiMap.put(105, 'i');
        asciiMap.put(106, 'j');
        asciiMap.put(107, 'k');
        asciiMap.put(108, 'l');
        asciiMap.put(109, 'm');
        asciiMap.put(110, 'n');
        asciiMap.put(111, 'o');
        asciiMap.put(112, 'p');
        asciiMap.put(113, 'q');
        asciiMap.put(114, 'r');

        asciiMap.put(115, 's');
        asciiMap.put(116, 't');
        asciiMap.put(117, 'u');
        asciiMap.put(118, 'v');
        asciiMap.put(119, 'w');
        asciiMap.put(120, 'x');
        asciiMap.put(121, 'y');
        asciiMap.put(122, 'z');

        for (int elem : arr) {
            if (asciiMap.containsKey(elem)) {
                wordToReturn.add(asciiMap.get(elem));
            } else {
                System.out.println("An error in decoding save name");
            }
        }
        StringBuilder strb = new StringBuilder();
        for (char i : wordToReturn) {
            strb.append(i);
        }
        return strb.toString();
    }
}