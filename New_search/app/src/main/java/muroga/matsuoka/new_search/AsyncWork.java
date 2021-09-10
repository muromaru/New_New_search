package muroga.matsuoka.new_search;


import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AsyncWork extends AsyncTask<Void, Void, Integer> {
    private String[][] textValues;
    private Integer i = 1;

    List<ArrayList<Map>> shop = new ArrayList<>();

    @Override
    protected Integer doInBackground(Void... params){
        try {
            Database d = new Database();
            d.getInfoAll();
            Content content = new Content();
            content.start();
            Log.d("abc", "Async success");
        } catch (IOException e) {
            Log.e("abc", "error");
            Log.e("abc", e.getMessage());
        }
        return i;
    }

    @Override
    protected void onPostExecute(Integer result) {

        Log.d("abc", "onPost");
    }

}