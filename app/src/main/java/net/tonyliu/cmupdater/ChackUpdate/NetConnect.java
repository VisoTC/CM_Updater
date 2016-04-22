package net.tonyliu.cmupdater.ChackUpdate;

import net.tonyliu.cmupdater.Item;
import net.tonyliu.cmupdater.Tool.SortComparator;
import net.tonyliu.cmupdater.ValueInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by szlyt on 2016/4/15 0015.
 */
public class NetConnect {
    private String Url;

    public NetConnect(String Url) {
        this.Url = Url;
    }

    public String connect() {
        if(Url != null){
            return connect(Url);
        }else {
            return null;
        }
    }

    public String connect(String url) {
        try {
            URL Url = new URL(url); //"http://192.168.1.110/version.json"
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);//超时时间
            InputStream inStream = connection.getInputStream();
            ByteArrayOutputStream data = new ByteArrayOutputStream();//新建一字节数组输出流
            byte[] buffer = new byte[1024];//在内存中开辟一段缓冲区，接受网络输入流
            int len;
            while ((len = inStream.read(buffer)) != -1) {
                data.write(buffer, 0, len); //缓冲区满了之后将缓冲区的内容写到输出流
            }
            inStream.close();
            return new String(data.toByteArray(), "utf-8");//最后可以将得到的输出流转成utf-8编码的字符串，便可
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Json解析并写入版本列表集合
     */
    /** 版本文件示例
    {
	    "minimumVersion": 2,
        "VersionList":[
        {
        	"Name": "cm-13.0-20160203-UNOFFICIAL-pisces",
        	"Version": 20160203,
        	"Description": "",
        	"Url": "http://cmupdate-10021188.file.myqcloud.com/cm-13.0-20160203-UNOFFICIAL-pisces.zip",
        	"Hash": "Hash"
	    },
    	{
	        "Name": "cm-13.0-20160204-UNOFFICIAL-pisces",
	        "Version": 20160204,
            "Description": "cm-13.0-20160204-UNOFFICIAL-pisces",
	        "Url": "http://cmupdate-10021188.file.myqcloud.com/cm-13.0-20160204-UNOFFICIAL-pisces.zip",
	        "Hash": "Hash"
    	},
    	{
    	    "Name": "cm-13.0-20160205-UNOFFICIAL-pisces",
        	"Version": 20160205,
        	"Description": "cm-13.0-20160205-UNOFFICIAL-pisces",
        	"Url": "http://cmupdate-10021188.file.myqcloud.com/cm-13.0-20160205-UNOFFICIAL-pisces.zip",
           "Hash": "Hash"}
	    ]
    }
    */
    public void parseJson(String strResult) {
        try {
            JSONObject jsonObj = new JSONObject(strResult);
            JSONArray jsonArray = jsonObj.getJSONArray("VersionList");
            if (jsonObj.getInt("minimumVersion") == 2) {      //配置读取的版本号
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject list = (JSONObject) jsonArray.get(i);
                    Item item = new Item(
                            list.getString("Name"),           //名字
                            list.getInt("Version"),           //版本号
                            list.getString("Description"),    //简介
                            list.getString("Url"),            //下载地址
                            list.getString("Hash")            //哈希值
                    );
                    Comparator comp = new SortComparator();
                    Collections.sort(ValueInfo.versionInfoList, comp);//
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<Item> sequence(List<Item> Array, Item addItem) {
        for (int i = 0; i < Array.size(); i++) {
            Item item = Array.get(i);
            if (item.getVersion() < addItem.getVersion()) {
                Array.add(i, item);
                break;
            } else if (item.getVersion() == addItem.getVersion()) {
                Array.set(i, addItem);
                break;
            }
        }
        return Array;
    }
}
