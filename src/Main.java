package src;

import src.controller.MainController;
import src.db.Dbinit;

public class Main {
    public static void main(String[] args) {
        Dbinit.init();
        MainController mainController = new MainController();
        mainController.start();
    }
}
