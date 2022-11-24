package Homework.inmemorymodel;

import Homework.modelelements.Camera;
import Homework.modelelements.Flash;
import Homework.modelelements.PoligonalModel;
import Homework.modelelements.Scene;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModelStore implements ModelChanger {
    public Collection <PoligonalModel> models;
    public Collection <Flash> flashes;
    public Collection<Scene> scenes;
    public Collection <Camera> cameras;


    private Collection<ModelChangedObserver>changedObservers = new ArrayList<>();


    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        changedObservers.add(o);
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

    public Collection<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<Camera> cameras) {
        this.cameras = cameras;
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        changedObservers.remove(o);
    }

    @Override
    public void NotifyChange() {
        for (ModelChangedObserver o : changedObservers){
            o.ApplyUpdateModel();
        }
    }

}


