package com.saqqu.snakepath;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;


public class SnakeGamePanel extends AbstractGamePanel {

	Context context;
	SnakeGameActivity activity;
	public SnakeGamePanel(Context context, SnakeGameActivity activity) {
		super(context);
		this.context = context;
		this.activity = activity;
	}

	private SnakeActor snake;
	private AppleActor apple;
	private ScoreBoard score;
	private boolean isPaused = false;

	@Override
	public void onStart() {
		//this.setBackgroundColor(ContextCompat.getColor(context,R.color.colorAccent));

		this.snake = new SnakeActor(100, 100);
		this.apple = new AppleActor(200, 50);
		this.score = new ScoreBoard(this);
	}

	@Override
	public void onTimer() {
		if (!isPaused) {
			if (this.snake.checkBoundsCollision(this)) {
				this.snake.setEnabled(false);
			}
			this.snake.move();
			if (this.apple.intersect(this.snake)) {
				this.snake.grow();
				this.score.earnPoints(50);
				this.apple.reposition(this);
			}
		}
	}

	@Override
	public void redrawCanvas(Canvas canvas) {
		if (this.snake.isEnabled()) {
			this.snake.draw(canvas);
			this.apple.draw(canvas);
			this.score.draw(canvas);
		} else {
			//activity.finish();
			/*Paint p = getPaint();
			p.setTextSize(50);
			p.setColor(Color.BLACK);

			int height = canvas.getHeight();
			int width = canvas.getWidth();



			canvas.drawText("Game over!", 100, 100, p);*/
			gameThread.setRunning(false);
			//gameThread.stop();
			activity.startActivity(new Intent(context, GameOverActivity.class));
			activity.finish();

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		this.snake.handleKeyInput(keyCode);
		if (keyCode == KeyEvent.KEYCODE_G) {
			this.onStart();
		}
		if (keyCode == KeyEvent.KEYCODE_P) {
			isPaused = !isPaused;
		}
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			this.snake.handleTouchInput(event);
			return true;
		}
		return false;
	}

}
