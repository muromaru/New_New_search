package muroga.matsuoka.new_search;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class SevenEleven extends Shop {

    private static ArrayList<Map> product = new ArrayList<Map>();


    public SevenEleven() throws IOException {
        super();
        this.name = "seven_eleven";
        this.url = "https://www.sej.co.jp";
    }

    public static void sendMain() {
        MainActivity.setInfo("seven",product);
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

}
