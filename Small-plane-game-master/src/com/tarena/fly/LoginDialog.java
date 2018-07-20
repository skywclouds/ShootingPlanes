package com.tarena.fly;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginDialog extends JFrame {
	/*
	 * ��˽�Լ���ȥ����
	 * */
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// ��¼���
	private JLabel jLabel = null;// ���û�������ǩ
	private static JTextField userField = null;// ���û������ı���
	private JLabel jLabel1 = null;// �����롱��ǩ
	private static JPasswordField passwordField = null;// �����롱�ı���
	private JButton loginButton = null;// ����¼����ť
	private JButton exitButton = null;// ���˳�����ť
	private static String userStr;// ���û������ı����е�����
	
	public static void main(String[] args) {
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// ����������Ļ����
		if (!(splashScreen== null)) {// ������Ļ����Ϊ��
			try {
				
				Thread.sleep(3000);// �߳�����3��
			} catch (InterruptedException e) {
			}
		
		}
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1800;i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				JFrame jf=new JFrame("������ϵͳ");
				jf.setSize(450, 200);
				Container cc=jf.getContentPane();
				JLabel jl=new JLabel("���Ѿ����˰�Сʱ����Ϸ��ǿ�ƹر�");
				jl.setHorizontalAlignment(SwingConstants.CENTER);
				cc.add(jl);
				jf.setResizable(false);
				jf.setLocationRelativeTo(null);
				jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				jf.setVisible(true);
				ShootGame.frame.setVisible(false);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		t.start();
		new LoginDialog().Sign();
	}
	public LoginDialog() {// ��¼����Ĺ��췽��
		try {
			// ���õ�¼����ķ��
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.out.println("��¼����������");
			initialize();// ��ʼ����¼����
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel() {// ��ʼ��loginPanel��¼���ķ���
		if (loginPanel == null) {// ��¼�����û�����ʱ
			jLabel1 = new JLabel();// �����롱��ǩ
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// ���á����롱��ǩ��λ������
			jLabel1.setText("�ܡ��룺");// ���á����롱��ǩ���ı�����
			jLabel = new JLabel();// ���û�������ǩ
			jLabel.setText("�û�����");// ���á��û�������ǩ���ı�����
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// ���á��û�������ǩ��λ������
			loginPanel = new LoginPanel();// ��¼���
			loginPanel.setLayout(null);// ���õ�¼���Ĳ���Ϊ���Բ���
			loginPanel.setBackground(new Color(0xD8DDC7));// ���õ�¼���ı���ɫ
			loginPanel.add(jLabel, null);// �ѡ��û�������ǩ���ڵ�¼�����
			loginPanel.add(getUserField(), null);// �ѡ��û������ı������ڵ�¼�����
			loginPanel.add(jLabel1, null);// �ѡ����롱��ǩ���ڵ�¼�����
			loginPanel.add(getPasswordField(), null);// �ѡ����롱�ı������ڵ�¼�����
			loginPanel.add(getLoginButton(), null);// �ѡ���¼����ť���ڵ�¼�����
			loginPanel.add(getExitButton(), null);// �ѡ��˳�����ť���ڵ�¼�����
		}
		return loginPanel;// ���ص�¼���
	}

	private JTextField getUserField() {// ��ʼ�����û������ı���
		if (userField == null) {// ���û������ı������Ϊ��ʱ
			userField = new JTextField();// ʵ�������û������ı���
			userField.setBounds(new Rectangle(142, 39, 127, 22));// ���á��û������ı����λ�úͿ��
		}
		return userField;// ���ء��û������ı���
	}

	private JPasswordField getPasswordField() {// ��ʼ�������롱�ı���
		if (passwordField == null) {// �����롱�ı������Ϊ��ʱ
			passwordField = new JPasswordField();// ʵ���������롱�ı���
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));// ���á����롱�ı����λ�úͿ��
			
		}
		return passwordField;// ���ء����롱�ı���
	}

	private JButton getLoginButton() {// ��ʼ������¼����ť
		if (loginButton == null) {// ����¼����ť����Ϊ��ʱ
			loginButton = new JButton();// ʵ��������¼����ť
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));// ���á���¼����ť��λ�úͿ��
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// ���á���¼����ť��ͼ��
			loginButton.addActionListener(new ActionListener() {// Ϊ����¼����ť��Ӷ����¼��ļ���
				public void actionPerformed(ActionEvent e) {								
					if (chicklog()) {// ��֤�û���������ʧ��
						JOptionPane.showMessageDialog(LoginDialog.this, "�û����������޷���¼", "��¼ʧ��",
								JOptionPane.ERROR_MESSAGE);// ��������¼ʧ�ܡ��Ի���
						return;
					}
					
					setVisible(false);// ʹ��¼���岻�ɼ�
					ShootGame.main(null);
				}
			});
		}
		return loginButton;// ���ء���¼����ť
	}

	private JButton getExitButton() {// ��ʼ�����˳�����ť
		if (exitButton == null) {// ���˳�����ť����Ϊ��ʱ
			exitButton = new JButton();// ʵ�������˳�����ť
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));// ���á��˳�����ť��λ�úͿ��
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// ���á��˳�����ť��ͼ��
			exitButton.addActionListener(new ActionListener() {// Ϊ���˳�����ť�����¼��ļ���
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// �˳���ǰ��Ӧ�ó���
				}
			});
		}
		return exitButton;// ���ء��˳�����ť
	}

	private void initialize() {// ��ʼ����¼����
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// ���õ�¼����
		setSize(296, 188);// ���õ�¼����Ŀ��
		this.setTitle("ϵͳ��¼");// ���õ�¼����ı���
		setContentPane(getLoginPanel());// ����¼������ڵ�¼������
	}

	public String getUserStr() {// ��á��û������ı����е�����
		return userStr;// ���ء��û������ı����е�����
	}
	/*
	 * ��֤�û����������Ƿ���ȷ
	 * */
	public static boolean chicklog() {
		boolean b=true;
		userStr = userField.getText();// ��á��û������ı����е�����
		String passStr = new String(passwordField.getPassword());// ��á����롱�ı����е�����
		//���û�����������������У���һ�ȶ�
		String[] username= {"wsoft","wmilk"};
		String[] password= {"145027","2017"};
		for(int i=0;i<2;i++) {
			boolean a1=userStr.equals(username[i]);
			boolean a2=passStr.equals(password[i]);
			if(a1&a2) {
				b=false;
				break;
			}
		}
		return b;
		
	}
	void Sign() {
		final JFrame sign=new JFrame("����");//������������
		sign.setResizable(false);
		sign.setSize(500, 700);
		sign.setLayout(null);
		Dimension size = getToolkit().getScreenSize();// �����Ļ�ߴ�
		sign.setLocation((size.width - 500) / 2, (size.height - 700) / 2);// ���ô��嵯��λ��
		Container cc=sign.getContentPane();//��ȡ����
		cc.setBackground(new Color(240,240,240));
		JLabel jl=new JLabel("��������");
		jl.setBounds(180, 0, 200, 50);
		jl.setFont(new Font("",1,30));
		JButton bi=new JButton("��ʼ��Ϸ");//���ð�ť
		
		cc.add(jl);
		String s="       ����Ϸ����ѧϰ�����֣�����ʹ�á�������κ��ˣ��������غ�24Сʱ֮��ж�أ����������һ�к������е���"
				+"���ڱ���ˮƽ���ޣ����������Ϸ�Ĵ������ҳ�Ϯ�ģ�ԭ���ߵ�github��ҳ��\'\'github.com/wblearn\'\'"+
				"�������һЩ����ͽ��飬�뷢���ҵĵ�������\'\'ws_wanghe@163.com\'\'��"
				+ "\n\t\t������\n\t\t2018-07-20";//����������
		JTextArea jt=new JTextArea(s);//�����ı������
		jt.setFont(new Font("",0,20));//�����ı��������
		jt.setEditable(false);//���ô��岻������
		jt.setLineWrap(true);//�����Զ�����
		jt.setBounds(45,75,400,400);
		cc.add(jt);//���ı��������������
		sign.setVisible(true);//�Ǵ���ɼ�
		bi.setBounds(190, 550, 100, 50);
		cc.add(bi);//����ť�����������
		bi.addActionListener(new ActionListener() {
			//Ϊ��ť�����굥���¼�
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame login = new LoginDialog();//ʵ������¼�������
				login.setResizable(false);
				login.setVisible(true);// ʹ��¼����ɼ�
				sign.setVisible(false);//���������ڲ��ɼ�
				
			}
		});
		//Ϊ�ı�����Ӽ����¼�
		jt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()=='\n') {//�ж��Ƿ�Ϊ�س���
					JFrame login = new LoginDialog();//ʵ������¼�������
					login.setVisible(true);// ʹ��¼����ɼ�
					sign.setVisible(false);//���������ڲ��ɼ�
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
			
			
		});
		sign.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//���ô��ڹرշ�ʽ
		System.out.println("��������������");
		
	}

}
