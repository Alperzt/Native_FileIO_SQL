package controller;

import util.PathName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterController {
    private static String userData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yaz : ");
        String data = scanner.nextLine();
        return data;
    }
    public static int FileReader(){
        String dataToString="";
        int readData;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PathName.myPathName))){
            StringBuilder stringBuilder = new StringBuilder();
            String readrows;
            while ((readrows = bufferedReader.readLine()) != null){
                stringBuilder.append(readrows);
            }
            dataToString = stringBuilder.toString();

        }catch (Exception exception){
            exception.printStackTrace();
        }
        readData = Integer.valueOf(dataToString);
        return readData;
    }
    public static void FileWriter(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathName.myPathName,false))) {
            String data =  userData();
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void isLogin(){

    }
    public static void main(String[] args) {
        FileWriter();
        System.out.println(FileReader());
    }
}
