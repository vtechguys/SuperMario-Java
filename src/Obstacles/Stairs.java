package Obstacles;

import Player.Mplayer;

public class Stairs{
	boolean isStairCollision;
	int yPlayer;
	int floor[]={418, 368 ,320,272,224,176,128,80,80};
	
	
	void checkIt(int x,int stairsStart, int stairsEnd,int category){
		
		int stairStart=stairsStart;
		int stairEnd=stairStart+16;
		int i=0;
		
		while(!(x<=stairsStart||x>=stairsEnd))
		{
			if((x>=stairStart&&x<=stairEnd)){
				//System.out.println("reached here too");
				if(category==1)
				isStairCollision=check(i,category);
				else if(category==2)
					isStairCollision=check(3-i,category);
				else if(category==3)
					isStairCollision=check(i,category);
					else if(category==4)
						isStairCollision=check(i,category);
				//System.out.println(isStairCollision);
				stairsStart+=16;
				stairEnd+=16;
				i++;
			
		}
		else{//System.out.println("reached here too");
			stairsStart+=16;
			stairEnd+=16;
			i++;
		}
	}}
	
	public boolean check(int i,int category)
	{if(category==3){
		floor[4]=272;
	}
	else floor[4]=224;
		if(yPlayer<=floor[i]){
		//set floor as floor
		
		Mplayer.FLOOR=floor[i];
		
		//System.out.println(Mplayer.FLOOR);
		return false;
	}
	else{//System.out.println("yplayer="+yPlayer+"floor"+floor);
	  if(category!=2)
		{if(i>0)
	Mplayer.FLOOR=floor[i-1];
		}
	  
		return true;
	}}
	
public boolean checkStairCollision(int x){
	yPlayer=Mplayer.y;
	if(x>=2437&&x<=2501){
		checkIt(x,2437,2501,1);
	}
	else if(x>=2533&&x<=2597){
		checkIt(x,2533,2597,2);
	}
	else if(x>=2661&&x<=2741){
		checkIt(x,2661,2741,3);
	}
	else if(x>=2773&&x<=2837){
		checkIt(x,2773,2837,2);
	}
	else if(x>=3189&&x<=3333){
		checkIt(x,3189,3333,4 );
	}
	else{//System.out.println("i have been called at x = "+x);
//		Mplayer.FLOOR=468;;
		isStairCollision=false;
	}
	return isStairCollision;
}
}
