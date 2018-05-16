import java.util.Scanner;

public class Body {

	public static String login;
	Scanner scanner;

	public Body() throws Exception {

		scanner = new Scanner(System.in);
		hello();

		Server bServer = new Server();
		Client bClient = new Client();

		Thread[] threads = new Thread[2];
		//threads[0] = new Thread(bServer);
		threads[1] = new Thread(bClient);

		//threads[0].run();
		threads[1].run();
	}

	public void hello() {
		System.out.println("************");
		System.out.println("0 Conf Chat");
		System.out.println("by MS and AB");
		System.out.println("************\n");
		System.out.println("type your login:");
		login = scanner.nextLine();
		System.out.println("your login is: " + login);
	}
}
