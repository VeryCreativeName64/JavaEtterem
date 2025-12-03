package controller;

import model.AsztalModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsztalController {

    public List<AsztalModel> beolvasAsztalok(String fajlNev) {
        List<AsztalModel> lista = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fajlNev), "UTF-8")) {

            String szin = null;

            while (sc.hasNextLine()) {
                String sor = sc.nextLine().trim();

                if (sor.isEmpty()) {  // üres sor = új blokk
                    szin = null;
                    continue;
                }

                if (szin == null) {
                    szin = sor;   // új szín
                } else {
                    // étel ehhez a színhez
                    lista.add(new AsztalModel(szin, sor));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
