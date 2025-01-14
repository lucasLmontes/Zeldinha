package com.zeldinha.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.zeldinha.main.Game;

public class Player extends Entity {
	public boolean right, left, up, down;
	public double spd = 1.0;
	private int right_dir = 0, left_dir = 1;
	private int dir = right_dir;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	private boolean moved = false;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(32 + (i*16), 0, 16, 16);
		}
		for(int i = 0; i < 4; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(80 - (i*16), 16, 16, 16);
		}
	}
	
	public void tick() {
		moved = false;
		
		if(right) {
			moved = true;
			dir = right_dir;
			x+=spd;
		} else if(left) {
			moved = true;
			dir = left_dir;
			x-=spd;
		}
		
		if(up) {
			moved = true;
			y-=spd;
		} else if(down) {
			moved = true;
			y+=spd;
		}
		
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		} else if(moved == false) {
			index = 0;
		}
	}
	
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[index], this.getX(), this.getY(), null);
		} else if(dir == left_dir) {
			g.drawImage(leftPlayer[index], this.getX(), this.getY(), null);
		}
	}

}
