/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    public static void main(String[] args) throws URISyntaxException, IOException {

        if (Desktop.isDesktopSupported()) {
            String varNumbers = "numbers=1+2+3+4+5+6+"; //El simbolo + al final es necesario
            Desktop.getDesktop().browse(new URI("https://mighty-scrubland-70358.herokuapp.com/results?" + varNumbers));
        }
    }

}
