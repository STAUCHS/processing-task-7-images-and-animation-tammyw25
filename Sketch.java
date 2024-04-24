import processing.core.PApplet;
import processing.core.PImage; 

public class Sketch extends PApplet {

  PImage imgMiffyBear; 
  PImage imgLittleFarm;

  // x and y coordinate for Miffy Bear
  float fltMiffyBearX = 50; 
  float fltMiffyBearY = 100;
  float fltMiffyBearRadian = 10;
  float fltMiffyBearRadius = 10;
  float fltMiffyBearWidth = 10;
  float fltMiffyBearHeight = 10;

  // Miffy Bear variables 
  float fltXSpeed = random(-1, 5); 
  float fltYSpeed = random(-1, 5); 

  // define colours
  int beige = color(227, 215, 184);
  int white = color(255, 255, 255);
  int brown = color(77, 44, 15);

  public void settings() {
    size(700, 700);
  }

  public void setup() {
    background(196, 233, 245);
   
    // load Miffy Bear
    imgMiffyBear = loadImage("miffy_002.png");
    
    // load Little Farm
    imgLittleFarm = loadImage("little farm.png");
    

    // resize Miffy bear 
    // imgMiffyBear.resize(50, 50); 
    imgMiffyBear.resize(imgMiffyBear.width/4, imgMiffyBear.height/4);
  }

  public void draw() {

    image(imgLittleFarm, 0, 0);
   
    // draw Miffy Bear to move 
    fltMiffyBearX += fltXSpeed;
    fltMiffyBearY += fltYSpeed;

    image(imgMiffyBear, fltMiffyBearX, fltMiffyBearY); 
  
    if (fltMiffyBearX > width - imgMiffyBear.width || fltMiffyBearX < 0) {
      fltXSpeed *= -1;
    } 

    if(fltMiffyBearY > width - imgMiffyBear.height || fltMiffyBearY< 0) {
      fltYSpeed *= -1;
 

    // Animate Miffy bear in a non-linear direction 
    
    float fltUpdatedMiffyBearX = fltMiffyBearX + cos(fltMiffyBearRadian) * fltMiffyBearRadius; 
    float fltUpdatedMiffyBearY = fltMiffyBearY + sin(fltMiffyBearRadian) * fltMiffyBearRadius;

    image(imgMiffyBear, fltUpdatedMiffyBearX, fltUpdatedMiffyBearY);

    // Create an edge collison 
   
    if (fltMiffyBearX > 0 || fltUpdatedMiffyBearX > width || fltUpdatedMiffyBearY < 0 || fltUpdatedMiffyBearX < 0) { 
      fltYSpeed *= -1;

  
    if (fltMiffyBearX + fltMiffyBearWidth > fltMiffyBearX && fltMiffyBearX < fltMiffyBearX + fltMiffyBearWidth && 
      fltMiffyBearY + fltMiffyBearHeight + fltYSpeed > fltMiffyBearY && fltMiffyBearY + fltYSpeed < fltMiffyBearY + fltMiffyBearHeight) {
         fltYSpeed *= -1;
         
         fltMiffyBearX += fltXSpeed;
         fltMiffyBearY += fltYSpeed;
       
    // draw the Miffy Bear
    image(imgMiffyBear, fltMiffyBearX, fltMiffyBearY, fltMiffyBearWidth, fltMiffyBearHeight);

    
    }
   }
  }
 }
} 

