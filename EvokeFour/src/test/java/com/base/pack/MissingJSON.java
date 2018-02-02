package com.base.pack;

public class MissingJSON {

	private static final String EMPTY = null;

	public static String difference(String str1, String str2) {
		if (str1 == null) {
			return str2;
		}
		if (str2 == null) {
			return str1;
		}
		int at = indexOfDifference(str1, str2);
		if (at == INDEX_NOT_FOUND) {
			return EMPTY;
		}
		return str2.substring(at);
	}

	private static final int INDEX_NOT_FOUND = 0;

	public static int indexOfDifference(String str1, String str2) {
		if (str1 == str2) {
			return INDEX_NOT_FOUND;
		}
		if (str1 == null || str2 == null) {
			return 0;
		}
		int i;
		for (i = 0; i < str1.length() && i < str2.length(); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
		}
		if (i < str2.length() || i < str1.length()) {
			return i;
		}
		return INDEX_NOT_FOUND;
	}

	public static void main(String[] args) {

		String str1 = "RaghuRam";
		String str2 = "RaghuRamYadav";

		int data = indexOfDifference(str1, str2);

		System.out.println(data);

		String sec = difference(str1, str2);

		System.out.println(sec);

	}

}
