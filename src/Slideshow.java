/*
public class Slideshow {

    public static Foto[] crearSlideshow(Foto[] fotos_sin_ordenar) {

        int[] foto_mas_relacionada = new int[fotos_sin_ordenar.length];
        int[] minimos = new int[fotos_sin_ordenar.length];

        for (int i = 0; i < foto_mas_relacionada.length; i++) {
            foto_mas_relacionada[i] = -1;
            minimos[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < fotos_sin_ordenar.length; i++) {
            for (int j = 0; j < fotos_sin_ordenar.length; j++) {

                if (i != j) {
                    int tagsS1 = fotos_sin_ordenar[i].getTags().length;
                    int tagsS2 = fotos_sin_ordenar[j].getTags().length;
                    int comunes = 0;
                    for (int n = 0; n < tagsS1; n++) {
                        for (int m = 0; m < tagsS2; m++) {
                            if (fotos_sin_ordenar[i].getTags()[n].equals(fotos_sin_ordenar[j].getTags()[m])) {
                                comunes++;
                                tagsS1--;
                                tagsS2--;
                            }
                        }
                    }

                    int min1 = Integer.min(tagsS1, tagsS2);
                    int min2 = Integer.min(comunes, min1);


                    // Si i y j son verticales, j no ha sido relacionada y i esta relacionada por una
                    // horizontal o nada, unirlas
                    if (haSidoRelacionadaPor(foto_mas_relacionada, j) == -1 &&
                            fotos_sin_ordenar[i].getPos() == 'V' &&
                            fotos_sin_ordenar[j].getPos() == 'V') {
                        if (haSidoRelacionadaPor(foto_mas_relacionada, i) != 1
                                || fotos_sin_ordenar[haSidoRelacionadaPor(foto_mas_relacionada, i)].getPos() == 'H') {
                            foto_mas_relacionada[i] = j;
                        }
                    }
                    // Si i es vertical y ha sido relacionada por una vertical, unirla a j
                    else if (fotos_sin_ordenar[i].getPos() == 'V' &&
                            haSidoRelacionadaPor(foto_mas_relacionada, i) != -1) {
                        if (fotos_sin_ordenar[haSidoRelacionadaPor(foto_mas_relacionada, i)].getPos() == 'V') {
                            unir(fotos_sin_ordenar, foto_mas_relacionada, minimos, min2, i, j);
                        }
                    }
                    // Si j es vertical e i es horizontal, y j no está relacionada con ninguna vertical, unirlas
                    else if (fotos_sin_ordenar[i].getPos() == 'H' &&
                            fotos_sin_ordenar[j].getPos() == 'V') {
                        if (haSidoRelacionadaPor(foto_mas_relacionada, j) == -1 ||
                                fotos_sin_ordenar[haSidoRelacionadaPor(foto_mas_relacionada, j)].getPos() == 'H') {
                            unir(fotos_sin_ordenar, foto_mas_relacionada, minimos, min2, i, j);
                        }
                    }
                    // Si no, dos horizontales. Comprobar que i no haya sido relacionada ya.
                    else if (fotos_sin_ordenar[i].getPos() == 'H' &&
                            fotos_sin_ordenar[j].getPos() == 'H' &&
                            haSidoRelacionadaPor(foto_mas_relacionada, i) == -1) {
                        unir(fotos_sin_ordenar, foto_mas_relacionada, minimos, min2, i, j);
                    } else {
                        System.out.println("ERROR AQUI");
                    }
                }
            }
        }

        // Tenemos las fotos más relacionadas de cada una. Ordenamos
        Foto[] fotos_ordenadas = new Foto[fotos_sin_ordenar.length];
        fotos_ordenadas[0] = fotos_sin_ordenar[0];
        for (int o = 1; o < fotos_sin_ordenar.length; o++) {
            fotos_ordenadas[o] = fotos_sin_ordenar[foto_mas_relacionada[o - 1]];
        }
        return fotos_ordenadas;
    }


    private static void unir(Foto[] fotos_sin_ordenar, int[] foto_mas_relacionada, int[] minimos, int min, int i, int j) {
        if (foto_mas_relacionada[i] != -1) {
            if (fotos_sin_ordenar[foto_mas_relacionada[i]] != fotos_sin_ordenar[j]
                    && min < minimos[i]) {

                if (haSidoRelacionadaPor(foto_mas_relacionada, j) != -1) {
                    if (fotos_sin_ordenar[haSidoRelacionadaPor(foto_mas_relacionada, j)] != fotos_sin_ordenar[i]) {
                        foto_mas_relacionada[i] = j;
                        minimos[i] = min;
                    }
                }
                else {
                    foto_mas_relacionada[i] = j;
                    minimos[i] = min;
                }
            }
        }
        else if (foto_mas_relacionada[i] == -1) {
            foto_mas_relacionada[i] = j;
            minimos[i] = min;
        }
    }
    private static int haSidoRelacionadaPor(int[] foto_mas_relacionada, int id) {
        int relacionado = -1;
        for (int i = 0; i < foto_mas_relacionada.length && relacionado == -1; i++) {
            if (foto_mas_relacionada[i] == id) relacionado = i;
        }
        return relacionado;
    }
}
 */