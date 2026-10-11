
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Membuat objek Queue dan Stack
        Queue antrian = new Queue();
        Stack riwayat = new Stack();

        int pilihan = 0;

        // Menampilkan menu selama pengguna belum memilih keluar
        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
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
                    // Validasi maksimal 5 pelanggan dalam antrian
                    if (antrian.size() >= 5) {
                        System.out.println(
                            "Antrian sudah mencapai maksimal 5 pelanggan."
                        );
                        break;
                    }

                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = input.nextLine();

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Total Belanja: ");

                    // Validasi total belanja harus berupa angka
                    if (!input.hasNextDouble()) {
                        System.out.println("Total belanja harus berupa angka.");
                        input.nextLine();
                        break;
                    }

                    double total = input.nextDouble();
                    input.nextLine();

                    if (total < 0) {
                        System.out.println(
                            "Total belanja tidak boleh negatif."
                        );
                        break;
                    }

                    // Menambahkan pelanggan ke Queue
                    antrian.enqueue(nomor, nama, total);

                    System.out.println(
                        "Data pelanggan ditambahkan ke antrian!"
                    );
                    break;

                case 2:
                    // Mengambil pelanggan paling depan (FIFO)
                    Node pelanggan = antrian.dequeue();

                    if (pelanggan == null) {
                        System.out.println(
                            "Tidak ada pelanggan dalam antrian."
                        );
                    } else {
                        System.out.println(
                            "Melayani pelanggan "
                            + pelanggan.nomorAntrian
                            + " (" + pelanggan.namaPelanggan + ")"
                        );

                        // Memasukkan transaksi ke Stack
                        riwayat.push(pelanggan);

                        System.out.println(
                            "Transaksi disimpan ke riwayat."
                        );
                    }
                    break;

                case 3:
                    // Menampilkan semua pelanggan yang menunggu
                    antrian.display();
                    break;

                case 4:
                    // Menampilkan transaksi terbaru terlebih dahulu
                    riwayat.display();
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
