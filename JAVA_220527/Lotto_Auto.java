package study0527;

import java.awt.*;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;

public class Lotto_Auto 
{
	public static void main(String[] args) 
	{
		Game g = new Game();
	}
}

class Game extends Frame implements ActionListener 
{
	int i = 0;
	int j = 0;
	
	int rank = 7; //�ζǵ���� ��Ÿ���� ����
	String lottoNum[] = new String[6]; //�ζǹ�ȣ�� TextField���� �Է¹޴� �迭
	int lotto[] = new int[6];// lottoNum�� int������ ��ȯ�Ͽ� �����ϴ� �迭
	
	int n1,n2; //���������� �����ϴ� ����
	int cnt1 = 0;//�ζǹ�ȣ ������ŭ ���������� �����ϵ��� ����� ����
	int cnt2 = 0;//�ζǹ�ȣ ������ŭ ���������� �����ϵ��� ����� ����
	int[] lottoWin = new int[6];//�ζǴ�÷��ȣ�� �����ϴ� �迭
	int[] lottoA = new int[6];//�ڵ��ζǹ�ȣ�� �����ϴ� �迭
	
	Random rd = new Random();
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Label lbTitle = new Label("�ζ� ���߱� ����");	
	Label lbMy = new Label("��ȣ�Է�");
	TextField tf1  = new TextField(2);
	TextField tf2  = new TextField(2);
	TextField tf3  = new TextField(2);
	TextField tf4  = new TextField(2);
	TextField tf5  = new TextField(2);
	TextField tf6  = new TextField(2);
	
	Label sixc = new Label("6�����߸� 1��: 10��");
	Label fivec = new Label("5�����߸� 2��: 1��");
	Label fourc = new Label("4�����߸� 3��: 1õ����");
	Label threec = new Label("3�����߸� 4��: 10����");
	Label twoc = new Label("2�����߸� 5��: 5õ��");
	Label onec = new Label("1�����߸� 6��: ��");
	Label zeroc = new Label("0�����߸� 7��: ��");
		
	Button btnStart = new Button("��÷ ����");
	Button btnauto = new Button("�ڵ� �Է�");
	
	public Game() 
	{
		super("Lotto");
		
		this.init();
		
		this.start();
		
		this.setSize(400, 490);	
		
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		
		this.setVisible(true);
	}

	public void init() 
	{
		// �ۼַ�Ʈ���  : ���� ��ǥ �Է¹��.
		this.setLayout(null);

		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//Ÿ��Ʋ
		this.add(lbTitle);
		lbTitle.setBounds(100, 50, 300, 30);		
		lbTitle.setFont(font20);
		
		this.add(lbMy);
		lbMy.setBounds(50, 100, 70, 30);
		lbMy.setFont(font15);
		
		this.add(btnStart);
		btnStart.setBounds(70, 220, 100, 30);
		btnStart.setFont(font15);
		this.add(btnauto);
		btnauto.setBounds(190, 220, 100, 30);
		btnauto.setFont(font15);
		
		this.add(sixc);
		sixc.setBounds(50, 260, 150, 30);
		this.add(fivec);
		fivec.setBounds(50, 290, 150, 30);
		this.add(fourc);
		fourc.setBounds(50, 320, 150, 30);
		this.add(threec);
		threec.setBounds(50, 350, 150, 30);
		this.add(twoc);
		twoc.setBounds(50, 380, 150, 30);
		this.add(onec);
		onec.setBounds(50, 410, 150, 30);
		this.add(zeroc);
		zeroc.setBounds(50, 440, 150, 30);
		
		this.add(tf1);
		tf1.setBounds(50, 140, 30, 30);
		this.add(tf2);
		tf2.setBounds(100, 140, 30, 30);
		this.add(tf3);
		tf3.setBounds(150, 140, 30, 30);
		this.add(tf4);
		tf4.setBounds(200, 140, 30, 30);
		this.add(tf5);
		tf5.setBounds(250, 140, 30, 30);
		this.add(tf6);
		tf6.setBounds(300, 140, 30, 30);
		
	}

	public void start() 
	{
		
		btnStart.addActionListener(this);
		btnauto.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnStart) 
		{
			ran();
			
			lottoNum[i] = tf1.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf2.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf3.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf4.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf5.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			lottoNum[i] = tf6.getText();
			lotto[i] = Integer.parseInt(lottoNum[i]);
			i++;
			
			final Dialog dlg = new Dialog(this, "��÷Ȯ��", true);
			dlg.setLayout(null);	
			
			Font font15 = new Font("SansSerif", Font.BOLD, 15);
			Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
			sorting();
			
			for(i=0;i<6;i++)
			{
				System.out.println("��÷��ȣ"+(i+1)+"��");
				System.out.println(lottoWin[i]);
				
				if(lotto[i] == lottoWin[i])
				{
					rank--;
				}
			}
			
			Label lbTitle = new Label("�����մϴ�"+rank+"���÷!");
			Button bt = new Button("Ȯ��");
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dlg.setVisible(false);
				}
			});
			
			dlg.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dlg.setVisible(false);
				}
			});
			
			dlg.add(lbTitle);
			lbTitle.setBounds(80, 50, 150, 30);		
			lbTitle.setFont(font15);
			
			dlg.add(bt);
			bt.setBounds(120, 100, 50, 30);		
			bt.setFont(font15);
			
			dlg.setLocation(xpos, 400);
			dlg.setSize(300, 150);
			dlg.setVisible(true);
		}
		
		if(e.getSource() == btnauto) 
		{
			ran2();
			
			tf1.setText(lottoA[0]+"");
			tf2.setText(lottoA[1]+"");
			tf3.setText(lottoA[2]+"");
			tf4.setText(lottoA[3]+"");
			tf5.setText(lottoA[4]+"");
			tf6.setText(lottoA[5]+"");
			
			sorting2();
			
		}
		
	}
	
	void ran()
	{
		jump:
			
		while(cnt1<6)
		{
			n1 = rd.nextInt(45)+1;
					
			for(int j=0; j<cnt1; j++)
			{
				if(lottoWin[j] == n1)
				{
					continue jump;
				}
			}
					
			lottoWin[cnt1] = n1;
					
			cnt1++;
		}
		
	}
	
	void ran2()
	{
		jump:
			
		while(cnt2<6)
		{
			n2 = rd.nextInt(45)+1;
					
			for(int k=0; k<cnt2; k++)
			{
				if(lottoA[j] == n2)
				{
					continue jump;
				}
			}
					
			lottoA[cnt2] = n2;
					
			cnt2++;
		}
		
	}
	
	void sorting()
	{
		Arrays.sort(lottoWin);
		Arrays.sort(lotto);
	}
	
	void sorting2()
	{
		Arrays.sort(lottoA);
	}
	
}

