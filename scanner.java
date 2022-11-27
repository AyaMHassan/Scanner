package com.company;

public class Scanner {
     public static void main(String[] args) {
        // TODO code application logic here
       String s="{ Sample program in TINY language –\n" +
"computes factorial}\n" +
"read x; {input an integer }\n" +
"if 0 < x then { don’t compute if\n" +
"x <= 0 }\n" +
"fact := 1;\n" +
"repeat\n" +
"fact := fact * x;\n" +
"x := x - 1\n" +
"until x = 0;\n" +
"write fact { output factorial of x\n" +
"}\n" +
"end";
       ArrayList<String> a=scanner(s);
    }
     public static ArrayList<String> scanner(String s) {
        ArrayList<String> arr = new ArrayList<String>();
        String program=s;
        int len = program.length();
        String state = "START";
        String token = "";
        String type = "";
        for (int i = 0; i < len; i++) {
            if (state == "START") {
                if ((program.charAt(i) == ';') || (program.charAt(i) == '<') || (program.charAt(i) == '=') || (program.charAt(i) == '+') || (program.charAt(i) == '-') || (program.charAt(i) == '*') || (program.charAt(i) == '/') || (program.charAt(i) == '(') || (program.charAt(i) == ')')) {
                    state = "INSYMBOL";
                    i = i - 1;
                } else if (program.charAt(i) == '{') {
                    state = "INCOMMENT";
                    i = i - 1;
                }else if (program.charAt(i) == ':') {
                    state = "INASSIGN";
                    i = i - 1;
                }

            } else if (state == "INRESERVEDWORDS") {

            } else if (state == "INNUM") {

            } else if (state == "INID") {

            } else if (state == "INASSIGN") {
                
                if((program.charAt(i)==':') &&(program.charAt(i+1)=='=')){
                    i=i+1;
                    token+=":=";
                    type="INASSIGN";
                    state="DONE";
                }

            } else if (state == "INSYMBOL") {
                
                if(program.charAt(i)==';') {
                    token+=program.charAt(i);
                    type="SEMICOLON";
                    state="DONE";
                }
                else if(program.charAt(i)=='<'){
                    token+=program.charAt(i);
                    type="LESSTHAN";
                    state="DONE";
                }
                else if(program.charAt(i)=='=') {
                    token+=program.charAt(i);
                    type="EQUAL";
                    state="DONE";
                }
                else if(program.charAt(i)=='+') {
                    token+=program.charAt(i);
                    type="PLUS";
                    state="DONE";
                }
                else if(program.charAt(i)=='-') {
                    token+=program.charAt(i);
                    type="MINUS";
                    state="DONE";
                }
                else if(program.charAt(i)=='*') {
                    token+=program.charAt(i);
                    type="MULT";
                    state="DONE";
                }else if(program.charAt(i)=='/') {
                    token+=program.charAt(i);
                    type="DIV";
                    state="DONE";
                }else if(program.charAt(i)=='(') {
                    token+=program.charAt(i);
                    type="OPENBRACKET";
                    state="DONE";
                }else if(program.charAt(i)==')') {
                    token+=program.charAt(i);
                    type="CLOSEDBRACKET";
                    state="DONE";
                }

            } else if (state == "DONE") {
                String temp=token+" , "+type+"\n";
                arr.add(temp);
                token="";
                type="";
                state="START";
                i=i-1;

            } else if (state == "INCOMMENT") {
                
            }
        }
        return arr;
    }
}

