package com.yueyibo.self_study.homework;

public class HomeWork01 {
    public static void main(String[] args) {

    }

    public static void userRegister(String name,String pwd,String email){

        int userLength = name.length();
        if(userLength>=2 && userLength<=4){
            throw new RuntimeException("用户名长度为2或3或4");
        }

        if(!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码长度为6，且要求全是数字");
        }

        int i =email.indexOf('@');
        int j = email.indexOf('.');

        if(!(i>0 && i<j)){
            throw new RuntimeException("邮箱要存在@和.，且@在.前面");
        }
    }

    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;++i){
            if(chars[i]<'0' || chars[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
