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
        String substate = "";
        int len = program.length();
        String state = "START";
        String token = "";
        String type = "";
        for (int i = 0; i < len; i++) {
            if (state == "START") {
               if(program.charAt(i) == 'i'){
                    state = "INRESERVEDWORDS";
                    substate = "IF";
                    i = i-1;
                }
                else if(program.charAt(i) == 't'){
                    state = "INRESERVEDWORDS";
                    substate = "THEN";
                    i = i-1;
                }
                else if(program.charAt(i) == 'e'){
                    state = "INRESERVEDWORDS";
                    substate = "END";
                    i = i-1;
                }
                else if(program.charAt(i) == 'r'){
                    state = "INRESERVEDWORDS";
                    substate = "REPEAT_READ";
                    i = i-1;
                }
                else if(program.charAt(i) == 'u'){
                    state = "INRESERVEDWORDS";
                    substate = "UNTIL";
                    i = i-1;
                }
                else if(program.charAt(i) == 'w'){
                    state = "INRESERVEDWORDS";
                    substate = "WRITE";
                    i = i-1;
                }
                else if ((program.charAt(i) == ';') || (program.charAt(i) == '<') || (program.charAt(i) == '=') || (program.charAt(i) == '+') || (program.charAt(i) == '-') || (program.charAt(i) == '*') || (program.charAt(i) == '/') || (program.charAt(i) == '(') || (program.charAt(i) == ')')) {
                    state = "INSYMBOL";
                    i = i - 1;
                } else if (program.charAt(i) == '{') {
                    state = "INCOMMENT";
                    i = i - 1;
                }else if (program.charAt(i) == ':') {
                    state = "INASSIGN";
                    i = i - 1;
                }else if(((program.charAt(i)>='a')&&(program.charAt(i)<='z'))||((program.charAt(i)>='A')&&(program.charAt(i)<='Z'))){
                    state="INID";
                    i=i-1;
                }

            }
            else if (state == "INRESERVEDWORDS"){
                if(substate == "IF"){
                    if(i + 2 <= len) {
                        if (program.substring(i, i + 2).equals("if")) {
                                token += "if";
                                if (program.charAt(i + 2) == '\n' || program.charAt(i + 2) == ' ' || program.charAt(i + 2) == '\t') {
                                    state = "DONE";
                                    type = substate;
                                    i = i + 2;
                                } else {
                                    state = "INID";
                                    i = i + 1;
                                }
                        }
                    }
                    else{
                        i = i - 1;
                        state = "INID";
                    }
                }
                else if (substate == "THEN"){
                    if(i+4 <= len) {
                        if (program.substring(i, i + 4).equals("then")) {
                            token += "then";
                            if (program.charAt(i + 4) == '\n' || program.charAt(i + 4) == ' ' || program.charAt(i + 4) == '\t') {
                                state = "DONE";
                                type = substate;
                                i = i + 4;
                            } else {
                                state = "INID";
                                i = i + 3;
                            }
                        }
                    }
                    else{
                        i = i - 1;
                        state = "INID";
                    }
                }
                else if (substate == "END"){
                    if(i+3 <= len){
                        if(program.substring(i,i+3).equals("end")) {
                            token += "end";
                            if(i+3 == len){
                                state = "DONE";
                                type = substate;
                                i = i + 1;
                            }
                            else if (program.charAt(i + 3) == '\n' || program.charAt(i + 3) == ' ' || program.charAt(i + 3) == '\t') {
                                state = "DONE";
                                type = substate;
                                i = i + 3;
                            } else {
                                state = "INID";
                                i = i + 2;
                            }
                        }
                    }
                    else{
                        i = i - 1;
                        state = "INID";
                    }
                }
                else if(substate == "REPEAT_READ"){
                    if(i+6 < len){
                        if(program.substring(i,i+6).equals("repeat")){
                            token+="repeat";
                            if(program.charAt(i+6) == '\n' || program.charAt(i+6) == ' ' || program.charAt(i+6) == '\t'){
                                state = "DONE";
                                type = "REPEAT";
                                i = i + 6;
                            }
                            else{
                                state = "INID";
                                i = i + 5;
                            }
                            continue;
                        }
                    }
                    if(i+4 < len){
                        if(program.substring(i,i+4).equals("read")){
                            token+="read";
                            if(program.charAt(i+4) == '\n' || program.charAt(i+4) == ' ' || program.charAt(i+4) == '\t'){
                                state = "DONE";
                                type = "READ";
                                i = i + 4;
                            }
                            else{
                                state = "INID";
                                i = i + 3;
                            }
                            continue;
                    }
                    }
                        i = i - 1;
                        state = "INID";
                }

                else if(substate == "UNTIL"){
                    if(i+5 < len){
                        if(program.substring(i,i+5).equals("until")){
                            token+="until";
                            if(program.charAt(i+5) == '\n' || program.charAt(i+5) == ' ' || program.charAt(i+5) == '\t'){
                                state = "DONE";
                                type = substate;
                                i = i + 5;
                            }
                            else{
                                state = "INID";
                                i = i + 4;
                            }
                        }
                    }
                    else{
                        i = i - 1;
                        state = "INID";
                    }
                }
                else if(substate == "WRITE"){
                    if(i+5 < len){
                        if(program.substring(i,i+5).equals("write")){
                            token+="write";
                            if(program.charAt(i+5) == '\n' || program.charAt(i+5) == ' ' || program.charAt(i+5) == '\t'){
                                state = "DONE";
                                type = substate;
                                i = i + 5;
                            }
                            else{
                                state = "INID";
                                i = i + 4;
                            }
                        }
                    }
                    else{
                        i = i - 1;
                        state = "INID";
                    }
                }
            }
             else if (state == "INNUM") {

            } else if (state == "INID") {
                  if(((program.charAt(i)>='a')&&(program.charAt(i)<='z'))||((program.charAt(i)>='A')&&(program.charAt(i)<='Z'))){
                    token+=program.charAt(i);
                    type="Identifier";
                }
                else {
                    i=i-1;
                    state="DONE";
                }

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
                int j;
                for( j=i;j<len;j++){
                    if(program.charAt(j)=='}') break;
                }
                i=j;
                state="START";
            }
        }
        return arr;
    }
}

