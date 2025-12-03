
package model;
import java.io.File;                  
import java.io.FileNotFoundException; 
import java.util.Scanner; 

public class EtelModel {
    private String nev;
    private int ar;

    public EtelModel(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }
    
    
    
}
