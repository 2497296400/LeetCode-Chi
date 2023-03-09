package 每日一题系列.每日一题九月.最大交换;



public class SOlution {
    public static void main(String[] args) {
        SOlution sOlution = new SOlution();
        System.out.println(sOlution.maximumSwap(98368));
    }

    public int maximumSwap(int num) {
        String value = String.valueOf(num);
        char[] chars = value.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                break;
            }
            char max = chars[i];
            int curIndex = i;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] >= max) {
                    curIndex = j;
                    max = chars[j];

                }
            }
            if(i!=curIndex&&chars[i]!=chars[curIndex]){
                char temp = chars[i];
                chars[i]=chars[curIndex];
                chars[curIndex]=temp;
                flag=true;
            }
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
