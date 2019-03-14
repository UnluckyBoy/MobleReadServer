package com.global.otherController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//I/O读取书籍内容
public class BookFileModel {
	public static String ReadFile(String filePath){
    	//Map<String ,Object> map=new HashMap<String, Object>();
    	StringBuffer stringBuffer=new StringBuffer();
    	try {
            String encoding = "UTF-8";
            File bookfile = new File(filePath);
            if (bookfile.isFile() && bookfile.exists())//是文件而且存在
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(
                		bookfile), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //System.out.print("文件内容：");
                while ((lineTxt = bufferedReader.readLine()) != null) {
                	//System.out.println(lineTxt);//原样输出读到的内容
                    //System.out.println(lineTxt);
                    if(!(lineTxt.equals(" "))){
                    	stringBuffer.append("\t\t"+lineTxt+"\n");
                    }
                    
                }
                //System.out.println("bookmap"+new String(stringBuffer));
                read.close();
                //return new String(stringBuffer);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return new String(stringBuffer);
    }
}
