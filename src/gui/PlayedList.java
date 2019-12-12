package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;


/**
 * �����б�
 * ��ʾ�Ѳ��Ż������ڲ��ŵĸ���
 * @author sparrow
 *
 */

public class PlayedList {
	
	public JButton calluploadButton;
	
	//�����Ѳ��ŵ��ļ�
	static Vector<File> playedSongFile;
	public JScrollPane playedJScrollPane;
	//�����б�
	static JList<String> songJList;
	//
	static Vector<String> songNameString;
	
	//����������MD5ֵ
	String md5String;
	public PlayedList() {
		// TODO Auto-generated constructor stub
		calluploadButton=new JButton("�ϴ�");
		calluploadButton.setSize(40, 30);
		calluploadButton.setLocation(0, 500);

		songJList=new JList<String>();
		songJList.setBackground(Color.black);
		songJList.setForeground(Color.white);
		
		md5String=new String();
		songNameString=new Vector<String>();
		playedSongFile=new Vector<File>();

		songJList.setListData(songNameString);
		
		playedJScrollPane=new JScrollPane(songJList);
		calluplistener();
	}
	
	/**
	 * ���� �б�
	 */
	public static void refresh() {
		songJList.setListData(songNameString);
	}
	
	public void calluplistener() {
		calluploadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UpSheetWindows();
				
			}
		});
		
	}
	
}
	

