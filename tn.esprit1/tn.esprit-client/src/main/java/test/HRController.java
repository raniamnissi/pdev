package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.control.ListView;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.prism.impl.Disposer.Record;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.web.HTMLEditor;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableView;

public class HRController implements Initializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FXML
	private Button ManageResources;
	@FXML
	private ImageView imgLoad;
	@FXML
	private ProgressBar bar;
	@FXML
	private AnchorPane htmlPane;
	@FXML
	private HTMLEditor htmlFiles;
	@FXML
	private Button CloseBtn;
	@FXML
	private AnchorPane paneCrud;
	@FXML
	private TextField txtId;
	@FXML
	private TextField NameText;
	@FXML
	private Button AddInterview;
	@FXML
	private Button btnBack;
	@FXML
	private DatePicker InterviewDate;
	@FXML
	private TextField MailText;
	@FXML
	private Button UploadButton;
	@FXML
	private TextField textCIN;
	@FXML
	private Button Uploadphoto;
	@FXML
	private ListView ListHireCondidate;
	@FXML
	private TextField CondidateName;
	@FXML
	private TextField CondidateMail;
	@FXML
	private TextField CondidateSalary;
	@FXML
	private ComboBox ComboFunction;
	@FXML
	private Button AddEmployee;
	@FXML
	private Button DeleteCondidate;
	@FXML
	private TextField OldSalaryInput;
	@FXML
	private TextField NewSalaryInput;
	@FXML
	private ListView ListEmployees;
	@FXML
	private ComboBox ComboAllFunctions;
	@FXML
	private ListView LeavesList;
	@FXML
	private RadioButton AcceptLeave;
	@FXML
	private RadioButton DeclineLeave;
	@FXML
	private AnchorPane AffichageEmployees;
	@FXML
	private TableView<Etudiant> CondidateTable;
	@FXML
	private TableColumn Actions;
	 @FXML
	    private TableColumn<Etudiant, String> ColName;

	    @FXML
	    private TableColumn<Etudiant, String> ColMail;
	@FXML
	private Button CVshower;
	
	
	@FXML
	private ListView<Etudiant> ListMarketingManger;
	
	@FXML
	private ListView <Archive>ListProjectCordinators;
	@FXML
	private Label helmi;
	@FXML
	private AnchorPane ChatPane;
	
	 Config2 con = new Config2();
	 private InitialContext initialContext = null;
	  private ChefDepartementInterfaceRemote chefdepProxy = null;
	 private String jndiName="tn.esprit-ear/tn.esprit-ejb/ChefDepartementService!tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote";
	  private ObservableList<Etudiant> condidats;
	  private ObservableList<Archive> archives;
	// Event Listener on Button[#ManageResources].onAction
	@FXML
	public void AddNew(ActionEvent event)  {
		Etudiant e=new Etudiant();
		e=CondidateTable.getSelectionModel().getSelectedItem();
		/*Etudiant E=new Etudiant();
		chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
		E=chefdepProxy.getById(i);*/
		System.out.println(e);
		ObservableList<Archive> items=FXCollections.observableArrayList(chefdepProxy.afficher(e));
		ListProjectCordinators.setCellFactory((ListView<Archive> arg2) -> {
            ListCell<Archive> cell = new ListCell<Archive>() {
                @Override
                protected void updateItem(Archive e,boolean btl) {
                    super.updateItem(e, btl);

                    if (e != null) {
                        //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                   	 File file = new File("C:\\Users\\RANI\\Pictures\\centos.png");
                   	 file.getParentFile().mkdirs();
                        Image IMAGE_RUBY = new Image(file.toURI().toString());
                        //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                        ImageView imgview = new ImageView(IMAGE_RUBY);

                        setGraphic(imgview);

                        imgview.setFitHeight(90);
                        imgview.setFitWidth(90);
                        Rectangle clip = new Rectangle(
                                imgview.getFitWidth(), imgview.getFitHeight()
                        );

                        clip.setArcWidth(20);
                        clip.setArcHeight(20);
                        imgview.setClip(clip);

                        // snapshot the rounded image.
                        SnapshotParameters parameters = new SnapshotParameters();
                        parameters.setFill(Color.TRANSPARENT);
                        WritableImage image = imgview.snapshot(parameters, null);

                        // remove the rounding clip so that our effect can show through.
                        imgview.setClip(null);

                        // apply a shadow effect.
                        imgview.setEffect(new DropShadow(20, Color.BLACK));

                        // store the rounded image in the imageView.
                        imgview.setImage(image);

                        setText("history of PFE files : "+e.getCategFiche()+"\n"+"Categorie : "+e.getDescriptionFiche()+"\n"+"etat fiche : "+e.getFctFiche()+"\n"+"entrprise :"+e.getMotCleFiche());

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                        
                        // setAlignment(Pos.CENTER);
                    }

                }

            };
            return cell;  });
		ListProjectCordinators.setItems(items);
            
		}
	// Event Listener on Button[#CloseBtn].onAction
	@FXML
	public void CloseHtml(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#AddInterview].onAction
	@FXML
	public void CondidatSave(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnBack].onAction
	@FXML
	public void aksiBack(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#UploadButton].onAction
	@FXML
	public void UploadCV(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#Uploadphoto].onAction
	@FXML
	public void AddPictureCondidate(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#AddEmployee].onAction
	@FXML
	public void EmployeSave(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#DeleteCondidate].onAction
	@FXML
	public void FireCondidate(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void PromoteEmployee(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void TreatLeave(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#CVshower].onAction
	@FXML
	public void ShowCV(ActionEvent event) throws NamingException {
		//initialContext = new InitialContext();
		
		int i=CondidateTable.getSelectionModel().getSelectedItem().getIdEtudiant();
		/*Etudiant E=new Etudiant();
		chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
		E=chefdepProxy.getById(i);*/
		System.out.println(i);
		
	}
	// Event Listener on Button.onAction

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 try {
		        CVshower.setVisible(false);
		        ManageResources.setVisible(false);

			initialContext = new InitialContext();
			 List<Etudiant> Users = new ArrayList<>();
			 List<Archive>archives=new ArrayList<>();
		        
				chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
				//ColName.setCellValueFactory(cellData -> cellData.getValue().getNomEtudiant());
				//ColMail.setCellValueFactory(cellData -> cellData.getValue().getEcoleEtudiant());
			
	         Users = chefdepProxy.afficherEtudiant();
			 Config2.setModelColumn(ColName, "nomEtudiant");
		        Config2.setModelColumn(ColMail, "emailEtudiant");
		       
		            condidats = FXCollections.observableArrayList(Users);
		            CondidateTable.setItems(condidats);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		   
		 CondidateTable.setOnMousePressed(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
                	 ManageResources.setVisible(true);
                   
                 }

             }
         });
		 ListMarketingManger.setCellFactory((ListView<Etudiant> arg2) -> {
             ListCell<Etudiant> cell = new ListCell<Etudiant>() {
                 @Override
                 protected void updateItem(Etudiant e,boolean btl) {
                     super.updateItem(e, btl);

                     if (e != null) {
                         //    File file = new File(ps.findById(e.getPassager().getId()).getAvatar());
                    	 File file = new File("C:\\Users\\RANI\\Pictures\\centos.png");
                    	 file.getParentFile().mkdirs();
                         Image IMAGE_RUBY = new Image(file.toURI().toString());
                         //   Image IMAGE_RUBY = new Image(ps.findById(e.getPassager().getId()).getAvatar());

                         ImageView imgview = new ImageView(IMAGE_RUBY);

                         setGraphic(imgview);

                         imgview.setFitHeight(90);
                         imgview.setFitWidth(90);
                         Rectangle clip = new Rectangle(
                                 imgview.getFitWidth(), imgview.getFitHeight()
                         );

                         clip.setArcWidth(20);
                         clip.setArcHeight(20);
                         imgview.setClip(clip);

                         // snapshot the rounded image.
                         SnapshotParameters parameters = new SnapshotParameters();
                         parameters.setFill(Color.TRANSPARENT);
                         WritableImage image = imgview.snapshot(parameters, null);

                         // remove the rounding clip so that our effect can show through.
                         imgview.setClip(null);

                         // apply a shadow effect.
                         imgview.setEffect(new DropShadow(20, Color.BLACK));

                         // store the rounded image in the imageView.
                         imgview.setImage(image);

                         setText("history of PFE files : "+e.getNomEtudiant()+"\n"+"Categorie : "+e.getEmailEtudiant()+"\n"+"etat fiche : "+e.getClasseEtudiant()+"\n"+"entrprise :"+e.getOptionEtudiant());

                         setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                         
                         // setAlignment(Pos.CENTER);
                     }

                 }

             };
             return cell;
             
             
             
         });
		 
		 ListMarketingManger.setItems(condidats);
	}

	private List<Etudiant> findCondidates() {
        List<Etudiant> Users = new ArrayList<>();
        try {
            initialContext = new InitialContext();
            chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
            Users = chefdepProxy.afficherEtudiant();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return Users;
    }
	private ObservableList<Etudiant> findCondidates(Integer functional) throws NamingException
    {
        initialContext = new InitialContext();
        chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
        condidats = FXCollections.observableArrayList(chefdepProxy.afficherEtudiant());
        
        return condidats;
    }
	
	
}
