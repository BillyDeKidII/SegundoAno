    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Status here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Status extends Button
{
    /**
     * Act - do whatever the Status wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }    
    
    public void changeLevel(int level){
        switch (level) {
            case 0:  this.setImage("signal1.png");
                     getImage().setTransparency(0);
                     break;
            case 1:  this.setImage("signal1.png");
                     getImage().setTransparency(255);
                     break;
            case 2:  this.setImage("signal2.png");
                     getImage().setTransparency(255);
                     break;
            case 3:  this.setImage("signal3.png");
                     getImage().setTransparency(255);
                     break; 
            default: 
                    getImage().setTransparency(255);
                    this.setImage("signal1.png");
                    break; 
        }         
    }
    
}
