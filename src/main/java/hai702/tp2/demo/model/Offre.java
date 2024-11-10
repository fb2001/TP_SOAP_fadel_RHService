package hai702.tp2.demo.model;

import hai702.tp2.demo.exceptions.ExceptionDateInvalide;
import hai702.tp2.demo.utils.DateUtils;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offre")
@XmlRootElement
public class Offre implements Serializable {
    private int id;
    private String detail;
   // private Hotel hotel;
    private ArrayList<Chambre> chambres;
    private String datedebutoffre;
    private String datedefinoffre;
    private double prixparjour;
    private String idAgence;
    private double pourcentageReduction;






    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public Offre() {
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public Offre(int id, String detail, ArrayList<Chambre> chambres,
                 String datedebutoffre, String datedefinoffre,
                 double prixparjour ,String idAgence , double pourcentageReduction) throws ExceptionDateInvalide {
        if (!DateUtils.isValidDateString(datedebutoffre) || !DateUtils.isValidDateString(datedefinoffre)) {
            throw new ExceptionDateInvalide("Les dates fournies ne sont pas valides");
        }
        this.id = id;
        this.detail = detail;
       // this.hotel = hotel;
        this.chambres = chambres;
        this.datedebutoffre = datedebutoffre;
        this.datedefinoffre = datedefinoffre;
        this.prixparjour = prixparjour;
        this.idAgence = idAgence;
        this.pourcentageReduction = pourcentageReduction;

      //  this.imageUrl = imageUrl;
    }


    public String getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(String idAgence) {
        this.idAgence = idAgence;
    }

    public double getPourcentageReduction() {
        return pourcentageReduction;
    }

    public void setPourcentageReduction(double pourcentageReduction) {
        this.pourcentageReduction = pourcentageReduction;
    }

    public void setImageBasedOnCapacity() {
     if (this.chambres != null && !this.chambres.isEmpty()) {
         for (Chambre chambre : this.chambres) {
             String basePath = "hai702/tp2/demo/image/";
             switch (chambre.getNombrelit()) {
                 case 1:
                     chambre.setImageUrl(basePath + "single.jpg");
                     break;
                 case 2:
                     chambre.setImageUrl(basePath + "2lits.jpg");
                     break;
                 case 3:
                     chambre.setImageUrl(basePath + "3lit.jpg");
                     break;
                 case 4:
                     chambre.setImageUrl(basePath + "jacuzi.jpg");
                     break;
                 default:
                     chambre.setImageUrl(basePath + "default.jpg");
                     break;
             }
         }
     }
 }


    private byte[] loadImageAsBytes(String imagePath) {
        try {
            File file = new File(imagePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            fis.close();
            return bos.toByteArray();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'image : " + imagePath);
            System.err.println("Exception: " + e);
            return null;
        }
    }


    public String getDatedebutoffre() {
        return datedebutoffre;
    }

    public void setDatedebutoffre(String datedebutoffre) throws ExceptionDateInvalide {
        if (!DateUtils.isValidDateString(datedebutoffre)) {
            throw new ExceptionDateInvalide("La date de début n'est pas valide");
        }
        this.datedebutoffre = datedebutoffre;
    }

    public String getDatedefinoffre() {
        return datedefinoffre;
    }

    public void setDatedefinoffre(String datedefinoffre) throws ExceptionDateInvalide {
        if (!DateUtils.isValidDateString(datedefinoffre)) {
            throw new ExceptionDateInvalide("La date de fin n'est pas valide");
        }
        this.datedefinoffre = datedefinoffre;
    }

    public void setPrixparjour(double prixparjour) {
        this.prixparjour = prixparjour;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrixparjour() {
        return prixparjour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", prixparjour=" + prixparjour +
                ", datedebutoffre=" + datedebutoffre +
                ", datedefinoffre=" + datedefinoffre +
                ", chambres=" + chambres ;
    }

    // Ces méthodes statiques peuvent être déplacées vers DateUtils
    public static String dateToString(Date date) throws ExceptionDateInvalide {
        return DateUtils.dateToString(date);
    }

    public static Date stringToDate(String dateString) throws ExceptionDateInvalide {
        return DateUtils.stringToDate(dateString);
    }
}