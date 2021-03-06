package org.minueto.sample.image.transformation;
/**
 * @(#)RotateDemo.java        1.00 15/09/2004
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
import org.minueto.window.MinuetoWindow;

/**
 * Sample that rotates a non-square image.
 *
 * Note that rotate is not an efficient operation and the results should
 * be cached.
 **/
public class RotateDemo3 {	
	
	public RotateDemo3() {
		 
		MinuetoWindow window;			// The Minueto window

		MinuetoImage imageRectangle;			// Original image
		MinuetoImage imageBoundry;
		MinuetoImage imageRotate;				// Rotated image		
		 		
		double r = 0.0;						// Rotation angle
	
		// Create a 640 by 480 window
		window = new MinuetoFrame(640, 480, true);
		
		
		// Create a non-square rectangle.
		imageRectangle = new MinuetoRectangle(98,98, MinuetoColor.RED, true);			
		
		// Show the game window.
		window.setVisible(true);
		
		// Game/rendering loop
		while(true) {
		
			// Clear the window.
			window.clear();
		
			// Change the rotation angle. Our demo does a demonstration
			// of rotation by changing the rotation angle at each frame.			
			r = r + 0.008;
			if (r > (Math.PI*2)) { r = 0; }
		
			// Rotate the image			
			imageRotate = imageRectangle.rotate(r);
			
			imageBoundry = new MinuetoRectangle(imageRotate.getWidth()+2,imageRotate.getHeight()+2, MinuetoColor.BLUE, false);
			
			// Draw the rotated rectangle
			window.draw(imageRotate, 50, 50);
			window.draw(imageBoundry, 49, 49);			
			
			// Render all graphics in the back buffer.
			window.render();
		}		
							
	}
	
	/**
	 * We need this to make our demo runnable from the command line.
	 **/
	public static void main(String[] args) {
	
		@SuppressWarnings("unused")
		RotateDemo3 rotExemple = new RotateDemo3();
	}
	
}
