package chlod.beeper.core.conn;

import java.net.InetAddress;

public class Connection {

	public InetAddress IP;
	public short Port;
	
	public Connection(InetAddress ip, short port) {
		IP = ip;
		Port = port;
	}
	
}

