
public class Node {

    // Atribut untuk menyimpan informasi buku
    String kodeBuku;
    String judul;
    String penulis;

    // Referensi menuju node berikutnya
    Node next;

    // Constructor untuk membuat node buku baru
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
