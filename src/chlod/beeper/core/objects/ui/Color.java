package chlod.beeper.core.objects.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Color {

	public int R = 0;
	public int G = 0;
	public int B = 0;
	public int A = 0;
	
	public Color(String hexR, String hexG, String hexB, String hexA) {
		try {
			R = Integer.parseInt(hexR, 16);
			G = Integer.parseInt(hexG, 16);
			B = Integer.parseInt(hexB, 16);
			A = Integer.parseInt(hexA, 16);
		} catch (Exception e) {
			Logger.getLogger("BeeperCore").log(Level.WARNING, "Color not valid! Falling back to black (#000000)");
			e.printStackTrace();
		}
	}
	
	public Color(String hexR, String hexG, String hexB) {
		try {
			R = Integer.parseInt(hexR, 16);
			G = Integer.parseInt(hexG, 16);
			B = Integer.parseInt(hexB, 16);
			A = 255;
		} catch (Exception e) {
			Logger.getLogger("BeeperCore").log(Level.WARNING, "Color not valid! Falling back to black (#000000)");
			e.printStackTrace();
		}
	}
	
	public Color(String hexColor) {
		try {
			if (hexColor.length() == 6) {
				R = Integer.parseInt(hexColor.substring(0, 1), 16);
				G = Integer.parseInt(hexColor.substring(2, 3), 16);
				B = Integer.parseInt(hexColor.substring(4, 5), 16);
				A = Integer.parseInt(hexColor.substring(6, 7), 16);
			} else if (hexColor.length() == 8) {
				R = Integer.parseInt(hexColor.substring(0, 1), 16);
				G = Integer.parseInt(hexColor.substring(2, 3), 16);
				B = Integer.parseInt(hexColor.substring(4, 5), 16);
				A = 255;
			} else {
				throw new NumberFormatException();
			}
		} catch (Exception e) {
			Logger.getLogger("BeeperCore").log(Level.WARNING, "Color not valid! Falling back to black (#000000)");
			e.printStackTrace();
		}
	}
	
	public String getColorHex() {
		return (A == 255) ? Integer.toHexString(R) + Integer.toHexString(G) + Integer.toHexString(B) : Integer.toHexString(R) + Integer.toHexString(G) + Integer.toHexString(B) + Integer.toHexString(A);
	}
	
}
