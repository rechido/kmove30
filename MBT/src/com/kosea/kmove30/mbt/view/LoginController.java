package com.kosea.kmove30.mbt.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{

	MybatisQuery query = new MybatisQuery("messenger/mybatis-config.xml");

	@FXML
	TextField idField;
	@FXML
	PasswordField pswdField;
	@FXML
	Button loginBtn, cancelBtn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		loginBtn.setOnAction(e->loginBtnAction(e));
		cancelBtn.setOnAction(e->cancelBtnAction(e));
		
	}	
	
	private Stage primaryStage;	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}	

	
	// 로그인버튼액션
	public void  loginBtnAction(ActionEvent event) {
		if (query.checkExistingID(idField.getText())) { // 아이디 존재 검사
			
			if (query.checkPassword(idField.getText(), pswdField.getText())) { // 비밀번호 검사
				alertMessage("Login Success", "Welcome! " + idField.getText());
				
				// 로그인 성공 했으면 클라이언트 띄워주기
				try {
					primaryStage.close();
					Stage mbtClient = new Stage(StageStyle.UTILITY);
					mbtClient.initModality(Modality.NONE);
					mbtClient.initOwner(primaryStage);
					mbtClient.setTitle("Login");	
					
					Parent parent = FXMLLoader.load(MBTClientController.class.getResource("MBTClient.fxml"));
					Scene scene = new Scene(parent);
					
					mbtClient.setScene(scene);
					mbtClient.setResizable(false);
					mbtClient.show();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			} 
			else {	
				alertMessage("Login Fail", "Incorrect password!");
			}
		} 
		else {
			alertMessage("Login Fail", "Incorrect ID!");
		}
	}
	
	
	
	// 취소버튼액션
	public void  cancelBtnAction(ActionEvent event) {
		Platform.exit();
	}
	
	// 에러 메시지 띄워주기
	private void alertMessage(String title, String str){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(str);
 
        alert.showAndWait();
    }

}
