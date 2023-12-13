package 基础数据结构.循环数组;

public class SafeArr {
    public static void main(String[] args) {
        SafeArr safeArr = new SafeArr(3);
        safeArr.add(1);
        safeArr.add(2);
        safeArr.add(3);
        System.out.println(safeArr.remove());
        System.out.println(safeArr.remove());
        System.out.println(safeArr.remove());
        System.out.println(safeArr.remove());
        safeArr.add(4);
        safeArr.add(5);
        System.out.println(safeArr.remove());
        System.out.println(safeArr.remove());
        System.out.println(safeArr.remove());
    }

    int size;
    int start;
    int end;
    int[] arr;

    public SafeArr(int N) {
        size = N;
        arr = new int[N];
        start = 0;
        end = 0;
    }
    
    public void add(int v) {
        if (isFull()) {
            System.out.println("满了");
        } else {
            arr[end] = v;
            end = (end + 1) % (size);
        }
    }
    
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int temp = arr[start];
        start = (start + 1) % (size);
        return temp;
    }

    private boolean isFull() {
        return (end + 1) % (size) == start;
    }

    private boolean isEmpty() {
        return start == end;
    }
}
