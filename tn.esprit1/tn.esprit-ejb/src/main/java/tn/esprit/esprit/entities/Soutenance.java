package tn.esprit.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Soutenance implements Serializable {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private int idSout;
	  
	  @Column(name = "ecole")
	    private String ecoleSout;
	  
	  @Column(name = "salle")
	    private String salleSout;
	  
	  @Temporal(TemporalType.DATE)
	    private Date dateSout;
	  
	  @Temporal(TemporalType.TIME)
	  @Column(name="horaire")
	  private Date horaireSout;
	  // litfiche etud empl fk
//**************
	  
	  @OneToOne
	  private Etudiant etudiant;
	 
	  public Etudiant getEtudiant() {
			return etudiant;
		}

		public void setEtudiant(Etudiant etudiant) {
			this.etudiant = etudiant;
		}
		
	  //***********************
		 @OneToOne(mappedBy="soutenance")
		  private Employe employePresident;
		 
		  public Employe getEmployePresident() {
				return employePresident;
			}

			public void setEmployePresident(Employe employePresident) {
				this.employePresident = employePresident;
			}

		//*************************
	public Date getHoraireSout() {
		return horaireSout;
	}

	

	
	public void setHoraireSout(Date horaireSout) {
		this.horaireSout = horaireSout;
	}

	public int getIdSout() {
		return idSout;
	}

	public void setIdSout(int idSout) {
		this.idSout = idSout;
	}

	

	public String getEcoleSout() {
		return ecoleSout;
	}

	public void setEcoleSout(String ecoleSout) {
		this.ecoleSout = ecoleSout;
	}

	public String getSalleSout() {
		return salleSout;
	}

	public void setSalleSout(String salleSout) {
		this.salleSout = salleSout;
	}

	public Date getDateSout() {
		return dateSout;
	}

	public void setDateSout(Date dateSout) {
		this.dateSout = dateSout;
	}

	@Override
	public String toString() {
		return "Soutenance [idSout=" + idSout + ", ecoleSout=" + ecoleSout + ", salleSout=" + salleSout + ", dateSout="
				+ dateSout + "]";
	}

	public Soutenance(String ecoleSout, String salleSout, Date dateSout) {
		super();
		this.ecoleSout = ecoleSout;
		this.salleSout = salleSout;
		this.dateSout = dateSout;
	}
	  
	  
	  

}
