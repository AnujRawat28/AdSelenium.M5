package practice;

public class MethodCallinng {

	public static void main(String[] args) 
	{

		int sum = add(20, 40);
		System.out.println(sum);
	}

	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}
}
