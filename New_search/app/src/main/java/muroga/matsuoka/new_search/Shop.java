package muroga.matsuoka.new_search;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

import java.net.URL;
import java.util.Map;

public class Shop {

    private String[]    info;


    String name;
    String url;
    private Document document;

    public Shop() throws IOException {

    }




    void getInfo(){
        Log.d("abc", this.name + "は" + this.url);
    }


    void getSoup(String url) throws IOException{
        document = Jsoup.connect(url).get();
    }

    Document getDocument() throws IOException{
        return document;
    }
    Elements getElements() throws IOException{
        Elements elements = document.getAllElements();
        return elements;
    }
    Elements getElementsP() throws IOException{
        Elements elements = document.select("p");
        return elements;
    }
    Elements getElementsA() throws IOException{
        Elements elements = document.select("a");
        return elements;
    }
    Elements getElementsLi() throws IOException{
        Elements elements = document.select("li");
        return elements;
    }
    Elements getElementsH3() throws IOException{
        Elements elements = document.select("h3");
        return elements;
    }
    Elements getElementsFlex() throws IOException{
        Elements elements = document.select("[class=flex_wrap]");
        return elements;
    }
    Elements getElementsActive() throws IOException{
        Elements elements = document.select("[class=active]");
        return elements;
    }
    Elements getElementsCate() throws IOException{
        Elements elements = document.select("[class=ly-mod-infoset4-cate");
        return elements;
    }
    Elements getElementsTtl() throws IOException{
        Elements elements = document.select("[class=ly-mod-infoset4-ttl]");
        return elements;
    }
    Elements getElementsTxt() throws IOException{
        Elements elements = document.select("[class=ly-mod-infoset4-txt]");
        return elements;
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

    Bitmap[] getImage(String[] url) throws IOException{
        Bitmap[] image = new Bitmap[url.length];
        for (int i = 0; i < url.length; i++) {
            URL image_url =new URL(url[i]);
            InputStream image_istream = image_url.openStream();
            image[i] = BitmapFactory.decodeStream(image_istream);
        }
        return image;
    }


//    String getLink(Elements soup) throws IOException {
//        String str1 = "新商品";
//        String url = "";
//
//        Elements s1 = soup.select("a");
//        for (Element i : s1) {
//            if (str1.equals(i.text())){
//                url = i.attr("href");
//            }
//        }
//        return url;
//    }
//
//    String getLink2() throws IOException {
//        String url = "";
//
//        Elements s2 = l.document.select("meta");
//        for(Element element : s2){
//            url = element.attr("content");
//            url = url.split("URL=")[1];
//        }
//        return url;
//    }
//
//    String getLinkOtherDay(Elements soup) throws IOException {
//        String str1 = "新商品";
//        String url = "";
//
//        Elements s1 = soup.select("a");
//        for (int i = 0; i < s1.size(); i++) {
//            if (str1.equals(s1.get(i).text())){
//                //Log.d("abc", s1.get(i+cnt).text());
//                url = s1.get(i+cnt).attr("href");
//                //Log.d("abc", url);
//            }
//        }
//        cnt++;
//        return url;
//    }
//
//    String[] getContent(Elements e) throws IOException {
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int date = cal.get(Calendar.DATE);
//        String str1 = "発売日" + String.valueOf(year) + "." + String.valueOf(month+1) + "." + String.valueOf(date);
//        String str2 = "発売日2020.10.06";
//        String[] a = new String[300];
//        int cnt = 0;
//        Elements ele2 = e.select("img");
//
//        for(int day=0; day<40; day++) {
//            date = date-1;
//            if (date==0){
//                month = month-1;
//                date=31;
//            }
//            if (month==0){
//                year = year-1;
//                month = 12;
//            }
//            str1 = "発売日" + String.valueOf(year) + "." + String.format("%02d",month+1) + "." + String.format("%02d",date);
//            //Log.d("abc", str1);
//            for (int i = 0; i < e.size(); i++) {
//                Log.d("abc", e.get(i).attr("src"));
//                if (str1.equals(e.get(i).text())) {
//                    //              Log.d("abc", e.get(i-2).attr("src"));
//                    //                Log.d("abc", e.get(i-2).text());
//                    //                Log.d("abc", e.get(i-1).text());
//                    //               Log.d("abc", e.get(i).text());
//                    //                Log.d("abc", "\n");
//                    a[cnt] = e.get(i - 3).text();
//                    a[cnt + 1] = e.get(i - 2).text();
//                    a[cnt + 2] = e.get(i - 1).text();
//                    a[cnt + 3] = e.get(i).text();
//                    a[cnt + 4] = "\n";
//                    cnt = cnt + 5;
//                }
//            }
//        }
//        return a;
//    }



}
