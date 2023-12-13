import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class faktur extends dataPembelian { // inheritance kelas data pembelian

    Scanner scanInt = new Scanner(System.in);
    Scanner scanStr = new Scanner(System.in);

    @Override
    public void login() {
        System.out.println("\tSELAMAT DATANG DI " + judul1.toUpperCase());
        System.out.println("\t-------------------------");
        while (inputPassword != password || username != inputUserName) { // perulangan jka username atau password tidak valid

            System.out.print("username\t: ");
            inputUserName = scanStr.nextLine();

            System.out.print("password\t: ");
            inputPassword = scanStr.nextLine();

            if (inputPassword.equals(password) && inputUserName.equals(username)) { // memberhentikan perulangan jika input username dan password valid
                System.out.println("");
                break;
            }

            System.out.println("username atau password salah\n"); // message jika input tidak valid

        }

        while (inputCap != cap) { // perulangan bila input captcha tidak valid
            System.out.println("kode captcha\t: " + cap);
            System.out.print("entry cap\t: ");
            inputCap = scanStr.nextLine();

            if (inputCap.equalsIgnoreCase(cap)) { // memberhentikan perulangan jika input valid
                break;
            }

            System.out.println("\nsilahkan masukkan lagi"); // message jika input tidak valid
        }
        System.out.println("==============================================\n");
    }

    @Override
    public void isidata() {

        System.out.print("masukkan nomor faktur\t\t: ");
        nofaktur = scanStr.nextLine();

        System.out.print("masukkan kode barang\t\t: ");
        kodeBarang = scanStr.nextLine();

        System.out.print("masukkan nama pelanggan\t\t: ");
        namaPelanggan = scanStr.nextLine();

        System.out.print("masukkan alamat pelanggan\t: ");
        alamat = scanStr.nextLine();

        System.out.print("masukkan nomor HP\t\t: ");
        noHP = scanStr.nextLine();

        System.out.print("masukkan nama barang\t\t: ");
        namaBarang = scanStr.nextLine();

        System.out.print("masukkan harga barang\t\t: ");


        try {
            hargaBarang = scanInt.nextInt(); // handlingException
            if (hargaBarang > 100000) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("nilai tidak valid, nilai lebih dari 100000");
        }

        System.out.print("masukkan jumlah beli\t\t: ");
        try {
            jumlahBeli = scanInt.nextInt(); // handlingException
            if (jumlahBeli > 100) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("nilai tidak valid, nilai lebih dari 100");
        }

        totalBayar = hargaBarang * jumlahBeli;
        scanInt.close();
        scanStr.close();

    }

    @Override
    public void cetakFaktur() {
        Date hariPesan = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("E dd/MM/yyyy"); // membuat objek untuk menampilkan tanggal
        SimpleDateFormat waktu = new SimpleDateFormat("hh:mm:ss zzzz"); // membuat objek untuk menampilkan waktu

        System.out.println("\n\t\t" + judul1.toUpperCase()); // uppercasse untuk nama toko
        System.out.println("tanggal\t\t: " + tanggal.format(hariPesan)); // method date untuk menampilkan tanggal
        System.out.println("jam\t\t: " + waktu.format(hariPesan)); // method date untuk menampilkan waktu
        System.out.println("==============================================");
        System.out.println("\n\t     " + judul2.toUpperCase()); // uppercase untuk data pelanggan
        System.out.println("\t    ----------------");
        System.out.println("nama pelanggan\t: " + namaPelanggan.toUpperCase()); // uppercase untuk nama pelanggan
        System.out.println("nomor HP\t: " + noHP);
        System.out.println("alamat\t\t: " + alamat);
        System.out.println("==============================================");
        System.out.println("\n\t   " + judul3.toUpperCase()); // uppercasse untuk data pembelian barang
        System.out.println("\t  ------------------------");
        System.out.println("nomor faktur\t: " + nofaktur);
        System.out.println("kode barang\t: " + kodeBarang);
        System.out.println("nama barang\t: " + namaBarang.toLowerCase()); // lowercase untuk nama barang
        System.out.println("harga barang\t: " + hargaBarang);
        System.out.println("jumlah beli\t: " + jumlahBeli);
        System.out.println("total bayar\t: " + totalBayar);
        System.out.println("===============================================");
        System.out.println("kasir : Muhammad Raihan Alghifari dan hilmi temanku");
    }

}
