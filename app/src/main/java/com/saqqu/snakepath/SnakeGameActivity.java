package com.saqqu.snakepath;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


public class SnakeGameActivity extends GameActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		
		//before activity is created : cold start
        //switch back to original Theme (App Theme)
        setTheme(R.style.AppTheme);

		switchFullscreen();
		setContentView(new SnakeGamePanel(this, this));

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
