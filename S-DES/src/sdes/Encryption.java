package sdes;

import java.util.Arrays;

public class Encryption {

	private String[] plainText;
	private String binary;
	private String binary2;
	private String ip_str;
	private String fk_str;
	private String sw_str;
	private String ipr_str;
	private String ep_str;
	private String s0;
	private String s1;
	private String sbox; // s0박스 + s1박스결과
	private String p4; // p4 치환값

	public void setS0(String s0) {
		this.s0 = s0;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS0() {
		return s0;
	}

	public String getS1() {
		return s1;
	}

	public String getSbox() {
		return sbox;
	}

	public void setSbox(String sbox) {
		this.sbox = sbox;
	}

	public String getP4() {
		return p4;
	}

	public void setP4(String p4) {
		this.p4 = p4;
	}

	public String getEp_str() {
		return ep_str;
	}

	public void setEp_str(String ep_str) {
		this.ep_str = ep_str;
	}

	public void setPlainText(String[] plainText) {
		this.plainText = plainText;
	}

	public String getPlainText() {
		String plainText = "";
		for (int i = 0; i < this.plainText.length; i++) {
			plainText += this.plainText[i];
		}
		return plainText;
	}

	public void setPlainText(String text) {
		this.plainText = text.split("");
	}

	public String getBinary() {
		return binary;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}

	public String getBinary2() {
		return binary2;
	}

	public void setBinary2(String binary2) {
		this.binary2 = binary2;
	}

	public String getIp_str() {
		return ip_str;
	}

	public void setIp_str(String ip_str) {
		this.ip_str = ip_str;
	}

	public String getFk_str() {
		return fk_str;
	}

	public void setFk_str(String fk_str) {
		this.fk_str = fk_str;
	}

	public String getSw_str() {
		return sw_str;
	}

	public void setSw_str(String sw_str) {
		this.sw_str = sw_str;
	}

	public String getIpr_str() {
		return ipr_str;
	}

	public void setIpr_str(String ipr_str) {
		this.ipr_str = ipr_str;
	}

	public void getIP(String binary) { // IP의 순열로 치환
		int[] permutation = { 2, 6, 3, 1, 4, 8, 5, 7 };

		String[] binaryArr = binary.split("");
		String IP = "";

		for (int i = 0; i < 8; i++) {
			if (binaryArr[permutation[i] - 1].equals("1")) {
				IP += "1";
			} else {
				IP += "0";
			}
		}

		setIp_str(IP);
	}

	public void getIPR(String binary) { // IP-의 순열로 치환
		int[] permutation = { 4, 1, 3, 5, 7, 2, 8, 6 };

		String[] binaryArr = binary.split("");
		String IPr = "";

		for (int i = 0; i < 8; i++) {
			if (binaryArr[permutation[i] - 1].equals("1")) {
				IPr += "1";
			} else {
				IPr += "0";
			}
		}

		setIpr_str(IPr);
	}

	public void EP(String ip) {
		String[] epArr = ip.split("");

		int[] permutation = { 4, 1, 2, 3, 2, 3, 4, 1 };

		String EP = "";
		for (int i = 0; i < 8; i++) {
			if (epArr[permutation[i] + 3].equals("1")) {
				EP += "1";
			} else {
				EP += "0";
			}
		}
		setEp_str(EP);
	}

	public void epXOR(String ep, String key1) { // EP와 key1 XOR연산
		String[] epArr = ep.split("");
		String[] key1Arr = key1.split("");

		String xor = "";
		for (int i = 0; i < 8; i++) {
			if (epArr[i].equals(key1Arr[i])) {
				xor += "0";
			} else {
				xor += "1";
			}
		}

		setS0("");
		setS1("0000");

		for (int i = 0; i < 4; i++) {
			s0 += xor.charAt(i) + "";
		}

		for (int i = 4; i < 8; i++) {
			s1 += xor.charAt(i) + "";
		}

	}

	public void p4XOR(String p4, String IP) { // p4와 IP의L 을 XOR 연산을 한 후 IP의 R과 이어붙이기

		String[] p4Arr = p4.split("");
		String[] IPArr = IP.split("");

		String xor = "";
		for (int i = 0; i < 4; i++) {
			if (p4Arr[i].equals(IPArr[i])) {
				xor += "0";
			} else {
				xor += "1";
			}
		}

		xor += IPArr[4] + IPArr[5] + IPArr[6] + IPArr[7];
		setFk_str(xor);
	}

	public void SW(String fk) {
		String[] arr = fk.split("");

		String sw = "";

		sw += arr[4] + arr[5] + arr[6] + arr[7];
		sw += arr[0] + arr[1] + arr[2] + arr[3];

		setSw_str(sw);

	}

	public void setS0Value(String s0) {
		int row = Integer.parseInt((s0.charAt(0) + "" + s0.charAt(3) + ""), 2);
		int col = Integer.parseInt((s0.charAt(1) + "" + s0.charAt(2) + ""), 2);

		int[][] s0Box = { { 1, 0, 3, 2 }, { 3, 2, 1, 0 }, { 0, 2, 1, 3 }, { 3, 1, 3, 2 } };

		if (s0Box[row][col] < 2) {
			setSbox("0" + Integer.toBinaryString(s0Box[row][col]));
		} else {
			setSbox(Integer.toBinaryString(s0Box[row][col]));
		}

	}

	public void setS1Value(String s1) {
		int row = Integer.parseInt((s1.charAt(4) + "" + s1.charAt(7) + ""), 2);
		int col = Integer.parseInt((s1.charAt(5) + "" + s1.charAt(6) + ""), 2);

		int[][] s1Box = { { 0, 1, 2, 3 }, { 2, 0, 1, 3 }, { 3, 0, 1, 0 }, { 2, 1, 0, 3 } };

		if (s1Box[row][col] < 2) {
			setSbox(getSbox() + "0" + Integer.toBinaryString(s1Box[row][col]));
		} else {
			setSbox(getSbox() + Integer.toBinaryString(s1Box[row][col]));
		}

	}

	public void P4(String sbox) {
		String[] sboxArr = sbox.split("");
		String result = "";

		int[] permutation = { 2, 4, 3, 1 };

		for (int i = 0; i < 4; i++) {
			if (sboxArr[permutation[i] - 1].equals("1")) {
				result += "1";
			} else {
				result += "0";
			}
		}
		setP4(result);

	}

	public void convertUnicode(String val) {
		for (int i = 0; i < val.length(); i++) {
			int code = val.codePointAt(i);
			// if (code < 128) { // 영어
			getBinaryArr(code, 8);
			// } else { // 한글
			// getBinaryArr(code, 16);
			// }
		}

	}

	public void convertUnicodeH(String val) {
		getBinaryArr((int) val.charAt(0), 16);
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

		if (length == 16) {
			bin = "";
			for (int i = 0; i < 8; i++) {
				bin += binaryArr[i];
			}
			setBinary(bin);
			bin = "";
			for (int i = 8; i < 16; i++) {
				bin += binaryArr[i];
			}
			setBinary2(bin);
		} else {
			for (int i = 0; i < binaryArr.length; i++) {
				bin += binaryArr[i];
			}
			setBinary(bin);
		}

	}

	public boolean isHangle(String binary) {
		String text = "";
		for (int i = 0; i < 8; i++) {
			text += binary.charAt(i);
		}

		if (text.equals("00000000")) {
			return true;
		} else {
			return false;
		}
	}

}
