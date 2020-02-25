/**
 * 描述:
 * 上传密钥构建
 *
 * @author dong
 * @date 2020-01-25 18:05
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.qiniu.util.StringUtils;
import com.qiniu.util.UrlSafeBase64;

public class TokenUpload {

    public static void tokenupload() throws NoSuchAlgorithmException, InvalidKeyException{
        String ACCESS_KEY = "****************************************";
        String SECRET_KEY = "****************************************";
//      过期时间：2022/5/3 0:0:0
        String putpolicy = "{\"scope\":\"hexo-backup\",\"deadline\":1651507200}";
        String t3 = UrlSafeBase64.encodeToString(putpolicy);
        Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(StringUtils.utf8Bytes(SECRET_KEY),"HmacSHA1"));
        String t2 = UrlSafeBase64.encodeToString(mac.doFinal(StringUtils.utf8Bytes(t3)));
        System.out.println(ACCESS_KEY+":"+t2+":"+t3);
    }

    public static void main(String args[]) throws InvalidKeyException, NoSuchAlgorithmException{
        tokenupload();
    }

}