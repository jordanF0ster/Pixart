package application;
	

import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
	private Stage primaryStage;
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * creating a new stage using the GUI.fxml
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    this.primaryStage.setScene(scene);
	    this.primaryStage.show();
	    
	    scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
	    
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

