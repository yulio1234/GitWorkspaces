

import java.util.Iterator;

/**
 * 
 * 类名称 ：MyStack<br>
 * 类描述：<br>
 * 创建人：余里<br>
 * 创建时间：2016年1月20日
 * @param <T>
 * @version
 */
public class MyStack<T> {
	private T[] element;
	private int size;
	private int topOfStack = -1;
	public MyStack(){
		this(10);
	}
	public MyStack(int length){
		element = (T[])new Object[length];
	}
	
	private void addElement(T t){
		if(element.length == size())
			swap(size * 2 + 1);
		element[++topOfStack] = t;
		size++;
	}

	public void push(T t){
		addElement(t);
	}
	
	public T pop(){
		T t = peek();
		removeElement(topOfStack--);
		size--;		
		
		return t;
	}
	
	public T peek(){
		if(size == 0)
			 throw new RuntimeException("没有数据错误,长度等于："+topOfStack);
			T t = element[topOfStack];
		return t;
	}
	
	private void removeElement(int length){
		element[length] = null;
	}
	
	public void clearAll(){
		element = (T[])new Object[10];
	}
	
	public T remove(int len){
		if(len < 0 || len >= size())
			throw new RuntimeException("越界");
		T t = element[len];
		for(int i = len;i> size()-1;i++){
			element[i] = element[i+1];
		}
		size--;
		return t;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	
	@SuppressWarnings("unchecked")
	private void swap(int length){
		T[] oldData = element;
		T[] newData = (T[])new Object[length]; 
		for(int i=0;i<oldData.length;i++){
			newData[i]=oldData[i];
		}
		element = newData;
	}
	public int size(){
		return this.size;
	}
	
	public Iterator<T> iterator(){
		return new MyStackIterrator();
	}
	public class MyStackIterrator implements java.util.Iterator<T>{
		int curr;
		
		@Override
		public boolean hasNext() {
			return curr != size();
		}

		@Override
		public T next() {
			if(!hasNext())
				throw new RuntimeException("没有下一个了");
			return element[curr++] ;
		}

		@Override
		public void remove() {
			if(curr <= 0 || curr > size())
				throw new RuntimeException("位置异常");
			MyStack.this.remove(--curr);
		}
		
	}
}
