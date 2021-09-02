package in.co.Basics;

import java.util.Scanner;

public class Swichcase {

	public static void main(String[] args) {
		int age =56;
		System.out.println("enter the age");
		
		Scanner sc =new Scanner(System.in);
		age= sc.nextInt();
		
		switch (age) {
		case 18:
			System.out.println("you are in going to adult");
			break;
		case 23:
			System.out.println("you are in going to job");
			break;
		case 60:
			System.out.println("you are in going retired");
			break;
		default:
			System.out.println("ok enjoy your life");
			break;
		}
		/*
		 * if(age>56) {
		 * 
		 * System.out.println("you are expirenced"); } else if(age>45) {
		 * System.out.println("you are semi expirenced"); } else if(age>30) {
		 * System.out.println("you are semi semi expirenced"); } else {
		 * System.out.println("you are not expirenced"); }
		 */
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
