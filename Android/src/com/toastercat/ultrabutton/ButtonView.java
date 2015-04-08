package com.toastercat.ultrabutton;

import java.util.Observable;
import java.util.Observer;

import com.toastercat.ultrabutton.model.AudioButton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ButtonView extends View 
	implements Observer
{
	private AudioButton  button;

	private final Paint brush = new Paint();
	
	// Button Attrs
	private Point buttonCenter = new Point();
	private int faceRadius;
	private int baseRadius;

	public ButtonView(final Context context, final AttributeSet attrs) {
		super(context, attrs);

		this.brush.setTextSize(175f);
		this.brush.setTextScaleX(1.25f);
		this.brush.setTypeface(Typeface.SANS_SERIF);
		this.brush.setFakeBoldText(true);
		this.brush.setTextAlign(Align.CENTER);
	}
	
	/**
	 * Report Touch Events to Controller
	 */
	@Override
	public boolean onTouchEvent(final MotionEvent e) {
		boolean b = false;
		
		switch (e.getAction()) {
			case MotionEvent.ACTION_DOWN:
				b = true;
				if (this.pointInsideButtonFace(e.getX(), e.getY())) {
					button.setDepressed(true);
					button.playAudio();
					this.postInvalidate();
				}
				break;
			case MotionEvent.ACTION_UP:
				b = true;
				button.setDepressed(false);
				this.postInvalidate();
				break;
		}
		return b;
	}
	
	/**
	 * Draw the Button
	 */
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int cWidth = canvas.getWidth();
		int cHeight = canvas.getHeight();
		
		int cx = cWidth / 2;
		int cy = cHeight / 2;
		this.buttonCenter.set(cx, cy);
		this.baseRadius = Math.min(cWidth, cHeight) / 2;
		this.faceRadius = baseRadius * 3 / 4;
		
		if (this.button != null) {
			//- Button Base -------------------------------=
			//
			this.brush.setColor(this.button.getBaseColor());
			canvas.drawCircle(buttonCenter.x, buttonCenter.y, 
					this.baseRadius, this.brush);
			
			//- Button Face ------------------------------=
			//
			this.brush.setColor(this.button.getFaceColor());
			canvas.drawCircle(buttonCenter.x, buttonCenter.y,
					this.faceRadius, this.brush);
			this.brush.setColor(this.button.getLabelColor());
			float offsetY = this.brush.getTextSize() / 2f;
			canvas.drawText(this.button.getLabelText(),
					this.buttonCenter.x, this.buttonCenter.y + offsetY,
					this.brush);
			
			// Draw overlay for depression
			if (this.button.isDepressed()) {
				this.brush.setColor(Color.argb(100, 100, 100, 100));
				canvas.drawCircle(buttonCenter.x, buttonCenter.y,
						this.faceRadius, this.brush);
			}
		}
	}
	
	/**
	 * If anything changes in the model, the current display is invalid.
	 * 
	 * Force rewrite of current view image.
	 */
	@Override
	public void update(Observable observable, Object data) {
		this.postInvalidate();
	}
	
	public void setButton(final AudioButton button) {
		this.button = button;
	}
	
	private boolean pointInsideButtonFace(final float x, final float y) {
		// X
		final int lowX = this.buttonCenter.x - this.faceRadius;
		final int highX = this.buttonCenter.x + this.faceRadius;
		// Y
		final int lowY = this.buttonCenter.y - this.faceRadius;
		final int highY = this.buttonCenter.y + this.faceRadius;
		
		return ((x > lowX && x < highX) && (y > lowY && y < highY));
	}
}
