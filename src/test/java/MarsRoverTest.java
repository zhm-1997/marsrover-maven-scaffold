import Area.Area;
import Rover.Rover;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class MarsRoverTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_land_the_rover_on_area() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        String position = rover.getPosition();
        assertThat(position).isEqualTo("55E");
    }

    @Test
    public void should_move_forward() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "E");
        rover.move();
        String position = rover.getPosition();
        assertThat(position).isEqualTo("65E");
    }

    @Test
    public void should_turn_left() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "S");
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55E");
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55N");
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55W");
        rover.turnLeft();
        assertThat(rover.getPosition()).isEqualTo("55S");

    }

    @Test
    public void should_turn_right() {
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 5, 5, "S");
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55W");
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55N");
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55E");
        rover.turnRight();
        assertThat(rover.getPosition()).isEqualTo("55S");
    }

    @Test
    public void out_of_area() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("out of area");
        Area area = new Area(10, 10);
        Rover rover = new Rover();
        rover.land(area, 20, 30, "S");
    }

    @Test
    public void should_execute_commands() {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.execute(mission);
        assertThat(position).isEqualTo("66E");
    }


}
