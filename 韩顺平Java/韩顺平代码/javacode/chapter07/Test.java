
public class Test {   //������
    int count = 9; //����
    public void count1() { //Test��ĳ�Ա����
 			count=10;//���count��������  �ĳ� 10
        	System.out.println("count1=" + count); //10  
    }
    public void count2() {  //Test��ĳ�Ա����
        System.out.println("count1=" + count++);
    } 
   
   	//����Test���main����, �κ�һ���࣬������main
    public static void main(String args[]) {
       //�Ϻ����
       //1.  new Test()	���������� ��������ʹ�ú󣬾Ͳ���ʹ��
       //2.  new Test().count1() ���������������, �͵���count1()
       new Test().count1(); 
      
       Test t1= new Test();
       t1.count2();
       t1.count2();
    }
}
