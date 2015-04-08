package com.toastercat.ultrabutton.model;

import com.toastercat.ultrabutton.audio.SoundManager;

/**
 * Audio Button
 * 
 * @author Dirk Hortensius [Dirker27@GitHub]
 */
public class AudioButton {
	
	//- Attribute Data -----------------------------------=
	//
	// TODO: Move to dedicate Attr Class
	//
	// Label
	private String labelText;
	//
	// Coloring
	private int labelColor;
	private int faceColor;
	private int baseColor;
	//
	// Audio Clip
	private int audioClipId;
	//
	// Interaction
	private boolean depressed;
	
	//- Toolset ------------------------------------------=
	//
	private SoundManager soundManager;
	
	public AudioButton() { /* . . . */ }
	
	/**
	 * Plays the Audio clip
	 */
	public void playAudio() {
		this.soundManager.playAudioClip(this.audioClipId);
	}
	
	//~ ACCESSORS =============================================== ~/
	//
	//- Label Text ---------------------------------------=
	public void setLabelText(final String lt) { this.labelText = lt; }
	public String getLabelText() { return this.labelText; }
	//- Audio Clip ID ------------------------------------=
	public void setAudioClipId(final int id) { this.audioClipId = id; }
	public int getAudioClipId() { return this.audioClipId; }
	//- Label Color --------------------------------------=
	public void setLabelColor(final int c) { this.labelColor = c; }
	public int getLabelColor() { return this.labelColor; }
	//- Face Color ---------------------------------------=
	public void setFaceColor(final int c) { this.faceColor = c; }
	public int getFaceColor() { return this.faceColor; }
	//- Base Color ---------------------------------------=
	public void setBaseColor(final int c) { this.baseColor = c; }
	public int getBaseColor() { return this.baseColor; }
	//- Depressed ----------------------------------------=
	public void setDepressed(final boolean d) { this.depressed = d; }
	public boolean isDepressed() { return this.depressed; }
	//- Sound Manager ------------------------------------=
	public void setSoundManager(final SoundManager m) { this.soundManager = m; }	
}