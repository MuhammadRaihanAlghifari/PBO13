
public class App {
    public static void main(String[] args) throws Exception {

        dataPembelian gas = new faktur(); // polymorphisme

        gas.login();
        gas.isidata();
        gas.cetakFaktur();

    }
}
