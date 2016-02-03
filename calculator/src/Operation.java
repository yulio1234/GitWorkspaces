
/**
 * 
 * 类名称 ：Operation<br>
 * 类描述：计算方法<br>
 * 创建人：余里<br>
 * 创建时间：2016年1月20日
 * @version 1.0
 */
public class Operation {
	MyStack<Integer> stack = new MyStack<Integer>();
	public int operation(String str){
		Conversion con = new Conversion();
		char[] c = str.toCharArray();
		String [] strs = new String[c.length];
		for(int i=0;i<c.length;i++){
			strs[i] = String.valueOf(c[i]);
		}
		String str1 = con.into(strs);
		char[] number = str1.toCharArray();
		for(int i=0;i<number.length;i++){
			if(number[i] == '*'){
				int i1 = stack.pop();
				int i2 = stack.pop();
				stack.push(i1*i2);
			}else if(number[i] == '+'){
				int i1 = stack.pop();
				int i2 = stack.pop();
				stack.push(i1+i2);
			}else{
				int num = Integer.valueOf(String.valueOf(number[i]));
				stack.push(num);
			}
		}
		return stack.pop();
	}
}
