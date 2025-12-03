package view;

import controller.AsztalController;
import controller.EtelController;
import model.AsztalModel;
import model.EtelModel;

import java.util.*;

public class EtteremCUI {

    private EtelController etelController = new EtelController();
    private AsztalController asztalController = new AsztalController();

    public void start() {

        List<EtelModel> etelek = etelController.beolvasEtelek("etelek.txt");
        List<AsztalModel> asztalok = asztalController.beolvasAsztalok("asztalok.txt");

        Map<String, List<String>> csoport = new LinkedHashMap<>();

        for (AsztalModel a : asztalok) {
            csoport.putIfAbsent(a.getSzin(), new ArrayList<>());
            csoport.get(a.getSzin()).add(a.getEtel());
        }

        for (String szin : csoport.keySet()) {

            System.out.println(szin + " asztal:");
            System.out.println("================================");

            int osszeg = 0;

            for (String etelNev : csoport.get(szin)) {

                EtelModel etel = keresEtelt(etelek, etelNev);

                if (etel == null) {
                    System.out.println("HIBA: Nem található étel: " + etelNev);
                    continue;
                }

                System.out.printf("%-20s %4d Ft\n", etel.getNev(), etel.getAr());
                osszeg += etel.getAr();
            }

            System.out.println("--------------------------------");
            System.out.printf("Összesen:%14d Ft\n\n", osszeg);
        }
    }

    private EtelModel keresEtelt(List<EtelModel> etelek, String nev) {
        for (EtelModel e : etelek) {
            if (e.getNev().trim().equalsIgnoreCase(nev.trim())) {
                return e;
            }
        }
        return null; // NPE helyett a View kezeli
    }
}
