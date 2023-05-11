package 周赛.三百四十一场.第三题;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addMinimum("aaaaac"));
    }

    public int addMinimum(String word) {
        char[] chars = word.toCharArray();
        int l = 0;
        int sum = 0;
        while (l < chars.length) {
            if (chars[l] != 'a') {
                if (chars[l] == 'b') {
                    if (l + 1 < chars.length) {
                        if (chars[l + 1] == 'c') {
                            sum += 1;
                            l++;
                        } else {
                            sum += 2;
                        }
                    } else {
                        sum += 2;
                    }
                } else {
                    sum += 2;
                }
                l++;
            } else {
                if (l + 1 < chars.length) {
                    if (chars[l + 1] == 'c') {
                        sum += 1;
                        l+=2;
                    } else if (chars[l + 1] == 'b') {
                        if (l + 2 < chars.length) {
                            if (chars[l + 2] == 'c') {
                                l += 3;
                                continue;
                            }
                        }
                        l+=2;
                        sum++;
                    } else {
                        l++;
                        sum += 2;
                    }
                } else {
                    l++;
                    sum += 2;
                }
            }

        }
        return sum;
    }
}
