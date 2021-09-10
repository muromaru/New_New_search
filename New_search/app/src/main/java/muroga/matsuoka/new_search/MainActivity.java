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
    private ImageView imageView0;
    private static String[][] textValues;
    private static Bitmap[] imageValues;
    private final String[] spinnerArea = {"北海道", "東北", "関東", "甲信越", "東海", "近畿", "中国", "四国", "九州", "沖縄"};
    private static Bitmap[] imageValues_2 = new Bitmap[10];
    private static Integer cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        final ImageView imageView0 = findViewById(R.id.imageview0);
//        final ImageView imageView1 = findViewById(R.id.imageview1);
        final ImageView imageView2 = findViewById(R.id.imageview2);
        final ImageView imageView3 = findViewById(R.id.imageview3);
        final ImageView imageView4 = findViewById(R.id.imageview4);
        final ImageView imageView5 = findViewById(R.id.imageview5);


        AsyncWork asyncWork = new AsyncWork();
        asyncWork.execute();

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);


        button0.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe0");
                String str = String.join("\n", textValues[1]);
                textView.setText(str);
                imageView0.setImageBitmap(imageValues[0]);
                ImageButton imgbutton = findViewById(R.id.imagebutton0);
                imgbutton.setImageBitmap(imageValues[0]);
                imgbutton.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        Log.d("abc", "bbbbbbbbbbb");
                        //MainActivity2.setImageValues2(imageValues[0]);
                        Intent intent = new Intent(MainActivity.this, MurogaActivity2.class);
                        intent.putExtra("TEst", "Sample Message");
                        startActivity(intent);
                    }
                });
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe1");
                String str = String.join("\n", textValues[1]);
                textView.setText(str);
                ImageButton imgbutton1 = findViewById(R.id.imagebutton1);
                imgbutton1.setImageBitmap(imageValues[1]);
                imgbutton1.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(View v) {
                        Log.d("abc", "imagebutton1");
                        //MainActivity2.setImageValues2(imageValues[0]);
                        Intent intent = new Intent(getApplication(), MatsuokaActivity1.class);
//                        intent.putExtra("TEst", "Sample Message");
                        startActivity(intent);
                    }
                });

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe2");   //Stringは「文字列」
                String str = String.join("\n", textValues[2]);  //二次元配列であるtextValueを一次元にがっちゃんこ。
                textView.setText(str);
                imageView2.setImageBitmap(imageValues_2[2]);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe3");
                String str = String.join("\n", textValues[3]);
                textView.setText(str);
                imageView3.setImageBitmap(imageValues_2[3]);
                textView.setText(str);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "Exe4");
                String str = String.join("\n", textValues[4]);
                textView.setText(str);
                textView.setText(str);
                imageView4.setImageBitmap(imageValues_2[4]);
                ImageView image4 = findViewById(R.id.imageview4);   //表示非表示
                if (image4.getVisibility() != View.VISIBLE) {
                    image4.setVisibility(View.VISIBLE);
                } else {
                    image4.setVisibility(View.INVISIBLE);
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "aaaaaaaaaaaaaaaaa");
                Intent intent = new Intent(MainActivity.this, MurogaActivity2.class);
                intent.putExtra("TEst", "Sample Message");
                startActivity(intent);
            }
        });








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

    public static void setImageValues (Bitmap[]i){

        imageValues = i;
    }

    public static void setImageValue (Bitmap i){
        //imageValue = i;
        imageValues_2[cnt] = i;
        cnt++;
    }

}