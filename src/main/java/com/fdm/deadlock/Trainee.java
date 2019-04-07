package com.fdm.deadlock;

public class Trainee extends Thread {
	private Pen pen;
	private Board board;

	public Trainee(Pen pen, Board board) {
		super("Trainee thread");
		this.pen = pen;
		this.board = board;
	}

	@Override
	public void run() {
		while (true) {
			if (pen.isAvailable()) {
				synchronized (pen) {
					if (board.isAvailable()) {

						synchronized (board) {
							System.out.println("Trainee wrties on board.");
						}
						board.finished();
					}
					pen.finished();
				}
			}
		}
	}

}
