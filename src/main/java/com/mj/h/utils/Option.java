package com.mj.h.utils;


import java.util.regex.Pattern;

public class Option {


    public static final String FUNCTION = "<value> func";
    public static final String VARIABLE = "var <value>";
    public static final String CONDITION = "<value> cond";

    public static final String PRINT = "print <value>";

    public static final boolean SEMICOLON = false;

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";
    public static final String SIX = "6";
    public static final String SEVEN = "7";
    public static final String EIGHT = "8";
    public static final String NINE = "9";

    public static final String INTEGER = "정수\"줘\"";
    public static final String DOUBLE = "실수\"줘\"";
    public static final String STRING = "문자열\"줘\"";
    public static final String BOOLEAN = "비교해\"줘\"";



    public static Pattern getFunctionPattern(){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_][\\(\\w\\)]*");

        return pattern;
    }
}
