package ao;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Bootstraps the application.
 * @author jsotuyod
 */
public class Bootstrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AOXPServer server = null;
		
		try {
			server = Bootstrap.bootstrap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		server.run();
	}

	/**
	 * Bootstraps the application.
	 * @return The application.
	 * @throws IOException 
	 */
	private static AOXPServer bootstrap() throws IOException {
		
		AOXPServer server = new AOXPServer();
		
		loadApplicationContext(server);
		startWorkers(server);
		startTimers(server);
		startNetworking(server);
		
		return server;
	}

	/**
	 * Initializes the workers on the given server.
	 * @param server The server on which to start the workers.
	 */
	private static void startWorkers(AOXPServer server) {
		// Create one thread per core.
		int threadCount = Runtime.getRuntime().availableProcessors();
		
		server.setThreadPool(Executors.newFixedThreadPool(threadCount));
	}

	/**
	 * Starts networking on the given server.
	 * @param server The server on which to start networking.
	 * @throws IOException
	 */
	private static void startNetworking(AOXPServer server) throws IOException {
		// TODO Auto-generated method stub
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		// TODO : Read all these values from configuration values, possibly even inject them...
		int port = 7666;
		InetSocketAddress endpoint = new InetSocketAddress(InetAddress.getLocalHost(), port);
		int backlog = 5;
		
		serverSocketChannel.socket().bind(endpoint, backlog);
		
		server.setServerSocketChannel(serverSocketChannel);
	}

	/**
	 * Starts the game timers on the given server.
	 * @param server The server on which to start the timers.
	 */
	private static void startTimers(AOXPServer server) {
		// TODO : repeat for each timer
		ExecutorService timer = Executors.newScheduledThreadPool(1);
		
		// TODO : get runnable for each timer class (use the app context) and the interval for execution
	}

	/**
	 * Loads the application context on the given server.
	 * @param server The server on which to load the application context.
	 */
	private static void loadApplicationContext(AOXPServer server) {
		// TODO Auto-generated method stub
	}

}
