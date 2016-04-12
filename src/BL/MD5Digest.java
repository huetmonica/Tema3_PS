package BL;

import java.security.MessageDigest;

public class MD5Digest {

	public String Criptare(String parolav) throws Exception {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(parolav.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	/*
	 * public static void main(String[] args) { String aux2=null; //
	 * ConexiuneDAO c = new ConexiuneDAO(); // Spectacol spec = new
	 * Spectacol("Aviatie", "Marin", "Ioana", // "12/04/2016", 15); //
	 * c.Conectare(); String aux="125648"; MD5Digest m= new MD5Digest(); try {
	 * aux2=m.Criptare(aux);} catch (Exception e) {
	 * 
	 * e.printStackTrace(); System.out.println( aux2); } System.out.println(
	 * aux2); }
	 */
}