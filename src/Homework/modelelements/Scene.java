package Homework.modelelements;

import java.util.Collection;

public class Scene {
    private int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;

    public int getId() {
        return id;
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = models;
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = flashes;
    }

}
