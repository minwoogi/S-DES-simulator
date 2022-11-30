package sdes;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;

public class SDES {

	private JFrame frmSdes;
	private JTextField plaintextField;
	private JTextField p10Field;
	private JTextField decryptField;
	private JTextField ipField;
	private JTextField ipdrField;
	private JTextField keyField;
	private JTextField lsField;
	private JTextField k1Field;
	private JTextField ls2Field;
	private JTextField k2Field;
	private JTextField fkField;
	private JTextField swField;
	private JTextField fk2Field;
	private JTextField ip2Field;
	private JTextField fkd2Field;
	private JTextField swdField;
	private JTextField fkdField;
	private JTextField ipdField;
	private JTextField encryption2;
	private JTextField encryptionField;
	private JLabel p10Lbl;
	private JLabel ls1Lbl;
	private JLabel k1Lbl;
	private JLabel k2Lbl;
	private JLabel ls2Lbl;
	private JLabel keyLbl;
	private JLabel ip2dLbl;
	private JLabel fk2dLbl;
	private JLabel swdLbl;
	private JLabel fkdLbl;
	private JLabel ipdLbl;
	private JLabel lblEncryption;
	private MakeKey makeKey;
	private Encryption encryption;
	private JButton btnReroad;
	private String encryptionText;

	public String getEncryptionText() {
		return encryptionText;
	}

	public void setEncryptionText(String encryptionText) {
		this.encryptionText = encryptionText;
	}

	public JButton getBtnReroad() {
		return btnReroad;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SDES window = new SDES();
		window.frmSdes.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public SDES() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		makeKey = new MakeKey();
		encryption = new Encryption();
		frmSdes = new JFrame();
		frmSdes.getContentPane().setBackground(new Color(255, 255, 255));
		frmSdes.setBackground(new Color(192, 192, 192));
		frmSdes.setForeground(new Color(192, 192, 192));
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage("icon\\lock_icon.png");
		frmSdes.setIconImage(icon);
		frmSdes.setTitle("SDES 추민욱");
		frmSdes.setBounds(100, 100, 734, 686);
		frmSdes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSdes.getContentPane().setLayout(null);

		JLabel key = new JLabel("Key");
		key.setFont(new Font("Consolas", Font.PLAIN, 20));
		key.setBounds(332, 35, 44, 39);
		frmSdes.getContentPane().add(key);

		JLabel plainText = new JLabel("plain Text");
		plainText.setFont(new Font("Consolas", Font.PLAIN, 20));
		plainText.setBounds(49, 35, 119, 39);
		frmSdes.getContentPane().add(plainText);

		JLabel decryptText = new JLabel("Decrypt Text");
		decryptText.setFont(new Font("Consolas", Font.PLAIN, 20));
		decryptText.setBounds(532, 31, 147, 47);
		frmSdes.getContentPane().add(decryptText);

		plaintextField = new JTextField();
		plaintextField.setBackground(SystemColor.window);
		plaintextField.setBounds(12, 68, 189, 69);
		frmSdes.getContentPane().add(plaintextField);
		plaintextField.setColumns(10);

		p10Field = new JTextField();
		p10Field.setFont(new Font("굴림", Font.BOLD, 12));
		p10Field.setBackground(SystemColor.activeCaption);
		p10Field.setEditable(false);
		p10Field.setColumns(10);
		p10Field.setBounds(264, 172, 189, 35);
		frmSdes.getContentPane().add(p10Field);

		decryptField = new JTextField();
		decryptField.setBackground(SystemColor.activeCaption);
		decryptField.setEditable(false);
		decryptField.setColumns(10);
		decryptField.setBounds(515, 68, 189, 69);
		frmSdes.getContentPane().add(decryptField);

		ipField = new JTextField();
		ipField.setFont(new Font("굴림", Font.BOLD, 12));
		ipField.setBackground(SystemColor.activeCaption);
		ipField.setEditable(false);
		ipField.setColumns(10);
		ipField.setBounds(12, 172, 189, 35);
		frmSdes.getContentPane().add(ipField);

		ipdrField = new JTextField();
		ipdrField.setFont(new Font("굴림", Font.BOLD, 12));
		ipdrField.setBackground(SystemColor.activeCaption);
		ipdrField.setEditable(false);
		ipdrField.setColumns(10);
		ipdrField.setBounds(515, 172, 189, 35);
		frmSdes.getContentPane().add(ipdrField);

		keyField = new JTextField();
		keyField.setBackground(SystemColor.window);
		keyField.setColumns(10);
		keyField.setBounds(264, 85, 189, 35);
		frmSdes.getContentPane().add(keyField);

		lsField = new JTextField();
		lsField.setFont(new Font("굴림", Font.BOLD, 12));
		lsField.setBackground(SystemColor.activeCaption);
		lsField.setEditable(false);
		lsField.setColumns(10);
		lsField.setBounds(264, 248, 189, 35);
		frmSdes.getContentPane().add(lsField);

		k1Field = new JTextField();
		k1Field.setFont(new Font("굴림", Font.BOLD, 12));
		k1Field.setBackground(SystemColor.activeCaption);
		k1Field.setEditable(false);
		k1Field.setColumns(10);
		k1Field.setBounds(264, 327, 189, 35);
		frmSdes.getContentPane().add(k1Field);

		ls2Field = new JTextField();
		ls2Field.setFont(new Font("굴림", Font.BOLD, 12));
		ls2Field.setBackground(SystemColor.activeCaption);
		ls2Field.setEditable(false);
		ls2Field.setColumns(10);
		ls2Field.setBounds(264, 397, 189, 35);
		frmSdes.getContentPane().add(ls2Field);

		k2Field = new JTextField();
		k2Field.setFont(new Font("굴림", Font.BOLD, 12));
		k2Field.setBackground(SystemColor.activeCaption);
		k2Field.setEditable(false);
		k2Field.setColumns(10);
		k2Field.setBounds(264, 465, 189, 35);
		frmSdes.getContentPane().add(k2Field);

		fkField = new JTextField();
		fkField.setFont(new Font("굴림", Font.BOLD, 12));
		fkField.setBackground(SystemColor.activeCaption);
		fkField.setEditable(false);
		fkField.setColumns(10);
		fkField.setBounds(12, 248, 189, 35);
		frmSdes.getContentPane().add(fkField);

		swField = new JTextField();
		swField.setFont(new Font("굴림", Font.BOLD, 12));
		swField.setBackground(SystemColor.activeCaption);
		swField.setEditable(false);
		swField.setColumns(10);
		swField.setBounds(12, 327, 189, 35);
		frmSdes.getContentPane().add(swField);

		fk2Field = new JTextField();
		fk2Field.setFont(new Font("굴림", Font.BOLD, 12));
		fk2Field.setBackground(SystemColor.activeCaption);
		fk2Field.setEditable(false);
		fk2Field.setColumns(10);
		fk2Field.setBounds(12, 397, 189, 35);
		frmSdes.getContentPane().add(fk2Field);

		ip2Field = new JTextField();
		ip2Field.setFont(new Font("굴림", Font.BOLD, 12));
		ip2Field.setBackground(SystemColor.activeCaption);
		ip2Field.setEditable(false);
		ip2Field.setColumns(10);
		ip2Field.setBounds(12, 465, 189, 35);
		frmSdes.getContentPane().add(ip2Field);

		fkd2Field = new JTextField();
		fkd2Field.setFont(new Font("굴림", Font.BOLD, 12));
		fkd2Field.setBackground(SystemColor.activeCaption);
		fkd2Field.setEditable(false);
		fkd2Field.setColumns(10);
		fkd2Field.setBounds(515, 248, 189, 35);
		frmSdes.getContentPane().add(fkd2Field);

		swdField = new JTextField();
		swdField.setFont(new Font("굴림", Font.BOLD, 12));
		swdField.setBackground(SystemColor.activeCaption);
		swdField.setEditable(false);
		swdField.setColumns(10);
		swdField.setBounds(515, 327, 189, 35);
		frmSdes.getContentPane().add(swdField);

		fkdField = new JTextField();
		fkdField.setFont(new Font("굴림", Font.BOLD, 12));
		fkdField.setBackground(SystemColor.activeCaption);
		fkdField.setEditable(false);
		fkdField.setColumns(10);
		fkdField.setBounds(515, 397, 189, 35);
		frmSdes.getContentPane().add(fkdField);

		ipdField = new JTextField();
		ipdField.setFont(new Font("굴림", Font.BOLD, 12));
		ipdField.setBackground(SystemColor.activeCaption);
		ipdField.setEditable(false);
		ipdField.setColumns(10);
		ipdField.setBounds(515, 465, 189, 35);
		frmSdes.getContentPane().add(ipdField);

		encryption2 = new JTextField();
		encryption2.setFont(new Font("굴림", Font.BOLD, 12));
		encryption2.setBackground(SystemColor.activeCaption);
		encryption2.setEditable(false);
		encryption2.setColumns(10);
		encryption2.setBounds(515, 539, 189, 69);
		frmSdes.getContentPane().add(encryption2);

		encryptionField = new JTextField();
		encryptionField.setFont(new Font("굴림", Font.BOLD, 12));
		encryptionField.setBackground(SystemColor.activeCaption);
		encryptionField.setEditable(false);
		encryptionField.setColumns(10);
		encryptionField.setBounds(12, 539, 189, 69);
		frmSdes.getContentPane().add(encryptionField);

		p10Lbl = new JLabel("P10");
		p10Lbl.setBounds(264, 159, 57, 15);
		frmSdes.getContentPane().add(p10Lbl);

		ls1Lbl = new JLabel("1bit Left Shift");
		ls1Lbl.setBounds(264, 234, 87, 15);
		frmSdes.getContentPane().add(ls1Lbl);

		k1Lbl = new JLabel("K1");
		k1Lbl.setBounds(264, 308, 57, 15);
		frmSdes.getContentPane().add(k1Lbl);

		k2Lbl = new JLabel("K2");
		k2Lbl.setBounds(264, 450, 57, 15);
		frmSdes.getContentPane().add(k2Lbl);

		ls2Lbl = new JLabel("2bit Left Shift");
		ls2Lbl.setBounds(264, 384, 97, 15);
		frmSdes.getContentPane().add(ls2Lbl);

		JLabel ipLbl = new JLabel("IP");
		ipLbl.setBounds(12, 159, 57, 15);
		frmSdes.getContentPane().add(ipLbl);

		JLabel fkLbl = new JLabel("fᵏ");
		fkLbl.setBounds(12, 234, 57, 15);
		frmSdes.getContentPane().add(fkLbl);

		JLabel swLbl = new JLabel("SW");
		swLbl.setBounds(12, 308, 57, 15);
		frmSdes.getContentPane().add(swLbl);

		JLabel fk2Lbl = new JLabel("fᵏ");
		fk2Lbl.setBounds(12, 384, 57, 15);
		frmSdes.getContentPane().add(fk2Lbl);

		JLabel ip2Lbl = new JLabel("IP⁻");
		ip2Lbl.setBounds(12, 450, 57, 15);
		frmSdes.getContentPane().add(ip2Lbl);

		JLabel encryptionLbl = new JLabel("Encryption");
		encryptionLbl.setBounds(12, 523, 71, 15);
		frmSdes.getContentPane().add(encryptionLbl);

		btnReroad = new JButton("REROAD");
		btnReroad.setEnabled(false);
		JButton runBtn = new JButton("RUN");
		runBtn.setBackground(SystemColor.activeCaption);
		runBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (plaintextField.getText().equals("") && keyField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "평문과 Key값을 입력하지 않았습니다.");
				} else if (plaintextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "평문을 입력하지 않았습니다.");
				} else if (keyField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Key값을 입력하지 않았습니다.");
				} else {

					btnReroad.setEnabled(false);
					runBtn.setEnabled(false);

					String[] plain = plaintextField.getText().split("");
					FocusThread th = new FocusThread(plain);
					Thread thread = new Thread(th);

					keyField.setEditable(false);
					plaintextField.setEditable(false);
					thread.start();
				}
			}
		});
		runBtn.setBounds(310, 536, 97, 35);
		frmSdes.getContentPane().add(runBtn);

		btnReroad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				keyField.setEditable(true);
				plaintextField.setEditable(true);

				runBtn.setEnabled(true);
				btnReroad.setEnabled(false);

				makeKey = new MakeKey();
				encryption = new Encryption();

				plaintextField.setText("");
				keyField.setText("");
				p10Field.setText("");
				lsField.setText("");
				ls2Field.setText("");
				k1Field.setText("");
				k2Field.setText("");

				encryptionField.setText("");
				encryption2.setText("");
				ipField.setText("");
				fk2Field.setText("");
				fkField.setText("");
				swField.setText("");
				ip2Field.setText("");

				decryptField.setText("");
				ipdrField.setText("");
				swdField.setText("");
				fkd2Field.setText("");
				fkdField.setText("");
				ipdField.setText("");

			}

		});
		btnReroad.setBackground(SystemColor.activeCaption);
		btnReroad.setBounds(310, 574, 97, 34);
		frmSdes.getContentPane().add(btnReroad);

		keyLbl = new JLabel("0~1023");
		keyLbl.setBounds(264, 68, 57, 15);
		frmSdes.getContentPane().add(keyLbl);

		ip2dLbl = new JLabel("IP⁻");
		ip2dLbl.setBounds(515, 159, 57, 15);
		frmSdes.getContentPane().add(ip2dLbl);

		fk2dLbl = new JLabel("fᵏ");
		fk2dLbl.setBounds(515, 234, 57, 15);
		frmSdes.getContentPane().add(fk2dLbl);

		swdLbl = new JLabel("SW");
		swdLbl.setBounds(515, 308, 57, 15);
		frmSdes.getContentPane().add(swdLbl);

		fkdLbl = new JLabel("fᵏ");
		fkdLbl.setBounds(515, 384, 57, 15);
		frmSdes.getContentPane().add(fkdLbl);

		ipdLbl = new JLabel("IP");
		ipdLbl.setBounds(515, 450, 57, 15);
		frmSdes.getContentPane().add(ipdLbl);

		lblEncryption = new JLabel("Encryption");
		lblEncryption.setBounds(515, 523, 71, 15);
		frmSdes.getContentPane().add(lblEncryption);
	}

	public class FocusThread implements Runnable {

		String[] plain;

		public FocusThread(String[] plain) {
			this.plain = plain;
		}

		public void run() {
			try {
				setP10Text();
				Thread.sleep(300);
				setFieldBlur(p10Field);
				setlsText();
				Thread.sleep(300);
				setFieldBlur(lsField);
				setK1Text();
				Thread.sleep(300);
				setFieldBlur(k1Field);
				setls2Text();
				Thread.sleep(300);
				setFieldBlur(ls2Field);
				setK2Text();
				Thread.sleep(300);
				setFieldBlur(k2Field);
			} catch (InterruptedException e1) {
			}

			for (int i = 0; i < plain.length; i++) {
				try {
					savePlainText(plain[i]);
					encryption.convertUnicodeH(encryption.getPlainText());
					if (encryption.isHangle(encryption.getBinary())) {
						setIPText();
						Thread.sleep(300);
						setFieldBlur(ipField);
						setFk1Text();
						Thread.sleep(300);
						setFieldBlur(fkField);
						setSWText();
						Thread.sleep(300);
						setFieldBlur(swField);
						setFk2Text();
						Thread.sleep(300);
						setFieldBlur(fk2Field);
						setIprText();
						Thread.sleep(300);
						setFieldBlur(ip2Field);
						setEncryptionText();
						Thread.sleep(300);
						setIpdText();
						Thread.sleep(300);
						setFieldBlur(ipdField);
						setfkdText();
						Thread.sleep(300);
						setFieldBlur(fkdField);
						setswdText();
						Thread.sleep(300);
						setFieldBlur(swdField);
						setfkd2Text();
						Thread.sleep(300);
						setFieldBlur(fkd2Field);
						setIpdrText();
						Thread.sleep(300);
						setFieldBlur(ipdrField);
						setDecryptText();
						Thread.sleep(300);
					} else {

						setIPH1Text();
						Thread.sleep(300);
						setFieldBlur(ipField);
						setFk1Text();
						Thread.sleep(300);
						setFieldBlur(fkField);
						setSWText();
						Thread.sleep(300);
						setFieldBlur(swField);
						setFk2Text();
						Thread.sleep(300);
						setFieldBlur(fk2Field);
						setIprText();
						setAlpaValue();
						Thread.sleep(300);
						setFieldBlur(ip2Field);

						setIPH2Text();
						Thread.sleep(300);
						setFieldBlur(ipField);
						setFk1Text();
						Thread.sleep(300);
						setFieldBlur(fkField);
						setSWText();
						Thread.sleep(300);
						setFieldBlur(swField);
						setFk2Text();
						Thread.sleep(300);
						setFieldBlur(fk2Field);
						setIprText();
						Thread.sleep(300);
						setFieldBlur(ip2Field);
						setHEncryptionText();

						savePlainText(encryption2.getText().charAt(i) + "");
						Thread.sleep(300);
						setIpdH1Text();
						Thread.sleep(300);
						setFieldBlur(ipdField);
						setfkdText();
						Thread.sleep(300);
						setFieldBlur(fkdField);
						setswdText();
						Thread.sleep(300);
						setFieldBlur(swdField);
						setfkd2Text();
						Thread.sleep(300);
						setFieldBlur(fkd2Field);
						setIpdrText();
						setDAlpaValue();
						Thread.sleep(300);
						setFieldBlur(ipdrField);

						Thread.sleep(300);
						setIpdH2Text();
						Thread.sleep(300);
						setFieldBlur(ipdField);
						setfkdText();
						Thread.sleep(300);
						setFieldBlur(fkdField);
						setswdText();
						Thread.sleep(300);
						setFieldBlur(swdField);
						setfkd2Text();
						Thread.sleep(300);
						setFieldBlur(fkd2Field);
						setIpdrText();
						Thread.sleep(300);
						setFieldBlur(ipdrField);
						setHDecryptText();

						Thread.sleep(300);

					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			getBtnReroad().setEnabled(true);
		}
	}

	public void setP10Text() {
		makeKey.getBinaryArr(Integer.parseInt(keyField.getText()), 10);
		makeKey.getP10(makeKey.getBinary());
		p10Field.setText(makeKey.getP10str());
		setFieldFocus(p10Field);
	}

	public void setlsText() {
		makeKey.getLS1(makeKey.getP10str());
		lsField.setText(makeKey.getLs1str());
		setFieldFocus(lsField);

	}

	public void setK1Text() {
		makeKey.setKey1(makeKey.getKey(makeKey.getLs1str()));
		k1Field.setText(makeKey.getKey1());
		setFieldFocus(k1Field);

	}

	public void setls2Text() {
		makeKey.getLS2(makeKey.getLs1str());
		ls2Field.setText(makeKey.getLs2str());
		setFieldFocus(ls2Field);
	}

	public void setK2Text() {
		makeKey.setKey2(makeKey.getKey(makeKey.getLs2str()));
		k2Field.setText(makeKey.getKey2());
		setFieldFocus(k2Field);

	}

	public void savePlainText(String str) {

		encryption.setPlainText(str);
	}

	public void setIPText() {
		encryption.convertUnicode(encryption.getPlainText());
		encryption.getIP(encryption.getBinary());
		ipField.setText(encryption.getIp_str());
		setFieldFocus(ipField);
	}

	public void setIPH1Text() {
		encryption.getIP(encryption.getBinary());
		ipField.setText(encryption.getIp_str());
		setFieldFocus(ipField);
	}

	public void setIPH2Text() {
		encryption.getIP(encryption.getBinary2());
		ipField.setText(encryption.getIp_str());
		setFieldFocus(ipField);
	}

	public void setFk1Text() {
		encryption.EP(encryption.getIp_str());
		encryption.epXOR(encryption.getEp_str(), makeKey.getKey1());
		encryption.setS0Value(encryption.getS0());
		encryption.setS1Value(encryption.getS1());
		encryption.P4(encryption.getSbox());
		encryption.p4XOR(encryption.getP4(), encryption.getIp_str());
		fkField.setText(encryption.getFk_str());
		setFieldFocus(fkField);
	}

	public void setSWText() {
		encryption.SW(encryption.getFk_str());
		swField.setText(encryption.getSw_str());
		encryption.setIp_str(encryption.getSw_str());
		setFieldFocus(swField);
	}

	public void setFk2Text() {
		encryption.EP(encryption.getIp_str());
		encryption.epXOR(encryption.getEp_str(), makeKey.getKey2());
		encryption.setS0Value(encryption.getS0());
		encryption.setS1Value(encryption.getS1());
		encryption.P4(encryption.getSbox());
		encryption.p4XOR(encryption.getP4(), encryption.getIp_str());
		fk2Field.setText(encryption.getFk_str());
		setFieldFocus(fk2Field);
	}

	public void setIprText() {
		encryption.getIPR(encryption.getFk_str());
		ip2Field.setText(encryption.getIpr_str());
		setFieldFocus(ip2Field);
	}

	public void setEncryptionText() {
		int alpa = Integer.parseInt(encryption.getIpr_str(), 2);
		char calpa = (char) alpa;
		encryptionField.setText(encryptionField.getText() + calpa + "");
		encryption2.setText(encryption2.getText() + calpa + "");
	}

	public void setAlpaValue() {
		setEncryptionText(encryption.getIpr_str());
	}

	public void setHEncryptionText() {

		int code = Integer.parseInt(getEncryptionText() + encryption.getIpr_str(), 2);
		String uni = String.format("%04x", code);
		Character c = (char) Integer.parseInt(uni, 16);
		encryptionField.setText(encryptionField.getText() + c.toString());
		encryption2.setText(encryption2.getText() + c.toString());

	}

	public void setIpdText() {
		encryption.convertUnicode(encryption2.getText());
		encryption.getIP(encryption.getBinary());
		ipdField.setText(encryption.getIp_str());
		setFieldFocus(ipdField);

	}

	public void setIpdH1Text() {
		encryption.convertUnicodeH(encryption.getPlainText());
		encryption.getIP(encryption.getBinary());
		ipdField.setText(encryption.getIp_str());
		setFieldFocus(ipdField);
	}

	public void setIpdH2Text() {
		encryption.getIP(encryption.getBinary2());
		ipdField.setText(encryption.getIp_str());
		setFieldFocus(ipdField);
	}

	public void setfkdText() {
		encryption.EP(encryption.getIp_str());
		encryption.epXOR(encryption.getEp_str(), makeKey.getKey2());
		encryption.setS0Value(encryption.getS0());
		encryption.setS1Value(encryption.getS1());
		encryption.P4(encryption.getSbox());
		encryption.p4XOR(encryption.getP4(), encryption.getIp_str());
		fkdField.setText(encryption.getFk_str());
		setFieldFocus(fkdField);
	}

	public void setswdText() {
		encryption.SW(encryption.getFk_str());
		swdField.setText(encryption.getSw_str());
		encryption.setIp_str(encryption.getSw_str());
		setFieldFocus(swdField);
	}

	public void setfkd2Text() {
		encryption.EP(encryption.getIp_str());
		encryption.epXOR(encryption.getEp_str(), makeKey.getKey1());
		encryption.setS0Value(encryption.getS0());
		encryption.setS1Value(encryption.getS1());
		encryption.P4(encryption.getSbox());
		encryption.p4XOR(encryption.getP4(), encryption.getIp_str());
		fkd2Field.setText(encryption.getFk_str());
		setFieldFocus(fkd2Field);
	}

	public void setIpdrText() {
		encryption.getIPR(encryption.getFk_str());
		ipdrField.setText(encryption.getIpr_str());
		setFieldFocus(ipdrField);
	}

	public void setDecryptText() {
		int alpa = Integer.parseInt(encryption.getIpr_str(), 2);
		char calpa = (char) alpa;
		decryptField.setText(decryptField.getText() + calpa + "");
	}

	public void setDAlpaValue() {
		setEncryptionText(encryption.getIpr_str());
	}

	public void setHDecryptText() {
		int code = Integer.parseInt(getEncryptionText() + encryption.getIpr_str(), 2);
		String uni = String.format("%04x", code);
		Character c = (char) Integer.parseInt(uni, 16);
		decryptField.setText(decryptField.getText() + c.toString());
	}

	public void setFieldFocus(JTextField tf) {
		tf.setForeground(Color.RED);
		tf.setBorder(BorderFactory.createLineBorder(Color.RED));
	}

	public void setFieldBlur(JTextField tf) {
		tf.setForeground(Color.black);
		tf.setBorder(BorderFactory.createEmptyBorder());
	}

}