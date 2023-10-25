
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ElevadorVisual extends Application {
    private static final int NUM_ANDARES = 10; // Número de andares no prédio
    private static final int NUM_PASSAGEIROS = 5; // Número de passageiros

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simulador de Elevador");

        Pane root = new Pane();

        // Crie um retângulo para representar o elevador
        Rectangle elevador = new Rectangle(50, 450, 50, 20);
        elevador.setStyle("-fx-fill: blue;");

        root.getChildren().add(elevador);

        // Crie retângulos para representar os andares
        for (int i = 0; i < NUM_ANDARES; i++) {
            Rectangle andar = new Rectangle(30, 400 - i * 40, 100, 5);
            andar.setStyle("-fx-fill: gray;");
            root.getChildren().add(andar);
        }

        // Crie retângulos para representar os passageiros
        for (int i = 0; i < NUM_PASSAGEIROS; i++) {
            Rectangle passageiro = new Rectangle(10, 400, 20, 20);
            passageiro.setStyle("-fx-fill: red;");
            root.getChildren().add(passageiro);
        }

        Scene scene = new Scene(root, 160, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
