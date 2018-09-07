/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.principal;

import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;

/**
 *
 * @author camilolopez
 */
public class App {

    private static codeWebGenerator codeGenerator;

    public static void main(String[] args) {
        port(getPort());
        codeGenerator = new codeWebGenerator();
        get("/results", (req, res) -> codeGenerator.codeJsonGenerator(req, res));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
