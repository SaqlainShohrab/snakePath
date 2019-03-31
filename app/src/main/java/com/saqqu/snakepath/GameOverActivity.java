package com.saqqu.snakepath;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {


    TextView highestScoreTxt;
    ImageView restartBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme);

        setContentView(R.layout.activity_game_over);
        highestScoreTxt = findViewById(R.id.highest_score_txt);
        restartBtn = findViewById(R.id.restart_btn);

        highestScoreTxt.setText("Highest Score : " + App.prefs.getStringExtra(Constants.SCORE));


        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, SnakeGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
			/*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
				SnakeGameActivity.finishAffinity(this);
			}*/
            super.onBackPressed();
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
        //super.onBackPressed();
    }

}
