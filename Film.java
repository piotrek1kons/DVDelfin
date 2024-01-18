public class Film {
    String tytul;
    String obrazekSRC;
    String rezyser;
    String gatunek;
    String czasTrwania;
    String opis;

    public Film(String tytul, String obrazekSRC, String rezyser, String gatunek, String czasTrwania, String opis){
        this.tytul = tytul;
        this.obrazekSRC = obrazekSRC;
        this.rezyser = rezyser;
        this.gatunek = gatunek;
        this.czasTrwania = czasTrwania;
        this.opis = opis;
    }

    public String getTytul() {
        return tytul;
    }
    public String getObrazekSRC() {
        return obrazekSRC;
    }
    public String getRezyser() {
        return rezyser;
    }
    public String getGatunek() {
        return gatunek;
    }
    public String getCzasTrwania() {
        return czasTrwania;
    }
    public String getOpis() {
        return opis;
    }
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
    public void setObrazekSRC(String obrazekSRC) {
        this.obrazekSRC = obrazekSRC;
    }
    public void setRezyser(String rezyser) {
        this.rezyser = rezyser;
    }
    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }
    public void setCzasTrwania(String czasTrwania) {
        this.czasTrwania = czasTrwania;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }
}