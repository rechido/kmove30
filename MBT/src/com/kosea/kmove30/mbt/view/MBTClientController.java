package com.kosea.kmove30.mbt.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MBTClientController implements Initializable{
	
	@FXML
	TextArea chatWindow, chatDisplay;	
	
	private Stage primaryStage;	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {			
		
		
	}	

	@FXML
	private void handleButtonAction(ActionEvent event) {
		if(!chatWindow.getText().equals(""))
			chatDisplay.appendText(chatWindow.getText()+"\n");
   }
	
}
