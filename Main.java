import controller.MainController;
import db.Dbinit;

public class Main {
    public static void main(String[] args) {
        Dbinit.init();
        MainController mainController = new MainController();
        mainController.start();
    }
}
