package Add_Branches;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		Random r=new Random();
		double a = Math.random();
		
		System.out.println(a*10000000000l);
long b = (long) a*10000000000l;
System.out.println(b);

long p=r.nextLong(10000000000l);

System.out.println(p);


	}

}
