package ba.unsa.etf.rma.VJ_18194;

public class Muzicar {

    String imeIPrezime="";
    String zanr="";
    String webStranica="";
    String biografija="";
    String ikona="";

    public String getTopLista() {
        return topLista;
    }

    public void setTopLista(String topLista) {
        this.topLista = topLista;
    }

    String topLista="";

    public Muzicar(String imeIPrezime, String zanr, String webStranica, String biografija, String slika, String lista) {
        this.imeIPrezime = imeIPrezime;
        this.zanr = zanr;
        this.webStranica = webStranica;
        this.biografija = biografija;
        this.ikona=slika;
        this.topLista=lista;
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
