import greenfoot.Actor;
import greenfoot.Greenfoot;


public class Link extends Actor {

	static final int MOVE_SPEED = 5;
	final int DELAY_AMOUNT = 4;
	final int IMAGE_RIGHT_ROT = 0;
	final int IMAGE_DOWN_ROT = 90;
	final int IMAGE_LEFT_ROT = 180;
	final int IMAGE_UP_ROT = 270;
	int counter = 0;
	
	public Link(){
		this.setRotation(90);
		this.setImage("images/LinkWalkDown2.png");
	}

	public void act(){
		counter++;
		if(Greenfoot.isKeyDown("up")){
			moveUp();
		}
		else if(Greenfoot.isKeyDown("right")){
			moveRight();
		}
		else if(Greenfoot.isKeyDown("left")){
			moveLeft();
		}
		else if(Greenfoot.isKeyDown("down")){
			moveDown();
		}
	}




	public void moveUp(){
//		while(Greenfoot.isKeyDown("up")){
			this.setRotation(IMAGE_UP_ROT);
			this.setImage("images/LinkWalkUp1.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkUp2.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkUp3.png");
			this.move(MOVE_SPEED);
//		}
	}

	public void moveRight(){
//		while(Greenfoot.isKeyDown("right")){
			this.setRotation(IMAGE_RIGHT_ROT);
			this.setImage("images/LinkWalkRight1.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkRight2.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkRight3.png");
			this.move(MOVE_SPEED);
//		}
	}

	public void moveLeft(){
//		while(Greenfoot.isKeyDown("left")){
			this.setRotation(IMAGE_LEFT_ROT);
			this.setImage("images/LinkWalkLeft1.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkLeft2.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkLeft3.png");
			this.move(MOVE_SPEED);
//		}
	}
	
	public void moveDown(){
//		while(Greenfoot.isKeyDown("down")){
			this.setRotation(IMAGE_DOWN_ROT);
			this.setImage("images/LinkWalkDown1.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkDown2.png");
			Greenfoot.delay(DELAY_AMOUNT);
			this.move(MOVE_SPEED);
			this.setImage("images/LinkWalkDown3.png");
			this.move(MOVE_SPEED);
//		}
	}
}
