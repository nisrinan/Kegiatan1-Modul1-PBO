public class App {
    public static void main(String[] args) {
        Tabung tabung = new Tabung("tabung");
        Kubus kubus = new Kubus("kubus");

        kubus.inputNilai();
        kubus.luasPermukaan();
        kubus.volume();

        tabung.inputNilai();
        tabung.luasPermukaan();
        tabung.volume();
    }
}
