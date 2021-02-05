import processing.core.*;
import java.util.*; 

public final class DrawLottery
   extends PApplet {

  CommunityLSim theCommunity;

  public void plotPoints(int r, int g, int b, ArrayList<Float> OnePlayersFunds) {
    float x =20, y =200;
    float pX =0;
    float pY = 0;
    float priorYear = OnePlayersFunds.get(0);
	  int heightOff = -350;
	  float scaleOff = 5.5f;
  
    for (int i=0; i < OnePlayersFunds.size(); i++) {
     if (i >= 1) {
      priorYear = OnePlayersFunds.get(i-1);
      }
      fill(r, g, b);
      y = heightOff + OnePlayersFunds.get(i)*scaleOff;
      ellipse(x, height - y, 8, 8);
      if(i >=1) {
        pY = heightOff + priorYear*scaleOff; 
        stroke(r, g, b);
        line(pX, height -pY, x, height - y);
      }
      if (i > 1) {
       pX = x;
      }
      x+=12;
      }
  }

  public void settings() {
      size(1000, 400);
  }

  public void setup() {
		noLoop();
		theCommunity = new CommunityLSim(30);
		theCommunity.simulateYears(80);
	}

  public void draw() {
  	background(255);
	for (int i=0; i < theCommunity.getSize(); i++) {
		Player p = theCommunity.getPlayer(i);
		plotPoints(p.getR(), p.getG(), p.getB(), p.getFunds());
	}
  }

   public static void main(String[] args) {
        PApplet.main("DrawLottery");
    }
}
