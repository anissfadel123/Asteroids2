import java.util.Random;

public class Asteroid extends Polygon {



    public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }
    public void move(){

        accelerate(1);

        if(position.x > Game.width){
            position.x = 0;
        }
        if(position.x < 0){
            position.x = Game.width;
        }
        if(position.y > Game.height){
            position.y = 0;
        }
        if(position.y<0){
            position.y = Game.height;
        }

    }

    public void accelerate (double acceleration) {
        position.x += (acceleration * Math.cos(Math.toRadians(rotation)));
        position.y += (acceleration * Math.sin(Math.toRadians(rotation)));
    }

}
