package controller;

import util.InMemoryData;
import util.PathName;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class RegisterController {
    private static int userData(){
        Scanner scanner = new Scanner(System.in);
        int data ;
        String stringData;
        while (true){
            System.out.println("Yaz : ");
            stringData = scanner.nextLine();
            if (Integer.valueOf(stringData)<=0){
                System.out.println("Giris hakki 0'dan kücük olamaz. Tekrar deneyin.\n");
            }
            else break;
        }
        data = Integer.valueOf(stringData);
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
    public static void DefaultRightOfEntry(){
        FileWriter(String.valueOf(5));
    }
    public static void FileWriter(String data){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathName.myPathName,false))) {
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    private static void BlogPage(){
        System.out.println("Blog sayfasina hosgeldiniz !!");
        System.out.println("Seciminizi yapın ");
    }
    public static void RedirectToBlog(){
        if(isLogin()){
            System.out.println("Blog sayfasina yönlendiriliyorsunuz...");
            BlogPage();
        }

    }
    public static boolean isLogin(){
        int counter = FileReader();
        while(true){
            if (counter>0){
                Scanner scanner = new Scanner(System.in);
                System.out.println("kullanici adinizi giriniz : ");
                String temporaryUserName = scanner.nextLine();
                System.out.println("sifrenizi giriniz : ");
                String temporaryPassword = scanner.nextLine();
                if (temporaryUserName.equals(InMemoryData.adminUserName) && temporaryPassword.equals(InMemoryData.adminPassword)){
                    System.out.println("tebrikler giris yaptiniz !");
                    FileWriter("5");
                    return true;
                }
                else {
                    counter--;
                    System.out.println("Kullanici adiniz veya sifreniz yanlis kalan giris hakkiniz : "  + counter);
                    FileWriter(Integer.toString(counter));
                }
            }
            else{
                System.out.println("Hesabiniz bloke edildi. Adminlere ulaşın");
                return false;
            }
        }

    }
    public static void main(String[] args) {
        //int rightOfEntry = userData();
        //FileWriter(Integer.toString(rightOfEntry));
        DefaultRightOfEntry();
        RedirectToBlog();
    }
}

