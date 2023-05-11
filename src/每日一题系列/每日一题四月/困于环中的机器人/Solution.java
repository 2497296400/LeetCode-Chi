package 每日一题系列.每日一题四月.困于环中的机器人;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        char[] array = instructions.toCharArray();
        int dircet = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : array) {
                if (c == 'G') {
                    switch (dircet) {
                        case 0 -> x += 1;
                        case 1 -> y += 1;
                        case 2 -> x -= 1;
                        case 3 -> y -= 1;
                    }
                } else if (c == 'L') {
                    dircet = (dircet + 1) % 4;
                } else if (c == 'R') {
                    if (dircet == 0) {
                        dircet = 3;
                    } else {
                        dircet -= 1;
                    }
                }
            }
        }
        return x == 0 && y == 0;
    }
}
