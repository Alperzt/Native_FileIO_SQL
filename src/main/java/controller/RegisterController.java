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
    public static void FileWriter(String data){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathName.myPathName,false))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void isLogin(){
        int counter = FileReader();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("kullanici adinizi giriniz : ");
            String temporaryUserName = scanner.nextLine();
            System.out.println("sifrenizi giriniz : ");
            String temporaryPassword = scanner.nextLine();
            if (temporaryUserName.equals(PathName.adminUserName) && temporaryPassword.equals(PathName.adminPassword)){
                System.out.println("tebrikler giris yaptiniz !");
                FileWriter("5");
                break;
            }
            else {
                counter--;
                System.out.println("Kullanici adiniz veya sifreniz yanlis kalan giris hakkiniz : "  + counter);
                FileWriter(Integer.toString(counter));
            }
            if (counter == 0){
                System.out.println("Hesabiniz bloke edildi.");
                break;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Giris hakkini belirleyin : ");
        int rightOfEntry = scanner.nextInt();
        FileWriter(Integer.toString(rightOfEntry));
        isLogin();
    }
}
