import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GifLoop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GifLoop extends Actor{
    private GifImage gifImage;

    public GifLoop(String gifFileName) {
        gifImage = new GifImage(gifFileName);
        setImage(gifImage.getCurrentImage());
    }

    public void act() {
        if (gifImage.isRunning()) {
            setImage(gifImage.getCurrentImage());
        }
    }
}
