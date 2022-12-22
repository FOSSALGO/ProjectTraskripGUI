package programerdaritimurkebarat;

public class Matakuliah {
    private String kode,nama,nilai;
    private int sks;

    public Matakuliah(String kode, String nama, String nilai, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.nilai = nilai;
        this.sks = sks;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    @Override
    public String toString() {
        return "Matakuliah{" + "kode=" + kode + ", nama=" + nama + ", nilai=" + nilai + ", sks=" + sks + '}';
    }
    
    
}
