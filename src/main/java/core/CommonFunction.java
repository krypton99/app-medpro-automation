package core;

public class CommonFunction {
	public static String getTestDataPath(String testName) {
		return Constants.TEST_DATA_PATH + testName + ".xlsx";
	}
	
	public static long priceToLong(String price) {
		String substring;
		if(price.contains(" ")) {
			substring = price.split(" ")[1];
		} else {
			substring = price.substring(0, price.length()-1);
		}
		String[] newPrice = substring.split("\\.");
		long thousand = Integer.parseInt(newPrice[0]) * 1000;
		long unit = Integer.parseInt(newPrice[1]);
		return thousand + unit;
	}
}
