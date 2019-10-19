public class Circle extends Shape{
    public Point point;
    private double radius;
    private Point center;
    Circle(Point point, double radius){
        this.point = point;
        this.radius = radius;
        center = new Point(point.getX()+radius, point.getY()+radius);

    }

    @Override
    public boolean contains(Point point) {
        double disX = Math.abs(getCenter().getX() - point.getX());
        double disY = Math.abs(getCenter().getY() - point.getY());
        double distance = Math.sqrt(disX*disX + disY*disY);
        if(distance<= getRadius()) return true;
        return false;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
    public double getX(){
        return point.getX();
    }
    public double getY(){
        return point.getY();
    }



}
