package welcome;

public class Demo1 {
    public static void main(String[] args) {
        //创建节点
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        Solution solution = new Solution();


        System.out.println(solution.ReverseList(l1));
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution {
    public ListNode ReverseList(ListNode head) {
        //处理空链表
        if(head == null)
            return null;
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            //断开链表，要记录后续一个
            ListNode temp = cur.next;
            //当前的next指向前一个
            cur.next = pre;
            //前一个更新为当前
            pre = cur;
            //当前更新为刚刚记录的后一个
            cur = temp;
        }
        return pre;
    }
}
