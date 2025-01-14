import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Makangratis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> antrian = new LinkedList<>();
        Queue<String> nama = new LinkedList<>();
        Queue<Integer> umur = new LinkedList<>();
        Queue<String> alamat = new LinkedList<>();
        Queue<String> jenisKelamin = new LinkedList<>();
        int nomorAntrian = 1;

        System.out.println("=== Program Makan Gratis ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ambil Nomor Antrian");
            System.out.println("2. Lihat Nomor Antrian");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: // Ambil nomor antrian
                    antrian.add(nomorAntrian);
                    
                    System.out.print("Masukkan nama Anda: ");
                    String dataNama = scanner.nextLine();
                    nama.add(dataNama);
                    
                    System.out.print("Masukkan usia: ");
                    int dataUmur = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi newline
                    umur.add(dataUmur);
                    
                    System.out.print("Masukkan alamat Anda: ");
                    String dataAlamat = scanner.nextLine();
                    alamat.add(dataAlamat);
                    
                    System.out.print("Masukkan jenis kelamin (L/P): ");
                    String dataJenisKelamin = scanner.nextLine().toUpperCase();
                    jenisKelamin.add(dataJenisKelamin);

                    System.out.println("Nomor antrian Anda: " + nomorAntrian);
                    nomorAntrian++;
                    break;

                case 2: // Lihat nomor antrian
                    if (antrian.isEmpty()) {
                        System.out.println("Tidak ada antrian.");
                    } else {
                        System.out.println("Nomor antrian saat ini: " + antrian);
                        System.out.println("Detail pengantri yang telah mendapatkan kupon makan gratis:");
                        
                        // Menggunakan iterator untuk mencetak semua informasi
                        Queue<String> tempNama = new LinkedList<>(nama);
                        Queue<Integer> tempUmur = new LinkedList<>(umur);
                        Queue<String> tempAlamat = new LinkedList<>(alamat);
                        Queue<String> tempJenisKelamin = new LinkedList<>(jenisKelamin);

                        while (!tempNama.isEmpty() && !tempUmur.isEmpty() && !tempAlamat.isEmpty() && !tempJenisKelamin.isEmpty()) {
                            String namaPengantri = tempNama.poll();
                            int umurPengantri = tempUmur.poll();
                            String alamatPengantri = tempAlamat.poll();
                            String jenisKelaminPengantri = tempJenisKelamin.poll();

                            System.out.println(namaPengantri + " dengan umur " + umurPengantri +
                                    ", alamat " + alamatPengantri +
                                    ", jenis kelamin " + (jenisKelaminPengantri.equals("L") ? "Laki-laki" : "Perempuan") +
                                    " telah mendapatkan kupon makan gratis.");
                        }
                    }
                    break;

                case 3: // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan Program Makan Gratis!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang tersedia.");
            }
        }
    }
}
