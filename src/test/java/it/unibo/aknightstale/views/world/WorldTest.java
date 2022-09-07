package it.unibo.aknightstale.views.world;

import it.unibo.aknightstale.controllers.interfaces.MapController;
import it.unibo.aknightstale.views.BaseViewTest;
import it.unibo.aknightstale.views.interfaces.MapView;
import it.unibo.aknightstale.views.map.CrossableTile;
import it.unibo.aknightstale.views.map.SolidTile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WorldTest extends BaseViewTest<MapController, MapView> {

    protected WorldTest() {
        super(MapView.class, MapController.class);
    }

    @Test
    @DisplayName("Check Tiles Type")
    void checkTilesType() {
        final var mapView = getView();
        Assertions.assertThat(mapView.getFloor().getClass()).isEqualTo(CrossableTile.class);
        Assertions.assertThat(mapView.getTree().getClass()).isEqualTo(SolidTile.class);
    }

    @Test
    @DisplayName("Check Tiles")
    void checkTiles() {
        final var mapView = getView();
        Assertions.assertThat(mapView.getTiles().size() > 0);
    }



    /*Non Posso fare questo test perchè il canvas gli viene passato dal file FXML*/
    /*@Test
    @DisplayName("Check Tiles Type")
    void chackMapResize() {
        final var mapView = new MapViewImpl();
        mapView.getScreenHeight();
        mapView.getScreenHeight();
        mapView.resize(20, 20);
        Assertions.assertThat(mapView.getFloor().getClass()).isEqualTo(CrossableTile.class);
        Assertions.assertThat(mapView.getTree().getClass()).isEqualTo(SolidTile.class);
    }*/


}
