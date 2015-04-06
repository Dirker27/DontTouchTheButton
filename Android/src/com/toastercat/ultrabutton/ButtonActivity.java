package com.toastercat.ultrabutton;

import com.toastercat.donttouchthebutton.R;
import com.toastercat.ultrabutton.audio.SoundManager;
import com.toastercat.ultrabutton.model.AudioButton;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ButtonActivity extends Activity {
	
	private AudioButton audioButton;
	private ButtonView view;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        
        this.view = (ButtonView) this.findViewById(R.id.primary_button_view);

        //- Default Buton (NERD) -------------------------=
        //
        // Attr's
        this.audioButton = new AudioButton();
        this.audioButton.setBaseColor(Color.GRAY);
        this.audioButton.setFaceColor(Color.GREEN);
        this.audioButton.setAudioClipId(0);
        this.audioButton.setLabelText("NERD");
        // Functionality
        final SoundManager soundManager = new SoundManager(this.getBaseContext());
        this.audioButton.setSoundManager(soundManager);
        
        this.view.setButton(this.audioButton);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    /**
     * Only for v1 with raw button assignment
     * 
     * @param v
     */
    public void playButtonAudio(final View v) {
    	this.audioButton.playAudio();
    }
}
