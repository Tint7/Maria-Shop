package com.solt.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.solt.entity.Member;
import com.solt.service.MemberService;
import com.solt.utility.Reloader;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberViewController implements Initializable,Reloader{

    @FXML
    private TextField schLoginID;

    @FXML
    private TextField schName;

    @FXML
    private TableView<Member> tableView;

    @FXML
    private TableColumn<Member, String> colLoginID;

    @FXML
    private TableColumn<Member, String> colName;

    @FXML
    private TableColumn<Member, String> colAddress;

    @FXML
    private TableColumn<Member, String> colPhone;

    
    public void schAdd() {
    	AddMemberViewController.showView(this);
    }

    
    public void schClear() {

    }
    
    private MemberService srv;
    private List<Member>list;
    
    public void refresh() {
		tableView.getItems().clear();
		list = srv.findAll();
		tableView.getItems().addAll(list);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colLoginID.setCellValueFactory(new PropertyValueFactory<>("loginId"));
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		srv = new MemberService();
		list = new ArrayList<Member>();
		refresh();
	}

	@Override
	public void reload() {
		refresh();
		
	}
	
}
