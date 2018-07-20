package com.tarena.fly;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginDialog extends JFrame {
	/*
	 * 我私自加上去的类
	 * */
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// 登录面板
	private JLabel jLabel = null;// “用户名”标签
	private static JTextField userField = null;// “用户名”文本框
	private JLabel jLabel1 = null;// “密码”标签
	private static JPasswordField passwordField = null;// “密码”文本框
	private JButton loginButton = null;// “登录”按钮
	private JButton exitButton = null;// “退出”按钮
	private static String userStr;// “用户名”文本框中的内容
	
	public static void main(String[] args) {
		SplashScreen splashScreen = SplashScreen.getSplashScreen();// 创建闪现屏幕对象
		if (!(splashScreen== null)) {// 闪现屏幕对象不为空
			try {
				
				Thread.sleep(3000);// 线程休眠3秒
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
				JFrame jf=new JFrame("防沉迷系统");
				jf.setSize(450, 200);
				Container cc=jf.getContentPane();
				JLabel jl=new JLabel("您已经完了半小时，游戏会强制关闭");
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
	public LoginDialog() {// 登录窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.out.println("登录窗体正常！");
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (loginPanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “密码”标签
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("密　码：");// 设置“密码”标签的文本内容
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("用户名：");// 设置“用户名”标签的文本内容
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// 设置“用户名”标签的位置与宽高
			loginPanel = new LoginPanel();// 登录面板
			loginPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			loginPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			loginPanel.add(getUserField(), null);// 把“用户名”文本框置于登录面板中
			loginPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中
			loginPanel.add(getPasswordField(), null);// 把“密码”文本框置于登录面板中
			loginPanel.add(getLoginButton(), null);// 把“登录”按钮置于登录面板中
			loginPanel.add(getExitButton(), null);// 把“退出”按钮置于登录面板中
		}
		return loginPanel;// 返回登录面板
	}

	private JTextField getUserField() {// 初始化“用户名”文本框
		if (userField == null) {// “用户名”文本框对象为空时
			userField = new JTextField();// 实例化“用户名”文本框
			userField.setBounds(new Rectangle(142, 39, 127, 22));// 设置“用户名”文本框的位置和宽高
		}
		return userField;// 返回“用户名”文本框
	}

	private JPasswordField getPasswordField() {// 初始化“密码”文本框
		if (passwordField == null) {// “密码”文本框对象为空时
			passwordField = new JPasswordField();// 实例化“密码”文本框
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));// 设置“密码”文本框的位置和宽高
			
		}
		return passwordField;// 返回“密码”文本框
	}

	private JButton getLoginButton() {// 初始化“登录”按钮
		if (loginButton == null) {// “登录”按钮对象为空时
			loginButton = new JButton();// 实例化“登录”按钮
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));// 设置“登录”按钮的位置和宽高
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// 设置“登录”按钮的图标
			loginButton.addActionListener(new ActionListener() {// 为“登录”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {								
					if (chicklog()) {// 验证用户名、密码失败
						JOptionPane.showMessageDialog(LoginDialog.this, "用户名与密码无法登录", "登录失败",
								JOptionPane.ERROR_MESSAGE);// 弹出“登录失败”对话框
						return;
					}
					
					setVisible(false);// 使登录窗体不可见
					ShootGame.main(null);
				}
			});
		}
		return loginButton;// 返回“登录”按钮
	}

	private JButton getExitButton() {// 初始化“退出”按钮
		if (exitButton == null) {// “退出”按钮对象为空时
			exitButton = new JButton();// 实例化“退出”按钮
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));// 设置“退出”按钮的位置和宽高
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// 设置“退出”按钮的图标
			exitButton.addActionListener(new ActionListener() {// 为“退出”按钮动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return exitButton;// 返回“退出”按钮
	}

	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// 设置登录窗体
		setSize(296, 188);// 设置登录窗体的宽高
		this.setTitle("系统登录");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}

	public String getUserStr() {// 获得“用户名”文本框中的内容
		return userStr;// 返回“用户名”文本框中的内容
	}
	/*
	 * 验证用户名与密码是否正确
	 * */
	public static boolean chicklog() {
		boolean b=true;
		userStr = userField.getText();// 获得“用户名”文本框中的内容
		String passStr = new String(passwordField.getPassword());// 获得“密码”文本框中的内容
		//将用户名与密码放在数组中，逐一比对
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
		final JFrame sign=new JFrame("声明");//创建声明窗口
		sign.setResizable(false);
		sign.setSize(500, 700);
		sign.setLayout(null);
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		sign.setLocation((size.width - 500) / 2, (size.height - 700) / 2);// 设置窗体弹出位置
		Container cc=sign.getContentPane();//获取容器
		cc.setBackground(new Color(240,240,240));
		JLabel jl=new JLabel("免责声明");
		jl.setBounds(180, 0, 200, 50);
		jl.setFont(new Font("",1,30));
		JButton bi=new JButton("开始游戏");//设置按钮
		
		cc.add(jl);
		String s="       本游戏仅供学习，娱乐，交流使用。不针对任何人，请于下载后24小时之内卸载，否则产生的一切后果由你承担。"
				+"由于本人水平有限，所以这个游戏的代码是我抄袭的，原作者的github主页是\'\'github.com/wblearn\'\'"+
				"如果您有一些意见和建议，请发到我的电子邮箱\'\'ws_wanghe@163.com\'\'。"
				+ "\n\t\t王先生\n\t\t2018-07-20";//声明的内容
		JTextArea jt=new JTextArea(s);//创建文本域对象
		jt.setFont(new Font("",0,20));//设置文本域的字体
		jt.setEditable(false);//设置窗体不能缩放
		jt.setLineWrap(true);//设置自动换行
		jt.setBounds(45,75,400,400);
		cc.add(jt);//将文本域添加至容器中
		sign.setVisible(true);//是窗体可见
		bi.setBounds(190, 550, 100, 50);
		cc.add(bi);//将按钮添加至容器中
		bi.addActionListener(new ActionListener() {
			//为按钮添加鼠标单击事件
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame login = new LoginDialog();//实例化登录窗体对象
				login.setResizable(false);
				login.setVisible(true);// 使登录窗体可见
				sign.setVisible(false);//是声明窗口不可见
				
			}
		});
		//为文本域添加键盘事件
		jt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()=='\n') {//判断是否为回车键
					JFrame login = new LoginDialog();//实例化登录窗体对象
					login.setVisible(true);// 使登录窗体可见
					sign.setVisible(false);//是声明窗口不可见
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}
			
			
		});
		sign.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭方式
		System.out.println("免责声明正常！");
		
	}

}
