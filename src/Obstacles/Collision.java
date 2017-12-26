package Obstacles;



public class Collision {
	private boolean isCollision;
pipes pipe=new pipes();
Stairs stairs=new Stairs();
//public boolean isCollisionFloors;

//public void setCollisionFloors(boolean isCollisionFloors) {

//	this.isCollisionFloors = isCollisionFloors;
//}

public boolean isCollision(int x){
//	System.out.println(this.isCollisionFloors);
	if(pipe.checkPipeCollision(x)||stairs.checkStairCollision(x))
		isCollision=true;
	else isCollision=false;
	return isCollision;
}
}
