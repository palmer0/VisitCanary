package es.ulpgc.eite.master.visitcanary;

import java.util.ArrayList;
import java.util.List;


public class PlaceStore {


    private List<Place> places = new ArrayList();


    public PlaceStore(List<String> titles, List<String> details, List<String> pictures) {
        for (int position = 0; position < titles.size(); position++) {
            String title = titles.get(position);
            String detail = details.get(position);
            String picture = pictures.get(position);
            addPlace(createPlace(position, title, detail, picture));
        }
    }


    private void addPlace(Place place) {
        places.add(place);
    }

    private Place createPlace(int position, String title, String detail, String picture ) {
        return new Place(String.valueOf(position), title, detail, picture);
    }


    public List<Place> getPlaces(){
        return places;
    }

    public Place getPlaceByPosition(int position) {
        return places.get(position);
    }

    public Place getPlaceById(String id) {
        Integer position = Integer.valueOf(id);
        return getPlaceByPosition(position);
    }

    public class Place {
        public final String id;
        public final String title;
        public final String details;
        public final String picture;


        public Place(String id, String title, String details, String picture) {
            this.id = id;
            this.title = title;
            this.details = details;
            this.picture = picture;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
