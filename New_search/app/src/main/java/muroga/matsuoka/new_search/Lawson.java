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

    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 2;


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



    String getLink(Elements soup) throws IOException {
        String str1 = "新商品";
        String url = "";

        Elements s1 = soup.select("a");
        for (Element i : s1) {
            if (str1.equals(i.text())){
                url = i.attr("href");
            }
        }
        return url;
    }

    String getLink2(Elements soup) throws IOException {
        String url = "";
        Elements s2 = soup.select("meta");
        for(Element element : s2){
            url = element.attr("content");
            url = url.split("URL=")[1];
        }
        return url;
    }

    String getLinkOtherDay(Elements soup) throws IOException {
        String str1 = "新商品";
        String url = "";

        Elements s1 = soup.select("a");
        for (int i = 0; i < s1.size(); i++) {
            if (str1.equals(s1.get(i).text())){
                //Log.d("abc", s1.get(i).text());
                //Log.d("abc", s1.get(i+cnt).text());
                //Log.d("abc", String.valueOf(i));
                //Log.d("abc", String.valueOf(i+cnt));
                url = s1.get(i+cnt).attr("href");
                //Log.d("abc", url);
            }
        }
        cnt++;
        return url;
    }

    String[] getLinkImage(Elements ele){
        String url = "";
        Elements ele2 = ele.select("img");
        Elements ele3 = ele2.select("[height=235]");
        String[] str = new String[ele3.size()];
        for (int i = 0; i < ele3.size(); i++) {
            url = ele3.get(i).attr("src");
            str[i] = url;
        }
        return str;
    }

    String[] getContent(Elements e) throws IOException {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        String str1 = "発売日" + String.valueOf(year) + "." + String.valueOf(month+1) + "." + String.valueOf(date);
        String str2 = "発売日2020.10.06";
        String[] a = new String[300];
        int cnt = 0;
        Elements ele2 = e.select("img");

        for(int day=0; day<40; day++) {
            date = date-1;
            if (date==0){
                month = month-1;
                date=31;
            }
            if (month==0){
                year = year-1;
                month = 12;
            }
            str1 = "発売日" + String.valueOf(year) + "." + String.format("%02d",month+1) + "." + String.format("%02d",date);
            //Log.d("abc", str1);
            for (int i = 0; i < e.size(); i++) {
                Log.d("abc", e.get(i).attr("src"));
                if (str1.equals(e.get(i).text())) {
                    //              Log.d("abc", e.get(i-2).attr("src"));
                    //                Log.d("abc", e.get(i-2).text());
                    //                Log.d("abc", e.get(i-1).text());
                    //               Log.d("abc", e.get(i).text());
                    //                Log.d("abc", "\n");
                    a[cnt] = e.get(i - 3).text();
                    a[cnt + 1] = e.get(i - 2).text();
                    a[cnt + 2] = e.get(i - 1).text();
                    a[cnt + 3] = e.get(i).text();
                    a[cnt + 4] = "\n";
                    cnt = cnt + 5;
                }
            }
        }
        return a;
    }

}



