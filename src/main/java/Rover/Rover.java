package Rover;

import Area.Area;

public class Rover {
    int x;
    int y;
    String direction;

    public void land(Area area, int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        if (x > area.containsPointWidth(x) || y > area.containsPointHeight(y)) {
            throw new IllegalArgumentException("out of area");
        }
    }

    public String getPosition() {
        return "" + this.x + this.y + this.direction;
    }


    public void move() {
        if (direction.equals("E")) {
            x += 1;
        } else if (direction.equals("W")) {
            x -= 1;
        } else if (direction.equals("N")) {
            y += 1;
        } else if (direction.equals("S")) {
            y -= 1;
        }
    }

    public void turnLeft() {

        if (direction.equals("S")) {
            direction = "E";
        } else if (direction.equals("E")) {
            direction = "N";
        } else if (direction.equals("N")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "S";
        }
    }

    public void turnRight() {
        if (direction.equals("E")) {
            direction = "S";
        } else if (direction.equals("S")) {
            direction = "W";
        } else if (direction.equals("W")) {
            direction = "N";
        } else if (direction.equals("N")) {
            direction = "E";
        }
    }
}
