import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Client implements Runnable {
	public Boolean go = true;
	public Client() {
	
	}

	@Override
	public void run() {
		System.out.println("1");
		
		try {
			String message = "tekst";
			InetAddress serverAddress = InetAddress.getByName("localhost");
			System.out.println(serverAddress);

			DatagramSocket socket = new DatagramSocket(); // Otwarcie gniazda
			byte[] stringContents = message.getBytes("utf8"); // Pobranie strumienia bajtów z wiadomosci

			DatagramPacket sentPacket = new DatagramPacket(stringContents, stringContents.length);
			sentPacket.setAddress(serverAddress);
			sentPacket.setPort(8000);
			socket.send(sentPacket);

			DatagramPacket recievePacket = new DatagramPacket(new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);
			socket.setSoTimeout(1010);

			try {
				socket.receive(recievePacket);
				System.out.println("Serwer otrzymał wiadomość");
			} catch (SocketTimeoutException ste) {
				System.out.println("Serwer nie odpowiedział, więc albo dostał wiadomość albo nie...");
			}
			socket.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
