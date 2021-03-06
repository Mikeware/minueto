package org.minueto.sample.image;
/**
 * @(#)RectangleDemo.java        1.00 15/09/2004
 *
 * Minueto - The Game Development Framework 
 * Copyright (c) 2004 McGill University
 * 3480 University Street, Montreal, Quebec H3A 2A7
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 **/
 
import org.minueto.MinuetoColor;
import org.minueto.image.MinuetoImage;
import org.minueto.image.MinuetoRectangle;
import org.minueto.window.MinuetoFrame;

/**
 * Sample that draws Squares and Rectangles.
 *
 * Note that the Squares/Rectangles are created only once. This is much more
 * efficient then re-creating them everytime we want to draw them.
 **/
public class RectangleDemo {
		
	public RectangleDemo() {

		MinuetoFrame window;			// The Minueto window
		
		MinuetoImage[] imageSquares = new MinuetoImage[10];	// Stores 10 circles
		MinuetoImage[] imageRectangles = new MinuetoImage[10];	// Stores 10 ellipses
				
		// Create a 640 by 480 window
		window = new MinuetoFrame(640, 480, true);
		
		// Create our 10 circles and 10 ellipses.
		for(int i = 0; i< 10; i++) {
			
			imageSquares[i] = new MinuetoRectangle((i+8)*2, (i+8)*2,new MinuetoColor(i*6, i*10, i*20), true);
			imageRectangles[i] = new MinuetoRectangle((i+8)*2, (i+5)*5, new MinuetoColor(i*20, i*10, i*6), false);
		}
		
		// Show the game window.
		window.setVisible(true);
				
		// Game/rendering loop
		while(true) {
		
			// Clear the window.
			window.clear();
		
			// Draw our 10 circles and 10 ellipses.
			for(int i = 0; i< 10; i++) {	
						
				window.draw(imageSquares[i], (i*62)+5, 20);
				window.draw(imageRectangles[i], (i*62)+5, 200);
			}
			
			// Render all graphics in the back buffer.
			window.render();
		}		
	}
	
	/**
	 * We need this to make our demo runnable from the command line.
	 **/
	public static void main(String[] args) {
	
		@SuppressWarnings("unused")
		RectangleDemo main = new RectangleDemo();
	}
}

