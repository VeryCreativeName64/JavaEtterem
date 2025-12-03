package controller;

import model.EtelModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EtelController {

    public List<EtelModel> beolvasEtelek(String fajlNev) {
        List<EtelModel> lista = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fajlNev), "UTF-8")) {

            sc.useDelimiter("[|\\r\\n]+");

            while (sc.hasNext()) {
                String nev = sc.next().trim();
                if (nev.isEmpty()) continue;  // üres sor átugrása

                if (!sc.hasNextInt()) {       // ha nincs szám, átugorjuk a sort
                    sc.next();
                    continue;
                }

                int ar = sc.nextInt();
                lista.add(new EtelModel(nev, ar));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
