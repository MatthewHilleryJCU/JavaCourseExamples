package com.fdm.deadlock;

public class RunDeadlock {
	public static void main(String[] args) {
		Pen pen = new Pen();
		Board board = new Board();
		Trainer trainer = new Trainer(pen, board);
		Trainee trainee = new Trainee(pen, board);
		
		trainee.start();
		trainer.start();
	}
}
