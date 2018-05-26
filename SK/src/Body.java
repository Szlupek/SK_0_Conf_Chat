import java.util.Scanner;

public class Body {


	Scanner scanner;

	public Body() throws Exception {

		scanner = new Scanner(System.in);
		hello();
		
		TServer tServer = new TServer();
		TClient tClient = new TClient();
		
		
		tServer.start();
		tClient.start();
		
	}

	public void hello() {
		System.out.println("************");
		System.out.println("0 Conf Chat");
		System.out.println("by MS and AB");
		System.out.println("************\n");
		System.out.println("type your login:");
		Config.login = scanner.nextLine();
		System.out.println("your login is: " + Config.login);
	}
}
