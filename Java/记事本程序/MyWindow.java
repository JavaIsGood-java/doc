import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JMenu;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
class MyWindow implements ActionListener{
	private File f=null;
	private JFrame frame=new JFrame("�ޱ���-�¼��±�");						
	private JTextArea text=new JTextArea();									
	private JMenu m1=new JMenu("�ļ�");					
	private JMenu m2=new JMenu("�༭");
	private JMenu m3=new JMenu("����");
	private JMenu m4=new JMenu("��ʽ");
	private JMenu m5=new JMenu("����");
	private JMenuBar menuBar=new JMenuBar();
	private JMenuItem n1=new JMenuItem("�½�");
	private JMenuItem n2=new JMenuItem("��");
	private JMenuItem n3=new JMenuItem("����");
	private JMenuItem n4=new JMenuItem("���");
	private JMenuItem n5=new JMenuItem("�˳�");
	private JMenuItem n6=new JMenuItem("����");
	private Font font1=new Font("Serief",Font.PLAIN,17);
	private Font font2=new Font("Serief",Font.PLAIN,16);
	private Change c=null;
	public MyWindow(){
		setFont();
		setMenu();
		setFrame();
	}
	public void setFont(){
		frame.setFont(font1);
		m1.setFont(font1);
		m2.setFont(font1);
		m3.setFont(font1);
		m4.setFont(font1);
		m5.setFont(font1);
		n1.setFont(font1);
		n2.setFont(font1);
		n3.setFont(font1);
		n4.setFont(font1);
		n5.setFont(font1);
		n6.setFont(font1);
		text.setFont(font2);
	}
	public void setFrame(){
		frame.setSize(800,500);
		frame.setLocation(500,300);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);	
			}
		});
		frame.setResizable(false);
		frame.add(new JScrollPane(text));
		menuBar.add(m1);
		menuBar.add(m2);
		menuBar.add(m3);
		menuBar.add(m4);
		menuBar.add(m5);
		frame.setJMenuBar(menuBar);
		text.setEditable(true);
		frame.setVisible(true);
	}
	public void setMenu(){
		m1.add(n1);
		m1.add(n2);
		m1.add(n3);
		m1.add(n4);
		m1.addSeparator();
		m1.add(n5);
		m4.add(n6);
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		n4.addActionListener(this);
		n5.addActionListener(this);
		n6.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		File file=null;
		int result=0;
		JFileChooser fileChooser=new JFileChooser();
		if(e.getSource()==n1){											//�½��ļ�
			text.setText("");
			frame.setTitle("�ޱ���-�¼��±�");
		}
		if(e.getSource()==n2){											//���ļ�							
			text.setText("");
			fileChooser.setApproveButtonText("ȷ��");
			fileChooser.setDialogTitle("���ļ�");
			result=fileChooser.showOpenDialog(frame.getContentPane());
			if(result==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
				f=file;
				frame.setTitle(file.getName()+"-�¼��±�");
			}
			if(file!=null){
				try{
					Scanner scan=new Scanner(new FileInputStream(file));
					scan.useDelimiter("\n");
					while(scan.hasNext()){
						this.text.append(scan.next());
						this.text.append("\n");
					}
					scan.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==this.n3){																//�����ļ�										
			if(frame.getTitle().equals("�ޱ���-�¼��±�")){
				result=fileChooser.showSaveDialog(this.frame);
				if(result==JFileChooser.APPROVE_OPTION){
					file=fileChooser.getSelectedFile();
					f=file;
				}
				if(f!=null){
					try{
						PrintStream out=new PrintStream(new FileOutputStream(file));
						out.print(this.text.getText());
						out.close();
					}catch(Exception e1){
						e1.printStackTrace();
					}
					frame.setTitle(file.getName()+"-�¼��±�");
				}
			}else{
				try{
					PrintStream out=new PrintStream(new FileOutputStream(f));
					out.print(this.text.getText());
					out.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==n4){									//�ļ����Ϊ
			fileChooser.setDialogTitle("�ļ����Ϊ");
			result=fileChooser.showSaveDialog(this.frame);
			if(result==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
				f=file;
				frame.setTitle(file.getName()+"-�¼��±�");
			}
			if(file!=null){
				try{
					PrintStream out=new PrintStream(new FileOutputStream(file));
					out.print(this.text.getText());
					out.close();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}	
		}
		if(e.getSource()==this.n5){														//�˳�
			System.exit(1);
		}
		if(e.getSource()==this.n6){														//��������
			c=new Change();
		}
	}
	class Change extends JFrame{														//�ڲ����ʾ��������Ĵ���
		private String[] s1={"����","����","����"};
		private String[] s2={"��ͨ","����","б��","��б"};
		private String[] s3={"10","12","14","16","18","20"};
		private JComboBox jcb1=new JComboBox(s1);						//��ʾ����
		private JComboBox jcb2=new JComboBox(s2);						//��ʾ��ʽ
		private JComboBox jcb3=new JComboBox(s3);						//��ʾ�ֺ�
		private JButton b1=new JButton("ȷ��");
		private JButton b2=new JButton("ȡ��");
		public Change(){
			setBox();
			setButton();
			listener();
			setFont();
			setFrame();
		}
		public void setFont(){		
			String s1=font2.getName();							//�õ���ǰ����
			jcb1.setSelectedItem(s1);							//������ʾ
			String s2=String.valueOf(font2.getSize());			//�õ���ǰ�����С
			jcb3.setSelectedItem(s2);							//������ʾ
			if(font2.isBold()&&font2.isItalic()){				
				jcb2.setSelectedItem("��б");
				return;
			}
			if(font2.isBold()){
				jcb2.setSelectedItem("����");
				return;
			}
			if(font2.isItalic()){
				jcb2.setSelectedItem("б��");
				return;
			}
			if(font2.isPlain()){
				jcb2.setSelectedItem("��ͨ");
				return;
			}
		}
		public void setButton(){
			b1.setBounds(450,30,60,25);
			add(b1);
			b2.setBounds(450,65,60,25);
			add(b2);
		}
		public void setBox(){
			jcb1.setFont(font1);
			jcb1.setBorder(BorderFactory.createTitledBorder("����"));
			jcb1.setMaximumRowCount(3);
			jcb1.setBounds(10,10,100,50);
			jcb2.setFont(font1);
			jcb2.setBorder(BorderFactory.createTitledBorder("��ʽ"));
			jcb2.setMaximumRowCount(3);
			jcb2.setBounds(130,10,100,50);
			jcb3.setFont(font1);
			jcb3.setBorder(BorderFactory.createTitledBorder("��С"));
			jcb3.setMaximumRowCount(3);
			jcb3.setBounds(250,10,100,50);
		}
		public void setFrame(){	
			setSize(600,400);
			setLocation(550,390);
			setLayout(null);
			setTitle("����");
			setResizable(false);
			add(jcb1);
			add(jcb2);
			add(jcb3);
			setVisible(true);
		}
		public void listener(){
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getSource()==b1){
						String st1=(String)jcb1.getSelectedItem();
						String st2=(String)jcb2.getSelectedItem();
						String st3=(String)jcb3.getSelectedItem();
						if(st2.equals("��ͨ")){
							if(!(st1.equals("����"))){
								font2=new Font(st1,Font.PLAIN,Integer.parseInt(st3));	
							}else{
								font2=new Font("Serief",Font.PLAIN,Integer.parseInt(st3));	
							}
						}	
						if(st2.equals("����")){
							if(!(st1.equals("����"))){
								font2=new Font(st1,Font.BOLD,Integer.parseInt(st3));
							}else{
								font2=new Font("Serief",Font.BOLD,Integer.parseInt(st3));
							}
						}
						if(st2.equals("б��")){
							if(!(st1.equals("����"))){
								font2=new Font(st1,Font.ITALIC,Integer.parseInt(st3));
							}else{
								font2=new Font("Serief",Font.ITALIC,Integer.parseInt(st3));
							}
							
						}
						if(st2.equals("��б")){
							if(!(st1.equals("����"))){
								font2=new Font(st1,Font.BOLD+Font.ITALIC,Integer.parseInt(st3));
							}else{
								font2=new Font("Serief",Font.BOLD+Font.ITALIC,Integer.parseInt(st3));
							}
						}
						text.setFont(font2);
						setVisible(false);
					}
				}
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getSource()==b2){
						setVisible(false);	
					}
				}
			});
		}
	}
}