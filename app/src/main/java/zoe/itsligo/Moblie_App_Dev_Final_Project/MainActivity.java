package zoe.itsligo.Moblie_App_Dev_Final_Project;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Button StartButton;
    private ImageView img1,img2,img3,img4;
   private int color1 , color2 , color3 , color4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        StartButton = findViewById(R.id.StartButton);

        img1 =(ImageView)findViewById(R.id.image1);
        img2 =(ImageView)findViewById(R.id.image2);
        img3 =(ImageView)findViewById(R.id.image3);
        img4 =(ImageView)findViewById(R.id.image4);


        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Random random = new Random();

                color1 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                color2 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                color3 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                color4 = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));


                img1.setColorFilter(color1);
                img2.setColorFilter(color2);
                img3.setColorFilter(color3);
                img4.setColorFilter(color4);

            }
        });
    }



    public void doNextPage(View view) {
        //String value="I hope this work";
        Intent i = new Intent(MainActivity.this, gameActivity.class);
        i.putExtra("c1",color1);
        i.putExtra("c2",color2);
        i.putExtra("c3",color3);
        i.putExtra("c4",color4);
        startActivity(i);
    }


}
