package hai702.tp2.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre")
public class Chambre implements Serializable {
    @XmlElement(required = true)
    private long idchambre;

    @XmlElement(required = true)
    private String description;
    private int nombrelit;
    private String imageUrl;

    public Chambre(long idchambre, String description,int nombrelit) {
        this.idchambre = idchambre;
        this.description = description;
        this.nombrelit = nombrelit;

    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNombrelit() {
        return nombrelit;
    }

    public void setNombrelit(int nombrelit) {
        this.nombrelit = nombrelit;
    }

    public long getIdchambre() {
        return idchambre;
    }

    public void setIdchambre(long idchambre) {
        this.idchambre = idchambre;
    }



    public byte[] getImageAsBytes() throws IOException {
        File imageFile = new File(imageUrl); // Crée un objet File avec le chemin de l'image
        return Files.readAllBytes(imageFile.toPath()); // Lit l'image et retourne un tableau d'octets
    }
}
