package muroga.matsuoka.new_search;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import muroga.matsuoka.new_search.Shop;

import java.io.IOException;

public class Content{

    void start()throws IOException {




        //String[][] a = {{"a1","b1"},{"a2","b2"},{"a3","b3"},{"a4","b4"}};
        //MainActivity.setTextValues(a);
        //
        //
        //データベースのテスト
        Database di = new Database();
        //d.setInfo("lawson", "product4",  "焼き炒飯");
        //d.setReview("lawson", "product01", 10, "ふわふわとろとろで今までのコンビニ焼き飯とは一線を画す味でした。");
        //d.setStar("lawson", "product4",  4.5);
        //d.setStarNum("lawson", "product4");
        for(int i=0;i<10;i++) {
            di.getImage(i);
        }
        //Double bbb = d.getStar("lawson", "product4");
        //Integer ddd = d.getStarNum("lawson", "product4");
        //String ccc = d.getReview("lawson", "product4", "review");


        Log.d("abc", "test");
        //Log.d("abc2", String.valueOf(bbb));
        //Log.d("abc", ccc);
        //
        //
    }







}

