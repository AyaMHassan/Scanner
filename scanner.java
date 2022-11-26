package com.example.scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scanner extends Application {
    public String[] scanner(String s){
        String[]arr={String.valueOf(0)};
        int len = 0;
        String state = "START";
        String token = "";
        String prevState = "";
        for (int i = 0; i < len; i++){
            if(state == "START"){

            }
            else if(state == "INRESERVEDWORDS"){

            }
            else if(state == "INNUM"){

            }
            else if(state == "INID"){

            }
            else if(state == "INASSIGN"){

            }
            else if(state == "INSYMBOL"){

            }
            else if(state == "DONE"){

            }
            else if(state == "INCOMMENT"){

            }
        }
        return arr;
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Scanner.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
