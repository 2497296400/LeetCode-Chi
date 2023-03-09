package 每日一题系列.每日一题十月.水果成篮;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 0, 1, 1};
        System.out.println(solution.totalFruit(arr));
    }

    public int totalFruit(int[] fruits) {
        int ans = 0;
        int sum = 0;
        Data fisrt = null;
        Data second = null;
        int size = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (size < 2 || fisrt.fr == second.fr) {
                if (fisrt == null) {
                    fisrt=new Data(fruits[i],i);
                }else {
                    second=new Data(fruits[i],i);
                    fisrt=new Data(fruits[i-1],i-1);

                }
                sum++;
                size++;
            } else {
                if (fruits[i] != fisrt.fr && fruits[i] != second.fr) {
                    if (fisrt.index < second.index) {
                        sum = i - fisrt.index - 1;
                        fisrt = new Data(fruits[i], i);
                    } else {
                        sum = i - second.index - 1;
                        second = new Data(fruits[i], i);
                    }
                } else {
                    if (fruits[i] == fisrt.fr) {
                        fisrt.index = i;
                    } else {
                        second.index = i;
                    }
                }
                sum++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}

class Data {
    int fr;
    int index;

    public Data(int fr, int index) {
        this.fr = fr;
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        return fr == data.fr;
    }

    @Override
    public int hashCode() {
        return fr;
    }
}
