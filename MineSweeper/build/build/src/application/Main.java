package application;

import java.io.IOException;

import org.apache.log4j.Logger;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	// 디버깅용 log
	private Logger log = Logger.getLogger(this.getClass());
	private Stage primaryStage = null;
	private int bombCount = 10;
	private int width = 9, height = 9;
	private long startTime = 0, endTime = 0;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		showMain();
		

	}

	public void showMain() {
		try {
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Main.fxml"));
			AnchorPane Layout = (AnchorPane) loader.load();

			// 상위 레이아웃을 포함하는 scene을 보여준다.
			Scene scene = new Scene(Layout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("MineSweeper - Dev. by D. E. Lee");
			primaryStage.getIcons().add(new Image("file:resources/icon.png"));
			primaryStage.setResizable(false);
			primaryStage.show();

			// 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
			MainController controller = loader.getController();
			controller.setMain(this);

			log.info("Display - Main");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void showMineSweeper() {
		try {
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MineSweeper.fxml"));
			AnchorPane Layout = (AnchorPane) loader.load();

			initBtnsArray();

			// 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
			MineSweeperController controller = loader.getController();
			controller.setMain(this);
			controller.getGamePane().getChildren().add(getGrid());
			controller.setWidth(width);
			controller.setHeight(height);
			controller.setBtns(btns);		
			controller.initializeTexts();					
			controller.installBomb();			
			controller.installNumbers();
			controller.installButtons();
			//controller.printTexts();
			//controller.showTexts();

			// 상위 레이아웃을 포함하는 scene을 보여준다.
			Scene scene = new Scene(Layout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("MineSweeper - Dev. by D. E. Lee");
			primaryStage.setResizable(false);
			primaryStage.show();

			log.info("Display - MineSweeper");
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	private Button[] btns = new Button[width * height];
	
	private void initBtnsArray() {
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new Button();
			btns[i].setPrefWidth(30);
			btns[i].setPrefHeight(30);
		}
	}
	
	private Pane getGrid() {

		GridPane gridPane = new GridPane();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				gridPane.add(btns[row * width + col], col, row);
			}
		}
		return gridPane;
	}	

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	// 에러 메시지 띄워주기
	public void alertMessage(String title, String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);

		// Header Text: null
		alert.setHeaderText(null);
		alert.setContentText(str);

		alert.showAndWait();
	}	

	public int getBombCount() {
		return bombCount;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
