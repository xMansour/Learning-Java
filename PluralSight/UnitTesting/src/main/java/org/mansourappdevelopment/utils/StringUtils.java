package org.mansourappdevelopment.utils;

public class StringUtils {
    public static boolean isPalindromes(String element) {
        if (element.length() % 2 == 0)
            return false;
        else {
            for (int i = 0; i < element.length() / 2; i++) {
                if (element.charAt(i) != element.charAt(element.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

    }
}
