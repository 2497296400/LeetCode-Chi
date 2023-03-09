package 字符串修改字典序;

public class LetterDictionaryString {
    public static void main(String[] args) {
        String s = "accefecb";
        System.out.println(remove(s));
    }

    public static String remove(String s) {
        if(s==null||s.length()<2){
            return s;
        }
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int minACSIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (--map[s.charAt(i)] == 0) {
                minACSIndex = s.charAt(minACSIndex) > s.charAt(i) ? i : minACSIndex;
                break;
            } else {
                minACSIndex = s.charAt(minACSIndex) > s.charAt(i) ? i : minACSIndex;
            }
        }
        return (s.charAt(minACSIndex) + remove(s.substring(minACSIndex + 1).replaceAll(String.valueOf(s.charAt(minACSIndex)), "")));
    }
}
