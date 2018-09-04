package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class MainController implements Initializable {
		// 디버깅용 log
		private Logger log = Logger.getLogger(this.getClass());
		// 메인 앱 참조
		private Main main;

		public void setMain(Main main) {
			this.main = main;
		}
		
		@FXML
		private Button start;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			start.setOnAction(e -> startAction(e));
		}
		
		public void startAction(ActionEvent event) {
			main.showMineSweeper();
			main.setStartTime(System.currentTimeMillis()); 
		}
		
}
