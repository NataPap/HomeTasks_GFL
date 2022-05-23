package task_4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WorkWithCollections {
    public static void main(String[] args) {

        Scanner in = new Scanner((System.in));

        //1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        List<String> list= new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("file1.txt")))
        {
            //чтение построчно и запись в лист
            String s;
            while((s=br.readLine())!=null){
                list.add(s);
                System.out.println(s);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        Collections.reverse (list);
        for (String i:list) {
            System.out.println(i);
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("file1.txt")))
        {
            for (String i:list) {
                bw.write(i+ "\n");
                bw.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        //2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном
        //порядке.
        System.out.print("Enter number: ");
        String num = in.nextLine();
        List<Integer> listInteger= new ArrayList<>();
        char [] numbers = String.valueOf(num).toCharArray();
        for (char s:numbers){
            listInteger.add(Integer.parseInt(String.valueOf(s)));
        }
        Collections.reverse (listInteger);
        System.out.println(listInteger);



//    //5. Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин
//    //   строк.
//        String first="Я к вам пишу — чего же боле?\n" +
//            "Что я могу еще сказать?\n" +
//            "Теперь, я знаю, в вашей воле\n" +
//            "Меня презреньем наказать.";
//        String second = "У лукоморья дуб зелёный;\n" +
//                "Златая цепь на дубе том:\n" +
//                "И днём и ночью кот учёный\n" +
//                "Всё ходит по цепи кругом;\n" +
//                "Идёт направо — песнь заводит,\n" +
//                "Налево — сказку говорит.";
//        String third="Я помню чудное мгновенье:\n" +
//                "Передо мной явилась ты,\n" +
//                "Как мимолетное виденье,\n" +
//                "Как гений чистой красоты.";

//    12. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк,
//    используяметод sort() из класса Collections.
        List<String> listStr = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
            //чтение построчно и запись в лист
            String s;
            while ((s = br.readLine()) != null) {
                listStr.add(s);
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Collections.sort(listStr);
        for (String i : listStr) {
            System.out.println(i);
        }
    }
}



