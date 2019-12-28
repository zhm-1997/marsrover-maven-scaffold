import Area.Area;
import Rover.Rover;

public class RoverController {
    Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }


    public String execute(String mission) {
        String[] commands = mission.split(",");
        int Width = Integer.parseInt(commands[0]);
        int Height = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);
        String direction = commands[4];
        rover.land(new Area(Width, Height), x, y, direction);
        rover.move();
        rover.turnLeft();
        rover.move();
        rover.turnRight();
        return rover.getPosition();
    }
}
