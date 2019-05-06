package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;
import javafx.event.ActionEvent;

import javafx.scene.control.DatePicker;

public class fController implements Initializable{
	@FXML
	private TextField txtecole;
	@FXML
	private TextField txt;
	@FXML
	private DatePicker date;
	@FXML
	private Button add;
	@FXML
	private JFXButton bebe;
	// Event Listener on Button[#add].onAction
	public static final String ACCOUNT_SID = "AC8e036098d97a5901324606f509b29256";
    public static final String AUTH_TOKEN = "aab3d1636670275481cfc54601ebc47e";
	@FXML
	public void add(ActionEvent event) {
		
		   Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

           Message message = Message
                   .creator(new PhoneNumber("+21627130976"), new PhoneNumber("+13143107633"),
                           "Votre mot de passe = " )
                   .create();
	}
	@FXML
	public void bebe(ActionEvent event) {
		
		   
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
