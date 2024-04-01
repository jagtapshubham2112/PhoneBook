package userinterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class SplashScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTitle1, lblTitle2, lblLoading, lblProjectBy;
	private JLabel lblImage;
	private JProgressBar pb;

	// Constructor
	SplashScreen() {
		/********************************************************/
		/* Frame Settings */
		/********************************************************/

		getContentPane().setLayout(null);
		setUndecorated(true);
		setSize(500, 350);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dim.width - 500) / 2, (dim.height - 350) / 2);

		/********************************************************/
		/* Labels Configuration */
		/********************************************************/

		lblTitle1 = new JLabel("- W E L C O M E -");
		lblTitle1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblTitle1.setForeground(Color.blue);
		lblTitle1.setBounds(220, 50, 240, 30);
		add(lblTitle1);
		
		lblTitle2 = new JLabel("Samarth Infotech Systems, Barshi.");
		lblTitle2.setForeground(Color.white);
		lblTitle2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTitle2.setBounds(150, 15, 350, 20);
		add(lblTitle2);

		lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Arial", Font.PLAIN, 10));
		lblLoading.setForeground(Color.green);
		lblLoading.setBounds(230, 325, 600, 15);
		add(lblLoading);

		lblProjectBy = new JLabel("AUTHOR : SAMARTH");
		lblProjectBy.setFont(new Font("Arial", Font.PLAIN, 10));
		lblProjectBy.setForeground(Color.cyan);
		lblProjectBy.setBounds(220, 305, 400, 20);
		add(lblProjectBy);

		lblImage = new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/splash.png")));
		lblImage.setBounds(0, 0, 500, 350);
		add(lblImage);

		/********************************************************/
		/* Progress bar Configuration */
		/********************************************************/

		pb = new JProgressBar();
		pb.setBounds(0, 340, 500, 10);
		pb.setBorderPainted(true);
		pb.setStringPainted(true);
		pb.setBackground(Color.red);
		pb.setForeground(Color.blue);
		pb.setValue(0);
		add(pb);

		setVisible(true);

		int i = 0;
		while (i <= 100) {
			try {
				Thread.sleep(50);
				pb.setValue(i);
				lblLoading.setText("LOADING " + Integer.toString(i) + "%");
				i++;

				if (i == 100) {
					AddContact.main(null);
					dispose();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new SplashScreen();
		
	}

}
