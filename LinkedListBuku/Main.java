
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();

        int pilihan = 0;

        // Menampilkan menu sampai pengguna memilih keluar
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi input menu
            if (!input.hasNextInt()) {
                System.out.println("Masukkan angka 1 sampai 5.");
                input.nextLine();
                continue;
            }

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    // Meminta data buku baru
                    String kode;

                    do {
                        System.out.print("Masukkan Kode Buku: ");
                        kode = input.nextLine().trim();

                        if (kode.isEmpty() || kode.length() > 5) {
                            System.out.println(
                                "Kode buku harus 1 sampai 5 karakter."
                            );
                        }

                    } while (kode.isEmpty() || kode.length() > 5);

                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine();

                    System.out.print("Masukkan Penulis: ");
                    String penulis = input.nextLine();

                    daftarBuku.tambahBuku(
                        kode, judul, penulis
                    );
                    break;

                case 2:
                    // Menghapus buku terakhir
                    daftarBuku.hapusBukuTerakhir();
                    break;

                case 3:
                    // Mencari buku berdasarkan kode
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String kodeCari = input.nextLine();

                    daftarBuku.cariBuku(kodeCari);
                    break;

                case 4:
                    // Menampilkan seluruh buku
                    daftarBuku.tampilkanSemua();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 5);

        input.close();
    }
}
