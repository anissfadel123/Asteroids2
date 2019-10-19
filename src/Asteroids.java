/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.
*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Asteroids extends Game {
    private Ship ship;
    private Point[] shipPoints;
    int amtAsteroid = 5;
    int amtStars = 50;
    List<Point[]> asteroidShape;
    Star[] stars;
    Asteroid[] ast;
    Random random;
    List<Bullet> bullets;



  public Asteroids() {
    super("Asteroids!",800,600);
    random = new Random();

    createStars();


    //shipPoint contains a set of points that defines the ship's shape
    shipPoints = new Point[4];
    shipPoints[0] = new Point(0,0);
    shipPoints[1] = new Point(20,10);  //head
    shipPoints[2] = new Point(0, 20);
    shipPoints[3] = new Point(10, 10);

      // shipInitLocation contains the coordinate of the ship's
      // initial location
      Point shipInitLocation = new Point(width/2-1, height/2-1);
      ship = new Ship(shipPoints, shipInitLocation, 0,1);
      bullets = ship.bullets;

    // creating 4 different shapes of asteroids
    asteroidShape = new ArrayList<>();

    //asteroid shape 1
      Point[] temp = new Point[4];
      temp[0] = new Point(0, 0);
      temp[1] = new Point(30, 30);
      temp[2] = new Point(50, 0);
      temp[3] = new Point(30, -40);

      asteroidShape.add(temp);

      //asteroid shape 2
      temp = new Point[4];
      temp[0] = new Point(0, 0);
      temp[1] = new Point(0, 20);
      temp[2] = new Point(40, 60);
      temp[3] = new Point(40, -30);
      asteroidShape.add(temp);

      //asteroid shape 3
      temp = new Point[5];
      temp[0] = new Point(0, 20);
      temp[1] = new Point(10, 40);
      temp[2] = new Point(40, 50);
      temp[3] = new Point(50, 20);
      temp[4] = new Point(20, 0);
      asteroidShape.add(temp);



      ast = createAsteriod(amtAsteroid);

      this.addKeyListener(ship);

  }
  private void createStars(){
        stars = new Star[amtStars];
        for(int i=0; i<amtStars; i++){
            Point pnt = new Point(random.nextInt(width), random.nextInt(height));
            stars[i] = new Star(pnt, random.nextInt(5));
        }

    }
  private Asteroid[] createAsteriod(int amount){
      Asteroid[] asteroid = new Asteroid[amount];
      for(int i=0; i<amount; i++){
          int choice = random.nextInt(asteroidShape.size()); //chooses a random shape
          Point[] asteroidPoint = asteroidShape.get(choice);
          int rotation = random.nextInt(361);
          asteroid[i] = new Asteroid(asteroidPoint, new Point(random.nextInt(width), random.nextInt(height)), rotation);
      }

      return asteroid;

  }
  
	public void paint(Graphics brush) {


        brush.setColor(Color.black);
        brush.fillRect(0,0,width,height);

        if(stars!=null){
        for(int i=0; i<amtStars; i++) {
            brush.setColor(Color.white);
            brush.fillOval((int)stars[i].getX(), (int)stars[i].getY(),
                    2*(int)stars[i].getRadius(), 2*(int)stars[i].getRadius());
            }

        }
        boolean shipcollides = false;
        if(ship != null && ast != null){

            for(int i = 0; i <ast.length; i++){
                if(ship.collision(ast[i])){
                    shipcollides = true;
                    break;
                }
            }
        }

        if(ship != null) {

            brush.setColor(Color.red);
            brush.fillPolygon(ship.getXPoints(), ship.getYPoints(), 4);
            if(!shipcollides) {
                ship.move();
            }
        }
        if(ast != null) {
            for (int i = 0; i < ast.length; i++) {
                if (ast[i] != null) {
                    brush.setColor(new Color(101,67,33)); // brown
                    brush.fillPolygon(ast[i].getXPoints(), ast[i].getYPoints(), 4);
//                    System.out.println("Asteroid Ready");
                    if(!shipcollides) {
                        ast[i].move();
                    }
                }
            }
        }
        if(bullets != null){
            for(int i=0; i<bullets.size(); i++){
                Bullet bullet = bullets.get(i);
                brush.setColor(Color.white);
                brush.fillOval((int)bullet.getX(), (int)bullet.getY(),
                        2*(int)bullet.getRadius(), 2*(int)bullet.getRadius());
                bullet.move();
            }
        }



  }
  
	public static void main (String[] args) {
    new Asteroids();
  }
}