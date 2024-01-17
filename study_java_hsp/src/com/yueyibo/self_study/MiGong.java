package com.yueyibo.self_study;

public class MiGong {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        for(int i = 0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i = 0;i<8;++i){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[2][2]=1;

        System.out.println("地图");
        for(int i = 0;i<map.length;++i){
            for(int j = 0;j<map[0].length;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        T t = new T();
        t.findway(map,1,1);

        System.out.println("找路情况：");
        for(int i = 0;i<map.length;++i){
            for(int j = 0;j<map[0].length;++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}

//1. findWay 方法就是专门来找出迷宫的路径
//2. 如果找到，就返回 true ,否则返回 false
//3. map 就是二维数组，即表示迷宫
//4. i,j 就是老鼠的位置，初始化的位置为(1,1)
//5. 因为我们是递归的找路，所以我先规定 map 数组的各个值的含义:0 表示可以走 1 表示障碍物 2 表示可以走 3 表示走过，但是走不通是死路
//6. 当 map[6][5] =2 就说明找到通路,就可以结束，否则就继续找. //7. 先确定老鼠找路策略 下->右->上->左
class T{
    public boolean findway(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){
                map[i][j]=2;
                if(findway(map,i+1,j)){
                    return true;
                }else if(findway(map,i,j+1)){
                    return true;
                }else if(findway(map,i-1,j)){
                    return true;
                }else if(findway(map,i,j-1)){
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}