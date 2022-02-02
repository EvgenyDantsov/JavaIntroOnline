package com.evgeny.unit.user;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    static String NAME_FILE = "users.txt";
    private List<User> users;
    private String masterPassword;
    private File saveFile;

    public Users() {
        createUsers();
    }

    private void createUsers() {
        users = new ArrayList<User>();
        saveFile = new File(NAME_FILE);
        if (saveFile.exists() && saveFile.canRead() && saveFile.length() != 0) {
            try (Scanner in = new Scanner(new FileReader(saveFile))) {
                masterPassword = in.nextLine();
                while (in.hasNextLine()) {
                    String admin = in.nextLine();
                    String login = in.nextLine();
                    String email = in.nextLine();
                    String passwordHash = in.nextLine();
                    boolean isAdmin = false;
                    if (admin.equals("Administrator:")) {
                        isAdmin = true;
                    }
                    User user = new User(login, email, passwordHash, isAdmin);
                    users.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (masterPassword == null) {
                    masterPassword = "admin";
                }
            }
        } else {
            masterPassword = "admin";
        }
    }

    public void saveToFile() {
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (saveFile.setWritable(true)) {
            try (PrintWriter out = new PrintWriter(saveFile)) {
                out.println(masterPassword);
                for (User user : users) {
                    out.print(user.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Address[] emailUser() throws AddressException {
        int i = 0, countUser = 0;
        for(User user : users) {
            if(!user.isAdmin()) {
                countUser++;
            }
        }
        Address[] addresses = new Address[countUser];
        for(User user : users){
            if(!user.isAdmin()) {
                addresses[i] = new InternetAddress(user.getEmail());
                i++;
            }
        }
        return addresses;
    }

    public Address[] emailAdmin() throws AddressException {
        int i = 0, countAdmin = 0;
        for(User user : users) {
            if(user.isAdmin()){
                countAdmin++;
            }
        }
        Address[] addresses = new Address[countAdmin];
        for(User user : users){
            if(user.isAdmin()) {
                addresses[i] = new InternetAddress(user.getEmail());
                i++;
            }
        }
        return addresses;
    }

    public boolean loginMaster(String password) {
        return masterPassword.equals(password);
    }

    public boolean checkLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    public boolean addUser(User newUser) {
        for (User user : users) {
            if (user.getLogin().equals(newUser.getLogin())) {
                return false;
            }
        }
        users.add(newUser);
        return true;
    }

    public User login(String login, String password) {
        for (User user : users) {
            if (user.login(login, password)) {
                return user;
            }
        }
        return null;
    }
}
