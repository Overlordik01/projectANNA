package com.develop.Application;


import java.io.*;
import java.util.*;

public class Application{

    private Scanner scan = new Scanner(System.in);

    private String maxString = "";
    private int maxLength = 0;

    public static void main(String[] args) {
        Application application = new Application();
        application.TheAnalysisOfSupply();
        application.ComparisonWithPangrams();
    }

    private void TheAnalysisOfSupply(){

        String FileName = "C:\\Users\\overl\\IdeaProjects\\Panпgrams\\src\\main\\java\\com\\develop\\Pangrams\\" + scan.nextLine() + ".txt";
        ArrayList<String> alfabet = new ArrayList<String>();

        try{
            FileInputStream stream = new FileInputStream(FileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                if(maxLength<alfabet.size()){
                    maxString = strLine;
                    maxLength = alfabet.size();
                }
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }

    private void ComparisonWithPangrams(){
        try{
            FileInputStream stream = new FileInputStream("C:\\Users\\overl\\IdeaProjects\\Panпgrams\\src\\main\\java\\com\\develop\\Pangrams\\Pangrams.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(stream));
            ArrayList<String> alfabet = new ArrayList<String>();
            System.out.println("Из Текста предложение '" + maxString + "' существует, с количеством уникальных символов " + maxLength);
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                System.out.println("Панграмма '" + strLine + "' самое большое, с количеством уникальных символов " + alfabet.size());
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }


}
