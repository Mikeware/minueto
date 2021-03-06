Minueto Changelog
=================

2.1 New features

* Modified MinuetoCircle to accept start and extension angles to create Arcs.
* Added ArcDemo sample.
* Update Documentation and fix some typos
* Started Github Repository

2.0.1 Bug Fix

* Fixed MinuetoImage.clear() to clear the image in a transparent fashion.

2.0 Reorganization

* Fixed the MinuetoPanel to make it stable. Removed the ability to resize a window 
  (was making everything unstable).

* Changed how the sample are stored and accessed in Minueto. Samples are stored in the
  minueto-sample.jar. 
  
* Added the FireInTheSky sample.

* Fixed variable names to be more Java-compliant.

* Removed the value argument to the typed function in the MinuetoKeyboardHandler.
  This change BREAKS COMPATIBILITY with previous versions of Minueto. Java does 
  not send a value in this type of event.

  Fixing your program requires two small changes in your keyboard handlers:

  public void handleKeyType(int value, char keyChar); -->
    public void handleKeyType(char keyChar);

  
1.3 New features

* Added the following functions to MinuetoImage : drawRectangle, drawCircle, drawPolygon

1.2.3 Bug fix

* Made behavior of windows more consistent when closed.

1.2.2 Bug fix

* Removed crash when masking in image with larger height than width.

1.2.1 Bug fix

* Allows for the generation of multiple MinuetoPanel, as long as
  only one is open at a time.

1.2 Features

* Added isVisible() method to MinuetoWindow
* Moved clear() and clear(MinuetoColor) methods from MinuetoWindow 
  to MinuetoDrawingSurface
* Added clear() and clear(MinuetoColor) methods to MinuetoImage

* MinuetoPanel 3.0
** Panel doesn't unregister listeners when made invisible
** close() is an alias for setVisible(false)
** MinuetoPanel can be resized with setSize()
** More than one MinuetoPanel can be created at once
** Added isAutoRepaint() and setAutoRepaint(boolean) functions to MinuetoPanel
*** If set, it will automatically call render on repaint() in case 
    no render loop is wanted
** MinuetoPanel's save their buffer when made invisible and visible again 
   (unlike MinuetoFullscreen and MinuetoFrame) or when resized.
** MinuetoPanels can be registered with Swing Listeners (Focus, Key, and Mouse)
   as well just like a JPanel

* Updated MinuetoPanel example to showcase setVisible and setSize

* Created MinuetoPanelInterfaceDemo example to showcase MinuetoPanel inside 
  a MDI Document type environment

1.1b Bug Fix

Bug fixes on samples, thanks to Gabriel Charette

1.1 Features

*** Fixed typo in unregisterMouseWeelHandler to unregisterMouseWheelHandler

*** Reworked MinuetoPanel to be a subclass of JPanel for 
    ease of Swing integration

* Renamed MinuetoWindow to MinuetoBaseWindow
** No compatibility broken, except if MinuetoWindow was further subclassed
 in your project, to fix just subclass MinuetoBaseWindow instead
* Extracted MinuetoWindow to an Interface

* Added getPixel() and setPixel() to MinuetoImage
* Added getPositionX() and getPositionY() to MinuetoWindow, retrieves screen 
  coordinates of window drawing surface
* Created MinuetoDrawingSurface interface to share the common functions between
 a window and an image
** This new interface adds save() function to MinuetoWindow
* Added MinuetoFocusHandler which MinuetoWindowHandler now extends, 
  useful for MinuetoPanels, but also MinuetoFrames
* Added two new constructors for MinuetoColor

* Added More Samples:
** MinuetoPanelDemo to demonstrate power of Swing+Minueto
** launchminueto: Show launching a Minueto Window from a Swing application
** GetSetPixelDemo: Show using the getPixel and setPixel methods
** ScreenshotDemo: Show capturing a screenshot within Minueto

1.0.2 Features

* Added the MinuetoMouseWheelHandler.

1.0.1 Bug Fix

* Fixed Make Files to use newly cased "minueto.jar" instead of old "Minueto.jar"

1.0 First official release

* This is the first integer release of Minueto. Ironically, it includes many
  new experimental features, so I wouldn't consider it stable.
  
* Broken compatibility in several areas. Since it's a major release, I decided
  to do all the refactoring that has been pending for the last 12 months :-)
  
* MinuetoWindow is now an abstract class. You can create either a 
  MinuetoFullScreen for a fullscreen window or MinuetoFrame for a non-
  fullscreen window. I've also create MinuetoPanel as groundwork for
  Swing integration. All three classes are sub-types of MinuetoWindow.
  so you only need to change the creation of the object, not the 
  declaration of the variable.

* Multi-window support should now work. You can have multiple MinuetoFrame
  at the same time. Only one MinuetoFullscreen allowed thought. Handlers
  have been moved form org.minueto.input to org.minueto.handlers.

* Finished the refactoring of envet handling and input handling. You can
  now register multiple handlers of the same type using different (or the 
  same) queue. 
  
* Remove old sound support from minueto core. Sound support is now in
  minueto-tools.

* The functions getWidth and getHeight has been renamed to getWindowWidth
  and getWindowHeight. The functions getDrawAreaWidth and getDrawAreaHeight
  have been renamed to getWidth and getHeight. More information about
  this change it available in the faq.

0.99.1 Broke compatibility to fix key handling bug

* Removed the character argument to the functions in the MinuetoKeyboardHandler
  added in 0.8.0. This change BREAKS COMPATIBILITY with previous versions 
  of Minueto. Java does not send the correct key char in those events.

  Fixing your program requires two small changes in your keyboard handlers:

  public void handleKeyPress(int iValue, char cKeyChar); -->
  	public void handleKeyPress(int iValue);

  public void handleKeyRelease(int iValue, char cKeyChar); -->
	  public void handleKeyRelease(int iValue);
	  
* Added a handleKeyType() function to the MinuetoKeyboardHandler. This 
  event receives the correct key character in every case. This change BREAKS 
  COMPATIBILITY with previous versions of Minueto. 

  Fixing your program requires you to add the following function to your
  keyboard handlers:

  public void handleKeyType(int iValue, char cKeyChar) {
  
  }
  
* Made MinuetoColor serializable.
     
0.99 Major Refactoring

* Minueto is moved to the org.minueto package.
* Added mask function to image.

0.9 Major changes

* Refactored code directory (and subversion directory)
* Move implementation of MinuetoWindow to MinuetoWindowImpl
* Move fullscreen code and windowed code to their respective class
* Added support for transparent images
* Added support for DirectX and OpenGL acceleration
* Added code to detect OS
* Moved listeners to their respective class
* Change windowed code to allow more than one window (not finished yet)
* Added AlphaImageDemo and MultiWindowDemo
* Added functions to darken and lighten a color.

0.8.1 Fine tunning

* Fixed a performance bug
* Fixed a fullscreen bug
* Cleaned up the source code

0.8.0 Major changes

* Moved the registerKeyboardHandler, registerMouseHandler, registerWindowHandler
  functions from the MinuetoEventQueue class to the MinuetoWindow class. This 
  change BREAKS COMPATIBILITY with previous versions of Minueto. This change 
  was made to correct a design flaw in Minueto and to facilitate the creation
  of extensions.
  
  Fixing your program requires three small changes when registering handlers:
  
  minEventQueue.registerKeyboardHandler(minKeyboardHandler, minWindow)
    -->
	  minWindow.registerKeyboardHandler(minKeyboardHandler, minEventQueue)
  
  minEventQueue.registerMouseHandler(MinuetoMouseHandler, minWindow)
    -->
	  minWindow.registerMouseHandler(MinuetoMouseHandler, minEventQueue)
  
  minEventQueue.registerWindowHandler(MinuetoWindowHandler, minWindow) 
    -->
      minWindow.registerWindowHandler(MinuetoWindowHandler, minEventQueue)

* Added an character argument to the functions in the MinuetoKeyboardHandler.
  This change BREAKS COMPATIBILITY with previous versions of Minueto. This
  change makes it much easier to read text from the keyboard.

  Fixing your program requires two small changes in your keyboard handlers:

  public void handleKeyPress(int iValue); -->
     public void handleKeyPress(int iValue, char cKeyChar);

  public void handleKeyRelease(int iValue); -->
     public void handleKeyRelease(int iValue, char cKeyChar);

* MinuetoImageFile can now load a file using an URL (thanks to Adam H. for
  the suggestion and the patch). This means images can be loaded from a JAR.
  
* Fixed a small bug where the "tab" key press was not properly detected.

0.7.0 Major new features

* Rewrote registration system (internal) for keyboard/mouse/window handlers.
  This should fix many bugs related to handlers.

* MinuetoImages no longuer need to be created after MinuetoWindow is
  initialized. Image will be loaded on an unaccelerated surface and 
  will be accelerated when first drawn. 

0.6.0 Major new features and bug fixes

* The build.xml is now available in the SDK. This means you can build
  Minueto using Ant.

* Added the setMaxFrameRate method to MinuetoWindow. You can use this to
  cap your framerate.

* Added the getFrameRate method to MinuetoWindow.

* Added a translateKey function to Minueto Keyboard.

* Added Minueto.KEY_BACKSPACE

* Make an important change in the internal drawing engine ( please tell me
  if this breaks anything ).

* Accelerated the crop function (thanks to Razvan T. for the suggestion).

* Fixed a bug where Minueto would crash if an empty string was passed to
  MinuetoText. Now, it just creates a small empty image.

* Fixed a bug in rotate where some angles would crash the JVM.

* Fixed a bug where the wrong exception would be thrown if fullscreen mode
  was unavalible.

* Fixed the offset bug ( on Linux, sometimes, the entire canvas would be 
  offset by a few pixels ).

* Added TextDemo2 and FramerateDemo.

* Minueto's source can now be found in the /Minueto directory (instead of
  /src).

0.4.8 Bug fix

* Fixed a bug where mouse move events would not be sent if the
  user pressed a mouse button.

0.4.7 - A few Improvements

* Added the getDrawAreaWidth and getDrawAreaHeight method.

* Cleaned up some code in MinuetoWindow (internal stuff).

* Minor graphic changes on HandlerDemo2.

0.4.6 - Bug fixes and new features

* Added the setCursorVisible method to the MinuetoWindow. Programmers can
  hide/show the mouse cursor.

* MinuetoImage is now cloneable. 

* Fixed a bug on rotating non-square images. ( thanks to Micheal A. H. for 
  finding the bug )

0.4.5 - Bug fixes

* Text is no longuer anti-aliased by default. Users can now
  specify if they want anti-aliasing in the MinuetoText
  constructor.

* Added TextDemo to show the different between normal and anti-aliased text.  

* Fixed a bug in rotate ( thanks to Michael A. Hawker )

* Added a flip function to MinuetoImage ( thanks to Michael A. Hawker )

* Added RotateDemo2, ScaleFlipDemo ( again Michael A. Hawker )

0.4.4 - Experimental sound support and a few bug fixes

* Added MinuetoWave and MinuetoMidi. You can now play sounds 
in your application. Hasn't been tested much yet. Works 
differently on different JDK. Mostly tested on JDK 1.4.*

* Added WavePlay and MidiPlay demo.

* Fixed a bug that prevented the user from creating a new 
Minueto Window if the first got an exception.

* Fixed a bug in MinuetoRotate.

0.4.3 - Bug fixes mostly

* Fixed a bug in crop (not being able to crop at the edge 
of an image).

* You can now draw outside the bounds of an image. This is 
allowed to simply the development of tilebase games where
you often need to drwa on parts of a tile on-screen.

* Fixed a bug in MinuetoRectangle where full rectangles 
where drawn one pixel short.

* MinuetoText is now AntiAliased.


0.4.2 - Better API Documentation and Exception Throwing

* Added a lot of documentation in the API.

* Improved exception throwing. Also all input into Minueto is 
  checked and an exceptions are thrown if the input is
  unacceptable.
  
* Improved the howto documentation on the website.

* Fixed a huge bug in crop image.

* Added a clear(MinuetoColor) method to MinuetoWindow.

* Added CropDemo, a demo about cropping an image.

0.4.1 - Bug fix and new exmaples

* Fixed a major bug related to double buffering. Minueto should
  be much more stable under Linux.

* Fixed an important bug in MinuetoColor which prevented users
  from defining their own color.

* Multiple smal bug fixes.

* Redesigned the sample directory. There is now a total of 15 
  examples. All of them are provided with a make.bat and a
  make.sh (shell scripts) to compile them easily.

* Minueto is now released as two types of package, one for users
  of the old 1.4.2 JDK and one for the users of JDK 1.5.

0.4 - First semi-public release

* Overhaul of the fullscreen/window system. Should be a little 
  more stable under 1.4.2 in fullscreen mode. The resize and 
  setborder functions were removed because of the instability
  they introduced.

* MinuetoWindow is now non-resizable. It should have been like
  that from the start.

* Added the MinuetoWindowHandler interface. Programmers can 
  how register this handler to receive events when the 
  window is minimized/restore, lost focus/get focus or the
  user tries to close the window.

* Handler are now registered with MinuetoEventQueue. This is
  a big change from the previous Minueto versions. It will
  require to change 3 lines in your previous Minueto Code.

  So code that looked like:

    meqQueue = new MinuetoEventQueue();
    mwiWindow = new MinuetoWindow(meqQueue,640, 480, 32, false);
    mwiWindow.registerKeyboardHandler(this);
    mwiWindowregisterMouseHandler(this);
    

  Should now look like

    meqQueue = new MinuetoEventQueue();
    mwiWindow = new MinuetoWindow(640, 480, 32, false);
    meqQueue.registerKeyboardHandler(this, mwiWindow);
    meqQueue.registerMouseHandler(this, mwiWindow);

*  Added Calibration and EventTester demo.

*  Added MinuetoMouse class to describe mouse buttons.

*  Added screenshots functionality to both MinuetoWindow
   and MinuetoImage.
