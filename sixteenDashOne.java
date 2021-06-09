import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.*; 

public class sixteenDashOne extends Application {
	//create text
	public Text text = new Text(50, 50, "Engineer GAMING!");
	

	protected BorderPane getPane() {
		//radio buttons
		HBox paneForRadioButtons = new HBox(20);
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlue = new RadioButton("Blue");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbRed = new RadioButton("Red");
		ToggleGroup rbGroup = new ToggleGroup();
		rbYellow.setToggleGroup(rbGroup);
		rbBlue.setToggleGroup(rbGroup);
		rbGreen.setToggleGroup(rbGroup);
		rbBlack.setToggleGroup(rbGroup);
		rbRed.setToggleGroup(rbGroup);
		paneForRadioButtons.getChildren().addAll(rbYellow, rbBlue, rbGreen, rbRed, rbBlack); 
		paneForRadioButtons.setAlignment(Pos.CENTER);
		
		//regular ol buttons
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("<-");
		Button btRight = new Button("->");
		paneForButtons.getChildren().addAll(btLeft, btRight); 
		paneForButtons.setAlignment(Pos.CENTER);
		
		//big pane
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons); 
		pane.setTop(paneForRadioButtons); 
		
		//text
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		pane.setCenter(paneForText);
		paneForText.setStyle("-fx-border-color: black");
		
		//mae radio button do the worky
		rbYellow.setOnAction(e -> text.setFill(Color.YELLOW));
		rbRed.setOnAction(e -> text.setFill(Color.RED));
		rbBlue.setOnAction(e -> text.setFill(Color.BLUE));
		rbBlack.setOnAction(e -> text.setFill(Color.BLACK));
		rbGreen.setOnAction(e -> text.setFill(Color.GREEN));
		
		//make button do the worky
		btLeft.setOnAction(e -> text.setX(text.getX() - 20));
		btRight.setOnAction(e -> text.setX(text.getX() + 20));
		
		//return the whole thing baby
		return pane; 
	}
	
	@Override
	public void start(Stage primaryStage) {
		//please exist
		Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setTitle("Toggle baby!"); // Set the stage title
		primaryStage.setScene(scene); 
		primaryStage.show(); // Display the stage
	}
}