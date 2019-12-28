
public class RoverController {
    Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }


    public String execute(String mission) {
        String[] commands = mission.split(",");
        int width = Integer.parseInt(commands[0]);
        int height = Integer.parseInt(commands[1]);
        int x = Integer.parseInt(commands[2]);
        int y = Integer.parseInt(commands[3]);
        String direction = commands[4];
        rover.land(new Area(width, height), x, y, direction);
        rover.move();
        rover.turnLeft();
        rover.move();
        rover.turnRight();
        return rover.getPosition();
    }
}
