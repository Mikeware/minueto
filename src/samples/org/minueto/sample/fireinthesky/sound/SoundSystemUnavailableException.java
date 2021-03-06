/**
 * @(#)SoundSystemUnavailableException.java
 *
 * Fire in the Sky - A Minueto Demo
 * Copyright (c) 2004 McGill University
 * 3480 University Street, Montreal, Quebec H3A 2A7
 
 * Fire in the sky is a demo of the Minueto graphic API. More information on
 * Minueto can be found at http://minueto.cs.mcgill.ca .
 
 * This game is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This game is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *  
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.minueto.sample.fireinthesky.sound;

/**
 * Thrown by <code>MinuetoMidi</code> or <code>MinuetoWave</code> when their 
 * respective sound system is not available.
 *
 * @author	Alexandre Denault
 * @version 1.0
 * @since 	Minueto 0.4.4
 * @see 	SoundMidi
 * @see		SoundWave
 **/
public class SoundSystemUnavailableException extends RuntimeException {
	
	private static final long serialVersionUID = 1;
	
	/**
	 * Constructs a <code>MinuetoSoundSystemUnavailableException</code> with null as its error message string.
    **/
	public SoundSystemUnavailableException() {
		super();
	}
	
	/**
	 * Constructs a <code>MinuetoSoundSystemUnavailableException</code>, saving a reference to the error 
	 * message string s for later retrieval by the getMessage method.
	 *
	 * @param s String indicating the detailed message.
	 **/
	public SoundSystemUnavailableException(String s) {
		super(s);
	}
}
