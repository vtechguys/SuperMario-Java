package Enemy;

import Draw.prepareItems;

public class prepareEnemy {
	public prepareEnemy() {
		this.prepareGoomba();
	}
	
	//special features for 5th and 6th goomba
	//7,8,9,10,11
int boundary1[]={0,2965,3350,3350,4730,4880,5305,5305,5305,5305,5305,8958,8958};
int boundary2[]={2350,3215,3740,3740,4850,5250,7428,7428,7428,7428,7428,9594,9594};
int x[]={1600,3000,3400,3600,4750,5000,5605,6495,6595,6895,6995,9000,9200};
int y[]={516,516,516,516,318,128,516,516,516,516,516,516,516};
int speed[]={4,4,4,-4,4,4,-4,4,-4,4,-4,4,-4};

Goomba [] goomba=new Goomba[13];

public void prepareGoomba(){
	for(int i=0;i<13;i++){
		//if condition needed here when it will be killed
		
		goomba[i]=new Goomba(x[i], y[i], speed[i], boundary1[i], boundary2[i],i);
	}
}

public Goomba[] getGoomba() {
	return goomba;
}



}
