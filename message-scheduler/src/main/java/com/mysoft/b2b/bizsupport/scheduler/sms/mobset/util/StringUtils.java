package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringUtils {

	public static final String replace(String line, String oldString,
			String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	public static final String replace(String line, String oldString,
			String newString, int[] count) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			int counter = 0;
			++counter;
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				++counter;
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			count[0] = counter;
			return buf.toString();
		}
		return line;
	}
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   }if("".equals(str)){
			   return false; 
		   }
		   return true; 
	}
	public static String getTaskStatue(long statue){ 
		   if( 0 == statue ){
		       return "0- �����ϴ�"; 
		   }if( 1 == statue ){
		       return "1- ����"; 
		   }if( 2 == statue ){
		       return "2- �����"; 
		   }if( 3 == statue ){
		       return "3- ���ʧ��"; 
		   }if( 4 == statue ){
		       return "4- ���ڷ���"; 
		   }if( 5 == statue ){
		       return "5- ����"; 
		   }if( 6 == statue ){
		       return "6- ǿ��ֹͣ"; 
		   }if( 7 == statue ){
		       return "7- �������"; 
		   }if( 8 == statue ){
		       return "8- �û����"; 
		   }if( 9 == statue ){
		       return "9- �û����2"; 
		   }if( 10 == statue ){
		       return "10- �û����ʧ��"; 
		   }
		   return "�������"+statue; 
	}
}
