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
	private JFrame frame=new JFrame("无标题-新记事本");						
	private JTextArea text=new JTextArea();									
	private JMenu m1=new JMenu("文件");					
	private JMenu m2=new JMenu("编辑");
	private JMenu m3=new JMenu("帮助");
	private JMenu m4=new JMenu("格式");
	private JMenu m5=new JMenu("帮助");
	private JMenuBar menuBar=new JMenuBar();
	private JMenuItem n1=new JMenuItem("新建");
	private JMenuItem n2=new JMenuItem("打开");
	private JMenuItem n3=new JMenuItem("保存");
	private JMenuItem n4=new JMenuItem("另存");
	private JMenuItem n5=new JMenuItem("退出");
	private JMenuItem n6=new JMenuItem("字体");
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
		if(e.getSource()==n1){											//新建文件
			text.setText("");
			frame.setTitle("无标题-新记事本");
		}
		if(e.getSource()==n2){											//打开文件							
			text.setText("");
			fileChooser.setApproveButtonText("确定");
			fileChooser.setDialogTitle("打开文件");
			result=fileChooser.showOpenDialog(frame.getContentPane());
			if(result==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
				f=file;
				frame.setTitle(file.getName()+"-新记事本");
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
		if(e.getSource()==this.n3){																//保存文件										
			if(frame.getTitle().equals("无标题-新记事本")){
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
					frame.setTitle(file.getName()+"-新记事本");
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
		if(e.getSource()==n4){									//文件另存为
			fileChooser.setDialogTitle("文件另存为");
			result=fileChooser.showSaveDialog(this.frame);
			if(result==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
				f=file;
				frame.setTitle(file.getName()+"-新记事本");
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
		if(e.getSource()==this.n5){														//退出
			System.exit(1);
		}
		if(e.getSource()==this.n6){														//设置字体
			c=new Change();
		}
	}
	class Change extends JFrame{														//内部类表示设置字体的窗口
		private String[] s1={"常规","楷体","宋体"};
		private String[] s2={"普通","粗体","斜体","粗斜"};
		private String[] s3={"10","12","14","16","18","20"};
		private JComboBox jcb1=new JComboBox(s1);						//表示字形
		private JComboBox jcb2=new JComboBox(s2);						//表示样式
		private JComboBox jcb3=new JComboBox(s3);						//表示字号
		private JButton b1=new JButton("确定");
		private JButton b2=new JButton("取消");
		public Change(){
			setBox();
			setButton();
			listener();
			setFont();
			setFrame();
		}
		public void setFont(){		
			String s1=font2.getName();							//得到当前字体
			jcb1.setSelectedItem(s1);							//设置显示
			String s2=String.valueOf(font2.getSize());			//得到当前字体大小
			jcb3.setSelectedItem(s2);							//设置显示
			if(font2.isBold()&&font2.isItalic()){				
				jcb2.setSelectedItem("粗斜");
				return;
			}
			if(font2.isBold()){
				jcb2.setSelectedItem("粗体");
				return;
			}
			if(font2.isItalic()){
				jcb2.setSelectedItem("斜体");
				return;
			}
			if(font2.isPlain()){
				jcb2.setSelectedItem("普通");
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
			jcb1.setBorder(BorderFactory.createTitledBorder("字体"));
			jcb1.setMaximumRowCount(3);
			jcb1.setBounds(10,10,100,50);
			jcb2.setFont(font1);
			jcb2.setBorder(BorderFactory.createTitledBorder("样式"));
			jcb2.setMaximumRowCount(3);
			jcb2.setBounds(130,10,100,50);
			jcb3.setFont(font1);
			jcb3.setBorder(BorderFactory.createTitledBorder("大小"));
			jcb3.setMaximumRowCount(3);
			jcb3.setBounds(250,10,100,50);
		}
		public void setFrame(){	
			setSize(600,400);
			setLocation(550,390);
			setLayout(null);
			setTitle("字体");
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
						if(st2.equals("普通")){
							if(!(st1.equals("常规"))){
								font2=new Font(st1,Font.PLAIN,Integer.parseInt(st3));	
							}else{
								font2=new Font("Serief",Font.PLAIN,Integer.parseInt(st3));	
							}
						}	
						if(st2.equals("粗体")){
							if(!(st1.equals("常规"))){
								font2=new Font(st1,Font.BOLD,Integer.parseInt(st3));
							}else{
								font2=new Font("Serief",Font.BOLD,Integer.parseInt(st3));
							}
						}
						if(st2.equals("斜体")){
							if(!(st1.equals("常规"))){
								font2=new Font(st1,Font.ITALIC,Integer.parseInt(st3));
							}else{
								font2=new Font("Serief",Font.ITALIC,Integer.parseInt(st3));
							}
							
						}
						if(st2.equals("粗斜")){
							if(!(st1.equals("常规"))){
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