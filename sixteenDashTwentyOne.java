import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.*; 
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class sixteenDashTwentyOne extends Application {
	//make media exist
	Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	//make timer exist
	Timer timer = new Timer();
	TextField tfTimer = new TextField();
	TimerTask finish = new TimerTask() {
		@Override
		public void run(){
			mediaPlayer.play();
			mediaPlayer.setAutoPlay(true);
		}
	};
	
	BorderPane pane = new BorderPane();
	
	protected BorderPane getPane() {
		//big pane
		pane.setTop(new Label("Timer! Please enter a value (in seconds) to count down:"));
		pane.setCenter(tfTimer);
		
		//make textfield do the work
		tfTimer.setOnAction(e -> startTimer(tfTimer.getText()));
		
		//return the whole thing baby
		return pane; 
	}
	
	public void startTimer(String t) {
		if (t.matches("[0-9]+")){
			timer.schedule(finish, (Long.parseLong(t)*1000l));
		}
		
		pane.setCenter(null);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//please exist
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setTitle("Timer"); // Set the stage title
		primaryStage.setScene(scene); 
		primaryStage.show(); // Display the stage
	}
}