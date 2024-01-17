package welcome;

public class Demo3 {
    public static void main(String[] args) {
        Node head = new Node(1);
        int[] value = {2,3};
        Node temp = head;

        for (int i = 0 ; i< value.length;i++) {
            Node node = new Node(value[i]);
            temp.next = node;
            temp = temp.next;
        }
        printList(head);

// 反序输出一个单链表
        head = reverse(head);
        printList(head);

    }
    public static void printList(Node head) {
        while(head!=null) {
            System.out.print(head.value + "\t");
            head = head.next;
        }
        System.out.println();
    }
    public static Node reverse(Node head) {
        Node pre = null;
        Node post = null;

        while(head!=null) {
            post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }
        return pre;
    }
    public static Node reverseSingleList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
class Node {
    public int value;
    public Node next;
    public Node(int value) {
        this.value = value;
    }
}


