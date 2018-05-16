import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server implements Runnable {
	public Boolean go = true;

	public Server() throws Exception {
	}

	@Override
	public void run() {
		System.out.println("0 ");
		

		try {

			DatagramSocket datagramSocket = new DatagramSocket(8000);
			byte[] byteResponse = Body.login.getBytes("utf8");

			while (go) {

				DatagramPacket reclievedPacket = new DatagramPacket(new byte[Config.BUFFER_SIZE], Config.BUFFER_SIZE);

				datagramSocket.receive(reclievedPacket);

				int length = reclievedPacket.getLength();
				String message = new String(reclievedPacket.getData(), 0, length, "utf8");

				// Port i host który wysłał nam zapytanie
				InetAddress address = reclievedPacket.getAddress();
				int port = reclievedPacket.getPort();

				System.out.println(message);

				DatagramPacket response = new DatagramPacket(byteResponse, byteResponse.length, address, port);

				datagramSocket.send(response);
				
				System.out.println("0 Conf Chat");

			}
			datagramSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
