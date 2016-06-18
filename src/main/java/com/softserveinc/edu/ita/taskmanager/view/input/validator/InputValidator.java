package com.softserveinc.edu.ita.taskmanager.view.input.validator;

import java.util.regex.Pattern;

/**
 * Created by nazar.dovhyy on 18.06.2016.
 */
public class InputValidator {

    private static final String REGEX ="([task]+[0-9]+[0-9a-z]*)";
    private static Pattern pattern;


    static{
        pattern = Pattern.compile(REGEX);
    }



    public static boolean validate(String fetchedInput) {
        return pattern.matcher(fetchedInput).matches();
    }
}
