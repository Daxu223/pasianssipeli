package com.pasianssipeli.model;

import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JPanel;

public abstract class Pino extends JPanel {
	
	protected int x, y;
	protected Stack<Kortti> cards;

	public Pino(int x, int y) {
		super.setLocation(x, y);
		cards = new Stack<>();
		
	}
	
	public Kortti topCard() {
		if(!this.cards.isEmpty()) {
			return this.cards.peek();
		}
		return null;
	}
	
	public Kortti pop() {
		try {
			return cards.pop();
		}catch(EmptyStackException ese) {
			return null;
		}
	}
	
	public void push(Kortti someCard) {
		this.cards.push(someCard);
	}
	
	public boolean isEmpty() {
		return this.cards.isEmpty();
	}
}
