package com.toastercat.ultrabutton;

import com.toastercat.donttouchthebutton.R;
import com.toastercat.ultrabutton.audio.SoundManager;
import com.toastercat.ultrabutton.model.AudioButton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ButtonActivity extends Activity {
	
	private AudioButton audioButton;
	private SoundManager soundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        
        this.audioButton = new AudioButton();
        this.soundManager = new SoundManager(this.getBaseContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    public void playButtonAudio(final View v) {
    	this.soundManager.playAudioClip(this.audioButton.getAudioClipId());
    }
}
