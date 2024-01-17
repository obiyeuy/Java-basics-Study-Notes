package com.yueyibo.self_study.file.stream.writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "d:\\idea\\java_learn\\src\\com.yueyibo.self_study\\file\\stream\\fileoutputstream.txt";
        //创建 FileWriter 对象
        FileWriter fileWriter = null;
        char[] chars = {'y', 'b', '与'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
            // 3) write(int):写入单个字符
            fileWriter.write('Y');
            // 4) write(char[]):写入指定数组
            fileWriter.write(chars);
            // 5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("哈工大".toCharArray(), 0, 3);
            // 6) write（string）：写入整个字符串
            fileWriter.write("你好~\n北京");
            fileWriter.write("风雨之后，定见彩虹\n");
            // 7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("山东威海", 0, 2);   //只写入山东
            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对应 FileWriter , 一定要关闭流，或者 flush 才能真正的把数据写入到文件
            /*看源码就知道原因.
            private void writeBytes() throws IOException {
                this.bb.flip();
                int var1 = this.bb.limit();
                int var2 = this.bb.position();
                assert var2 <= var1;
                int var3 = var2 <= var1 ? var1 - var2 : 0;
                if (var3 > 0) {
                    if (this.ch != null) {
                        assert this.ch.write(this.bb) == var3 : var3;
                    } else {
                        this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                    }
                }
                this.bb.clear();
            }
            */
            try {
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束...");
    }
}
