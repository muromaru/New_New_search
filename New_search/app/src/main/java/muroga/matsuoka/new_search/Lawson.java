package muroga.matsuoka.new_search;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Lawson extends Shop {

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


}



