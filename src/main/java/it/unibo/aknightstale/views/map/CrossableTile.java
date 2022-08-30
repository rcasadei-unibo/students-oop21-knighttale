package it.unibo.aknightstale.views.map;

import it.unibo.aknightstale.models.entity.EntityType;

public class CrossableTile extends AbstractTile{

    public CrossableTile(final String url, final int index, final EntityType entityType){
        super(url, index, entityType);
        super.setCollidable(false);
    }
}