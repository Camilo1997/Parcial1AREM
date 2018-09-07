/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.principal;

import edu.escuelaing.arem.readFileAndJson.JsonCode;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import spark.Request;
import spark.Response;

/**
 *
 * @author camilolopez
 */
public class codeWebGenerator {

    private String allCode, inHtml, finHtml,
            inBody, finBody, input, inForm,
            finForm, nameInput, resultButton,
            numbersInText, codeDeviation;   
    private Request req;
    private Response res;
    private JsonCode codeJson;

    public codeWebGenerator() {
    }

    public String codeJsonGenerator(Request req, Response res) throws FileNotFoundException, UnsupportedEncodingException {
        this.req = req;
        this.res = res;
        getResults();
        textToAFile();
        codeJson = new JsonCode();
        return codeJson.getCodeJson();
    }

    public void getResults() {
        numbersInText = req.queryParams("numbers");
    }

    public void textToAFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter("file.txt", "UTF-8");
        String number = "";
        for (int i = 0; i < numbersInText.length(); i++) {            
            if (" ".equals(String.valueOf(numbersInText.charAt(i)))) {
                pw.println(number);                
                number = "";
            } else {
                number += numbersInText.charAt(i);
            }
        }        
        pw.close();
    }

    public void setAllCode(String allCode) {
        this.allCode = allCode;
    }

    public String getCodeDeviation() {
        return codeDeviation;
    }

    public void setCodeDeviation(String codeDeviation) {
        this.codeDeviation = codeDeviation;
    }

    public String getNumbersInText() {
        return numbersInText;
    }

    public void setNumbersInText(String numbersInText) {
        this.numbersInText = numbersInText;
    }

}
