package muroga.matsuoka.new_search;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

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

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private TextView textView;
    private static ArrayList<Map> productInfoS = new ArrayList<Map>();
    private static ArrayList<Map> productInfoL = new ArrayList<Map>();
    private static ArrayList<Map> productInfoF = new ArrayList<Map>();
    private final String[] spinnerArea = {"北海道", "東北", "関東", "甲信越", "東海", "近畿", "中国", "四国", "九州", "沖縄"};
    public static Bitmap[] productImageS = new Bitmap[10000];
    public static Bitmap[] productImageL = new Bitmap[10000];
    public static Bitmap[] productImageF = new Bitmap[10000];
    private static Integer cntS=0;
    private static Integer cntL=0;
    private static Integer cntF=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.textview);
//        final ImageView imageView1 = findViewById(R.id.imageview1);

        TextView textView0 = findViewById(R.id.text0);
        textView0.setText("セブンイレブン");

        TextView textView1 = findViewById(R.id.text1);
        textView1.setText("ローソン");

        TextView textView2 = findViewById(R.id.text2);
        textView2.setText("ファミリーマート");

        AsyncWork asyncWork = new AsyncWork();
        asyncWork.execute();

        ImageButton imgbutton1 = findViewById(R.id.imagebutton_1);
        imgbutton1.setImageBitmap(productImageS[1]);
        imgbutton1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_1");
                Intent intent = new Intent(getApplication(), Activity2.class);
//                ImageView imageView__1 = findViewById(R.id.image_1);
//                imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2",1);
                intent.putExtra("TEst3","S");
                startActivity(intent);
            }
        });
        ImageButton imgbutton2 = findViewById(R.id.imagebutton_2);
        imgbutton2.setImageBitmap(productImageS[2]);
        imgbutton2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_2");
                Intent intent = new Intent(getApplication(), Activity2.class);
//                ImageView imageView__1 = findViewById(R.id.image_1);
//                imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2",2);
                intent.putExtra("TEst3","S");

                startActivity(intent);
            }
        });


        ImageButton imgbutton3 = findViewById(R.id.imagebutton_3);
        imgbutton3.setImageBitmap(productImageS[3]);
        imgbutton3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_3");
                Intent intent = new Intent(getApplication(), Activity2.class);
//                ImageView imageView__1 = findViewById(R.id.image_1);
//                imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2", 3);
                intent.putExtra("TEst3","S");

                startActivity(intent);
                    }
        });

        ImageButton imgbutton4 = findViewById(R.id.imagebutton_4);
        imgbutton4.setImageBitmap(productImageL[0]);
        imgbutton4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_4");
                Intent intent = new Intent(getApplication(), Activity2.class);
//               ImageView imageView__1 = findViewById(R.id.image_1);
//               imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2", 0);
                intent.putExtra("TEst3","L");

                startActivity(intent);
            }
        });

        ImageButton imgbutton5 = findViewById(R.id.imagebutton_5);
        imgbutton5.setImageBitmap(productImageL[1]);
        imgbutton5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_5");
                Intent intent = new Intent(getApplication(), Activity2.class);
//               ImageView imageView__1 = findViewById(R.id.image_1);
//               imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2", 1);
                intent.putExtra("TEst3","L");

                startActivity(intent);
            }
        });

        ImageButton imgbutton6 = findViewById(R.id.imagebutton_6);
        imgbutton6.setImageBitmap(productImageF[0]);
        imgbutton6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_6");
                Intent intent = new Intent(getApplication(), Activity2.class);
//               ImageView imageView__1 = findViewById(R.id.image_1);
//               imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2", 0);
                intent.putExtra("TEst3","F");

                startActivity(intent);
            }
        });

        ImageButton imgbutton7 = findViewById(R.id.imagebutton_7);
        imgbutton7.setImageBitmap(productImageF[1]);
        imgbutton7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.d("abc", "imagebutton_7");
                Intent intent = new Intent(getApplication(), Activity2.class);
//               ImageView imageView__1 = findViewById(R.id.image_1);
//               imageView__1.setImageBitmap(imageValues2[1]);
                intent.putExtra("TEst2", 1);
                intent.putExtra("TEst3","F");

                startActivity(intent);
            }
        });

    }


    public static void setInfo (String shop ,ArrayList<Map> product){
        if(shop=="seven"){productInfoS = product;}
        if(shop=="lawson"){productInfoL = product;}
        if(shop=="family"){productInfoF = product;}
    }


    public static void setImage(String shop , Bitmap i){
        if(shop=="seven"){
            productImageS[cntS] = i;
            cntS++;
        }
        if(shop=="lawson"){
            productImageL[cntL] = i;
            cntL++;
        }
        if(shop=="family"){
            productImageF[cntF] = i;
            cntF++;
        }

    }

}