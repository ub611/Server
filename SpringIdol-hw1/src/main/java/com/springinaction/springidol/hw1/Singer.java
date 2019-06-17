package com.springinaction.springidol.hw1;

import com.springinaction.springidol.PerformanceException;
import com.springinaction.springidol.Performer;

public class Singer implements Performer {
	private String name;
	private Song song;

	public Singer() {
	}

	public Singer(String name, Song song) {
		this.song = song;
		this.name = name;
	}

	public Song getSong() {
		return song;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + " is singing a song \"" + song.getTitle() + "\" by " + song.getComposer());
	}
}
