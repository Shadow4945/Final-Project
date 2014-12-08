import greenfoot.World;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import java.awt.Color;

public class ToThePast extends World {

	final static int WIDTH = 512;
	final static int HEIGHT = 600;
	final static int CELL = 1;
	final static int MAX_DELAY = 100;
	final int IMAGE_START_LOC = 0;
	final int STARTING_ROOM_X = 258;
	final int STARTING_ROOM_Y = 386;
	final int RABBIT_X_LOC = 350 ;
	final int RABBIT_Y_LOC = 394;
	final int VILLAGE_X1 = 112;
	final int VILLAGE_X2 = 312;
	final int VILLAGE_Y2 = 10;
	final int VILLAGE_Y1 = 446;
	final int CAVE_X = 191;
	final int CAVE_Y = 201;
	int lastXLoc;
	int lastYLoc;
	static int switchDelay = MAX_DELAY;
	Link player1;
	Fairy fairy;
	Thug thug;
	Professor magician;
	Zelda princess;
	Male npc;
	Rabbit wabbit;
	Locations loc = Locations.STARTING_ROOM;
	Locations lastLoc;
	GreenfootImage gif = new GreenfootImage("images/tile-anim.gif");
	GreenfootImage gif2 = new GreenfootImage("images/Map2.png");
	GreenfootImage gif3 = new GreenfootImage("images/Map3.png");


	public ToThePast(){
		super(WIDTH, HEIGHT, CELL, true);
		resetScene();
		getBackground().drawImage(gif, IMAGE_START_LOC,IMAGE_START_LOC);

		//		GreenfootImage isaac = new GreenfootImage("images/Isaac Head.png");
		//		getBackground().drawImage(isaac, 50, 50);

		player1 = new Link();
		wabbit = new Rabbit();
		this.addObject(player1, WIDTH/2, HEIGHT/2);
	}

	public void resetScene(){
		getBackground().setColor(Color.BLACK);
		getBackground().fill();
	}

	public void changeScene(){
		if(loc == Locations.STARTING_ROOM){
			//			getBackground().setColor(Color.WHITE);
			//			getBackground().fill();
			resetScene();
			getBackground().drawImage(gif, IMAGE_START_LOC, IMAGE_START_LOC);
			player1.setLocation(STARTING_ROOM_X, STARTING_ROOM_Y);
		}

		if(loc == Locations.VILLAGE1){
			//			getBackground().setColor(Color.WHITE);
			//			getBackground().fill();
			resetScene();
			getBackground().drawImage(gif2, IMAGE_START_LOC,IMAGE_START_LOC);
			if(lastLoc == Locations.RIGHT){
				player1.setLocation(VILLAGE_X2, VILLAGE_Y1);
			}
			else if(lastLoc == Locations.LEFT){
				player1.setLocation(VILLAGE_X1, VILLAGE_Y1);
			}
			else{
				player1.setLocation(CAVE_X , CAVE_Y);
			}
			this.removeObject(wabbit);
		}

		if(loc == Locations.VILLAGE2){
			resetScene();
			getBackground().drawImage(gif3,IMAGE_START_LOC,IMAGE_START_LOC);
			//112,446
			if(lastLoc == Locations.LEFT){
				player1.setLocation(VILLAGE_X1, VILLAGE_Y2);
			}
			//310,446
			else if(lastLoc == Locations.RIGHT){
				player1.setLocation(VILLAGE_X2, VILLAGE_Y2);
			}
			this.addObject(wabbit,RABBIT_X_LOC ,RABBIT_Y_LOC);

		}
		switchDelay = MAX_DELAY;
	}
	public void act(){

		if(switchDelay != 0){
			switchDelay--;
		}
		if(loc == Locations.STARTING_ROOM){
			lastLoc = null;
			if(!(this.getObjectsAt(STARTING_ROOM_X, STARTING_ROOM_Y , Link.class).isEmpty())){
				if(switchDelay ==0){
					loc = Locations.VILLAGE1;
					changeScene();
				}
			}
		}
		if(loc == Locations.VILLAGE1){
			if(!(this.getObjectsAt(CAVE_X ,CAVE_Y, Link.class).isEmpty())){
				if(switchDelay ==0){
					loc = Locations.STARTING_ROOM;
					changeScene();
				}
			}
			else if(!(this.getObjectsAt(VILLAGE_X1,VILLAGE_Y1, Link.class).isEmpty())){
				lastLoc = Locations.LEFT;
				if(switchDelay ==0){
					loc = Locations.VILLAGE2;
					changeScene();
				}
			}
			else if(!(this.getObjectsAt(VILLAGE_X2,VILLAGE_Y1, Link.class).isEmpty())){
				lastLoc = Locations.RIGHT;
				if(switchDelay ==0){
					loc = Locations.VILLAGE2;
					changeScene();
				}
			}

		}

		if(loc == Locations.VILLAGE2){
			if(!(this.getObjectsAt(VILLAGE_X2,VILLAGE_Y2, Link.class).isEmpty())){
				lastLoc = Locations.RIGHT;
				if(switchDelay ==0){
					loc = Locations.VILLAGE1;
					changeScene();
				}
			}
			else if(!(this.getObjectsAt(VILLAGE_X1,VILLAGE_Y2, Link.class).isEmpty())){
				lastLoc = Locations.LEFT;
				if(switchDelay ==0){
					loc = Locations.VILLAGE1;
					changeScene();
				}
			}
		}
	}



}

