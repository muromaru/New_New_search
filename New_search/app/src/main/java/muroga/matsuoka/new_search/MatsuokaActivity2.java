package muroga.matsuoka.new_search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MatsuokaActivity2 extends AppCompatActivity {

    public static Bitmap[] imageValues3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matsuoka2);

        Intent intent = getIntent();
        Log.d("abc", "_1");
        int imagenumber = intent.getIntExtra("TEst2",0);
        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageBitmap(imageValues3[imagenumber]);

//        String b = intent.getStringExtra("TEst2");

//        textView.setText(a);
//        ImageView imageView = fileList(image_view);
//        imageView.setImageBitmap(b);


    }
    public static void setImageValues3 (Bitmap[]i){

        imageValues3 = i;
    }


}