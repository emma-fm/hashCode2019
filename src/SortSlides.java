import java.util.ArrayList;

public class SortSlides {

    private static int[] minimos;
    private static Slide[] slides_sin_ordenar;
    private static int[] relacionado;

    public static Slide[] sort(Slide[] s) {
        minimos = new int[s.length];
        slides_sin_ordenar = s;

        for (int i = 0; i < minimos.length; i++) {
            minimos[i] = Integer.MAX_VALUE;
        }

        relacionado = new int[slides_sin_ordenar.length];

        for (int i = 0; i < slides_sin_ordenar.length; i++) {
            for (int j = 0; j < slides_sin_ordenar.length; j++) {
                if (i != j) {
                    int tagsS1 = slides_sin_ordenar[i].getTags().length;
                    int tagsS2 = slides_sin_ordenar[j].getTags().length;
                    int comunes = 0;
                    for (int n = 0; n < tagsS1; n++) {
                        for (int m = 0; m < tagsS2; m++) {
                            try {
                                if (slides_sin_ordenar[i].getTags()[n].equals(slides_sin_ordenar[j].getTags()[m])) {
                                    comunes++;
                                    tagsS1--;
                                    tagsS2--;
                                }
                            }
                            catch (NullPointerException e) {
                                System.out.println("i: " + i);
                                System.out.println("j: " + j);
                                System.out.println("n: " + n);
                                System.out.println("m: " + m);
                                throw new NullPointerException();
                            }
                        }
                    }

                    int primerMin = Integer.min(tagsS1, tagsS2);
                    int min = Integer.min(comunes, primerMin);

                    if (min < minimos[i] && !haSidoRelacionadoYa(j)) {
                        relacionado[i] = j;
                    }
                }
            }
        }

        // Si hay elementos que no se han relacionado, los relaciona entre ellos
        ArrayList<Integer> noRelacionados = new ArrayList<Integer>();
        for (int i = 0; i < relacionado.length; i++) {
            if (relacionado[i] == Integer.MAX_VALUE) {
                noRelacionados.add(relacionado[i]);
            }
        }

        Object[] nR = noRelacionados.toArray();

        /*
        for (int i = 0; i < noRelacionados.size() - 1; i++) {
            relacionado[(int)nR[i]] = (int)nR[i + 1];
        }
        */

        Slide[] slides_ordenados = new Slide[slides_sin_ordenar.length];

        for (int i = 0; i < slides_sin_ordenar.length; i++) {
            slides_ordenados[i] = slides_sin_ordenar[relacionado[i]];
        }

        return slides_ordenados;
    }

    private static boolean haSidoRelacionadoYa(int n) {
        boolean res = false;
        for (int i = 0; i < relacionado.length && !res; i++) {
            res = relacionado[i] == n;
        }
        return res;
    }

    private static int obtenerRelacionado(int n) {
        int res = -1;
        for (int i = 0; i < relacionado.length && res == -1; i++) {
            if (relacionado[i] == n) res = i;
        }
        return res;
    }
}
