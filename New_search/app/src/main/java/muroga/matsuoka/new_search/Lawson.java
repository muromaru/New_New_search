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
        MainActivity.setInfo("lawson",product);
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



