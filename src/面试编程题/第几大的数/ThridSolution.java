package 面试编程题.第几大的数;

public class ThridSolution {
    public static void main(String[] args) {
        ThridSolution thridSolution = new ThridSolution();
        int[] arr = {5, 5, 4, 4, 5};
        System.out.println(thridSolution.getThird(arr));
    }

    public int getThird(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > first) {
                third = second;
                second = first;
                first = i;
            } else if (i > second && i < first) {
                third = second;
                second = i;
            } else if (i > third && i < second) {
                third = i;
            }
        }
        return third == Integer.MIN_VALUE ? first : third;
    }
}
