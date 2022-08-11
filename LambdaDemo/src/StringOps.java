public class StringOps {
    public String reverse(String str) {
        String resultStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            resultStr += str.charAt(i);
        }
        return resultStr;
    }
}
