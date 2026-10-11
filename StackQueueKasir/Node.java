
public class Node {

    // Atribut untuk menyimpan data pelanggan
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;

    // Referensi menuju node berikutnya
    Node next;

    // Constructor untuk membuat node pelanggan baru
    public Node(String nomorAntrian, String namaPelanggan,
                double totalBelanja) {

        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
