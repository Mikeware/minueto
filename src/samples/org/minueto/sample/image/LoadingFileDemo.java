package org.minueto.sample.image;
/**
 * @(#)LoadingFileDemo.java        1.00 15/09/2004
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
 
import org.minueto.MinuetoFileException;
import org.minueto.image.MinuetoImage;
import org.minueto.image.MinuetoImageFile;
import org.minueto.window.MinuetoFrame;
import org.minueto.window.MinuetoWindow;

/**
 * Sample that scales an image..
 *
 * Note that scale is not an efficient operation and the results should
 * be cached.
 **/
public class LoadingFileDemo {
	
	public LoadingFileDemo() {
		 
		MinuetoWindow window;			// The Minueto window
		
		MinuetoImage imageTank;				// MinuetoImage used to store
											// the image we will load.		
		
		double x;							// Position to draw the image.
		
		// Create a 640 by 480 window
		window = new MinuetoFrame(640, 480, true);
		
		// Load our image.
		try {
			imageTank = new MinuetoImageFile("images/tank.png");			
		} catch (MinuetoFileException e) {
			System.out.println("Could not load tank file");
			System.exit(0);
			return;
		}
		
		// Starting position of our image.
		x = 0;
		
		// Show the game window.
		window.setVisible(true);
		
		// Game/rendering loop
		while(true) {
		
			// Clear the window.
			window.clear();
		
			// Move the image at every frame.
			x = x + 0.05;
			if (x > 639) {x = 0;}			
			
			// Draw the image.
			window.draw(imageTank, (int)x, 50);			
			
			// Render all graphics in the back buffer.
			window.render();
		}		
							
	}
	
	/**
	 * We need this to make our demo runnable from the command line.
	 **/
	public static void main(String[] args) {
	
		@SuppressWarnings("unused")
		LoadingFileDemo lfdExemple = new LoadingFileDemo();
	}
	
}
