package util;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileTutorials {
    private static String currentDate(){
        Date date = new Date();
        return date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"\t";
    }
    private static String userData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Yaz : ");
        String data = scanner.nextLine();
        return data.concat("\n");
    }

    public static void FileWriter(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PathName.myPathName,true))) {
            String data = currentDate() + userData();
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void FileReader(){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PathName.myPathName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String readrows;
            while ((readrows = bufferedReader.readLine()) != null){
                stringBuilder.append(readrows).append("\n");
            }
            System.out.println(stringBuilder);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    public static void FileTutorials(){
        try {
            // C:\EcodationJavaSE\ecodation.txt
            File file = new File(PathName.myPathName);
            System.out.println("File mı ? : " + file.isFile());
            System.out.println("Directory mi ? : " + file.isDirectory());
            System.out.println("Name : " + file.getName());
            System.out.println("Path : " + file.getPath());
            System.out.println("Parent file : " + file.getParentFile());
            System.out.println("Free Space : " + file.getFreeSpace());
            System.out.println("Total Space : " + file.getTotalSpace());
            System.out.println("Absolute Path : " + file.getAbsolutePath());
            System.out.println("Canonical Path : " + file.getCanonicalPath());
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
    public static void main(String[] args){
        //FileWriter();
        FileReader();
    }
}
