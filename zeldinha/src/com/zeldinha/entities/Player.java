package com.zeldinha.entities;

import java.awt.image.BufferedImage;

public class Player extends Entity {
	public boolean right, left, up, down;
	public double spd = 1.4;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {		
		if(right) {
			x+=spd;
		} else if(left) {
			x-=spd;
		}
		
		if(up) {
			y-=spd;
		} else if(down) {
			y+=spd;
		}
	}

}
