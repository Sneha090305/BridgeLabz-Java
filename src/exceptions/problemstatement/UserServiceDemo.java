import java.util.HashSet;
import java.util.Set;


class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}


class UserService {

    private Set<String> users = new HashSet<>();

    public UserService() {

        users.add("admin");
        users.add("john");
    }


    public void registerUser(String username)
            throws UserAlreadyExistsException {

        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User already exists");
        }

        users.add(username);
        System.out.println("User registered successfully: " + username);
    }


    public void checkUserExistence(String username)
            throws UserNotFoundException {

        if (!users.contains(username)) {
            throw new UserNotFoundException("User not found");
        }

        System.out.println("User exists: " + username);
    }
}


public class UserServiceDemo {

    public static void main(String[] args) {

        UserService service = new UserService();

        try {
            service.checkUserExistence("john");     // exists
            service.registerUser("john");           // will throw
        }

        catch (UserNotFoundException e) {
            System.out.println("Check failed: " + e.getMessage());
        }

        catch (UserAlreadyExistsException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}
