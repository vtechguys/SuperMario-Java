package Draw;

import Common.gameConstants;

public class prepareItems {public static boolean isPresentBrick[]=new boolean[30];//for brick image

public static boolean isPresentQuesMark[]=new boolean[13];
	public prepareItems(){
		for(int i=0;i<30;i++){
			isPresentBrick[i]=true;
			if(i<13)
			{isPresentQuesMark[i]=true;
			}
		}
		this.prepareBricks();
		this.prepareQuestionMarks();
	}
	
int brickFirst[]={2005,2105,2205,4740,4840,5555,5845,5895,6708,7238,7288,9108,9158,9258,
		4890,4940,4990,5040,5090,5140,5190,5240,5405,5455,5505,6798,6848,6898,7188,7338};
Bricks brick[]=new Bricks[30];

int animation[]={1805,2055,2168,4790,6145,6295,6445,9208,
		2105,5555,6295,7238,7288};
questionMarks qMarks[]=new questionMarks[13];


void prepareQuestionMarks(){
		for(int i=0;i<13;i++){
		
			
		if(i<8)
		qMarks[i]=new questionMarks(animation[i],gameConstants.FIRST_FLOOR,"qmark.gif","afterBonus.jpg");
		else
			qMarks[i]=new questionMarks(animation[i],gameConstants.SECOND_FLOOR,"qMark.gif","afterBonus.jpg");
	
		
		}
}
void prepareBricks(){
	for(int i=0;i<30;i++){
		if(prepareItems.isPresentBrick[i])
		{if(i<14)
		{//if(i==1)
		//	brick[i]=new Bricks(brickFirst[i],gameConstants.FIRST_FLOOR,"blank.jpg");
	//	else	
		brick[i]=new Bricks(brickFirst[i],gameConstants.FIRST_FLOOR,"brick.jpg");
		}
		else
		brick[i]=new Bricks(brickFirst[i],gameConstants.SECOND_FLOOR,"brick.jpg");
		}
		//else
	//	{
			//{if(i<14)
			//{
			//	brick[i]=new Bricks(brickFirst[i],gameConstants.FIRST_FLOOR,"blank.jpg");
			
			//}
			//else
			//brick[i]=new Bricks(brickFirst[i],gameConstants.SECOND_FLOOR,"blank.jpg");
			//}
		//}
		}
	
}
public Bricks[] getBrick() {
	return brick;
}
public void setBrick(Bricks[] brick) {
	this.brick = brick;
}
public questionMarks[] getqMarks() {
	return qMarks;
}
public void setqMarks(questionMarks[] qMarks) {
	this.qMarks = qMarks;
}

}
