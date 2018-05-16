
public class main2 {

	public main2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Server bServer = new Server();
		Thread threads = new Thread(bServer);
		threads.run();

	}

}
