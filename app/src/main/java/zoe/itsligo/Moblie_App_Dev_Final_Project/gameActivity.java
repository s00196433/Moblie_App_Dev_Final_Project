package zoe.itsligo.Moblie_App_Dev_Final_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import zoe.itsligo.Moblie_App_Dev_Final_Project.R;

public class gameActivity extends AppCompatActivity implements SensorEventListener {



    private ImageView img1,img2,img3,img4;




     private int TotalPoints = 0;

    String[] directionArray = new String[4];


    List<String> tiltList = new ArrayList<String>();
    List<String> directionList =new ArrayList<String>();

    String TotalPointsString;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private int color1,color2, color3,color4;
    private int setColor1,setColor2,setColor3,setColor4;

    TextView directionResult ,tiltResult ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);



        img1 =(ImageView)findViewById(R.id.image1);
        img2 =(ImageView)findViewById(R.id.image2);
        img3 =(ImageView)findViewById(R.id.image3);
        img4 =(ImageView)findViewById(R.id.image4);



        directionResult=findViewById(R.id.directionResultTv);
        tiltResult=findViewById(R.id.tvTilt);



        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            color1 = extras.getInt("c1");
            color2 = extras.getInt("c2");
            color3 = extras.getInt("c3");
            color4 = extras.getInt("c4");

            setColor1 = randomColor();
            setColor2 = randomColor();
            setColor3 = randomColor();
            setColor4 = randomColor();

        }

            do{

                if ((setColor1 == setColor2) || (setColor1 == setColor3) || (setColor1 == setColor4) ) {
                    setColor1 = randomColor();

                } else if ((setColor2 == setColor1) || (setColor2 == setColor3) || (setColor2 == setColor4)) {
                    setColor2 = randomColor();

                } else if ((setColor3 == setColor1) || (setColor3 == setColor2) || (setColor3 == setColor4)) {
                    setColor3 = randomColor();

                } else if ((setColor4 == setColor1) || (setColor4 == setColor2) || (setColor4 == setColor3)) {
                    setColor4 = randomColor();

                }
            } while ((setColor1 == setColor2) || (setColor1 == setColor3) || (setColor1 == setColor4) ||(setColor2 == setColor1) || (setColor2 == setColor3) || (setColor2 == setColor4) ||(setColor3 == setColor1) || (setColor3 == setColor2) || (setColor3 == setColor4)  || (setColor4 == setColor1) || (setColor4 == setColor2) || (setColor1 == setColor3));

            img1.setColorFilter(setColor1);
            img2.setColorFilter(setColor2);
            img3.setColorFilter(setColor3);
            img4.setColorFilter(setColor4);


            //first color



                if (color1 == setColor1) {
                    directionArray[0] = "N";
                } else if (color1 == setColor2) {
                    directionArray[0] = "E";
                } else if (color1 == setColor3) {
                    directionArray[0] = "S";
                } else if (color1 == setColor4) {
                    directionArray[0] = "W";
                }

                //second color
                if (color2 == setColor1) {
                    directionArray[1] = "N";
                } else if (color2 == setColor2) {
                    directionArray[1] = "E";
                } else if (color2 == setColor3) {
                    directionArray[1] = "S";
                } else if (color2 == setColor4) {
                    directionArray[1] = "W";
                }

                // third color
                if (color3 == setColor1) {
                    directionArray[2] = "N";
                } else if (color3 == setColor2) {
                    directionArray[2] = "E";
                } else if (color3 == setColor3) {
                    directionArray[2] = "S";
                } else if (color3 == setColor4) {
                    directionArray[2] = "W";
                }

                //fourth color
                if (color4 == setColor1) {
                    directionArray[3] = "N";

                } else if (color4 == setColor2) {
                    directionArray[3] = "E";
                } else if (color4 == setColor3) {
                    directionArray[3] = "S";
                } else if (color4 == setColor4) {
                    directionArray[3] = "W";
                }


        directionList = Arrays.asList(directionArray);

        directionResult.setText(directionList.toString());



    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        int a = event.accuracy;

        if (Math.abs(x) > 0.1f) {

        }

        if (Math.abs(y) > 0.1f) {

        }
        if (Math.abs(z) > 0.1f) {

        }

       int  size = tiltList.size();

        if  (size != 4) {
            if (x < 0.2f & x > 0f) {


                if (!tiltList.contains("N")) {
                    tiltList.add("N");

                }
            } else if (x > 0.8f) {


                if (!tiltList.contains("S")) {
                    tiltList.add("S");

                }

            }

            if (y > 0.35f) {

                if (!tiltList.contains("W")) {
                    tiltList.add("W");
                }
            } else if (y < -0.24f) {

                if (!tiltList.contains("E")) {
                    tiltList.add("E");
                }
            }
        }

        if (size == 4)
        {
            int val1 = 0;
            int val2 = 0;
            int val3 = 0;
            int val4 = 0;

            if (tiltList.get(0) == directionList.get(0)) {
                if (val1 != 5) {
                    val1 = 5;
                }
            }
            if (tiltList.get(1) == directionList.get(1)  ) {
                if (val2 != 10) {
                    val2 = 10;
                }

            }
            if (tiltList.get(2) == directionList.get(2)) {
                if (val3 != 15) {
                    val3 = 15;
                }

            }
            if (tiltList.get(3) == directionList.get(3)) {
                if (val4 != 20) {
                    val4 = 20;
                }
            }

            TotalPoints = val1 + val2+ val3+ val4;

if (TotalPoints == 50) {

    SharedPreferences preferences = getSharedPreferences("PRESS",0);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("lastScore",TotalPoints);
    editor.apply();

    Intent intent = new Intent(getApplicationContext(),highScoreActivity.class);
    startActivity(intent);
    finish();


}
else
{
    Intent i = new Intent(gameActivity.this, loseActivity.class);
    i.putExtra("TotalPoints", TotalPoints);
    startActivity(i);

}


        }

        tiltResult.setText(tiltList.toString());
    }

    private int randomColor(){
        List<Integer> colors = new ArrayList<>();
        colors.add(color1);
        colors.add(color2);
        colors.add(color3);
        colors.add(color4);
        Random rand = new Random();
        return colors.get(rand.nextInt(colors.size()));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /*
     * When the app is brought to the foreground - using app on screen
     */
    protected void onResume() {
        super.onResume();
        // turn on the sensor
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    /*
     * App running but not on screen - in the background
     */
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);    // turn off listener to save power    }
    }

   }