package muroga.matsuoka.new_search;

import android.graphics.Bitmap;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import muroga.matsuoka.new_search.Shop;

import java.io.IOException;
import java.util.ArrayList;

public class Content{

    public static ArrayList<String> productImageNameS = new ArrayList<String>();
    public static ArrayList<String> productImageNameL = new ArrayList<String>();
    public static ArrayList<String> productImageNameF = new ArrayList<String>();
    public static ArrayList<String> productImageNameS_2 = new ArrayList<String>();
    public static ArrayList<String> productImageNameL_2 = new ArrayList<String>();
    public static ArrayList<String> productImageNameF_2 = new ArrayList<String>();

    void start()throws IOException {

        Database di = new Database();
        //d.setReview("lawson", "product01", 10, "ふわふわとろとろで今までのコンビニ焼き飯とは一線を画す味でした。");
        //d.setStar("lawson", "product4",  4.5);
        //d.setStarNum("lawson", "product4");

        String date = "0";
        di.getImageName("seven", date);
        di.getImageName("lawson", date);
        di.getImageName("family", date);
        try {
            Thread.sleep(2000); // ミリ秒処理を止める
        } catch (InterruptedException e) {
        }

        Log.d("abc","image download start");
        for(int i=0;i<productImageNameS.size();i++) {
            di.getImage(date,"seven",productImageNameS.get(i), i);
        }
        for(int i=0;i<productImageNameL.size();i++) {
            di.getImage(date,"lawson",productImageNameL.get(i), i);
        }
        for(int i=0;i<productImageNameF.size();i++) {
            di.getImage(date,"family",productImageNameF.get(i), i);
        }



    }



    
    public static void setImageNameS(String name){
        productImageNameS.add(name);
    }
    public static void setImageNameL(String name){
        productImageNameL.add(name);
    }
    public static void setImageNameF(String name){
        productImageNameF.add(name);
    }





}

