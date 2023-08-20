package com.solt.model;

import java.net.URL;
import java.util.ResourceBundle;

import com.solt.entity.Member;
import com.solt.service.MemberService;
import com.solt.utility.ShopException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class LoginViewController implements Initializable {
	 	@FXML
	    private TextField username;

	    @FXML
	    private TextField pword;

	    
	    private MemberService memberSrv;
	
	    public void clear() {
			

		}
	    public void submit() {
	    	try {
			Member member = memberSrv.login(username.getText(),pword.getText());
			if (member!=null){
//				showView
				MainFrameController.showView();
				username.getScene().getWindow().hide();
			}
	    	}catch (ShopException e) {
				Alert alert = new Alert(AlertType.WARNING,e.getMessage());
				alert.showAndWait();
			}
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			memberSrv = new MemberService();
		}
}
