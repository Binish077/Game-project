import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyCode;


public class Game extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hawk Game");
        base(primaryStage);
    }

    public void base(Stage primaryStage) {

        // -------------- INITIALIZING THE GAME MATRIX ----------------------
        final Player player = new Player();
        GridPane gameBase = new GridPane();
        StackPane[][] cells = new StackPane[50][50];
        int count = 0;
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                StackPane cell = new StackPane();
                cell.setMinHeight(10);
                cell.setMinWidth(10);
                gameBase.add(cell, i, j);
                cells[i][j] = cell;
                cells[i][j].setStyle("-fx-background-color: #86e3de");

            }
        }
        gameBase.requestFocus();
        gameBase.setOnKeyPressed(ke -> {
            System.out.println("ke");
            if(ke.getCode() == KeyCode.UP) {
                player.y--;
            }
            if(ke.getCode() == KeyCode.DOWN) {
                player.y++;
            }
            if(ke.getCode() == KeyCode.LEFT) {
                player.x--;
            }
            if(ke.getCode() == KeyCode.RIGHT) {
                player.x++;
            }
            if (player.x >= 3 && player.x <= 6) {
                if (player.y <= 2) {
                    suspectOneQ();
                    System.out.println("1");
                } else if (player.y >= 7) {
                    suspectTwoQ();
                    System.out.println("2");
                }
            } else {
                if (player.y >= 3 && player.y <= 6) {
                    if (player.x <= 2) {
                        suspectThreeQ();
                        System.out.println("3");
                    } else if (player.x >= 7) {
                        suspectFourQ();
                        System.out.println("4");
                    }
                }
            }

        });
        
        Scene myScene = new Scene(gameBase);
        primaryStage.setScene(myScene);
        primaryStage.show();
        gameBase.requestFocus();
    }

    public void suspectOneQ() {
        // pop up: suspect one, the baker. Fight or question?

    }

    public void suspectTwoQ() {

    }

    public void suspectThreeQ() {

    }

    public void suspectFourQ() {
        
    }
}