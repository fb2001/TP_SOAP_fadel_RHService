package hai702.tp2.demo.model;

import java.io.Serializable;

public class Agence implements Serializable {
    private String id;
    private String motdepasse;

    public Agence(String id, String motdepasse) {
        this.id = id;
        this.motdepasse = motdepasse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
}
