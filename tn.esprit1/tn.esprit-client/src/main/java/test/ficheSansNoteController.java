package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.prism.impl.Disposer.Record;

import annimations.FadeInUpTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Employe;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;
import tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class ficheSansNoteController implements Initializable{
	@FXML
	private Button ManageResources;
	@FXML
	private ImageView imgLoad;
	@FXML
	private ProgressBar bar;
	@FXML
	private AnchorPane AffichageEmployees;
	@FXML
	private TableView <FichePfe>CondidateTable;
	@FXML
	private TableColumn Actions;
	@FXML
	private TableColumn <FichePfe, Float>ColName;
	@FXML
	private TableColumn<FichePfe, Float> ColMail;
	@FXML
	private Label helmi;
    @FXML
    private AnchorPane paneCrud;
    
    @FXML
    private TableView<Employe> tabRapo;

    @FXML
    private TableColumn<Employe, String> nomRap;

    @FXML
    private TableColumn<Employe, String> emailRap;

    @FXML
	 Config2 con = new Config2();
	 private InitialContext initialContext = null;
	  private ChefDepartementInterfaceRemote chefdepProxy = null;
	  private ChefDepartementInterfaceRemote  RapProxy=null;
	 private String jndiName="tn.esprit-ear/tn.esprit-ejb/ChefDepartementService!tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote";
	  private ObservableList<FichePfe> condidats;
	  private ObservableList<Archive> archives;
	  private ObservableList<Employe> Rapo;
static int i;

	// Event Listener on Button[#ManageResources].onAction
	@FXML
	public void AddNew(ActionEvent event) {
		int s=tabRapo.getSelectionModel().getSelectedItem().getIdEmploye();
		long nb;
		nb=RapProxy.afficherNbdesEtudiantsAff(s);
		if(nb>5)
		{
			Config2.dialog(Alert.AlertType.INFORMATION, "The rapporteur has more than five students");
		}
		else 
		{
			RapProxy.affecterRapporteurRania(i, s);
			Config2.dialog(Alert.AlertType.INFORMATION, " assignment successfully");
		}
		
		
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabRapo.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
               	 ManageResources.setVisible(true);
                  
                }

            }
        });
		ManageResources.setVisible(false);
		 AffichageEmployees.setOpacity(1);
         paneCrud.setOpacity(0);
         new FadeInUpTransition(AffichageEmployees).play();
		try {
			initialContext = new InitialContext();
		
		 List<FichePfe> Users = new ArrayList<>();
		 List<Archive>archives=new ArrayList<>();
		 List<Employe>emRaporteur=new ArrayList<>();
	        
			chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
			
			
		
        Users = chefdepProxy.afficherFicheSanNote();
      // emRaporteur=RapProxy.affichertouslesRap();
       
        
        
		 Config2.setModelColumn(ColName, "noteRap");
	       Config2.setModelColumn(ColMail, "noteEnc");
	      
	        
	       
	            condidats = FXCollections.observableArrayList(Users);
	            
	            CondidateTable.setItems(condidats);
	           tabRapo.setEditable(true);
	            RapProxy=(ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
	           emRaporteur=RapProxy.affichertouslesRap();
	            Config2.setModelColumn(nomRap, "nomEmploye");
	            Config2.setModelColumn(emailRap, "prenomEmploye");
	            Rapo=FXCollections.observableArrayList(emRaporteur);
	           tabRapo.setItems(Rapo);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		  Actions.setCellFactory(new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {

              @Override
              public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> param) {
                  // TODO Auto-generated method stub
                  return new ButtonCell();
              }

          });
		
	}
	  private class ButtonCell extends TableCell<Record, Boolean> {

	        //final Hyperlink cellButtonDelete = new Hyperlink("Delete");
	        final Hyperlink cellButtonEdit = new Hyperlink("Edit");
	        final HBox hb = new HBox( cellButtonEdit);
	        
	        
	        
	        public ButtonCell() {
	            hb.setSpacing(4);
	        
	        
	        cellButtonEdit.setOnAction(t -> {
                
                int row = getTableRow().getIndex();
                CondidateTable.getSelectionModel().select(row);
              
                 i = CondidateTable.getSelectionModel().getSelectedItem().getIdFiche();
                System.out.println(i);
              
                                          // txtId.setText(String.valueOf(i.getCode()));
                AffichageEmployees.setOpacity(0);
                paneCrud.setOpacity(1);
                new FadeInUpTransition(paneCrud).play();
               
            });

            // Action when the button is pressed
        }
	        
	        @Override
	        protected void updateItem(Boolean t, boolean empty) {
	            super.updateItem(t, empty);
	            if (!empty) {
	                setGraphic(hb);
	            } else {
	                setGraphic(null);
	            }
	        }
	  }
}
