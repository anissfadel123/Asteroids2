public class Bullet extends Circle {
    double rotation;
    Ship ship;

    Bullet(Ship ship, Point point, double radius, double inRotation){
        super(point, radius);
        this.ship = ship;
        rotation = inRotation;
    }
    public void move(){
        System.out.println(rotation);
        point.setX(point.getX() + 5*Math.cos(Math.toRadians(rotation)));
        point.setY(point.getY() + 5*Math.sin(Math.toRadians(rotation)));
        if(point.x > 800){
            point.x = 0;
        }
        if(point.x < 0){
            point.x = 800;
        }
        if(point.y > 600){
            point.y = 0;
        }
        if(point.y<0){
            point.y = 600;
        }
    }
}
