package com.springinaction.springidol.hw1;

import com.springinaction.springidol.Performer;

public class Encore {
	private Performer encorePerformer;

	public void setPerformer(Performer p) {
		this.encorePerformer = p;
	}

	public void execute() {
		System.out.println("<Encore Performance>");
		encorePerformer.perform();
	}
}
