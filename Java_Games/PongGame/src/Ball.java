import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Ball extends Rectangle{
  Random random;
  int xVelocity;
  int yVelocity;
  int initialSpeed = 3;

  Ball(int x, int y, int width, int height){
    super(x, y, width, height);
    random = new Random();
    int randomXDIRECTION = random.nextInt(2);
    if(randomXDIRECTION == 0)
      randomXDIRECTION--;
    setXDirection(randomXDIRECTION * initialSpeed);

    int randomYDIRECTION = random.nextInt(2);
    if(randomYDIRECTION == 0)
      randomYDIRECTION--;
    setYDirection(randomYDIRECTION * initialSpeed);
  }

  public void setXDirection(int randomXDirection){
  xVelocity = randomXDirection;
  }
  public void setYDirection(int randomYDirection){
  yVelocity = randomYDirection;
  }
  public void move(){
  x += xVelocity;
  y += yVelocity;
  }
  public void draw(Graphics g){
  g.setColor(Color.WHITE);
  g.fillOval(x, y, height, width);
  }

}
