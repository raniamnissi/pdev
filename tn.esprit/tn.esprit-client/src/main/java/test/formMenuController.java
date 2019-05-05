package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.input.MouseEvent;

public class formMenuController implements Initializable{
	@FXML
	private Label title;
	@FXML
	private Button fullscreen;
	@FXML
	private Button minimize;
	@FXML
	private Button maximize;
	@FXML
	private Button close;
	@FXML
	private Button resize;
	@FXML
	private ListView<String> listMenu;
	@FXML
	private Button btnLogout;
	@FXML
	private AnchorPane paneData;
	
	 Config2 con = new Config2();

	    Stage stage;
	    Rectangle2D rec2;

	    public static final Double W = 0.1;

	    public static final Double H = 0.1;

	    private static final String ACTION = "decoration-button-restore";

	// Event Listener on Button[#fullscreen].onAction
	    public Label getTitle() {
	        return title;
	    }

	    public void setTitle(Label title) {
	        this.title = title;
	    }

	    public Button getFullscreen() {
	        return fullscreen;
	    }

	    public void setFullscreen(Button fullscreen) {
	        this.fullscreen = fullscreen;
	    }

	    public Button getMinimize() {
	        return minimize;
	    }

	    public void setMinimize(Button minimize) {
	        this.minimize = minimize;
	    }

	    public Button getMaximize() {
	        return maximize;
	    }

	    public void setMaximize(Button maximize) {
	        this.maximize = maximize;
	    }

	    public Button getClose() {
	        return close;
	    }

	    public void setClose(Button close) {
	        this.close = close;
	    }

	    public Button getResize() {
	        return resize;
	    }

	    public void setResize(Button resize) {
	        this.resize = resize;
	    }

	    public ListView<String> getListMenu() {
	        return listMenu;
	    }

	    public void setListMenu(ListView<String> listMenu) {
	        this.listMenu = listMenu;
	    }

	    public Button getBtnLogout() {
	        return btnLogout;
	    }

	    public void setBtnLogout(Button btnLogout) {
	        this.btnLogout = btnLogout;
	    }

	    public AnchorPane getPaneData() {
	        return paneData;
	    }

	    public void setPaneData(AnchorPane paneData) {
	        this.paneData = paneData;
	    }

	    public Config2 getCon() {
	        return con;
	    }

	    public void setCon(Config2 con) {
	        this.con = con;
	    }

	    public Stage getStage() {
	        return stage;
	    }

	    public void setStage(Stage stage) {
	        this.stage = stage;
	    }

	    public Rectangle2D getRec2() {
	        return rec2;
	    }

	    public void setRec2(Rectangle2D rec2) {
	        this.rec2 = rec2;
	    }

	    public Double getW() {
	        return W;
	    }

	    public Double getH() {
	        return H;
	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {

	        rec2 = Screen.getPrimary().getVisualBounds();
	        listMenu.getItems().addAll("  History of PFE File", "  State of PFE file", "Files without marks", " Send mail to admin ",
	                "  ", "  ", "  ", "");
	        Platform.runLater(() -> {
	            stage = (Stage) maximize.getScene().getWindow();
	            stage.setMaximized(true);
	            stage.setHeight(rec2.getHeight());
	            maximize.getStyleClass().add(ACTION);
	            resize.setVisible(false);
	            listMenu.getSelectionModel().select(0);
	            listMenu.requestFocus();
	        });

	    }

	    @FXML
	    void aksiClose() {
	        Platform.exit();
	    }

	    @FXML
	    void aksiKlikListMenu() {
	        switch (listMenu.getSelectionModel().getSelectedIndex()) {
	        case 0: {
	            con.loadAnchorPane(paneData, "ArchiveFiches.fxml");
	        }
	            break;
	        case 1: {
	            con.loadAnchorPane(paneData, "listerlesfiches.fxml");
	        }
	            break;
	       case 2: {
	            con.loadAnchorPane(paneData, "ficheSansNote.fxml");
	        }
	            break;

	              case 3: {
	            con.loadAnchorPane(paneData, "EnvoyerEmail.fxml");
	        }
	            break;}
	        /*case 6: {
	            con.loadAnchorPane(paneData, "intervention.fxml");
	        }
	            break;
	        case 7: {
	            con.loadAnchorPane(paneData, "Agenda.fxml");
	        }
	            break;
	        case 4: {
	            if (LoginController.getLoggedUser().getUserFct().equals(UserFunction.PROJECT_MANAGER)
	                    || LoginController.getLoggedUser().getUserFct().equals(UserFunction.DIRECTOR)) {
	                con.loadAnchorPane(paneData, "ProjectManagment.fxml");
	            } else {
	                con.loadAnchorPane(paneData, "ProjectManagmentEngineer.fxml");
	            }

	        }
	            break;
	        case 5: {
	            if (LoginController.getLoggedUser().getUserFct().equals(UserFunction.CHIEF_RH)
	                    || LoginController.getLoggedUser().getUserFct().equals(UserFunction.DIRECTOR)) {

	                con.loadAnchorPane(paneData, "HR.fxml");
	            } else {
	                con.loadAnchorPane(paneData, "HREmployees.fxml");
	            }

	        }
	            break;
	        }*/
	    }

	    @FXML
	    void aksiLogout() {
	        Config2 config = new Config2();
	        config.newStage((Stage) btnLogout.getScene().getWindow(), "/fxml/login.fxml", "Sample Apps", true,
	                StageStyle.UNDECORATED, false);

	    }

	    @FXML
	    void aksiMaximized() {
	        int height = 600;
	        int width = 800;

	        stage = (Stage) maximize.getScene().getWindow();
	        if (stage.isMaximized()) {
	            if (W == rec2.getWidth() && H == rec2.getHeight()) {
	                stage.setMaximized(false);
	                stage.setHeight(height);
	                stage.setWidth(width);
	                stage.centerOnScreen();
	                maximize.getStyleClass().remove(ACTION);
	                resize.setVisible(true);
	            } else {
	                stage.setMaximized(false);
	                maximize.getStyleClass().remove(ACTION);
	                resize.setVisible(true);
	            }

	        } else {
	            stage.setMaximized(true);
	            stage.setHeight(rec2.getHeight());
	            maximize.getStyleClass().add(ACTION);
	            resize.setVisible(false);
	        }
	    }

	    @FXML
	    void aksiResize() {
	        // //abc
	    }

	    @FXML
	    void aksifullscreen() {
	        stage = (Stage) fullscreen.getScene().getWindow();
	        if (stage.isFullScreen()) {
	            stage.setFullScreen(false);
	        } else {
	            stage.setFullScreen(true);
	        }
	    }

	    @FXML
	    void aksiminimize() {
	        stage = (Stage) minimize.getScene().getWindow();
	        if (stage.isMaximized()) {
	            stage.setMaximized(false);
	            stage.setHeight(H);
	            stage.setWidth(W);
	            stage.centerOnScreen();
	            Platform.runLater(() -> stage.setIconified(true));
	        } else {
	            stage.setIconified(true);
	        }
	    }

	}
