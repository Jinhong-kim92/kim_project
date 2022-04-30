import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * [중요] 패스워드를 암호화 시키기
 *
 */
public class PasswordEncrptUtil {
	public static void main(String[] args) {
		//패스워드 값
		String plainText = "test1234";	//평문(plainText)
		String sha256 = "";		//빈 문자열
		
		try {
			//자바에서 SHA-256 알고리즘을 사용하려면 MessageDigest 클래스를 이용한다.
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			
			//update() 메소드를 호출할 때마다 객체 내에 저장된 digest값이 계속해서 갱신된다.
			mdSHA256.update(plainText.getBytes("UTF-8"));
			
			//최종적으로 digest() 메소드를 호출하면 암호화된 값을 가져오게 된다.
			byte[] sha256Hash = mdSHA256.digest();
			
			StringBuffer hexSHA256hash = new StringBuffer();
			
			for(byte b : sha256Hash) {
				String hexString = String.format("%02x", b);
				hexSHA256hash.append(hexString);
			}
			sha256 = hexSHA256hash.toString();
			
		}catch(NoSuchAlgorithmException e) {e.printStackTrace();
		}catch(UnsupportedEncodingException e) {e.printStackTrace();}
		System.out.println(sha256);
		//937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244
	}
}







