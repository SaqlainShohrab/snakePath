package com.saqqu.snakepath;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.saqqu.snakepath.actors.PositionedActor;


public class ScoreBoard extends PositionedActor {
	private int score;

	public ScoreBoard(AbstractGamePanel context) {
		super(context.getWidth() - 150, 30);
		this.score = 0;
	}

	@Override
	public void stylePaint(Paint p) {
		p.setTextSize(20);
	}
	
	public void earnPoints(int points) {
		score += points;
		App.prefs.putStringExtra(Constants.SCORE, String.valueOf(score));
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawText("Score: " + score, getX(), getY(), getPaint());
	}

}
