package programerdaritimurkebarat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {

    private String nama = null, nim = null, prodi = null;
    private int semester = 0;
    private ArrayList<Matakuliah> transkrip = null;

    public Data(String nama, String nim, String prodi, int semester, ArrayList<Matakuliah> transkrip) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.semester = semester;
        this.transkrip = transkrip;
    }

    public Data() {

    }

    public boolean insert(Matakuliah matakuliah) {
        boolean status = false;
        if (nama != null && nim != null && prodi != null && semester > 0
                && semester <= 14 && transkrip != null) {
            transkrip.add(matakuliah);
        }
        return status;
    }

    public boolean insert(String kodeMK, String namaMK, String nilaiMK, int sks) {
        boolean status = false;
        if (nama != null && nim != null && prodi != null && semester > 0
                && semester <= 14 && transkrip != null) {
            Matakuliah matakuliah = new Matakuliah(kodeMK, namaMK, nilaiMK, sks);
            transkrip.add(matakuliah);

        }
        return status;
    }

    public boolean delete(int index) {
        boolean status = false;
        if (transkrip != null && index >= 0 && index < transkrip.size()) {
            transkrip.remove(index);
        }
        return status;
    }

    public boolean update(int index, Matakuliah matakuliah) {
        boolean status = false;
        if (transkrip != null && index >= 0 && index < transkrip.size()) {
            transkrip.set(index, matakuliah);
        }
        return status;
    }

    public boolean update(int index, String kodeMK, String namaMK, String nilaiMK, int sks) {
        boolean status = false;
        if (transkrip != null && index >= 0 && index < transkrip.size()) {
            Matakuliah matakuliah = new Matakuliah(kodeMK, namaMK, nilaiMK, sks);
            transkrip.set(index, matakuliah);
        }
        return status;
    }

    public Data read(File file) {
        try {
            Scanner sc = new Scanner(file);

            //baris-1
            String baris = sc.nextLine();
            String[] elements = baris.split(",");
            nama = elements[1];

            //baris-2
            baris = sc.nextLine();
            elements = baris.split(",");
            nim = elements[1];

            //baris-3
            baris = sc.nextLine();
            elements = baris.split(",");
            prodi = elements[1];

            //baris-4
            baris = sc.nextLine();
            elements = baris.split(",");
            semester = Integer.parseInt(elements[1].trim());

            //baris-5
            sc.nextLine();

            //baris-4
            transkrip = new ArrayList<>();
            while (sc.hasNext()) {
                baris = sc.nextLine();
                elements = baris.split(",");
                String kodeMK = elements[0];
                String namaMK = elements[1];
                String nilaiMK = elements[2];
                int sks = Integer.parseInt(elements[3]);
                Matakuliah matakuliah = new Matakuliah(kodeMK, namaMK, nilaiMK, sks);
                transkrip.add(matakuliah);
            }

            sc.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return this;
    }

    public void save(File file) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            if (nama != null && nim != null && prodi != null && semester > 0
                    && semester <= 14) {
                bw.write("NAMA," + nama + "\n");
                bw.write("NIM," + nim + "\n");
                bw.write("PROGRAM STUDI," + prodi + "\n");
                bw.write("SEMESTER," + semester + "\n");
                bw.write("KODE,MATAKULIAH,NILAI,SKS\n");

                if (transkrip != null) {
                    //tulis isi transkrip
                    for (Matakuliah mk : transkrip) {
                        bw.write(mk.getKode() + "," + mk.getNama() + "," + mk.getNilai() + "," + mk.getSks() + "\n");
                    }
                }
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<Matakuliah> getTranskrip() {
        return transkrip;
    }

    public void setTranskrip(ArrayList<Matakuliah> transkrip) {
        this.transkrip = transkrip;
    }

    @Override
    public String toString() {
        return "Data{" + "nama=" + nama + ", nim=" + nim + ", prodi=" + prodi + ", semester=" + semester + ", transkrip=" + transkrip + '}';
    }

}
