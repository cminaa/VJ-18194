package ba.unsa.etf.rma.VJ_18194;

import java.util.ArrayList;

public class Muzicar {

    String imeIPrezime="";
    String zanr="";
    String webStranica="";
    String biografija="";
    String ikona="";

    public ArrayList<String> getTopLista() {
        return topLista;
    }

    public void setTopLista(ArrayList<String> topLista) {
        this.topLista = topLista;
    }

    ArrayList<String> topLista=new ArrayList<>();

    public Muzicar(String imeIPrezime, String zanr, String webStranica, String biografija, String slika) {
        this.imeIPrezime = imeIPrezime;
        this.zanr = zanr;
        this.webStranica = webStranica;
        this.biografija = biografija;
        this.ikona=slika;
    }

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String imeIPrezime) {
        this.imeIPrezime = imeIPrezime;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getIkona() {
        return ikona;
    }

    public void setIkona(String ikona) {
        this.ikona = ikona;
    }
}
