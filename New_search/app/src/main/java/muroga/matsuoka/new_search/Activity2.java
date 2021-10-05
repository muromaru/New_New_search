package muroga.matsuoka.new_search;

import androidx.appcompat.app.AppCompatActivity;

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

import static muroga.matsuoka.new_search.MainActivity.productImageS;
import static muroga.matsuoka.new_search.MainActivity.productImageF;
import static muroga.matsuoka.new_search.MainActivity.productImageL;

public class Activity2 extends AppCompatActivity {

//    private static Bitmap[] productImageS_2 = new Bitmap[100];
//    private static Bitmap[] productImageL_2 = new Bitmap[100];
//    private static Bitmap[] productImageF_2 = new Bitmap[100];
    private static Integer cntS=0;
    private static Integer cntL=0;
    private static Integer cntF=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        Intent intent = getIntent();
        Log.d("abc", "_1");
        String shopname = intent.getStringExtra("TEst3");

        Log.d("abcd", shopname);


        if(shopname.equals("S")){
            Intent intentS = getIntent();
            int imagenumber = intentS.getIntExtra("TEst2",0);
            ImageView imageView = findViewById(R.id.image_1);
            imageView.setImageBitmap(productImageS[imagenumber]);
        }
        if(shopname.equals("F")){
            Intent intentS = getIntent();
            int imagenumber = intentS.getIntExtra("TEst2",0);
            ImageView imageView = findViewById(R.id.image_1);
            imageView.setImageBitmap(productImageF[imagenumber]);
        }
        if(shopname.equals("L")){
            Intent intentS = getIntent();
            int imagenumber = intentS.getIntExtra("TEst2",0);
            ImageView imageView = findViewById(R.id.image_1);
            imageView.setImageBitmap(productImageL[imagenumber]);
        }



    }
}