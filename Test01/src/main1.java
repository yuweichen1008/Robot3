
public class main1 {
	private static String[] respo = new String[] { "59", "45", "52", "43", "20", "00", "68", "00", "01", "01", "00",
			"00", "00", "00", "00", "00", "39", "39", "39", "39", "39", "39", "39", "39", "8a", "00", "01", "00", "01",
			"02", "00", "00", "01", "00", "00", "00", "00", "00", "00", "00", "01", "00", "00", "00", "e8", "03", "00",
			"00", "11", "00", "00", "00", "fc", "c7", "0e", "00", "7c", "ce", "00", "00", "6b", "19", "05", "00", "ff",
			"0d", "ed", "ff", "d4", "45", "f2", "ff", "b4", "7a", "f7", "ff", "00", "00", "00", "00", "00", "00", "00",
			"00", "00", "00", "00", "00", "01", "00", "00", "00", "03", "00", "00", "00", "00", "00", "00", "00", "00",
			"00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00",
			"00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00", "00" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] x = a(respo);
		System.out.println(x[3]);
	}
	public static byte[] a(String[] s) {
		int length = s.length;
		byte[] data = new byte[1024];
		for (int j = 0; j < length; j++) {
			for (int i = 0; i <= 2; i += 2) {
				data[(j * 4) + (i / 2)] =  (byte) ((Character.digit(respo[j].charAt(0), 16) << 4)+ (Character.digit(respo[j].charAt(0 + 1), 16)));
			}
		}
		for (int i = 0; i < data.length; i++) {
			if ((i + 1) % 4 == 0 && i != 0) {
				byte[] first = { data[i - 3], data[i - 2] };
				byte[] second = { data[i - 1], data[i] };
				data[i - 3] = second[1];
				data[i - 2] = second[0];
				data[i - 1] = first[1];
				data[i] = first[0];
				System.out.println(
						"OBYTES" + i + " : " + data[i - 3] + " " + data[i - 2] + " " + data[i - 1] + " " + data[i]);
			}
		}
		return data;
	    }
}
