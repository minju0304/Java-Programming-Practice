import java.util.*;
public class SimpleCalculator {

public static class OutOfRangeException extends Exception {
	OutOfRangeException(String msg){
		super(msg);
	}
}
public static class AddZeroException extends Exception {
	AddZeroException(String msg){
		super(msg);
	}
}
public static class SubtractZeroException extends Exception {
	SubtractZeroException(String msg){
		super(msg);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0,b=0;
		String input;
		char operator = 0;
		Scanner sc = new Scanner(System.in);
		input = sc.next();
		String[] ab = null;
		int result=0;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)==43) {
				operator='+';
				ab = input.split("\\+");
				a=Integer.parseInt(ab[0]);
				b=Integer.parseInt(ab[1]);
				result=a+b;
				break;
			}
			else if(input.charAt(i)=='-'){
				operator='-';
				ab = input.split("-");
				a=Integer.parseInt(ab[0]);
				b=Integer.parseInt(ab[1]);
				result=a-b;
				break;
			}
		}
		try {
			if(a==0||b==0) {
				if(operator=='-') {
					throw new SubtractZeroException("SubtractZeroException");
				}
				else {
					throw new AddZeroException("AddZeroException");
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		try {
			if((a<0||a>1000)||(b<0||b>1000)||(result<0||result>1000)) {
				throw new OutOfRangeException("OutOfRangeException");
			}
		}catch(OutOfRangeException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println(result);
	}
}
