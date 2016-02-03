

import java.util.Iterator;

/**
 * 
 * 类名称 ：Conversion<br>
 * 类描述：将中缀表达式转换为后缀表达式<br>
 * 创建人：余里<br>
 * 创建时间：2016年1月14日
 * @version 1.0
 */
public class Conversion {
	private MyStack<String> stack = new MyStack<String>();
	private int innerNum;
	private int outerNum;
	private String exit = "";
	public String into(String[] str){
		for(int i=0;i<str.length;i++){
			if("(".equals(str[i])){
				stack.push(str[i]);
			}else if("+".equals(str[i])){
				if(stack.size()<= 0)
					stack.push(str[i]);
				else
					comparable(str[i]);
			}else if("*".equals(str[i])){
				if(stack.size()<= 0)
					stack.push(str[i]);
				else
					comparable(str[i]);
			}else if(")".equals(str[i])){
				while(!"(".equals(stack.peek()))
					exit += stack.pop();
				stack.pop();
			}else{
				exit += str[i];
			}
		}
		while(stack.size() > 0){
			exit += stack.pop();
		}
		return exit;
	}
	public void comparable(String outer){
		if(stack.size() <= 0){
			stack.push(outer);
			return;
		}
		innerNum = priority(stack.peek());
		outerNum = priority(outer);
		if(outerNum > innerNum){
			stack.push(outer);
			return;
		}else{
			String p = stack.pop();
			if(!"(".equals(p))
				exit += p;
			comparable(outer);
		}
	}
	public int priority(String c){
		if("(".equals(c))
			return 1;
		else if("+".equals(c))
			return 2;
		else if("*".equals(c))
			return 3;
		return 0;
	}
}
