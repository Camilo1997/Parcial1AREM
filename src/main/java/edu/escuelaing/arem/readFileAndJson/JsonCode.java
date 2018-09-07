/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.readFileAndJson;

import edu.escuelaing.arem.linkedList.LinkedList;
import edu.escuelaing.arem.linkedList.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class JsonCode {

    private LinkedList numbers;
    private readFile numbersFile;
    private double maxNumber, minNumber, sumNumbers, multNumbers;
    private ArrayList<Double> numbersJson;
    private String codeJson, allCode;

    public JsonCode() {
        numbersFile = new readFile();
        numbersJson = new ArrayList<Double>();
        maxNumber = 0;
        minNumber = 0;
        sumNumbers = 0;
        multNumbers = 1;
        allCode = "";
        listNumbersToJson();
        createJson();
    }

    public void listNumbersToJson() {
        numbers = numbersFile.getListLinked();
        Node nextNode = numbers.nextNode();
        setMinNumber(nextNode.getInfoNode());
        while (nextNode != null) {
            numbersJson.add(nextNode.getInfoNode());
            isBigger(nextNode.getInfoNode());
            isMinor(nextNode.getInfoNode());
            sum(nextNode.getInfoNode());
            mult(nextNode.getInfoNode());
            nextNode = nextNode.getNextNode();
        }        
    }

    public void createJson() {
        String inQuote = "{";
        String finQuote = "}";
        String numbers = "\"numbers\":" + "\"";
        String sumNumbers = "\"sumNumbers\":" + "\"" + getSumNumbers() + "\"" + ", ";
        String multNumbers = "\"multNumbers\":" + "\"" + getMultNumbers() + "\"" + ", ";
        String maxNumber = "\"maxNumber\":" + "\"" + getMaxNumber() + "\"" + ", ";
        String minNumber = "\"minNumber\":" + "\"" + getMinNumber() + "\"";
        for (Double x : numbersJson) {
            numbers += x + " ";
        }
        numbers += "\"" + ", ";
        allCode = inQuote + numbers + sumNumbers + multNumbers + maxNumber + minNumber + finQuote;
        setCodeJson(allCode);
    }

    public void isBigger(double num) {
        if (num > maxNumber) {
            setMaxNumber(num);
        }
    }

    public void isMinor(double num) {
        if (num < minNumber) {
            setMinNumber(num);
        }
    }

    public void sum(double num) {
        setSumNumbers(getSumNumbers() + num);
    }

    public void mult(double num) {
        setMultNumbers(getMultNumbers() * num);
    }

    public double getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(double maxNumber) {
        this.maxNumber = maxNumber;
    }

    public double getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(double minNumber) {
        this.minNumber = minNumber;
    }

    public double getSumNumbers() {
        return sumNumbers;
    }

    public void setSumNumbers(double sumNumbers) {
        this.sumNumbers = sumNumbers;
    }

    public double getMultNumbers() {
        return multNumbers;
    }

    public void setMultNumbers(double multNumbers) {
        this.multNumbers = multNumbers;
    }

    public String getCodeJson() {
        return codeJson;
    }

    public void setCodeJson(String codeJson) {
        this.codeJson = codeJson;
    }

}
