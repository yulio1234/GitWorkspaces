

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 类名称 ：MathList<br>
 * 类描述：将字符串转换成计算集合<br>
 * 创建人：余里<br>
 * 创建时间：2016年1月20日
 * @version 0.8
 */
public class MathList {
	List<String> math = new ArrayList<String>();
	public List<String> get(String str){
		int num = str.length();
		for(int i=0;i<num;i++){
			if(str.indexOf("*")==-1 && str.indexOf("+")==-1 && str.indexOf("(")==-1 && str.indexOf(")")==-1){
				return math;
			}
			if(str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '(' || str.charAt(i) == ')'){
				math.add(str.substring(0, i));
				math.add(str.substring(i, i+1));
				str = str.substring(i+1);
				get(str);
				math.add(str);
			}
		}
		return math;
	}
}
