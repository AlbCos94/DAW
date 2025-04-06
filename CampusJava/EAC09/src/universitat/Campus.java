/**
 * Classe que defineix un campus. Es defineix pel seu nom,
 * la seva ubicació, un array d'aules estàndard,
 * un array d'aules d'informàtica i un array de laboratoris.
 */

package universitat;

import static universitat.UnitatUniversitat.DADES;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Campus implements UnitatUniversitat {

    private String nomCampus;
    private String ubicacio;

    private List<Aula> aules = new ArrayList<Aula>(300); // programming to an interface (Interface-based programming) - List is the interface and ArrayList is the implementation ( it is easy to change the implementation without modifying other parts of the code)
    //private Aula[] aules = new Aula[300];
    //private int pAules = 0; //Primera posició buida de l'array d'aules

    public Campus(String nomCampus, String ubicacio) {
        this.nomCampus = nomCampus;
        this.ubicacio = ubicacio;
    }

    public String getNomCampus() {
        return this.nomCampus;
    }

    public void setNomCampus(String nomCampus) {
        this.nomCampus = nomCampus;
    }

    public String getUbicacio() {
        return this.ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }


    
    public void setAules(List<Aula> aules) {
        this.aules = new ArrayList<>(aules); 
    }

    public List<Aula> getAules() {
        return this.aules; 
    }



    /* 
    public Aula[] getAules() {
        return aules;
    }

    public void setAules(Aula[] aules) {
        this.aules = aules;
    }
    
    public int getpAules() {
        return pAules;
    }

    public void setpAules(int pAules) {
        this.pAules = pAules;
    }
    */
    

    public static Campus addCampus() {
        String nom, ubicacio;

        System.out.println("\nNom del campus: ");
        nom = DADES.nextLine();
        System.out.println("\nUbicació del campus: ");
        ubicacio = DADES.nextLine();

        return new Campus(nom, ubicacio);
    }


    @Override
    public void updateUnitatUniversitat() {
        System.out.println("\nNom del campus: " + this.getNomCampus());
        System.out.println("\nEntra el nou nom del campus:");
        this.nomCampus = DADES.nextLine();
        System.out.println("\nUbicació del campus : " + this.getUbicacio());
        System.out.println("\nEntra la nova ubicació del campus:");
        this.ubicacio = DADES.nextLine();
    }


    public double costManteniment() {
        double costTotal = 0;

        for (int i = 0; i < this.aules.size(); i++) {
            costTotal += aules.get(i).costManteniment();
        }

        /* 
        for (int i = 0; i < pAules; i++) {
            costTotal += aules[i].costManteniment();
        }
        */

        return costTotal;
    }
    
    @Override
    public void showUnitatUniversitat() {
        System.out.println("\nLes dades del campus " + this.nomCampus + " són:");
        System.out.println("\nUbicació: " + this.getUbicacio());
        System.out.println("\nCost de manteniment: " + this.costManteniment() + " EUR");
    }
    
   
    public void addAulaEstandard(AulaEstandard nouAulaEstandard) {
        
        if (nouAulaEstandard == null){
            nouAulaEstandard = AulaEstandard.addAulaEstandard();
        }   
        
        //AulaEstandard nouAulaEstandard = AulaEstandard.addAulaEstandard();

        if (selectAula(1, nouAulaEstandard.getCodi()) == -1) {
            aules.add(nouAulaEstandard);
            /* 
            aules[pAules] = nouAulaEstandard;
            pAules++;
            */
        } else {
            System.out.println("\nAula Estàndard ja existeix");
        }




    }

    public void addAulaInformatica(AulaInformatica novaAulaInformatica) {

        if (novaAulaInformatica == null){
            novaAulaInformatica = AulaInformatica.addAulaInformatica();
        }   

        //AulaInformatica novaAulaInformatica = AulaInformatica.addAulaInformatica();

        if (selectAula(2, novaAulaInformatica.getCodi()) == -1) {
            aules.add(novaAulaInformatica);
            /* 
            aules[pAules] = novaAulaInformatica;
            pAules++;
            */
        } else {
            System.out.println("\nAula d'informàtica ja existeix");
        }
    }

    public void addLaboratori(Laboratori nouLaboratori) {
        
        if (nouLaboratori==null){
            nouLaboratori = Laboratori.addLaboratori();
        }
        
        //Laboratori nouLaboratori = Laboratori.addLaboratori();

        if (selectAula(3, nouLaboratori.getCodi()) == -1) {
            
            aules.add(nouLaboratori);
            /* 
            aules[pAules] = novaLaboratori;
            pAules++;
            */

        } else {
            System.out.println("\nLaboratori ja existeix");
        }
    }

    public int selectAula(int tipusAula, String codi) {
        if (codi == null) {
            //Demanem quin tipus d'aula es vol seleccionar i el seu codi
            switch (tipusAula) {
                case 1:
                    System.out.println("Codi de l'aula estàndard: ");
                    break;
                case 2:
                    System.out.println("Codi de l'aula d'informàtica: ");
                    break;
                case 3:
                    System.out.println("Codi del laboratori: ");
                    break;
            }

            codi = DADES.nextLine();
        }

        int posAula = -1; //Posició que ocupa l'aula seleccionada dins l'array d'aules del campus

        //Seleccionem la posició que ocupa l'aula dins l'array d'aules del campus
        //for (int i = 0; i < pAules; i++) {
        for (int i = 0; i < this.aules.size(); i++) {

            Aula aula_i = this.aules.get(i);

            if (aula_i instanceof AulaEstandard && tipusAula == 1) {
                if (((AulaEstandard) aula_i).getCodi().equals(codi)) {
                    return i;
                }
            } else if (aula_i instanceof AulaInformatica && tipusAula == 2) {
                if (((AulaEstandard) aula_i).getCodi().equals(codi)) {
                    return i;
                }
            } else if (aula_i instanceof Laboratori && tipusAula == 3) {
                if (((Laboratori) aula_i).getCodi().equals(codi)) {
                    return i;
                }
            }
        }

        return posAula;
    }
    
    
   
}