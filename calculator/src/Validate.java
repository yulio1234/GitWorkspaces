

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Validate {
	@SuppressWarnings("resource")
	public static void validate(String url) throws IOException{
		MyStack<Character> stack = new MyStack<Character>();
		File file = new File(url);
		InputStream is = new FileInputStream(file);
		
		Reader r = new InputStreamReader(is);
		BufferedReader in = new BufferedReader(r);
		int i = 0;
		int num = 0;
		while((i = in.read()) != -1){
			char c = (char)i;
			System.out.println(c);
			if(c == '{' || c=='(' || c == '['){
				stack.push(c);
			}else if(c == '}' || c == ')' || c == ']'){
				char s = close(c);
				char b = stack.pop();
				if(s != b){
					throw new RuntimeException("结束符号异常");
				}
			}
			num++;
		}
		if( stack.size() > 0){
			throw new RuntimeException("语句未正确结束");
		}
		System.out.println("检测字符数："+num);
		
	}
	public static char close(char c){
		switch(c){
		case '}':
			c = '{';
			break;
		case ')':
			c =  '(';
			break;
		case ']':
			c = '[';
			break;
		}
		return c;
	}
	public static void main(String[] args) throws IOException {
		validate("d:\\FpyzJbSxAction.java");
	}
}
