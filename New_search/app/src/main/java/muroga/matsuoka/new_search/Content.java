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

        Database di = new Database();
        //d.setReview("lawson", "product01", 10, "ふわふわとろとろで今までのコンビニ焼き飯とは一線を画す味でした。");
        //d.setStar("lawson", "product4",  4.5);
        //d.setStarNum("lawson", "product4");
        String date = "2109_1";
        for(int i=0;i<100;i++) {
            di.getImage(date,"seven",i);
            di.getImage(date,"lawson",i);
            di.getImage(date,"family",i);
        }


    }







}

