package com.toastercat.ultrabutton.model;

import java.util.List;

import android.graphics.Color;

public class AudioButton {
	
	private List<String> labelText;
	private Color color;
	private boolean depressed;
	
	private String audioClipKey;
	private int audioClipId;
	
	public AudioButton() {
		
	}

	public int getAudioClipId() {
		return audioClipId;
	}
}
