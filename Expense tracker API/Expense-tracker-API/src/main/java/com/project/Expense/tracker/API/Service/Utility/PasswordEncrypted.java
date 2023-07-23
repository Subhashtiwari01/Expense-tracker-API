package com.project.Expense.tracker.API.Service.Utility;

import jakarta.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncrypted {
    public static String encryptionPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();
        return DatatypeConverter.printHexBinary(digested);
    }

}
