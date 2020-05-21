package com.my.thread;

public class Fifth extends Thread{
	private int from, to;

	private int tot;
	public Fifth(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		for(int i = from; i <= to; i++) {
			tot += i;
		}
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	public int getTot() {
		return tot;
	}
}
