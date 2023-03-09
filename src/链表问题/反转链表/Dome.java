package 链表问题.反转链表;

public class Dome {
    public static void main(String[] args) {
        Solution01 s=new Solution01();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
        l1.next.next.next=new ListNode(4);
        Solution s1=new Solution();
        //l1=    s1.reverseList(l1);
        Test test=new Test();
        l1= test.res(l1);
       while (l1!=null){
           System.out.println(l1.val);
           l1=l1.next;
       }
    }
}
