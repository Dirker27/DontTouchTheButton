package com.toastercat.ultrabutton.audio;

import com.toastercat.donttouchthebutton.R;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundManager {
	
	private static final int DEFAULT_PLAYBACK_PRIORITY = 1;
	private static final int DEFAULT_LOOP_COUNT = 0;
	private static final float DEFAULT_PLAYBACK_RATE = 1f;
	
	private float playbackVolume = 10.0f;
	
	private final SoundPool soundPool;
	
	private final int defaultSoundId;
	
	public SoundManager(final Context c) {
		this.soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		
		this.defaultSoundId = this.soundPool.load(c, R.raw.nerd, 1);
		//this.defaultSoundId = this.soundPool.load("audio/nerd.wav", 1);

		//- Available in Android 5 (API 21) --------------=
		//
		/*final AudioAttributes audioAttrs =
			new AudioAttributes.Builder()
				.setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
				.setUsage(AudioAttributes.USAGE_MEDIA)
				.build();
		
		this.soundPool = new SoundPool.Builder()
				.setMaxStreams(1)
				.setAudioAttributes(audioAttrs)
				.build();*/
	}
	
	public void playAudioClip(final int audioClipId) {
		
		int soundID = /* DO A THING */ this.defaultSoundId;
		
		this.soundPool.play(soundID, 
				playbackVolume, playbackVolume,
				DEFAULT_PLAYBACK_PRIORITY,
				DEFAULT_LOOP_COUNT,
				DEFAULT_PLAYBACK_RATE);
	}
}
