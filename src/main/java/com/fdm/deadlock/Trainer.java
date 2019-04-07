package com.fdm.deadlock;

public class Trainer extends Thread {

	private Pen pen;
	private Board board;

	public Trainer(Pen pen, Board board) {
		super("Trainer Thread");
		this.pen = pen;
		this.board = board;
	}

	@Override
	public void run() {
		while (true) {
			if (board.isAvailable()) {
				synchronized (board) {
					if (pen.isAvailable()) {

						synchronized (pen) {
							System.out.println("Trainer has written on board.");
						}
						pen.finished();
					}
					board.finished();
				}
			}
		}
	}
}
