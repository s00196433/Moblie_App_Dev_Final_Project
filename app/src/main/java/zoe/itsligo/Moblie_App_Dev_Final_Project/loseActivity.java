package zoe.itsligo.Moblie_App_Dev_Final_Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zoe.itsligo.Moblie_App_Dev_Final_Project.R;

public class loseActivity extends AppCompatActivity {

    TextView ScoreTv;
   private int TotalPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        ScoreTv = (TextView) findViewById(R.id.ScoreTv);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TotalPoints = extras.getInt("TotalPoints");
            //The key argument here must match that used in the other activity
        }
         ScoreTv.setText(String.valueOf("Your Score  was" + " " +TotalPoints));


    }

    public void doHighScore(View view) {

        SharedPreferences preferences = getSharedPreferences("PRESS",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("lastScore",TotalPoints);
        editor.apply();

        Intent intent = new Intent(getApplicationContext(),highScoreActivity.class);
        startActivity(intent);
        finish();
    }

    public void doPlayAgain(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}