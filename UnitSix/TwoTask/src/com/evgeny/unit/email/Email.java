package com.evgeny.unit.email;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email implements Serializable {
    static final long serialVersionUID = -7588980448999010399L;
    public static final Pattern EMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String email;

    public Email(String email) {
        setEmail(email);
    }

    public static boolean validate(String email) {
        Matcher matcher = EMAIL.matcher(email);
        return matcher.find();
    }

    public boolean setEmail(String email) {
        if (validate(email)) {
            this.email = email;
            return true;
        } else {
            this.email = "";
            return false;
        }
    }

    @Override
    public String toString() {
        return email + "";
    }
}