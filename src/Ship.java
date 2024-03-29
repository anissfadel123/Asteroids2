import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Ship extends Polygon implements KeyListener {
    boolean up = false, down = false, right = false, left = false, stop = true, start = true, space = false;
    List<Bullet> bullets;
    int headIndex;

    public Ship(Point[] inShape, Point inPosition, double inRotation, int headindex) {
        super(inShape, inPosition, inRotation);
        headIndex = headindex;
        bullets = new ArrayList<>();
    }
    public void move(){

        if(!start) {
            position.x += pull.x;
            position.y += pull.y;
        }
        if(space){
            bullets.add(new Bullet(this,getHead(),1, rotation));
//            System.out.println(getHead().getX()+" "+getHead().getY());
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
    public Point getHead(){
        Point[] pnt = getPoints();
        return pnt[headIndex];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        start = false;

        if(e.getKeyCode() == KeyEvent.VK_UP) {
//            System.out.println("up");
            up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            System.out.println("right");
            right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//            System.out.println("left");
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            space = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
//            System.out.println("up");
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            System.out.println("right");
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
//            System.out.println("left");
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            space = false;
        }

    }
}
