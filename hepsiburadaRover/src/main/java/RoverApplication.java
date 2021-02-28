import logic.RoverInputSettings;
import model.Rover;

import java.util.Scanner;

public class RoverApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RoverInputSettings.setMatrixDimensions(scanner);
        String quit = " ";
        do {
            RoverInputSettings.setMatrixCoordinates(scanner);
            RoverInputSettings.setMatrixWay(scanner);
            System.out.println(Rover.getInstance().getX() + " " + Rover.getInstance().getY() + " " + Rover.getInstance().getDirection().getValue());
            System.out.println("press q to exit, or any key to continue");
            quit = scanner.nextLine();
        } while (!quit.equals("q"));

    }

}
