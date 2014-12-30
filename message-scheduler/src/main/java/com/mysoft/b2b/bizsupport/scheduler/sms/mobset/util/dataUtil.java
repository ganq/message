package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsFileGroup;

/**
 * ������
 * 
 * ��һЩ���õĹ��߷���
 * @author lvone
 * @version 1.0
 */
public class dataUtil {
public static String id="000001";
	
	/**
	 * ���һ��id�����ڷ��Ͷ���
	 * 
	 * @return ����id
	 */
	public String getID(){
		if("999999".equals(id)){
			id="000001";
		}
		try{
			int intid=Integer.parseInt(id);
			intid+=1;
			id=Integer.toString(intid);
			int size=id.length();
			if(size<6){
			for(int i=0;i<6-size;i++){
				id="0"+id;
			}
			//if(size)
			}else{
				return id;
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	/**
	 * utf-8����ת����GB2312����
	 * 
	 * @param str Ҫת�����ַ����
	 * @return ��ת�����ַ�
	 */
	public static String utf8Togb2312(String str){
	      StringBuffer sb = new StringBuffer();
	      for(int i=0; i<str.length(); i++) {
	          char c = str.charAt(i);
	          switch (c) {
	             case '+':
	                 sb.append(' ');
	             break;
	             case '%':
	                 try {
	                      sb.append((char)Integer.parseInt(
	                      str.substring(i+1,i+3),16));
	                 }
	                 catch (NumberFormatException e) {
	                     throw new IllegalArgumentException();
	                }
	                i += 2;
	                break;
	             default:
	                sb.append(c);
	                break;
	           }
	      }
	      // Undo conversion to external encoding
	      String result = sb.toString();
	      String res=null;
	      try{
	          byte[] inputBytes = result.getBytes("8859_1");
	          res= new String(inputBytes,"UTF-8");
	      }
	      catch(Exception e){}
	      return res;
	}
	
	/**
	 * 
	 * ��ɲ��ŷ��������MmsFileGroup[] �����ʽ
	 * 
	 * @param imgUrl ����ͼƬ
	 * @param count	   ��������
	 * @return  ���������MmsFileGroup����
	 */
	public static MmsFileGroup[] makeMmsFile(String imgUrl,String count){
		
		//ͨ�������ļ���ȡ��ҳ��Ʒ��ʾ����
//		String filePath=Properties.GetPropertise("resource", "filepath");
		
		MmsFileGroup mm=new MmsFileGroup();
		
		mm.setText_FileName("aa.txt");

		try {
			mm.setText_Content(new String(count.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mm.setImage_FileData(dataUtil.getByteArray(imgUrl));
		String fileName="";
		if(imgUrl.lastIndexOf(".")!=-1){
			fileName=imgUrl.substring(imgUrl.lastIndexOf("."),imgUrl.length());
		}
		mm.setImage_FileName("send"+fileName);
		mm.setPlayTime(0);
		MmsFileGroup[] mmsFile={mm};
		return mmsFile;
	}
	
	/**
	 * ͼƬ������ת��
	 * 
	 * @param imgurl  ����ͼƬ
	 * @return	ͼƬ�Ķ����Ƹ�ʽ
	 */
	public static byte[] getByteArray(String imgurl) {
		byte[] xml=null;
        try{
	        File file = new File(imgurl);//deploy file
	        BufferedInputStream  br  =  new  BufferedInputStream(new  FileInputStream(file)); 
	        if(br!=null){
	            int len=br.available();
	            xml=new byte[len];
	            br.read(xml);
	            //����file�е�����ȫ������byte[]������
	            //����ļ������ı���Ϣ��ô�� String str=new String(xml,"utf-8");�Ϳ��Եõ���������
	        }
        }catch(Exception ex) {
            ex.printStackTrace();            
        }
        return xml;

    }
	
	public static String getTxtContent(String imgurl) {
		byte[] xml=null;
		String str = "";
        try{
	        File file = new File(imgurl);//deploy file
	        BufferedInputStream  br  =  new  BufferedInputStream(new  FileInputStream(file)); 
	        if(br!=null){
	            int len=br.available();
	            xml=new byte[len];
	            br.read(xml);
	            //����file�е�����ȫ������byte[]������
	            //����ļ������ı���Ϣ��ô���Ϳ��Եõ���������
	            str=new String(xml,"utf-8");
	        }
        }catch(Exception ex) {
            ex.printStackTrace();            
        }
        return str;

    }
	
	/*public static void main(String[] arg){
		dataUtil dutil=new dataUtil();
		
		byte[] b=dutil.getByteArray("d:\\test.jpg");
		System.out.print(b[1]);
	}*/
}
