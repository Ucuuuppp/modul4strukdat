import java.util.HashMap;
import java.util.Scanner;

public class Kegiatan_1 {

    private HashMap<String, String> tabelData;

    public Kegiatan_1() {
        this.tabelData = new HashMap<String, String>();
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.contains("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        }
        return false;
    }

    public void tampil() {
        if (tabelData.isEmpty()) {
            System.out.println("Belum ada data yang diinputkan.");
        } else {
            System.out.println("Data yang telah diinputkan:");
            for (String nimPraktikan : tabelData.keySet()) {
                System.out.println(nimPraktikan + " - " + tabelData.get(nimPraktikan));
            }
        }
    }

    public void listNimPraktikan() {
        if (tabelData.isEmpty()) {
            System.out.println("Belum ada data yang diinputkan.");
        } else {
            System.out.println("Daftar NIM praktikan yang telah diinputkan:");
            for (String nimPraktikan : tabelData.keySet()) {
                System.out.println(nimPraktikan);
            }
        }
    }

    public void listNamaAsisten() {
        if (tabelData.isEmpty()) {
            System.out.println("Belum ada data yang diinputkan.");
        } else {
            System.out.println("Daftar nama asisten yang telah diinputkan:");
            for (String namaAsisten : tabelData.values()) {
                System.out.println(namaAsisten);
            }
        }
    }

    public int totalData() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            return true;
        }
        return false;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data dengan NIM " + nimPraktikan + " berhasil diedit.");
        } else {
            System.out.println("NIM " + nimPraktikan + " tidak ditemukan dalam daftar data.");
        }
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Kegiatan_1 data = new Kegiatan_1();

            System.out.println("Program Data Praktikan");
            System.out.println("======================");

            int choice = 0;
            while (choice != 6) {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah data");
                System.out.println("2. Tampilkan semua data");
                System.out.println("3. Tampilkan semua NIM praktikan");
                System.out.println("4. Tampilkan semua nama asisten");
                System.out.println("5. Hapus data");
                System.out.println("6. Keluar");

                System.out.print("\nPilihan anda: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("\nMasukkan NIM praktikan (dengan prefix 'IF'): ");
                        String nim = scanner.next();
                        System.out.print("Masukkan nama asisten: ");
                        String namaAsisten = scanner.next();
                        if (data.tambahData(nim, namaAsisten)) {
                            System.out.println("Data berhasil ditambahkan");
                        } else {
                            System.out.println("Data gagal ditambahkan");
                        }
                        break;

                    case 2:
                        data.tampil();
                        break;

                    case 3:
                        data.listNimPraktikan();
                        break;

                    case 4:
                        data.listNamaAsisten();
                        break;

                    case 5:
                        System.out.print("\nMasukkan NIM praktikan yang akan dihapus: ");
                        nim = scanner.next();
                        System.out.print("Masukkan nama asisten yang akan dihapus: ");
                        namaAsisten = scanner.next();
                        if (data.hapusData(nim, namaAsisten)) {
                            System.out.println("Data berhasil dihapus");
                        } else {
                            System.out.println("Data gagal dihapus");
                        }
                        break;

                    case 6:
                        System.out.println("\nTerima kasih telah menggunakan program ini");
                        break;

                    default:
                        System.out.println("\nPilihan tidak valid, silahkan coba lagi");
                        break;
                }
            }
            scanner.close();
        }


}

