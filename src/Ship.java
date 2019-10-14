import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ship extends Polygon implements KeyListener {
    boolean up = false, down = false, right = false, left = false, stop = true, start = true;


    public Ship(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }
    public void move(){

        if(!start) {
            position.x += pull.x;
            position.y += pull.y;
        }
        if(up) {
            accelerate(0.3);
        }
        else if(right){
            rotate(10);

        }
        else if(left){
            rotate(-10);
        }
        if(position.x > 800){
            position.x = 0;
        }

        if(position.x < 0){
            position.x = 800;
        }
        if(position.y > 600){
            position.y = 0;
        }
        if(position.y<0){
            position.y = 600;
        }

    }
    public void accelerate (double acceleration) {
        pull.x += (acceleration * Math.cos(Math.toRadians(rotation)));
        pull.y += (acceleration * Math.sin(Math.toRadians(rotation)));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        start = false;

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up");
            up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");
            down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("right");
            right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left");
            left = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        up = false;
        down = false;
        right = false;
        left = false;

    }
}
