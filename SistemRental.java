import java.util.ArrayList;
import java.util.Scanner;

public class SistemRental {
    private static ArrayList<Kendaraan> kendaraanTersedia = new ArrayList<>();
    private static ArrayList<Penyewa> penyewaList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== Sistem Rental ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tambah Penyewa");
            System.out.println("3. Lihat Daftar Kendaraan");
            System.out.println("4. Lihat Daftar Penyewa");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (pilihan) {
                case 1:
                    tambahKendaraan();
                    break;
                case 2:
                    tambahPenyewa();
                    break;
                case 3:
                    tampilkanKendaraanTersedia();
                    break;
                case 4:
                    tampilkanPenyewa();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem rental.");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }

    // Fungsi untuk menambah kendaraan
    private static void tambahKendaraan() {
        System.out.println("Pilih jenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.println("3. Sepeda");
        System.out.print("Pilih opsi: ");
        int jenis = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        System.out.print("Masukkan merk: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan model: ");
        String model = scanner.nextLine();
        System.out.print("Masukkan tahun produksi: ");
        int tahunProduksi = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        if (jenis == 1) {
            System.out.print("Masukkan jumlah roda: ");
            int jumlahRoda = scanner.nextInt();
            kendaraanTersedia.add(new Mobil(merk, model, tahunProduksi, jumlahRoda));
        } else if (jenis == 2) {
            System.out.print("Masukkan jumlah roda: ");
            int jumlahRoda = scanner.nextInt();
            kendaraanTersedia.add(new Motor(merk, model, tahunProduksi, jumlahRoda));
        } else if (jenis == 3) {
            System.out.print("Masukkan jenis sepeda (misalnya BMX, balap): ");
            String jenisSepeda = scanner.nextLine();
            kendaraanTersedia.add(new Sepeda(merk, model, tahunProduksi, jenisSepeda));
        } else {
            System.out.println("Jenis kendaraan tidak valid.");
            return;
        }

        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    // Fungsi untuk menambah penyewa
    private static void tambahPenyewa() {
        if (kendaraanTersedia.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang tersedia untuk disewa.");
            return;
        }

        System.out.print("Masukkan nama penyewa: ");
        String nama = scanner.nextLine();

        System.out.println("Pilih kendaraan yang ingin disewa:");
        for (int i = 0; i < kendaraanTersedia.size(); i++) {
            System.out.println((i + 1) + ". " + kendaraanTersedia.get(i).getInfo());
        }
        System.out.print("Pilih nomor kendaraan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        if (pilihan > 0 && pilihan <= kendaraanTersedia.size()) {
            Kendaraan kendaraanDipilih = kendaraanTersedia.get(pilihan - 1);
            penyewaList.add(new Penyewa(nama, kendaraanDipilih));
            System.out.println("Penyewa berhasil ditambahkan!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Fungsi untuk menampilkan daftar kendaraan yang tersedia
    private static void tampilkanKendaraanTersedia() {
        System.out.println("Daftar Kendaraan Tersedia:");
        if (kendaraanTersedia.isEmpty()) {
            System.out.println("Belum ada kendaraan yang tersedia.");
        } else {
            for (int i = 0; i < kendaraanTersedia.size(); i++) {
                System.out.println((i + 1) + ". " + kendaraanTersedia.get(i).getInfo());
            }
        }
    }

    // Fungsi untuk menampilkan daftar penyewa
    private static void tampilkanPenyewa() {
        System.out.println("Daftar Penyewa:");
        if (penyewaList.isEmpty()) {
            System.out.println("Belum ada penyewa yang terdaftar.");
        } else {
            for (Penyewa penyewa : penyewaList) {
                System.out.println(penyewa.getDetailSewa());
            }
        }
    }
}
