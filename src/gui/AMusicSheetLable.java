package gui;

import net.MusicSheet;


/**
 * 
 * �赥����չʾ�ĸ赥��
 * ��MusicSheet   ����� ����һ����ʾ��    string
 * @author sparrow
 *
 */
public class AMusicSheetLable  {
	String sheetName;
	String sheetCreator;
	String sheetId;
	String amusicSheetString;
	/*
	 * ���������һ��musicsheet
	 */
	public AMusicSheetLable(MusicSheet b) {
		// TODO Auto-generated constructor stub
		super();
		sheetId=new String();
		sheetName=new String();
		sheetCreator=new String();
		loadMusicSheet(b);
		amusicSheetString=sheetName;
		//this.setText(sheetId+sheetName+sheetCreator);
		//this.setSize(100, 30);
		
	}
	
	/*
	 * ��ȡ�赥
	 * 
	 */
	public void loadMusicSheet(MusicSheet a) {
		sheetId=a.getlistid();
		sheetCreator=a.getCreator();
		sheetName=a.getName();
		
		
	}
	

}
