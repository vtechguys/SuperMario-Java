package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import Bonus.BonusItems;
import Bonus.Coins;
import Common.Display;
import Common.gameConstants;
import Draw.Bricks;
import Draw.pipeImages;
import Draw.prepareItems;
import Draw.questionMarks;
import Enemy.Goomba;
import Enemy.prepareEnemy;
import Music.BackGroundMusic;
import Obstacles.Fall;
import Player.Mplayer;
import different.CoinsAdditional;
import different.inPipe;

public class Board extends JPanel implements gameConstants {
	private boolean isStopTimer=false;
	private Image image,image_inPipe;
	private Camera camera;
	Mplayer player;
	Fall fall;
	prepareItems prepare;
	prepareEnemy prepareEnemies;
	pipeImages additional; 
	Bricks brick[];
	questionMarks qMarks[];
	Coins coins[]=new Coins[10];
	Goomba goomba[];
	Final end=new Final();
	inPipe inpipe=new inPipe();
	CoinsAdditional [] coinsA =new CoinsAdditional[10];
	
	Board(){
	setSize(GWIDTH, GHEIGHT);
	camera=new Camera();
	loadImage();
	gameLoop();
	player= new Mplayer();
	fall=new Fall();
	prepare=new prepareItems();
	prepareEnemies=new prepareEnemy();
	qMarks=prepare.getqMarks();
	brick=prepare.getBrick();
	additional =new pipeImages();
	goomba=prepareEnemies.getGoomba();
	coinsA=inpipe.getCoins();
	 for(int i=0;i<10;i++)                              //for the coins
      if(i<6)
      {	coins[i]=new Coins(318 , 50,50);
      }
      	else
      		coins[i]=new Coins(128 , 50,50);
     
	
	}

	private void loadImage() {
		try {//image = ImageIO.read(Board.class.getResource("hdMariomain.jpg")).getSubimage(camera.getX(),2*IMAGE_HEIGHT,IMAGE_WIDTH,IMAGE_HEIGHT);
		
			image = ImageIO.read(Board.class.getResource("hdMariomain.jpg")).getSubimage(camera.getX(),2*IMAGE_HEIGHT,IMAGE_WIDTH,IMAGE_HEIGHT);
			//try {image = ImageIO.read(Board.class.getResource("hdMariomain.jpg")).getSubimage(1046,camera.getX(),IMAGE_WIDTH,IMAGE_HEIGHT);
		image_inPipe=ImageIO.read(Board.class.getResource("background2.png")).getSubimage(0,0,258,224);	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void bindEvent() {
		this.requestFocusInWindow();
		this.addKeyListener(new KeyAdapter() {
			@Override
		public void keyPressed(KeyEvent e){
				if(!Mplayer.isReachedEnd)
				{if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					Mplayer.isStanding=false;
					if(!Camera.isInPipe)
					{player.checkFront(Camera.x);                                   //for checking relativity
						if(Mplayer.x==100)
					{	camera.right();
				     
					player.takeOff();
					 for(Bricks b: brick){
				        	b.right(camera.getSpeed());
				        }
				    for(Goomba go:goomba){
				    	go.right(camera.getSpeed());
				    }
					 for(questionMarks q: qMarks){
						 q.right(camera.speed);
					 }
					 additional.right(camera.getSpeed());
					 end.right(camera.getSpeed());
					//brick.right(camera.getSpeed());                            error
				}
					else {
						player.moveRight();
					}}
					else                                                        //if in pipe
					{while(Camera.x<2924){                                   //for  skipping the level
						
						camera.right();
						 for(Bricks b: brick){
					        	b.right(camera.getSpeed());
					        }
						 for(Goomba go:goomba){
						    	go.right(camera.getSpeed());
						    }
							 for(questionMarks q: qMarks){
								 q.right(camera.speed);}
							 additional.right(camera.getSpeed());
							 end.right(camera.getSpeed());
					}                                                            //till level is skipped
						
						player.moveRight();
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT)
					{	Mplayer.isStanding=false;
					player.checkBack(Camera.x);                                     //for checking relativity
					
					player.moveLeft();
					
//					camera.left();
//					for(Bricks b: brick){
//			        	b.left(camera.getSpeed());
//			        	
//			        }
//					  for(Goomba go:goomba){
//					    	go.left(camera.getSpeed());
//					    }
//					 for(questionMarks q: qMarks){
//						 q.left(camera.speed);
//					 }
//					 end.left(camera.getSpeed());
				   // brick.left(camera.getSpeed());                            error
					}
				
				
				if(e.getKeyCode()==KeyEvent.VK_UP)                                   
					{
					player.jump();}
				if(e.getKeyCode()==KeyEvent.VK_DOWN&&(Mplayer.x-pipeImages.x1)<25&&(Mplayer.x-pipeImages.x1)>-35) 
				{//BackGroundMusic.playPipe();                                        music
 					Mplayer.isEnterPipe=true;
				}
				if(e.getKeyCode()==KeyEvent.VK_SPACE&&BonusItems.isTaken[8]){
				if(!Mplayer.isFire)    
				{	Mplayer.isFire=true;
					Display.FIRE=(int)Display.TIME;}
					
				}}
			}
			
		});
		
	}
private Timer timer;
	
	private void gameLoop(){
		timer = new Timer(DELAY, (e)->{
			repaint();
			Mplayer.isStanding=true;
		});
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g){
		//System.out.println(Camera.isInPipe+" "+Camera.outOfPipe);
		if(!GameOver.isOver())
		{super.paintComponent(g);
		Display.TIME-=0.07;
		Graphics2D twoD = (Graphics2D) g;
		drawBackGround(twoD);
        player.drawPlayer(twoD);
        if(!Camera.isInPipe)
        {int i=0,j=0;
        for(Bricks b: brick){
        	if(prepareItems.isPresentBrick[i])
        	{b.drawBrick(twoD,i);
        	i++;}
        	else{
        		i++;
        	}
        }
        end.drawFlag(twoD);
        for(questionMarks q: qMarks){
        
        	q.drawQuestioinMarks(twoD,j++);     	
        	        	     
		 }
        additional.drawImagesOverlap(twoD);
        if(Coins.isCoin){                          //for bouncing the coins
        	int temp;
        	switch(Coins.I){
        	case 0:temp=0;break;
        	case 1:temp=1;break;
        	case 4:temp=2;break;
        	case 5:temp=3;break;
        	case 6:temp=4;break;
        	case 7:temp=5;break;
        	case 9:temp=6;break;
        	case 10:temp=7;break;
        	case 11:temp=8;break;
        	case 12:temp=9;break;
        	default:temp=0;break;
        	}
        	coins[temp].check(twoD);   
        	coins[temp].fall();
        }	
        
        
      for(Goomba go:goomba){
    	 go.drawGoomba(twoD);
      }
      player.enter();}
        else if(Camera.isInPipe){
        	for(int i=0;i<10;i++)
        	coinsA[i].drawCoins(twoD);
        }
                    	
      //        draw.drawAll(twoD);
        fall.fallDown(camera.getX());
        player.fall();
        
        }
		
		else
		{ //BackGroundMusic.mp31.stop(); 
		  //BackGroundMusic.playMarioDie();                   //music
			printGameOver(g);
			this.isStopTimer=true;
		}
		this.printTopBar(g);
        
		if(Mplayer.isNotVisible){
			this.drawMessage(g);
		}
		if(this.isStopTimer){
			timer.stop();
		}
		
	}
	private void drawBackGround(Graphics2D g){
		
		loadImage();
		if(!Camera.isInPipe)
		{g.drawImage(image,0,0,GWIDTH,GHEIGHT ,null);
		
		}
		else if(Camera.isInPipe)
		{
			g.drawImage(image_inPipe, 0,0,GWIDTH,GHEIGHT ,null);
		}
       
		//System.out.println("Draw....");
	}
	private void printGameOver(Graphics g) {
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.BOLD,64));
		g.drawString(" ===========", 300, 150);
		g.drawString("|GAME OVER|", 300, 200);
		g.drawString(" ===========", 300, 260);
		
		
	}
	private void printTopBar(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.BOLD,26));
		g.drawString("Score : "+Display.SCORE, 10, 25);
		g.drawString("Coins : "+Display.COINS, 450, 25);
		g.drawString("Time : "+(int)Display.TIME, 950,25);
	}
	void drawMessage(Graphics g){
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial",Font.BOLD,64));
		g.drawString("=================", 300, 150);
		g.drawString("|LEVEL COMPLETE|", 300, 200);
		g.drawString("=================", 300, 260);
		this.isStopTimer=true;
	}
}

	
	


