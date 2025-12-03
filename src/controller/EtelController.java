
package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.EtelModel;


public class EtelController {
    public List<EtelModel> beolvasEtelek(String fajlNev) {
        List<EtelModel> lista = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(fajlNev))) {

            sc.useDelimiter("[|\\n]+"); // | és ENTER is elválasztó

            while (sc.hasNext()) {
                String nev = sc.next().trim();
                int ar = sc.nextInt();
                lista.add(new EtelModel(nev, ar));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista; 
    }
}
