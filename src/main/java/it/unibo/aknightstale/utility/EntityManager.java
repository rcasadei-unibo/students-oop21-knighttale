package it.unibo.aknightstale.utility;


import it.unibo.aknightstale.entity.EntityController;

public interface EntityManager {
    void update();

    void addEntity(EntityController ec);
    void removeEntity(EntityController ec);

    //non è deciso se array o mappa o lista o set ecc...
    EntityController[] getEntities();
}
