package net.tonyliu.cmupdater.ChackUpdate;

/**
 * Created by szlyt on 2016/4/15 0015.
 */
public class ChackThread implements Runnable {
    public void run(){
        NetConnect netConnect = new NetConnect("http://127.0.0.1/version.json");
        netConnect.parseJson(netConnect.connect());
    }
}
