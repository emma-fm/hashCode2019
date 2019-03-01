import java.util.ArrayList;

public class Slide {
    String[] tags;
    String id;

    public Slide(Foto f) {
        ArrayList<String> tagsList = new ArrayList<>();
        for (int i = 0; i < f.getTags().length; i++) {
            tagsList.add(f.getTags()[i]);
        }
        tags = new String[tagsList.size()];
        tags = tagsList.toArray(tags);
        id = String.valueOf(f.getID());
    }

    public Slide(Foto f1, Foto f2){
        ArrayList<String> tagsList = new ArrayList<>();
        for (int i = 0; i < f1.getTags().length; i++) {
            tagsList.add(f1.getTags()[i]);
        }
        for (int i = 0; i < f2.getTags().length; i++) {
            tagsList.add(f2.getTags()[i]);
        }

        for (int i = 0; i < tagsList.size(); i++){
            for (int j = i + 1; j < tagsList.size(); j++){
                if (tagsList.get(i).equals(tagsList.get(j))) {
                    tagsList.remove(j);
                }
            }
        }

        tags = new String[tagsList.size()];
        tags = tagsList.toArray(tags);

        id = String.valueOf(f1.getID()) + " " + String.valueOf(f2.getID());
    }

    public String[] getTags() { return this.tags; }
}
