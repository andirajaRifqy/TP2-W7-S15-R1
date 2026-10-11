
public class Queue {

    private Node front;
    private Node rear;
    private int jumlah;

    // Constructor untuk membuat antrian kosong
    public Queue() {
        front = null;
        rear = null;
        jumlah = 0;
    }

    // Menambahkan pelanggan ke bagian belakang antrian
    public void enqueue(String nomorAntrian,
                        String namaPelanggan,
                        double totalBelanja) {

        Node pelangganBaru = new Node(
            nomorAntrian, namaPelanggan, totalBelanja
        );

        if (rear == null) {
            front = pelangganBaru;
            rear = pelangganBaru;
        } else {
            rear.next = pelangganBaru;
            rear = pelangganBaru;
        }

        jumlah++;
    }

    // Mengambil dan menghapus pelanggan paling depan
    public Node dequeue() {

        if (front == null) {
            return null;
        }

        Node pelanggan = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        pelanggan.next = null;
        jumlah--;

        return pelanggan;
    }

    // Menampilkan seluruh antrian pelanggan
    public void display() {

        if (front == null) {
            System.out.println("Antrian masih kosong.");
            return;
        }

        Node current = front;

        System.out.println("\n===== ANTRIAN PELANGGAN =====");

        while (current != null) {
            System.out.printf(
                "%s | %s | Rp%,.0f%n",
                current.nomorAntrian,
                current.namaPelanggan,
                current.totalBelanja
            );

            current = current.next;
        }

        System.out.println("Jumlah antrian: " + jumlah);
    }

    // Mengembalikan jumlah pelanggan dalam antrian
    public int size() {
        return jumlah;
    }

    // Memeriksa apakah antrian kosong
    public boolean isEmpty() {
        return front == null;
    }
}
