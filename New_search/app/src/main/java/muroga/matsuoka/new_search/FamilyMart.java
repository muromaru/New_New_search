package muroga.matsuoka.new_search;


import android.graphics.Bitmap;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FamilyMart extends Shop {


    private static ArrayList<Map> product = new ArrayList<Map>();

    //private Document document;
    String[] a = new String[100];
    String[][] bb = new String[10][100];
    Bitmap[] image = new Bitmap[100];
    int cnt = 0;


    public FamilyMart() throws IOException {
        super();
        this.name = "family_mart";
        this.url = "https://www.family.co.jp/goods/newgoods";
    }


    public static void setData(Map data) {
        product.add(data);
    }

    public static ArrayList<Map> getProductInfo(){
        return product;
    }






    public String[][] flow() throws IOException {
        getInfo();
        Log.d("abc", "aaa111");
        getSoup(this.url);
        String[] str1 = getElementsTxTt();
        Log.d("abc", str1[0]);
        Log.d("abc", "aaa222");
        bb[0] = str1;

        Elements ele = getElementsP();
        String[] urlImage = getLinkImage(ele);
        for(int i=0;i<urlImage.length;i++){
            urlImage[i] = "https://www.family.co.jp" + urlImage[i];
        }
        image = getImage(urlImage);
//        MainActivity.setImageValues(image);
        MainActivity.setImageValues(image);
        MatsuokaActivity1.setImageValues2(image);
        MatsuokaActivity2.setImageValues3(image);

        Log.d("abc", "f.flow finish");
        return bb;
    }





    String[] getLinkImage(Elements ele){
        String url = "";
        String url2 = "";
        int cnt = 0;
        Elements ele2 = ele.select("img");
        String[] str = new String[ele2.size()];
        for (int i = 0; i < ele2.size(); i++) {
            url = ele2.get(i).attr("src");
            url2 = ele2.get(i).attr("alt");
            if(url.equals(url2)) {
                str[cnt] = url;
                cnt += 1;
            }
        }
        String[] str2 = new String[cnt];
        for (int i = 0;i<cnt;i++){
            str2[i] = str[i];
        }
        return str2;
    }

    Elements getElementsCate() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-cate]");
        return elements;
    }
    Elements getElementsTtl() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-ttl]");
        return elements;
    }
    Elements getElementsTxt() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-txt]");
        return elements;
    }
    String[] getElementsTxTt() throws IOException{
        Document document = getDocument();
        Elements elements = document.select("[class=ly-mod-infoset4-txt],[class=ly-mod-infoset4-ttl]");
        String[] a = new String[100];
        String str = "";
        for (int i = 0; i < elements.size(); i++) {
            str += elements.get(i).text();
            if(i%2==1){
                int num = i/2;
                a[num] = str;
                str = "";
            }
        }
        return a;
    }




}
