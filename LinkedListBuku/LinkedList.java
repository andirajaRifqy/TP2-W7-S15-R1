
public class LinkedList {

    private Node head;
    private int jumlahBuku;

    // Constructor untuk membuat Linked List kosong
    public LinkedList() {
        head = null;
        jumlahBuku = 0;
    }

    // Menambahkan buku baru di akhir Linked List
    public void tambahBuku(String kodeBuku, String judul, String penulis) {

        Node bukuBaru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            head = bukuBaru;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = bukuBaru;
        }

        jumlahBuku++;
        System.out.println("Data berhasil ditambahkan!");
    }

    // Menghapus buku terakhir dari Linked List
    public void hapusBukuTerakhir() {

        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            System.out.println("Buku yang dihapus: " + head.judul);
            head = null;
            jumlahBuku--;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        System.out.println("Buku yang dihapus: " + current.next.judul);

        current.next = null;
        jumlahBuku--;
    }

    // Mencari buku berdasarkan kode buku
    public void cariBuku(String kodeBuku) {

        Node current = head;

        while (current != null) {

            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("\nBuku ditemukan:");
                System.out.println("Kode Buku : " + current.kodeBuku);
                System.out.println("Judul     : " + current.judul);
                System.out.println("Penulis   : " + current.penulis);
                return;
            }

            current = current.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // Menampilkan seluruh data buku berdasarkan urutan input
    public void tampilkanSemua() {

        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
            return;
        }

        Node current = head;
        int nomor = 1;

        System.out.println("\n===== DAFTAR BUKU =====");

        while (current != null) {
            System.out.println(
                nomor + ". Kode: " + current.kodeBuku
                + " | Judul: " + current.judul
                + " | Penulis: " + current.penulis
            );

            current = current.next;
            nomor++;
        }

        System.out.println("Total Buku: " + jumlahBuku);
    }

    // Mengambil jumlah buku yang tersimpan
    public int getJumlahBuku() {
        return jumlahBuku;
    }
}
