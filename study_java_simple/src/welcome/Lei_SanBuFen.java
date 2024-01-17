public class Lei_SanBuFen {
    //属性
    int id;
    String sname;
    int age;

    //方法
    void study(){
        System.out.println("fly" );

    }
    //构造方法（方法名与类名保持一致）
    Lei_SanBuFen(){   //无参构造器
    }

    public static void main(String[]args){
        Lei_SanBuFen s1=new Lei_SanBuFen();
        s1.id=1001;
        s1.sname="yyb";
        s1.study();
        System.out.println(s1.id);
        System.out.println(s1.sname);

    }
}


