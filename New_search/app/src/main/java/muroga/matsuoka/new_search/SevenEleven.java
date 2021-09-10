package muroga.matsuoka.new_search;


import android.util.Log;
import android.graphics.Bitmap;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class SevenEleven extends Shop {

    private static ArrayList<Map> product = new ArrayList<Map>();


    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 0;


    public SevenEleven() throws IOException {
        super();
        this.name = "seven_eleven";
        this.url = "https://www.sej.co.jp";
    }

    public static void setData(Map data) {
        /*
        Log.d("abc", "SevenEleven");
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


    Elements getElementsP(Elements e) throws IOException {
        Elements elements = e.select("p");
        return elements;
    }


    String[] getContent(Elements e) throws IOException {
        String[] a = new String[300];
        for (int i = 0; i < e.size(); i++) {
            a[i] = e.get(i).text();
        }
        return a;
    }

    String[] getLinkImage(Elements ele){
        String url = "";
        String url2 = "";
        int cnt = 0;
        Elements ele2 = ele.select("img");
        String[] str = new String[ele2.size()];
        for (int i = 0; i < ele2.size(); i++) {
            url = ele2.get(i).attr("data-original");
            str[i] = url;
        }
        return str;
    }


}
