/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class javaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        String numbersPage = "numbers=1+2+3+4+5+6+7+8+"; // El simbolo + al final de los numeros es necesario
        URL pageHeroku = new URL("https://mighty-scrubland-70358.herokuapp.com/results?" + numbersPage);
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(pageHeroku.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }

    }

}
