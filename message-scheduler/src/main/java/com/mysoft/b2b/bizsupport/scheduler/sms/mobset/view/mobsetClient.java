package com.mysoft.b2b.bizsupport.scheduler.sms.mobset.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.DataObjectBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.mmsResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.msmResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.bean.taskResultBean;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.factory.DataObjectFactory;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms.mms_GetFileStatus;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms.mms_GetReport;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms.mms_Send;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.mms.mms_UpFile;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms.Sms_GetBalance;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms.sms_GetRecv;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms.sms_GetReport;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms.sms_GetSign;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.sms.sms_Send;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_DelFile;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_GetSmsStatus;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_MmsSend;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_MmsStop;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_SmsSend;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_SmsStop;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.task.task_UpFile;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsFileGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MmsIDGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobileFileGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.MobsetApiSoap;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.SmsIDGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.SmsRecvGroup;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.tempuri.holders.ArrayOfSmsReportListHolder;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.AudoiFileFilter;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.ImageFileFilter;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.StringUtils;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.TextFileFilter;
import com.mysoft.b2b.bizsupport.scheduler.sms.mobset.util.dataUtil;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JSeparator;

import java.awt.SystemColor;

class ZPanel extends JPanel {
	private Image image;
	private int imgwidth;
	private int imgHeight;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	public int getImgwidth() {
		return imgwidth;
	}

	public void setImgwidth(int imgwidth) {
		this.imgwidth = imgwidth;
	}

	public void setImagePath(String imgPath) {
		try {
			System.out.println(imgPath);
			image = ImageIO.read(new FileInputStream(imgPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (image != null) {
			setImgwidth(image.getWidth(this));
			setImgHeight(image.getHeight(this));
		}
	}

	public void paintComponent(Graphics g1) {
		// System.out.println("000000000000000000000000000: "+image);
		int x = 0;
		int y = 0;
		Graphics g = (Graphics) g1;
		if (null == image) {
			return;
		}
		g.drawImage(image, x, y, 163, 155, this);
		g = null;
	}
}

public class mobsetClient extends JFrame {

	private JTextField txtSendNum;
	private JTextField txtImage;
	private JTextField txtText;
	private JTextField txtTitle;
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	private JTable table;
	private JTextField txtPasswd;
	private JTextField txtServer;
	private JTextField txtMsgId;
	private JTextField txtSendState;
	private JTextField txtAudoi;
	private JTextField txtFileID;
	private JTextField txtMobile;
	private JTextField txtmmsID;
	private JTextField txtAssigID;
	private JTextField txtNumUrl;
	private JTextField txtNumTitle;
	private JTextField txtNumID;
	private JTextField txtSmsTaskID;

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("user.timezone", "Asia/Shanghai");
					mobsetClient frame = new mobsetClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public mobsetClient() {
		super();
		final JTextField textField_2 = new JTextField();
		final JTextField txtCordId = new JTextField();
		txtCordId.setText("300000");
		final JTextField txtUserName = new JTextField();
		txtUserName.setText("admin");
		final JButton button = new JButton();
		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataObjectBean bean = DataObjectFactory.getInstance();
				bean.setCordId("");
				bean.setPasswd("");
				bean.setServerIP("");
				bean.setUserName("");
			}
		});
		final JButton button_3 = new JButton();
		final JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				System.exit(0);
			}
		});
		getContentPane().setLayout(new BorderLayout());
		setTitle("Sms_Client");
		setBounds(100, 100, 696, 467);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JTabbedPane tabbedPane = new JTabbedPane();
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("�ʺŵ�½", null, panel, null);

		final JLabel lblSms = DefaultComponentFactory.getInstance()
				.createLabel("Sms\u4FE1\u606F\u767B\u5F55");
		lblSms.setForeground(new Color(0, 0, 255));
		lblSms.setFont(new Font("Dialog", Font.BOLD, 30));
		lblSms.setBounds(197, 10, 212, 69);
		panel.add(lblSms);

		final JLabel label_1 = DefaultComponentFactory.getInstance()
				.createLabel("��ҵID��");
		label_1.setForeground(new Color(0, 0, 255));
		label_1.setFont(new Font("���ķ���", Font.BOLD, 16));
		label_1.setBounds(148, 89, 75, 29);
		panel.add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("���ķ���", Font.BOLD, 18));
		label_2.setText(" \u5E10  \u53F7\uFF1A");
		label_2.setBounds(148, 128, 75, 29);
		panel.add(label_2);

		txtCordId.setBounds(229, 89, 192, 29);
		panel.add(txtCordId);

		txtUserName.setBounds(229, 128, 192, 29);
		panel.add(txtUserName);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				DataObjectBean bean = DataObjectFactory.getInstance();
				bean.setCordId(txtCordId.getText());
				bean.setPasswd(txtPasswd.getText());
				bean.setServerIP(txtServer.getText());
				bean.setUserName(txtUserName.getText());
				if ("".equals(txtPasswd.getText())) {
				} else {
					button_2.setEnabled(true);
				}
			}
		});
		button.setText("�û���¼");
		button.setBounds(148, 252, 86, 28);
		panel.add(button);

		button_2.setEnabled(false);
		button_2.setText("ע���û�");
		button_2.setBounds(261, 252, 86, 28);
		panel.add(button_2);

		button_3.setText("�˳�ϵͳ");
		button_3.setBounds(372, 252, 86, 28);
		panel.add(button_3);

		final JLabel label_3 = new JLabel();
		label_3.setText("��ʾ��");
		label_3.setBounds(110, 303, 49, 18);
		panel.add(label_3);

		textField_2.setEditable(false);
		textField_2.setInheritsPopupMenu(false);
		textField_2.setBounds(165, 301, 293, 22);
		panel.add(textField_2);
		textField_2.setText("......����������ӳɹ���");

		txtPasswd = new JTextField();
		txtPasswd.setBounds(229, 167, 192, 29);
		txtPasswd.setText("");
		panel.add(txtPasswd);

		JLabel label = new JLabel();
		label.setText(" \u5BC6  \u7801\uFF1A");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("���ķ���", Font.BOLD, 18));
		label.setBounds(148, 167, 75, 29);
		panel.add(label);

		txtServer = new JTextField();
		txtServer.setBounds(229, 206, 192, 29);
		panel.add(txtServer);

		JLabel label_38 = new JLabel();
		label_38.setText(" \u670D\u52A1\u5668\uFF1A");
		label_38.setForeground(Color.BLUE);
		label_38.setFont(new Font("���ķ���", Font.BOLD, 16));
		label_38.setBounds(148, 206, 75, 29);
		panel.add(label_38);

		JLabel label_14 = new JLabel();
		label_14.setText("");
		label_14.setBounds(10, 10, 585, 18);
		/*
		 * ģ�������;
		 */
		final Object cols[] = { "֡���", "�ı��ļ�", "ͼ���ļ�", "�����ļ�", "" };
		final Object rows[][] = {};
		panel_2.setLayout(null);
		tabbedPane.addTab("���Ų���", null, panel_2, null);

		final JLabel label_18 = new JLabel();
		label_18.setFont(new Font("����", Font.PLAIN, 16));
		label_18.setText("\u76EE\u6807\u53F7\u7801\uFF1A");
		label_18.setBounds(23, 15, 85, 33);
		panel_2.add(label_18);

		final JLabel label_19 = new JLabel();
		label_19.setFont(new Font("����", Font.PLAIN, 16));
		label_19.setText("\u53D1\u9001\u5185\u5BB9\uFF1A");
		label_19.setBounds(23, 58, 85, 33);
		panel_2.add(label_19);

		txtSendNum = new JTextField();
		txtSendNum.setBounds(118, 22, 191, 22);
		panel_2.add(txtSendNum);

		final JTextArea txtSendContent = new JTextArea();
		txtSendContent.setBounds(118, 65, 214, 102);
		panel_2.add(txtSendContent);

		JLabel lblMsmid = new JLabel();
		lblMsmid.setText("MsgID\uFF1A");
		lblMsmid.setFont(new Font("����", Font.PLAIN, 16));
		lblMsmid.setBounds(353, 15, 56, 33);
		panel_2.add(lblMsmid);

		txtMsgId = new JTextField();
		txtMsgId.setBounds(408, 45, 168, 22);
		panel_2.add(txtMsgId);

		JLabel label_17 = new JLabel();
		label_17.setText("\u72B6\u6001\u62A5\u544A\uFF1A");
		label_17.setFont(new Font("����", Font.PLAIN, 16));
		label_17.setBounds(342, 77, 87, 40);
		panel_2.add(label_17);

		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msmResultBean smsBean = sms_Send.SendMsg(txtSendNum.getText(),
						txtSendContent.getText());
				SmsIDGroup[] smsIDGroup = smsBean.getSmsIDList().value;
				String msgId = "";
				if(smsIDGroup != null){
					for (int i = 0; i < smsIDGroup.length; i++) {
						msgId += ((Long) smsIDGroup[i].getSmsID()).toString();
						msgId += ";";
					}
				}
				JOptionPane.showMessageDialog(mobsetClient.this, smsBean
						.getErrMsg().value);
				txtMsgId.setText(msgId);
			}
		});
		button_1.setText("\u53D1\u9001\u77ED\u4FE1");
		button_1.setBounds(102, 187, 86, 28);
		panel_2.add(button_1);

		txtSendState = new JTextField();
		txtSendState.setBounds(408, 112, 168, 22);
		panel_2.add(txtSendState);

		JButton button_8 = new JButton();
		button_8.setText("\u83B7\u53D6\u72B6\u6001\u62A5\u544A");
		button_8.setBounds(235, 187, 114, 28);
		panel_2.add(button_8);

		JButton button_9 = new JButton();
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msmResultBean bean = Sms_GetBalance.getRecv();
				long balance = 0;
				if(bean.getBalance() != null){
					balance = bean.getBalance().value;
				}
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value
						+ "\r\n ���ʺŵ�ʣ���������" + balance);
			}
		});
		button_9.setText("\u83B7\u53D6\u77ED\u4FE1\u4F59\u989D");
		button_9.setBounds(398, 187, 114, 28);
		panel_2.add(button_9);

		JButton button_10 = new JButton();
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msmResultBean bean = sms_GetSign.getSign();
				String sign = "";
				if(bean.getBalance() != null){
					sign = bean.getSign().value;
				}
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value
						+ "\r\n ���ʺŵĶ��Ŷ���ǩ��" + sign);
			}
		});
		button_10.setText("\u83B7\u53D6\u77ED\u4FE1\u7B7E\u540D");
		button_10.setBounds(327, 225, 114, 28);
		panel_2.add(button_10);

		JButton button_11 = new JButton();
		button_11.setText("\u83B7\u53D6\u4E0A\u884C\u77ED\u4FE1");
		button_11.setBounds(175, 225, 114, 28);
		panel_2.add(button_11);

		final JTextArea txtReContent = new JTextArea();
		txtReContent.setBounds(38, 273, 538, 83);
		panel_2.add(txtReContent);

		JLabel label_20 = new JLabel();
		label_20.setText("\u83B7\u53D6\u4FE1\u606F\uFF1A");
		label_20.setFont(new Font("����", Font.PLAIN, 16));
		label_20.setBounds(23, 234, 85, 33);
		panel_2.add(label_20);
		final JPanel panel_1 = new JPanel();

		panel_1.setLayout(null);
		tabbedPane.addTab("���Ų���", null, panel_1, null);

		final JLabel label_4 = new JLabel();
		label_4.setText("\u5F69\u4FE1\u6807\u9898\uFF1A");
		label_4.setBounds(20, 40, 66, 18);
		panel_1.add(label_4);

		final JLabel label_5 = new JLabel();
		label_5.setText("\u6587\u672C\u6587\u4EF6\uFF1A");
		label_5.setBounds(20, 68, 66, 18);
		panel_1.add(label_5);

		final JLabel label_6 = new JLabel();
		label_6.setText("\u56FE\u50CF\u6587\u4EF6\uFF1A");
		label_6.setBounds(20, 94, 66, 18);
		panel_1.add(label_6);

		final JLabel label_7 = new JLabel();
		label_7.setText("\u58F0\u97F3\u6587\u4EF6\uFF1A");
		label_7.setBounds(20, 122, 66, 18);
		panel_1.add(label_7);

		txtTitle = new JTextField();
		txtTitle.setBounds(84, 38, 277, 22);
		panel_1.add(txtTitle);

		txtText = new JTextField();
		txtText.setBounds(84, 66, 277, 22);
		panel_1.add(txtText);

		txtImage = new JTextField();
		txtImage.setBounds(84, 92, 277, 22);
		panel_1.add(txtImage);

		JSeparator separator = new JSeparator();
		separator.setBounds(424, 22, -413, 12);
		panel_1.add(separator);

		final JComponent separator1 = DefaultComponentFactory.getInstance()
				.createSeparator("�����ļ�");
		separator1.setBounds(10, 10, 427, 18);
		panel_1.add(separator1);

		final JComponent separator2 = DefaultComponentFactory.getInstance()
				.createSeparator("���ŷ���");
		separator2.setBounds(447, 10, 202, 18);
		panel_1.add(separator2);

		final JComponent separator3 = DefaultComponentFactory.getInstance()
				.createSeparator("����״̬");
		separator3.setBounds(447, 129, 202, 18);
		panel_1.add(separator3);

		final JComponent separator4 = DefaultComponentFactory.getInstance()
				.createSeparator("������");
		separator4.setBounds(20, 338, 629, 18);
		panel_1.add(separator4);

		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 154, 417, 138);
		panel_1.add(scrollPane_1);

		table = new JTable(rows, cols);
		// setTableConfig(table);
		scrollPane_1.setViewportView(table);

		txtAudoi = new JTextField();
		txtAudoi.setBounds(84, 122, 277, 22);
		panel_1.add(txtAudoi);

		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msmResultBean bean = sms_GetRecv.getRecv();

				String recMsg = "";
				if(bean.getSmsRecvList().value!=null){
					SmsRecvGroup[] recvList = bean.getSmsRecvList().value;
					for (int i = 0; i < recvList.length; i++) {
						recMsg += recvList[i].getContent();
						recMsg += "\r\n";
					}
					try {
						txtReContent.setText(new String(recMsg.getBytes("gbk"),"UTF-8"));
						txtReContent.setText(recMsg);
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value);
			}
		});

		JButton button_4 = new JButton("\u6D4F\u89C8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new TextFileFilter(
						"txt;smil"));
				int result = fileChooser.showOpenDialog(mobsetClient.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getPath();
					txtText.setText(filePath);
				}
			}
		});
		button_4.setBounds(371, 66, 66, 23);
		panel_1.add(button_4);

		JButton button_5 = new JButton("\u6D4F\u89C8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new ImageFileFilter(
						"jpg;gif"));
				int result = fileChooser.showOpenDialog(mobsetClient.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getPath();
					txtImage.setText(filePath);
				}
			}
		});
		button_5.setBounds(371, 92, 66, 23);
		panel_1.add(button_5);

		JButton button_6 = new JButton("\u6D4F\u89C8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new AudoiFileFilter(
						"mid;midi;amr"));
				int result = fileChooser.showOpenDialog(mobsetClient.this);

				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getPath();
					txtAudoi.setText(filePath);
				}
			}
		});
		button_6.setBounds(371, 120, 66, 23);
		panel_1.add(button_6);

		txtFileID = new JTextField();
		txtFileID.setBounds(534, 40, 115, 22);
		panel_1.add(txtFileID);

		txtMobile = new JTextField();
		txtMobile.setBounds(534, 68, 115, 22);
		txtMobile.setText("15018445516");
		panel_1.add(txtMobile);

		JLabel lblid = new JLabel();
		lblid.setText("\u6587\u4EF6 ID\uFF1A");
		lblid.setBounds(458, 40, 66, 18);
		panel_1.add(lblid);

		JLabel label_9 = new JLabel();
		label_9.setText("\u76EE\u6807\u53F7\u7801\uFF1A");
		label_9.setBounds(458, 68, 66, 18);
		panel_1.add(label_9);

		JButton button_7 = new JButton("\u53D1\u9001");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!button_2.isEnabled()) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"����ȷ�ϵ�¼��ť��");
					return;
				}
				String mobiles = txtMobile.getText();
				long mmsFileID = new Long(txtFileID.getText());
				mmsResultBean bean = mms_Send.SendMsg(mobiles, mmsFileID);
				String MmsIDs = "";
				MmsIDGroup[] mmsIDGroup = bean.getMmsIDList().value;
				if (mmsIDGroup != null) {
					for (int i = 0; i < mmsIDGroup.length; i++) {
						MmsIDs += mmsIDGroup[i].getMmsID();
						if (i < mmsIDGroup.length - 1) {
							MmsIDs += ";";
						}
					}
				}
				txtmmsID.setText(MmsIDs);
				JOptionPane.showMessageDialog(mobsetClient.this, "���Ͳ��ŷ���ֵ��"
						+ bean.getErrMsg().value);
			}
		});
		button_7.setBounds(458, 96, 66, 23);
		panel_1.add(button_7);

		txtmmsID = new JTextField();
		txtmmsID.setBounds(534, 96, 115, 22);
		panel_1.add(txtmmsID);

		JButton button_12 = new JButton("\u83B7\u53D6\u72B6\u6001");
		button_12.setEnabled(false);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (button_2.isEnabled()) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"����ȷ�ϵ�¼��ť��");
					return;
				}
				mms_GetReport.getReport(txtmmsID.getText());
			}
		});
		button_12.setBounds(457, 157, 92, 23);
		panel_1.add(button_12);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(454, 190, 195, 138);
		textArea
				.setText("ʹ��˵����\r\n  1��������ҵID���ʺš����롣"
						+"\r\n  2��ѡ��ÿ֡��Ӧ���ز��ļ���\r\n      �������֡��\r\n  "
						+"3������ϴ������ļ���\r\n  4�������ֻ���벢������Ͳ��š�"
						+"\r\n  5��������������������ļ�ID����\r\n      �ϴ������ļ����ļ�ID���ύ����");
		panel_1.add(textArea);

		JButton button_13 = new JButton("\u63D2\u5165\u5E27");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowCount = 0;
				int colCount = 0;
				rowCount = table.getRowCount();
				colCount = table.getColumnCount();
				Object newrows[][] = new Object[rowCount][colCount];
				int urlCount = 0;

				if (!"".equals(txtText.getText())) {
					urlCount++;
				}
				if (!"".equals(txtImage.getText())) {
					urlCount++;
				}
				if (!"".equals(txtAudoi.getText())) {
					urlCount++;
				}
				if (urlCount < 1) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"��ѡ���ϴ��Ĳ����ļ���");
					return;
				}

				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < colCount; j++) {
						newrows[i][j] = table.getValueAt(i, j);
					}
				}

				int k = rowCount;
				for (int i = 0; i < rowCount; i++) {
					if (table.isRowSelected(i)) {
						k = i + 1;
					}
				}
				Object rows2[][] = new Object[rowCount + 1][colCount];
				int count = 0;
				for (int i = 0; i <= rowCount; i++) {
					if (i == k) {
						Object row[] = { i + 1, txtText.getText(),
								txtImage.getText(), txtAudoi.getText(), "" };
						rows2[i] = row;
					} else {
						rows2[i] = newrows[count];
						rows2[i][0] = i + 1;
						count++;
					}
				}
				table = new JTable(rows2, cols);
				scrollPane_1.setViewportView(table);
				txtText.setText("");
				txtImage.setText("");
				txtAudoi.setText("");
			}
		});
		button_13.setBounds(17, 302, 79, 23);
		panel_1.add(button_13);

		JButton button_14 = new JButton("\u5220\u9664\u5E27");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowCount = 0;
				int colCount = 0;
				rowCount = table.getRowCount();
				colCount = table.getColumnCount();
				if (rowCount <= 0)
					return;
				Object newrows[][] = new Object[rowCount][colCount];

				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < colCount; j++) {
						newrows[i][j] = table.getValueAt(i, j);
					}
				}

				int k = rowCount;
				for (int i = 0; i < rowCount; i++) {
					if (table.isRowSelected(i)) {
						k = i;
					}
				}
				Object rows2[][] = new Object[rowCount - 1][colCount];
				int count = 0;
				for (int i = 0; i < rowCount; i++) {
					if (i == k) {
					} else if (rowCount > 1) {
						rows2[count] = newrows[i];
						rows2[count][0] = count + 1;
						count++;
					}
					if (count == rowCount - 1)
						break;
				}
				table = new JTable(rows2, cols);
				scrollPane_1.setViewportView(table);
			}
		});
		button_14.setBounds(106, 302, 79, 23);
		panel_1.add(button_14);

		JButton button_15 = new JButton("\u4E0A\u4F20\u5F69\u4FE1\u6587\u4EF6");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!button_2.isEnabled()) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"����ȷ�ϵ�¼��ť��");
					return;
				}
				int rowCount = 0;
				int colCount = 0;
				rowCount = table.getRowCount();
				colCount = table.getColumnCount();
				Object newrows[][] = new Object[rowCount][colCount];

				for (int i = 0; i < rowCount; i++) {
					for (int j = 0; j < colCount; j++) {
						newrows[i][j] = table.getValueAt(i, j);
					}
				}
				if (rowCount > 0) {
					String title = txtTitle.getText();
					String url = "";
					File f = null;
					MmsFileGroup[] mmsFileList = new MmsFileGroup[rowCount];
					for (int i = 0; i < rowCount; i++) {

						mmsFileList[i] = new MmsFileGroup();
						mmsFileList[i].setPlayTime(10);
						url = newrows[i][2].toString();
						if (!"".equals(url)) {
							f = new File(url);
							mmsFileList[i].setImage_FileName(f.getName());
							byte[] image_FileData = dataUtil.getByteArray(url);
							mmsFileList[i].setImage_FileData(image_FileData);
							url = newrows[i][1].toString();
						}
						if (!"".equals(url)) {
							f = new File(url);
							mmsFileList[i].setText_FileName(f.getName());
							String text_Content = dataUtil.getTxtContent(url);
							mmsFileList[i].setText_Content(text_Content);
							url = newrows[i][3].toString();
						}
						if (!"".equals(url)) {
							f = new File(url);
							mmsFileList[i].setAudio_FileName(f.getName());
							byte[] Audio_FileData = dataUtil.getByteArray(url);
							mmsFileList[i].setAudio_FileData(Audio_FileData);
						}
					}
					mmsResultBean bean = mms_UpFile.MmsUpFile(title,
							mmsFileList);
					txtFileID.setText(((Long) bean.getMmsFileID().value)
							.toString());
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this, "�����֡��");
				}

			}
		});
		button_15.setBounds(195, 302, 115, 23);
		panel_1.add(button_15);

		JButton button_16 = new JButton("\u83B7\u53D6\u6587\u4EF6\u72B6\u6001");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!button_2.isEnabled()) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"����ȷ�ϵ�¼��ť��");
					return;
				}
				long mmsFileID = new Long(txtFileID.getText());
				mmsResultBean bean = mms_GetFileStatus.GetFileStatus(mmsFileID);
				JOptionPane.showMessageDialog(mobsetClient.this, "��ȡ�ļ�״ֵ̬Ϊ��"
						+ ((Long) bean.getStatus().value).toString());
			}
		});
		button_16.setBounds(322, 302, 115, 23);
		panel_1.add(button_16);

		JButton button_17 = new JButton("\u63D0\u4EA4\u5F69\u4FE1\u4EFB\u52A1");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!button_2.isEnabled()) {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"����ȷ�ϵ�¼��ť��");
					return;
				}
				MobileFileGroup[] mobileList = new MobileFileGroup[1];
				mobileList[0] = new MobileFileGroup();
				mobileList[0].setTaskFileType(1);
				mobileList[0].setTaskFileID(txtAssigID.getText());
				
				long mmsFileID = 0;
				if (StringUtils.isNumeric(txtFileID.getText())) {
					mmsFileID = new Long(txtFileID.getText());
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"��������ȷ�Ĳ��������ļ�ID��");
					return;
				}
				taskResultBean bean = task_MmsSend.taskSmsSend(mobileList, mmsFileID);
				JOptionPane.showMessageDialog(mobsetClient.this, bean.getErrMsg().value);
			}
		});
		button_17.setBounds(42, 356, 115, 23);
		panel_1.add(button_17);

		JButton button_18 = new JButton("\u5F69\u4FE1\u4EFB\u52A1\u72B6\u6001");
		button_18.setBounds(176, 356, 115, 23);
		button_18.setEnabled(false);
		panel_1.add(button_18);

		JButton button_19 = new JButton("\u7ED3\u675F\u5F69\u4FE1\u4EFB\u52A1");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long taskMmsID = 0;
				String fileNumID = txtAssigID.getText();
				if (StringUtils.isNumeric(fileNumID)) {
					taskMmsID = new Long(fileNumID);
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"��������ȷ�Ĳ��������ļ�ID��");
					return;
				}
				taskResultBean bean = task_MmsStop.taskSmsStop(taskMmsID);
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value);
			}
		});
		button_19.setBounds(311, 356, 115, 23);
		panel_1.add(button_19);

		txtAssigID = new JTextField();
		txtAssigID.setBounds(534, 357, 115, 22);
		panel_1.add(txtAssigID);

		JButton button_20 = new JButton("\u83B7\u53D6\u5F69\u4FE1");
		button_20.setBounds(557, 157, 92, 23);
		button_20.setEnabled(false);
		panel_1.add(button_20);
		
		JLabel lblId_1 = new JLabel();
		lblId_1.setText("\u4EFB\u52A1\u6587\u4EF6 ID\uFF1A");
		lblId_1.setBounds(459, 358, 90, 18);
		panel_1.add(lblId_1);

		final JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		tabbedPane.addTab("��������", null, panel_3, null);

		JButton button_21 = new JButton("\u6D4F\u89C8");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.addChoosableFileFilter(new TextFileFilter(
						"txt;smil"));
				int result = fileChooser.showOpenDialog(mobsetClient.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					String filePath = fileChooser.getSelectedFile().getPath();
					txtNumUrl.setText(filePath);
				}
			}
		});
		button_21.setBounds(363, 61, 66, 23);
		panel_3.add(button_21);

		txtNumUrl = new JTextField();
		txtNumUrl.setBounds(84, 62, 269, 22);
		panel_3.add(txtNumUrl);

		final JComponent separator5 = DefaultComponentFactory.getInstance()
				.createSeparator("����ģʽ");
		separator5.setBounds(10, 10, 638, 18);
		panel_3.add(separator5);

		JLabel label_8 = new JLabel();
		label_8.setText("\u53F7\u7801\u6587\u4EF6\uFF1A");
		label_8.setBounds(20, 64, 66, 18);
		panel_3.add(label_8);

		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(84, 171, 544, 102);
		panel_3.add(textArea_1);

		JLabel label_11 = new JLabel();
		label_11.setText("\u53D1\u9001\u5185\u5BB9\uFF1A");
		label_11.setBounds(20, 173, 66, 18);
		panel_3.add(label_11);

		JButton button_22 = new JButton("\u4E0A\u4F20\u53F7\u7801\u6587\u4EF6");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = txtNumTitle.getText();
				String numUrl = txtNumUrl.getText();

				byte[] txt_FileData = dataUtil.getByteArray(numUrl);
				taskResultBean bean = task_UpFile.taskUpFile(title,
						txt_FileData);

				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value);
				txtNumID
						.setText(((Long) bean.getTaskFileID().value).toString());
			}
		});
		button_22.setBounds(94, 95, 125, 23);
		panel_3.add(button_22);

		JButton button_23 = new JButton("\u5220\u9664\u53F7\u7801\u6587\u4EF6");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long taskFileID = 0;
				String fileNumID = txtNumID.getText();
				if (StringUtils.isNumeric(fileNumID)) {
					taskFileID = new Long(fileNumID);
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"������Ҫɾ���ļ���ȷ��ID��");
					return;
				}
				taskResultBean bean = task_DelFile.taskDelFile(taskFileID);
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value);
			}
		});
		button_23.setBounds(246, 95, 125, 23);
		panel_3.add(button_23);

		txtNumTitle = new JTextField();
		txtNumTitle.setBounds(84, 30, 276, 22);
		panel_3.add(txtNumTitle);

		JLabel label_10 = new JLabel();
		label_10.setText("\u6587\u4EF6\u6807\u9898\uFF1A");
		label_10.setBounds(20, 32, 66, 18);
		panel_3.add(label_10);

		txtNumID = new JTextField();
		txtNumID.setBounds(484, 30, 144, 22);
		panel_3.add(txtNumID);

		final JComponent separator11 = DefaultComponentFactory.getInstance()
				.createSeparator("�������");
		separator11.setBounds(10, 143, 638, 18);
		panel_3.add(separator11);

		JLabel lblid_1 = new JLabel();
		lblid_1.setText("\u6587\u4EF6 ID\uFF1A");
		lblid_1.setBounds(420, 32, 66, 18);
		panel_3.add(lblid_1);

		JButton button_24 = new JButton("\u63D0\u4EA4\u77ED\u4FE1\u4EFB\u52A1");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String content = textArea_1.getText();
				MobileFileGroup[] mobileList = new MobileFileGroup[1];
				mobileList[0] = new MobileFileGroup();
				mobileList[0].setTaskFileType(1);
				mobileList[0].setTaskFileID(txtNumID.getText());
				taskResultBean bean = task_SmsSend.taskSmsSend(mobileList,
						content);
				JOptionPane.showMessageDialog(mobsetClient.this, "�����������Ϊ��"
						+ (bean.getErrMsg().value).toString());
				txtSmsTaskID.setText(((Long) bean.getTaskSmsID().value)
						.toString());
			}
		});
		button_24.setBounds(122, 283, 113, 23);
		panel_3.add(button_24);

		JButton button_25 = new JButton("\u77ED\u4FE1\u4EFB\u52A1\u72B6\u6001");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long taskFileID = 0;
				String fileNumID = txtSmsTaskID.getText();
				if (StringUtils.isNumeric(fileNumID)) {
					taskFileID = new Long(fileNumID);
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"��������ȷ�Ķ�������ID��");
					return;
				}
				taskResultBean bean = task_GetSmsStatus
						.taskGetSmsStatus(taskFileID);
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value+ " \r\n ��������״̬��"
						+ StringUtils.getTaskStatue(bean.getStatus().value)
						+"\r\n �ֻ��������"+bean.getMobileCount().value
						+"\r\n �ѷ���������"+bean.getYFMobileCount().value
						+"\r\n ����ʼʱ�䣺"+bean.getBeginTime().value
						+"\r\n �������ʱ�䣺"+bean.getEndTime().value);
			}
		});
		button_25.setBounds(179, 316, 113, 23);
		panel_3.add(button_25);

		JButton button_26 = new JButton("\u505C\u6B62\u77ED\u4FE1\u4EFB\u52A1");
		button_26.setBounds(373, 316, 113, 23);
		panel_3.add(button_26);

		txtSmsTaskID = new JTextField();
		txtSmsTaskID.setBounds(381, 283, 144, 22);
		panel_3.add(txtSmsTaskID);

		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long taskSmsID = 0;
				String fileNumID = txtSmsTaskID.getText();
				if (StringUtils.isNumeric(fileNumID)) {
					taskSmsID = new Long(fileNumID);
				} else {
					JOptionPane.showMessageDialog(mobsetClient.this,
							"��������ȷ�Ķ�������ID��");
					return;
				}
				taskResultBean bean = task_SmsStop.taskSmsStop(taskSmsID);
				JOptionPane.showMessageDialog(mobsetClient.this, bean
						.getErrMsg().value);
			}
		});
		
		JLabel lblId = new JLabel();
		lblId.setText("\u77ED\u4FE1\u4EFB\u52A1 ID\uFF1A");
		lblId.setBounds(301, 286, 85, 18);
		panel_3.add(lblId);

		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				msmResultBean smsBean = sms_GetReport.getReport(txtMsgId
						.getText());
				JOptionPane.showMessageDialog(mobsetClient.this, smsBean
						.getErrMsg().value);
				String result = "";
				if (smsBean.getSmsReportList() != null && smsBean.getSmsReportList().value!=null && smsBean.getSmsReportList().value.length>0) {
					
					for (int i=0;i<smsBean.getSmsReportList().value.length;i++) {
						result += ((Long) smsBean.getSmsReportList().value[0]
						                      							.getStatus()).toString()+";";
					}
					
				} else
					result = "״̬����û��״̬���棡";
				txtReContent.setText(result);
			}
		});
		//
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
