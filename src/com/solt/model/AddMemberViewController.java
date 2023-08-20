package com.solt.model;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.solt.entity.Member;
import com.solt.service.MemberService;
import com.solt.utility.Reloader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMemberViewController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pword;

    @FXML
    private TextField phone;

    @FXML
    private TextField address;
    
    private Reloader reload;
    
    private MemberService srv;
    public static void showView(Reloader reload) {
    	try {
    		FXMLLoader load = new FXMLLoader(
    		AddMemberViewController.class.getResource("AddMemberView.fxml"));
			Parent view = load.load();
			AddMemberViewController addMem = load.getController();
			addMem.reload = reload;
			Stage stage = new Stage();
			//stage.setMaximized(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(new Scene(view));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void Add() {
    	try {
    		Member member = new Member();
        	member.setName(name.getText());
        	member.setLoginId(id.getText());
        	member.setPassword(pword.getText());
        	member.setPhone(phone.getText());
        	member.setAddress(address.getText());
        	srv.add(member);
        	reload.reload();
        	Close();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING,"ERROR");
			alert.showAndWait();
		}
    	
    }

    @FXML
    void Close() {
    	name.getScene().getWindow().hide();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reload = new MemberViewController();
		srv = new MemberService();
	}

}
