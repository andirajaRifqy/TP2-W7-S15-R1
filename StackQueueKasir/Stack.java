
public class Stack {

    private Node top;

    // Constructor untuk membuat Stack kosong
    public Stack() {
        top = null;
    }

    // Menyimpan transaksi yang sudah selesai dilayani
    public void push(Node pelanggan) {

        Node transaksi = new Node(
            pelanggan.nomorAntrian,
            pelanggan.namaPelanggan,
            pelanggan.totalBelanja
        );

        // Node baru ditempatkan di bagian atas Stack
        transaksi.next = top;
        top = transaksi;
    }

    // Menampilkan riwayat transaksi dari terbaru ke terlama
    public void display() {

        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        Node current = top;

        System.out.println("\n===== RIWAYAT TRANSAKSI =====");

        while (current != null) {
            System.out.printf(
                "%s | %s | Rp%,.0f%n",
                current.nomorAntrian,
                current.namaPelanggan,
                current.totalBelanja
            );

            current = current.next;
        }
    }
}
