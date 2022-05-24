import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Client1 extends JFrame{
	public static void main(String[] args)throws Exception{										
		DatagramSocket ds=new DatagramSocket(8000);
		boolean flag=true;
		Client11 c=new Client11(ds);
		while(flag){
			DatagramPacket dp=new DatagramPacket(new byte[1024],1024);
			ds.receive(dp);
			String str=URLDecoder.decode(new String(dp.getData(),0,dp.getLength()),"UTF-8");
			c.getT2().append(str+"\n");
		}
		ds.close();
	}
}
class Client11 extends JFrame{													
	private JButton b1=new JButton("发送");
	private JTextField t1=new JTextField("");
	private JTextArea t2=new JTextArea();
	private JScrollPane s1=null;
	private DatagramSocket ds=null;
	public Client11(){
		setFrame();
		setButton();
		setText();
	}
	public Client11(DatagramSocket ds){
		this();
		this.ds=ds;
	}
	public void run(){
		try{
			String str=URLEncoder.encode("张三:"+t1.getText(),"UTF-8");
			DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("192.168.137.1"),7000);
			ds.send(dp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void setFrame(){
		setLayout(null);
		setTitle("我是张三");
		setSize(500,300);
		setLocation(600,300);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1);
			}
		});
	}
	public void setButton(){
		b1.setBounds(415,220,60,30);
		add(b1);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==b1){
					if(!("".equals(t1.getText()))){
						t2.append("我:"+t1.getText()+"\n");
						run();
						t1.setText("");
					}
				}
			}
		});
	}
	public void setText(){
		t1.setBounds(1,221,410,30);
		add(t1);
		t2.setBounds(1,1,40,30);
		s1=new JScrollPane(t2);
		s1.setBounds(1,1,425,210);
		add(s1);
	}
	public JTextArea getT2(){
		return t2;
	}
}