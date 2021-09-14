package muroga.matsuoka.new_search;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class Lawson extends Shop {

    private String[]    info;
    private static ArrayList<Map> product = new ArrayList<Map>();



    public Lawson() throws IOException {
        super();
        this.name = "lawson";
        this.url = "https://www.lawson.co.jp";
    }

    public static void sendMain() {
        String[][] test = new String[10][4];
        for(int i=0;i<10;i++) {
            test[i][0]=(String)product.get(i).get("info1");
            test[i][1]=(String)product.get(i).get("info2");
            test[i][2]=(String)product.get(i).get("info3");
            test[i][3]=(String)product.get(i).get("info4");
        }
        MainActivity.setTextValues(test);
    }
    public static void setData(Map data) {
        /*
        Log.d("abc", "Lawson");
        Log.d("abc", (String)data.get("info1"));
        Log.d("abc", (String)data.get("info2"));
        Log.d("abc", (String)data.get("info3"));
        Log.d("abc", (String)data.get("info4"));
        Log.d("abc", data.get("star").toString());
        Log.d("abc", data.get("star_num").toString());
        */
        product.add(data);
    }

    public static ArrayList<Map> getProductInfo(){
        return product;
    }



}



