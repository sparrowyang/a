package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.*;

public class JsonGeter {
	
	/**
	 * �������ȡjson���ݣ�����String 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String loadJson(String url) throws Exception {
		//��ȡurl,����json��
		StringBuilder json = new StringBuilder();
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine = null;
		while((inputLine = in.readLine()) != null){
			json.append(inputLine);
		}
		in.close();
		return json.toString();
	}
	
	/**
	 * ���õ���json תΪjsinObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getjson() throws Exception {
		String url = "http://service.uspacex.com/music.server/queryMusicSheets?type=all";
		String json = loadJson(url);

		JSONObject jsonObject=new JSONObject(json);;
		return jsonObject;
		
	}
	
	/**
	 * ��ץȡ��jsonObject  �����Musicsheet[]
	 * @author sparrow
	 */
	public static MusicSheet[] jsonToMap() throws Exception {
		JSONObject a=getjson();
		
		//���json  musicSheetList����  �����һ���赥����
		JSONArray b=a.getJSONArray("musicSheetList");
		//ʹ��musicsheet��������
		MusicSheet[] musicSheet=new MusicSheet[b.length()];
		//����赥
		
		//��ʼ��������
		for(int i=0;i<b.length();i++) {
			//һ���赥
			JSONObject c=new JSONObject(b.getString(i));
			//��ʼ��������ʼ���ͻᱨ��ָ���쳣��
			musicSheet[i] = new MusicSheet();
			
			//��ȡÿ���赥�еĸ���
			JSONObject songlistArray=c.getJSONObject("musicItems");
			//��ȡ�赥������<-----c�е�"creator"����Ӧ��ֵ��   new String(string.getBytes(),"utf-8")�ǽ����������
			musicSheet[i].setCreator(new String(c.getString("creator").getBytes(),"utf-8"));
			//��ȡ����ʱ��
			musicSheet[i].setDateCreated(new String(c.getString("dateCreated").getBytes(),"utf-8"));
			//......
			musicSheet[i].setCreatorId(new String(c.getString("creatorId").getBytes(),"utf-8"));
			
			musicSheet[i].setlistid(new String(c.getString("id").getBytes(),"utf-8"));
			
			musicSheet[i].setName(new String(c.getString("name").getBytes(),"utf-8"));
			
			musicSheet[i].setPicture(new String(c.getString("picture").getBytes(),"utf-8"));
			
			musicSheet[i].setUuid(new String(c.getString("uuid").getBytes(),"utf-8"));
			
			//��ȡ key  Ҳ����MD5
			if(songlistArray.keys()!=null) {
				//**������������֪����ʲô��      ���ڻ�ȡ�赥��keyֵ
				Iterator<String> it =songlistArray.keys(); 
				
				//����   �������
				while(it.hasNext()){
					String keyString=new String(it.next());
					//Map.put(key,value);��MD5  �͸�����put ��Map ��
					musicSheet[i].musicItems.put(keyString, songlistArray.getString(keyString));
				
				}
			}
			
		}
		return musicSheet;
	}
}

