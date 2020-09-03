package com.shiro.util;

import com.shiro.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {

   private SecureRandomNumberGenerator randomNumberGenerator= new SecureRandomNumberGenerator();

   private String algorithmName="md5";

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    private  int hashIterations=2;

    public void setRandomNumberGenerator(SecureRandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }


    public void encryptPassword(User user){
       user.setSalt(randomNumberGenerator.nextBytes().toHex());
       String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
       user.setPassword(newPassword);
   }
}
