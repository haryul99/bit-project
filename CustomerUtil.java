package com.workshop.util;

import java.util.Scanner;

public class CustomerUtil {
	public static String getUserInput() {
		Scanner input=new Scanner(System.in);
		return input.nextLine();
	}
}
