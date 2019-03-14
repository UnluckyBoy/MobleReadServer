package com.global.otherController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//I/O��ȡ�鼮����
public class BookFileModel {
	public static String ReadFile(String filePath){
    	//Map<String ,Object> map=new HashMap<String, Object>();
    	StringBuffer stringBuffer=new StringBuffer();
    	try {
            String encoding = "UTF-8";
            File bookfile = new File(filePath);
            if (bookfile.isFile() && bookfile.exists())//���ļ����Ҵ���
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(
                		bookfile), encoding);//���ǵ������ʽ
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                //System.out.print("�ļ����ݣ�");
                while ((lineTxt = bufferedReader.readLine()) != null) {
                	//System.out.println(lineTxt);//ԭ���������������
                    //System.out.println(lineTxt);
                    if(!(lineTxt.equals(" "))){
                    	stringBuffer.append("\t\t"+lineTxt+"\n");
                    }
                    
                }
                //System.out.println("bookmap"+new String(stringBuffer));
                read.close();
                //return new String(stringBuffer);
            } else {
                System.out.println("�Ҳ���ָ�����ļ�");
            }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���");
            e.printStackTrace();
        }
        return new String(stringBuffer);
    }
}
