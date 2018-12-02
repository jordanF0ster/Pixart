package application;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

import javafx.scene.paint.Color;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.bytedeco.javacv.FrameGrabber.Exception;

import yhacks2018.VideoReader;
import yhacks2018.ImageReader;

public class Controller  {
	@FXML
	private Label label1 ;
	@FXML
	private Label label2 ;

	@FXML
	private Button File;

	@FXML
	private ProgressBar progressBar;
	public static ProgressBar statprogressBar;

	@FXML 
	private Label progress;
	public static Label label;
	
	

	/*class bg_Thread implements Runnable {

		@Override
		public void run() {
			for(int i = 0; i < 100; i++) {
				try {
					progressBar.setProgress(i/100.0);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			} 

		}

	} 
	@FXML
	public void HandleButton(ActionEvent Event) {
		Thread th = new Thread(new bg_Thread());
		th.start();
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		progressBar.setProgress(0.0);

	} 
	*/
	@FXML
	public void onFileClick(MouseEvent event) throws Exception, IOException {
		 int position = 0;
		ArrayList<String> fileType = new ArrayList<>();
//		fileType.add("*.mov");
		fileType.add("*.mp4");
//		fileType.add("*.wmv");
//		fileType.add("*.avi");
//		fileType.add("*.flv");
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".mp4", fileType));
		chooser.setTitle("Open File");
		File file = chooser.showOpenDialog(new Stage());
		VideoReader a = new VideoReader(file.toString(), "/Users/jfoster/Documents/yhacks/images");
		File.setVisible(false);
		ArrayList<javafx.scene.paint.Color> newList = a.videoToImg("jpg", 200);
		GridPane gridPane = new GridPane();
		gridPane.setPrefHeight(360);
		gridPane.setPrefWidth(640);
		Stage stage = new Stage();
		Scene scene = new Scene(gridPane, 640, 360);
		stage.setScene(scene);
		stage.setTitle("Picture");
		stage.show();
		double w = (double) gridPane.getWidth() / newList.size();
		
		for(int i = 0; i <newList.size(); i++) {
			Rectangle rec = new Rectangle();
			rec.setWidth(w);
			rec.setHeight(gridPane.getHeight());
			rec.setFill(newList.get(i));
			
			gridPane.setColumnIndex(rec, i);
			gridPane.getChildren().add(rec);
		}

		
		}
	}