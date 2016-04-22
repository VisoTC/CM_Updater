package net.tonyliu.cmupdater;

/**
 * Created by szlyt on 2016/4/15 0015.
 */

/**
 * 更新项
 */
public class Item {
    public String Name;      //名称
    public int Version;      //版本号
    public String Url;          //更新地址
    public String Description;  //描述
    public String Hash;         //哈希值
    public long DownloadID = -1;   //系统下载管理ID
    public int Status = -1;        //状态指示值

    public Item(String name, int Version, String Description, String Url, String Hash)  {
        this("",Version,Description,Url,Hash,-1);
    }

    public Item(String Name,int Version, String Description, String Url, String Hash, long DownloadID) {
        this.Name = Name;
        this.Version = Version;
        this.Url = Url;
        this.Description = Description;
        this.Hash = Hash;
        this.DownloadID = DownloadID;
    }

    private Item() {
    }

    public Item(String Description, int Status) {
        this.Version = 0;
        this.Description = Description;
        this.Status = Status;
    }

    public String getName() {
        return this.Name;
    }

    public int getVersion() {
        return Version;
    }

    public String getUrl() {
        return Url;
    }

    public String getDescription() {
        return Description;
    }

    public String getHash() {
        return Hash;
    }

    public long getDownloadID() {
        return DownloadID;
    }

    public int getStatus() {
        return Status;
    }

    //
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setVersion(int Version) {
        this.Version = Version;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setHash(String Hash) {
        this.Hash = Hash;
    }

    public void setDownloadID(long DownloadID) {
        this.DownloadID = DownloadID;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    //

}
