package it.unibo.aknightstale.controllers.entity;

import it.unibo.aknightstale.models.entity.ObstacleEntity;
import it.unibo.aknightstale.views.map.SolidTile;

public class ObstacleController extends EntityControllerImpl <ObstacleEntity, SolidTile> {

    public ObstacleController(ObstacleEntity model, SolidTile view) {
        super(model, view);
    }
}
