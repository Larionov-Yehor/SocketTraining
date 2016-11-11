import app.DashBoardImpl;
import web.Server;
import web.router.Router;
import web.router.RouterImpl;

/**
 * Created by employee on 11/11/16.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        RouterImpl router = new RouterImpl();

        router.register("/", DashBoardImpl::new);

        Server server = new Server();
        server.startServer();

    }
}
