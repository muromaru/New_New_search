package muroga.matsuoka.new_search;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class FamilyMart extends Shop {


    private static ArrayList<Map> product = new ArrayList<Map>();




    public FamilyMart() throws IOException {
        super();
        this.name = "family_mart";
        this.url = "https://www.family.co.jp/goods/newgoods";
    }


    public static void sendMain() {
        MainActivity.setInfo("family",product);
    }

    public static void setData(Map data) {
        /*
        Log.d("abc", "Family");
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
