package welcome;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //显示
        singleLinkedList.list();

    }
}

class SingleLinkedList{
    //初始化一个头节点,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为头节点不能动，因此我们需要一个辅助指针temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true){
            if(temp.next == null){
                break;
            }
            //如果没有找到最后
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;

    }
    //显示链表
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助指针temp
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//定义HeroNode，每个就是一个节点
class HeroNode{
    public int note;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器
    public HeroNode(int note,String name,String nickname){
        this.note = note;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString(){
        return "HeroNode[note=" + note +", name=" + name +",nickname="+nickname + "]";
    }
}
