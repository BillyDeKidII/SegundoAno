import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
 private int nums[];
 private static int LARGURA = 1024;
 private static int ALTURA = 576;
 private static int DIFF = 45;
 private Info infBtn;
 private Add addBtn;
 private Delete delBtn;
 private Sort sortBtn;
 private Search searchBtn;
 private Status status;
 private Selected selected;   
 private VetorDeAlunos vetor;
    
 /**
 * Constructor for objects of class MyWorld.
 * 
 */
 public MyWorld()
 {    
  // Create a new world with 1024x576 cells with a cell size of 1x1 pixels.
  super(LARGURA, ALTURA, 1);     
  init();
  }
    
 /**
  * Criar a GUI (Graphic User Interface) do programinha
  * 
  */
  public void createGUI(){
        
  }
     
  public void act()
  {
    if(vetor.tamanho() >= vetor.espacoAlocado())
    {
     status.changeLevel(3);
    }else
    if(vetor.tamanho() > vetor.espacoAlocado()*2/3+1)
    {
     status.changeLevel(2);
    }else 
    if((vetor.tamanho() > vetor.espacoAlocado()/3))
    {
     status.changeLevel(1);
    }else 
    {
     status.changeLevel(0);
    }
       
   if(Greenfoot.mouseClicked(addBtn))
   {
    Aluno a = new Aluno(Greenfoot.getRandomNumber(20));
    vetor.inserir(a);
    if( vetor.tamanho()<11)
    {
     addObject(vetor.getUltimo(), (LARGURA/11)*(vetor.tamanho()), ALTURA/2); 
    }else{
     addObject(vetor.getUltimo(), (LARGURA/11)*(vetor.tamanho()- 10), ALTURA/2 + 150);   
    }   
   }
}

  public void init(){      
   vetor = new VetorDeAlunos();     
   // Instanciando e posicionando os botoes
   addBtn = new Add();
   addObject(addBtn, (LARGURA/20), ALTURA/12);
   delBtn = new Delete();
   addObject(delBtn, (LARGURA/20)*2, ALTURA/12);
   sortBtn = new Sort();
   addObject(sortBtn, (LARGURA/20)*3, ALTURA/12);
   infBtn = new Info();
   addObject(infBtn, (LARGURA/20)*4, ALTURA/12);
   status = new Status();
   addObject(status, (LARGURA/20)*19, ALTURA/12);
 }
 }
