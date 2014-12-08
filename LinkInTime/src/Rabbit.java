import java.util.Random;
import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Rabbit extends Actor{

	final int MOVE_SPEED = 5;
	final int DELAY_AMOUNT = 4;
	final int STILL_DELAY = 50;
	int delay = STILL_DELAY;
	int moveChoices  = 2;
	int counter = 0;
	int dir = 0;
	final int IMAGE_START_ROT = 0;
	final int IMAGE_LEFT_ROT = 180;
	Random rand  = new Random();

	public Rabbit(){
		this.setRotation(IMAGE_START_ROT);
		this.setImage("images/RabbitRight1.png");
	}

	public void act(){
		if(delay <= 0){
			counter++;
			if(dir == 0){
				if(counter % 4 == 0){
					this.move(MOVE_SPEED);
					if(counter == 4){
						this.setRotation(IMAGE_START_ROT);
						this.setImage("images/RabbitRight1.png");
					}
					else if(counter == 8){
						this.setImage("images/RabbitRight2.png");
					}
					else if(counter == 12){
						this.setImage("images/RabbitRight3.png");
					}
					else if(counter == 16){
						this.setImage("images/RabbitRight1.png");
						counter = 0;
						delay = STILL_DELAY;
					}
				}
			}
			else if(dir == 1){
				if(counter % 4 == 0){
					this.move(MOVE_SPEED);
					if(counter == 4){
						this.setRotation(IMAGE_LEFT_ROT);
						this.setImage("images/RabbitLeft1.png");
					}
					else if(counter == 8){
						this.setImage("images/RabbitLeft2.png");
					}
					else if(counter == 12){
						this.setImage("images/RabbitLeft3.png");
					}
					else if(counter == 16){
						this.setImage("images/RabbitLeft1.png");
						counter = 0;
						delay = STILL_DELAY;
					}
				}
			}
		}
		else{
			delay--;
			dir = chooseMoveDir();
		}
	}

	private int chooseMoveDir() {
		int moveDir = rand.nextInt(moveChoices);
		return moveDir;
	}
}
