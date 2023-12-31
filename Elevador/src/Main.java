import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
	static int numAndares = 10;
	static int numPassageiros = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		 //int numAndares = 10;
	        int capacidadeElevador = 1;
	        Predio predio = new Predio(numAndares, capacidadeElevador);
	        Elevador elevador = predio.getElevador();

	        //int numPassageiros = 5;
	        for (int i = 0; i < numPassageiros; i++) {
	            Passageiro passageiro = new Passageiro(elevador, i, (i + 1) % numAndares);
	            passageiro.run();
	        }
	}
	public void start(Stage primaryStage) {
        primaryStage.setTitle("Simulador de Elevador");

        Pane root = new Pane();

        // Crie um retângulo para representar o elevador
        Rectangle elevador = new Rectangle(50, 450, 50, 20);
        elevador.setStyle("-fx-fill: blue;");

        root.getChildren().add(elevador);

        // Crie retângulos para representar os andares
        for (int i = 0; i < numAndares; i++) {
            Rectangle andar = new Rectangle(30, 400 - i * 40, 100, 5);
            andar.setStyle("-fx-fill: gray;");
            root.getChildren().add(andar);
        }

        // Crie retângulos para representar os passageiros
        for (int i = 0; i < numPassageiros; i++) {
            Rectangle passageiro = new Rectangle(10, 400, 20, 20);
            passageiro.setStyle("-fx-fill: red;");
            root.getChildren().add(passageiro);
        }

        Scene scene = new Scene(root, 160, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
