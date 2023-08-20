package com.solt.model;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFrameController {

    @FXML
    private Label title;

    @FXML
    private StackPane stackPane;

    @FXML
    void exit(MouseEvent event) {
    	Platform.exit();
    }

    @FXML
    void showCategory(MouseEvent event) {

    }

    @FXML
    void showItem(MouseEvent event) {

    }

    @FXML
    void showMember(MouseEvent event) {
    	LoadView("Member", "MemberView.fxml");
    }

    @FXML
    void showSaleItem(MouseEvent event) {

    }

    @FXML
    void showSaleReport(MouseEvent event) {

    }
    public static void showView() {
    	try {
			Parent view = FXMLLoader.load(MainFrameController.class.getResource("MainFrame.fxml"));
			Stage stage = new Stage(StageStyle.UNDECORATED);
			stage.setScene(new Scene(view));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void LoadView(String title, String view) {
    	this.title.setText("");
    	try {
			Parent root = FXMLLoader.load(getClass().getResource(view));
			stackPane.getChildren().clear();
			stackPane.getChildren().add(root);
			this.title.setText(title);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

}