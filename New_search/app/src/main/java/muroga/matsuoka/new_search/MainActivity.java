package muroga.matsuoka.new_search;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static String[][] textValues;
    private final String[] spinnerArea = {"北海道", "東北", "関東", "甲信越", "東海", "近畿", "中国", "四国", "九州", "沖縄"};
    private static Bitmap[] imageValues = new Bitmap[100];
    private static Integer cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);


        AsyncWork asyncWork = new AsyncWork();
        asyncWork.execute();


        int num = 0;
        while (num < 7){
            String str = String.valueOf(num);
            ImageButton "imgbutton"+str = findViewById(R.id.);
            imgbutton"+num".setImageBitmap(imageValues[num]);
            imgbutton"+num".setOnClickListener(new View.OnClickListener() {
                                              @RequiresApi(api = Build.VERSION_CODES.O)
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(getApplication(), ProductActivity.class);
                                                  intent.putExtra("productinfo",num);
                                                  startActivity(intent);
                                              }

            num = num + 1;
        }








        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerArea);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                String item = (String) spinner.getSelectedItem();
                textView.setText(item);
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });

    }


    //publicなのでどこからでも使える。
    public static void setTextValues (String[][]t){  //String[][]tは引数。tという名前の二次元配列
        textValues = t; //二次元配列tをtextValuesに入れた。
        Log.d("abc", t[0][0]);
        //final TextView textView1;
        //textView1 = findViewById(R.id.textview);
        //textView1.setText("OK!!!!!");
    }


    public static void setImageValue (Bitmap i){
        //imageValue = i;
        imageValues[cnt] = i;
        cnt++;
    }

}