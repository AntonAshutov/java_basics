import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private static final Logger LOGGER =
            LogManager.getLogger(CustomerStorage.class);
    private final Map<String, Customer> storage;
    String phoneRegex = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

        if (components.length != 4) {
            LOGGER.log(Level.ERROR, "wrong word amount: " + data);
            throw new WordAmountException("wrong word amount");
        }
        if (!components[INDEX_EMAIL].matches(emailRegex)) {
            LOGGER.log(Level.ERROR, "wrong email address: " + components[INDEX_EMAIL]);
            throw new EmailFormatException("wrong email address");
        }
        if (!components[INDEX_PHONE].matches(phoneRegex)) {
            LOGGER.log(Level.ERROR, "wrong phone number: " + components[INDEX_PHONE]);
            throw new PhoneFormatException("wrong phone number");
        }


        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {storage.values().forEach(System.out::println);}

    public void removeCustomer(String name) {storage.remove(name);}

    public Customer getCustomer(String name) {return storage.get(name);}

    public int getCount() {return storage.size();}
}

class WordAmountException extends IllegalArgumentException {
    public WordAmountException(String message) {
        super(message);
    }
}

class PhoneFormatException extends IllegalArgumentException {
    public PhoneFormatException(String message) {
        super(message);
    }
}

class EmailFormatException extends IllegalArgumentException {
    public EmailFormatException(String message) {
        super(message);
    }
}