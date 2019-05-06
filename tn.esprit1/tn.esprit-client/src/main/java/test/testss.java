package test;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testss extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		String fxmlFile = "splash.fxml";
	      
	      //  FXMLLoader loader = new FXMLLoader();
	        Parent rootNode = FXMLLoader.load(getClass().getResource(fxmlFile));

	       // log.debug("Showing JFX scene");
	        Scene scene = new Scene(rootNode);
	        scene.getStylesheets().add("/fxml/login.css");
	       // Scene scene = new Scene(rootNode, 400, 200);

	        stage.setTitle("Hello JavaFX and Maven");
	        stage.setScene(scene);
	        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
