package sdes;

public class MakeKey {

	private String binary;
	private String p10_str;
	private String ls1_str;
	private String ls2_str;
	private String key1;
	private String key2;

	public String getBinary() {
		return binary;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}

	public String getP10str() {
		return p10_str;
	}

	public void setP10str(String p10) {
		this.p10_str = p10;
	}

	public String getLs1str() {
		return ls1_str;
	}

	public void setLs1str(String ls1) {
		this.ls1_str = ls1;
	}

	public String getLs2str() {
		return ls2_str;
	}

	public void setLs2str(String ls2) {
		this.ls2_str = ls2;
	}

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		this.key1 = key1;
	}

	public String getKey2() {
		return key2;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public void getBinaryArr(int key, int length) {
		String bin = Integer.toBinaryString(key);
		String[] binaryArr = new String[length];

		if (bin.length() < length) {
			for (int i = 0; i < length - bin.length(); i++) {
				binaryArr[i] = "0";
			}
			for (int i = length - bin.length(); i < length; i++) {
				binaryArr[i] = bin.substring(i - (length - bin.length()), i - (length - bin.length()) + 1);

			}
		} else {
			for (int i = 0; i < bin.length(); i++) {
				binaryArr[i] = bin.charAt(i) + "";
			}
		}

		bin = "";
		for (int i = 0; i < binaryArr.length; i++) {
			bin += binaryArr[i];
		}
		setBinary(bin);

	}

	public void getP10(String binary) {
		String[] binaryArr = binary.split("");
		int[] permutation = { 3, 5, 2, 7, 4, 10, 1, 9, 8, 6 };
		String p = "";

		for (int i = 0; i < 10; i++) {
			if (binaryArr[permutation[i] - 1].equals("1")) {
				p += "1";
			} else {
				p += "0";
			}
		}
		setP10str(p);
	}

	public void getLS1(String p10) { // Left Shift 1bit
		String[] p10Arr = p10.split("");

		String temp = p10Arr[0];
		String temp2 = p10Arr[5];

		for (int i = 0; i < 4; i++) {
			p10Arr[i] = p10Arr[i + 1];
		}
		p10Arr[4] = temp;
		for (int i = 5; i < 9; i++) {
			p10Arr[i] = p10Arr[i + 1];
		}
		p10Arr[9] = temp2;

		String ls = "";
		for (int i = 0; i < p10Arr.length; i++) {
			ls += p10Arr[i];
		}

		setLs1str(ls);
	}

	public void getLS2(String LS1) { // Left Shift 2bit
		String[] LSArr = LS1.split("");

		String temp = LSArr[0];
		String temp2 = LSArr[1];
		String temp3 = LSArr[5];
		String temp4 = LSArr[6];

		for (int i = 0; i < 3; i++) {
			LSArr[i] = LSArr[i + 2];
		}
		LSArr[3] = temp;
		LSArr[4] = temp2;
		for (int i = 5; i < 8; i++) {
			LSArr[i] = LSArr[i + 2];
		}
		LSArr[8] = temp3;
		LSArr[9] = temp4;

		String LS2 = "";
		for (int i = 0; i < LSArr.length; i++) {
			LS2 += LSArr[i];
		}

		setLs2str(LS2);
	}

	public String getKey(String LS) { // P8의 순열로 치환
		String[] LSArr = LS.split("");

		int[] permutation = { 6, 3, 7, 4, 8, 5, 10, 9 };

		String[] key1 = new String[8];

		for (int i = 0; i < 8; i++) {
			if (LSArr[permutation[i] - 1].equals("1")) {
				key1[i] = "1";
			} else {
				key1[i] = "0";
			}
		}
		String key = "";

		for (int i = 0; i < key1.length; i++) {
			key += key1[i];
		}

		return key;
	}

}