import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main {

    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;
    private static final Logger LOGGER =
            LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            LOGGER.log(Level.INFO, command);


            switch (tokens[0].toLowerCase()) {
                case "add":
                    try {
                        executor.addCustomer(tokens[1]);
                        System.out.println("Пользователь добавлен");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "list":
                    executor.listCustomers();
                    break;
                case "remove":
                    executor.removeCustomer(tokens[1]);
                    break;
                case "count":
                    System.out.println("There are " + executor.getCount() + " customers");
                    break;
                case "help":
                    System.out.println(HELP_TEXT);
                    break;
                default:
                    LOGGER.log(Level.ERROR, "unknown command: " + tokens[0]);
                    System.out.println(COMMAND_ERROR);
                    break;
            }
        }
    }
}
