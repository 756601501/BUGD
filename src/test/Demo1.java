package test;

import java.nio.channels.NetworkChannel;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import redis.clients.jedis.Jedis;

public class Demo1 {

	public static void main(String[] args) {
		/*double a;
		a=200/(double)300;
		System.out.println(a);*/
		/*Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		System.out.println(calendar);*/
		//fun1();
		//String string=new String("sss");
		//String content="src=\"http://mmsns.qpic.cn/mmsns/ibT0NtFLEcbSHTdW2tGeaaVTSX1QHSBIh08iaPK9pjwhh3ta1dufXtCQ/0\"ddddddddsfe556erfsa<img src=\"http://mmsns.qpic.cn/mmsns/ibT0NtFLEcbSHTdW2tGeaaVTSX1QHSBIh08iaPK9pjwhh3ta1dufXtCQ/0\"";
		//content=fun2(content);
		//System.out.println(content);
		//Integer a=null;
		//System.out.println(a+1);
	}
	
	public static void fun1(){
		ResourceBundle bundle=ResourceBundle.getBundle("redis");
	}
	
	public static String  fun2(String content){
		System.out.println("ssss");
		String regex="src=\"[^\"]*\"";
		
		StringBuffer content2=new StringBuffer(content);
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(content);
		while(matcher.find()){
			//matcher.group().replace(matcher.group(), "123");
			//matcher.replaceAll("ddd");
			String str=matcher.group().substring(5, matcher.group().length()-1);
			//System.out.println(str);
			//content2.replace(start, end, str)
			//content2=new StringBuffer(content2.toString().replaceAll(str, "ddd"));
			content=content.replaceAll(str, "http://dsfsadf/mmmmmmm");
			
		}
		return content;
		//System.out.println(content);
//		String str="sdsfdd";
//		System.out.println(str.replaceAll("sd", "44"));
	}
	
	public static void fun3(){
		String str="srtvsvsd";
		System.out.println(str.substring(1, str.length()-1));
	}
	
	public static void fun4(){
		System.out.println(new Date().getTime());
	}

}
