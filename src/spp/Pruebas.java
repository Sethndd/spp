package spp;


import dataaccess.*;
import domain.*;
import sun.security.util.AuthResources_it;
import utilities.AccessCredentialsController;
import utilities.Encrypter;
import utilities.datastructure.DataBaseCredentials;
import utilities.datastructure.EmailCredentials;

import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        //DataBaseCredentials dbc = new DataBaseCredentials("midguetg.ddns.net", "3307", "seth", "Magt2208@1998");
        //EmailCredentials mail = new EmailCredentials("exceptionsSPP@gmail.com", "03042020asd");

        //AccessCredentialsController.writeDataBaseCredentials(dbc);
        //AccessCredentialsController.writeEmailCredentials(mail);
        ManagerDAO dao = new ManagerDAO();
        System.out.println(dao.getManager(1).getOrganizationName());
    }
}

