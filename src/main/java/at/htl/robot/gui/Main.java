package at.htl.robot.gui;

import at.htl.robot.model.Direction;
import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    int upperMargin = 40;
    int leftMargin = 20;
    int boxLength = 50;
    Robot robot;

    // Hier die Member-Attribute eintragen

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);


    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(210); //https://processing.org/tutorials/color/

        robot = new Robot();

        robot.setX(0);
        robot.setY(0);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {
        for (int i = 0; i < 11; i++) {
            line(
                    leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength

            );
            line(
                    leftMargin + i * boxLength,
                    upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength
            );
        }

        int centerX = leftMargin + boxLength / 2 + robot.getX() * boxLength;
        int centerY = upperMargin + boxLength / 2 + robot.getY() * boxLength;

        ellipse(centerX,
                centerY,
                (int) (boxLength * 0.8),
                (int) (boxLength * 0.8));
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(210);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            deleteAll();
            robot.stepForward();
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
