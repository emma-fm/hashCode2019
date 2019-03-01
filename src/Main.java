import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] tags = Parser.parseFile("input.txt");
        Foto[] fotos = new Foto[tags.length];
        for (int i = 0; i < fotos.length; i++) {
            fotos[i] = new Foto(tags[i], i);
        }
        ArrayList<Foto> verticales = new ArrayList<>();
        for (int i = 0; i < fotos.length; i++) {
            if (fotos[i].getPos() == 'V') {
                verticales.add(fotos[i]);
            }
        }
        ArrayList<Slide> slideList = new ArrayList<>();
        for (int i = 0; i < verticales.size(); i = i + 2) {
            slideList.add(new Slide(verticales.get(i), verticales.get(i + 1)));
        }

        for (int i = 0; i < fotos.length; i++) {
            if (fotos[i].getPos() == 'H') {
                slideList.add(new Slide(fotos[i]));
            }
        }
        Slide[] slides = new Slide[slideList.size()];
        for (int j = 0; j < slideList.size(); j++) {
            slides[j] = slideList.get(j);
        }
        slides = SortSlides.sort(slides);
        Display.saveFile(slides);
    }
}
