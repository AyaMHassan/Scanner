package com.company;

public class Scanner {
    public String[] scanner(String s) {
        String[] arr = {String.valueOf(0)};
        String program;
        int len = 0;
        String state = "START";
        String token = "";
        String prevState = "";
        for (int i = 0; i < len; i++) {
            if (state == "START") {

            } else if (state == "INRESERVEDWORDS") {

            } else if (state == "INNUM") {

            } else if (state == "INID") {

            } else if (state == "INASSIGN") {

            } else if (state == "INSYMBOL") {

            } else if (state == "DONE") {

            } else if (state == "INCOMMENT") {

            }
        }
        return arr;
    }
}

