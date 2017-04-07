import Controller.Controlador;
import Model.UsersManager;
import Network.Servidor;
import View.MainView;

import java.io.IOException;


/**
 * Created by edgarprieto on 3/4/17.
 */
public class Main {

    public static void main (String[] args) {
        MainView View = new MainView();
        Controlador Controller = new Controlador(View);
        UsersManager Model = new UsersManager(Controller);
        Servidor server = new Servidor(Model);

        try {
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        View.showWindow;
    }
}
