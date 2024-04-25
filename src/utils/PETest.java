/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.PasswordEncrypter;

/**
 *
 * @author Pham Van Vung
 */
public class PETest {
    public static void main(String[] args) {
        String pass = "mentor1";
        System.out.println(PasswordEncrypter.encryptPassword(pass));
    }


}
