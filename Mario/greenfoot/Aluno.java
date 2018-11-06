import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Aluno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aluno extends Actor{
    private String nome;
    private int num;
    
    public Aluno(int img){
        this.setImage(Utils.IMAGENS[img] + ".png");
        this.nome = Utils.NOMES[img];
        this.num = new Random().nextInt(99);
        //getWorld().showText(String.valueOf(this.num), this.getX(), this.getY() + (this.getImage().getHeight()/2));
    }
    
    /**
     * Act - do whatever the Aluno wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(Greenfoot.mouseClicked(this)){
        }
    }

}
