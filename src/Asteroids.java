/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
*/
import java.awt.*;
import java.awt.event.*;

class Asteroids extends Game {
    private Ship ship;
    private Point[] shipPoints;
    private int shipXpoint[];
    private int shipYpoint[];


  public Asteroids() {
    super("Asteroids!",800,600);


    //shipPoint contains a set of points that defines the ship's shape
    shipPoints = new Point[4];
    shipPoints[0] = new Point(0,0);
    shipPoints[1] = new Point(20,10);
    shipPoints[2] = new Point(0, 20);
    shipPoints[3] = new Point(10, 10);


    // shipInitLocation contains the coordinate of the ship's
      // initial location
    Point shipInitLocation = new Point(width/2-1, height/2-1);
    ship = new Ship(shipPoints, shipInitLocation, 0);
//    shipPoints = ship.getPoints();

    //
    shipXpoint = new int[shipPoints.length];
    shipYpoint = new int[shipPoints.length];
      System.out.println(shipPoints.length);
    for(int i=0; i<shipPoints.length; i++){
        shipXpoint[i] = (int)shipPoints[i].getX();
    }
      for(int i=0; i<shipPoints.length; i++){
          shipYpoint[i] = (int)shipPoints[i].getY();
      }
      for(int i=0; i<shipXpoint.length; i++){
          System.out.println("y"+i+": "+shipXpoint[i]);
      }
      for(int i=0; i<shipYpoint.length; i++){
          System.out.println("y"+i+": "+shipYpoint[i]);
      }
      this.addKeyListener(ship);

  }
  
	public void paint(Graphics brush) {

        brush.setColor(Color.black);
        brush.fillRect(0,0,width,height);


        if(shipXpoint!=null||shipXpoint!=null) {
            shipPoints = ship.getPoints();

            //
            shipXpoint = new int[shipPoints.length];
            shipYpoint = new int[shipPoints.length];
            System.out.println(shipPoints.length);
            for(int i=0; i<shipPoints.length; i++){
                shipXpoint[i] = (int)shipPoints[i].getX();
            }
            for(int i=0; i<shipPoints.length; i++){
                shipYpoint[i] = (int)shipPoints[i].getY();
            }
            System.out.println("Yoooo");
            brush.setColor(Color.red);
            brush.fillPolygon(shipXpoint, shipYpoint, shipPoints.length);
//            brush.fillPolygon(ship.getXPoints(), ship.getYPoints(), shipPoints.length);
            ship.move();
        }

  }
  
	public static void main (String[] args) {
    new Asteroids();
  }
}