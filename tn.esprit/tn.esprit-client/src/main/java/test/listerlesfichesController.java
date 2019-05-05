package test;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tn.esprit.esprit.entities.Archive;
import tn.esprit.esprit.entities.Etudiant;
import tn.esprit.esprit.entities.FichePfe;
import tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.RejectedExecutionException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import annimations.FadeInUpTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tn.esprit.esprit.entities.Employe;

public class listerlesfichesController implements Initializable {
	@FXML
	private Text ProjectName;
	@FXML
    private AnchorPane Anchor;

	@FXML
	private ProgressBar bar;
	@FXML
	private AnchorPane DetailsProject;
	@FXML
	private ListView<FichePfe> fiAttDafRap;
	@FXML
	private ListView <FichePfe>enAttentDaffEnc;
	@FXML
	private Button aff1;
	@FXML
	private Label Created;
	@FXML
	private Label Delivered;
	@FXML
	private Label Description;
	@FXML
	private Label Budget;
	@FXML
	private Label product;
	@FXML
	private ListView<FichePfe> FichAccDirec;
	 
	
	@FXML
    private Button aff11;
	@FXML
    private Button aff111;
	 @FXML
	    private Button aaa;

	 @FXML
	    private AnchorPane affectationEncadrant;

	  @FXML
	  private TableView<Employe> tabEncadrant;

	    @FXML
	    private TableColumn<Employe,String> supName;

	    @FXML
	    private TableColumn<Employe,String>  supEmail;

	    @FXML
	    private Button affecEnc;
	
	
	
	private String jndiName="tn.esprit-ear/tn.esprit-ejb/ChefDepartementService!tn.esprit.tn.esprit.services.ChefDepartementInterfaceRemote";
	private ObservableList<FichePfe> items;
	 private InitialContext initialContext ;
		private ChefDepartementInterfaceRemote chefdepProxy ;
		static int idFiche;
		private ObservableList<Employe> Rapo;

	
	// Event Listener on Button[#aff1].onAction
		  @FXML
		    void aa(ActionEvent event) {
			  int s=tabEncadrant.getSelectionModel().getSelectedItem().getIdEmploye();
				long nb;
				nb=chefdepProxy.afficherNbdesEtudiantsAff(s);
				if(nb>5)
				{
					Config2.dialog(Alert.AlertType.INFORMATION, "The rapporteur has more than five students");
				}
				else 
				{
					chefdepProxy.affecterEncadRania(idFiche, s);
					Config2.dialog(Alert.AlertType.INFORMATION, " assignment successfully");
				}
				

		    }
		@FXML
	    void affecEnc(ActionEvent event) {
			
			idFiche=enAttentDaffEnc.getSelectionModel().getSelectedItem().getIdFiche();
			System.out.println(idFiche);
			DetailsProject.setOpacity(0);
			affectationEncadrant.setOpacity(1);
             new FadeInUpTransition(affectationEncadrant).play();
             
            
 			
			

	    }
	@FXML
	public void aff1(ActionEvent event) throws NamingException {
		System.out.println("a0");
		initialContext=new InitialContext();
		chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
		System.out.println("a01");
		List<FichePfe>fiches=new ArrayList<>();
		fiches=chefdepProxy.listerFicheAccParDirec();
		System.out.println("a1");
		for(FichePfe f :fiches)
		{
			System.out.println(f.getEtatFiche());
		}
		System.out.println("a2");
		 items=FXCollections.observableArrayList(fiches);
		FichAccDirec.setCellFactory((ListView<FichePfe> arg2) -> {
            ListCell<FichePfe> cell = new ListCell<FichePfe>() {
                @Override
                protected void updateItem(FichePfe e,boolean btl) {
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
		FichAccDirec.setItems(items);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		DetailsProject.setOpacity(1);
		//Anchor.setOpacity(1);
		 affectationEncadrant.setOpacity(0);
		   new FadeInUpTransition(DetailsProject).play();
		 //*affichge des encadrant
		   try {
			initialContext = new InitialContext();
		
		   List<Employe>emEnc=new ArrayList<>();
		   
		   chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
		   emEnc=chefdepProxy.affichertouslesRap();
		   Config2.setModelColumn(supName, "nomEmploye");
           Config2.setModelColumn(supEmail, "prenomEmploye");
           Rapo=FXCollections.observableArrayList(emEnc);
           tabEncadrant.setItems(Rapo);
		   } catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
/*	private List<FichePfe> listeFichACD() {
        List<FichePfe> fiches = new ArrayList<>();
        try {
            initialContext = new InitialContext();
            chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
            fiches = chefdepProxy.listerFicheAccParDirec();
        } catch (NamingException e) {
            System.out.println("NamingException jndi");
        } catch (RejectedExecutionException e1) {
            System.out.println("catched rejected");
        }
        return fiches;
    }*/
		
	
	@FXML
    void listFicheEnAttEnc(ActionEvent event) throws NamingException {
		
		System.out.println("a0");
		initialContext=new InitialContext();
		chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
		System.out.println("a01");
		List<FichePfe>fiches=new ArrayList<>();
		fiches=chefdepProxy.afficherSansEncad();
		System.out.println("a1");
		for(FichePfe f :fiches)
		{
			System.out.println(f.getEtatFiche());
		}
		System.out.println("a2");
		 items=FXCollections.observableArrayList(fiches);
		 enAttentDaffEnc.setCellFactory((ListView<FichePfe> arg2) -> {
            ListCell<FichePfe> cell = new ListCell<FichePfe>() {
                @Override
                protected void updateItem(FichePfe e,boolean btl) {
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

                        setText(" PFE files waiting for  : "+e.getCategFiche()+"\n"+"Categorie : "+e.getDescriptionFiche()+"\n"+"etat fiche : "+e.getFctFiche()+"\n"+"entrprise :"+e.getMotCleFiche());

                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));
                        
                        // setAlignment(Pos.CENTER);
                        
                      
                    }

                }

            };
            return cell;  });
		enAttentDaffEnc.setItems(items);
		
		
    }
	  @FXML
	    void listFicheEnAttRap(ActionEvent event) throws NamingException {
		  
			System.out.println("a0");
			initialContext=new InitialContext();
			chefdepProxy = (ChefDepartementInterfaceRemote) initialContext.lookup(jndiName);
			System.out.println("a01");
			List<FichePfe>fiches=new ArrayList<>();
			fiches=chefdepProxy.afficherSansRap();
			System.out.println("a1");
			for(FichePfe f :fiches)
			{
				System.out.println(f.getEtatFiche());
			}
			System.out.println("a2");
			 items=FXCollections.observableArrayList(fiches);
			 fiAttDafRap.setCellFactory((ListView<FichePfe> arg2) -> {
	            ListCell<FichePfe> cell = new ListCell<FichePfe>() {
	                @Override
	                protected void updateItem(FichePfe e,boolean btl) {
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

	                        setText(" PFE files waiting for  : "+e.getCategFiche()+"\n"+"Categorie : "+e.getDescriptionFiche()+"\n"+"etat fiche : "+e.getFctFiche()+"\n"+"entrprise :"+e.getMotCleFiche());

	                        setFont(Font.font("Berlin Sans FB Demi Bold", 12));
	                        
	                        // setAlignment(Pos.CENTER);
	                    }

	                }

	            };
	            return cell;  });
			 fiAttDafRap.setItems(items);
	    }
	 
	}

