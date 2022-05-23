package task_4;

import java.io.*;
import java.util.*;

public class WorkWithCollections {
    public static void main(String[] args) {

        Scanner in = new Scanner((System.in));

        //1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        System.out.println("\nTask 1:\n");
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
        System.out.println("\nTask 2:\n");
        System.out.print("Enter number: ");
        String num = in.nextLine();
        List<Integer> listInteger= new ArrayList<>();
        char [] numbers = String.valueOf(num).toCharArray();
        for (char s:numbers){
            listInteger.add(Integer.parseInt(String.valueOf(s)));
        }
        Collections.reverse (listInteger);
        System.out.println(listInteger);



    //5. Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин
    //   строк.
        System.out.println("\nTask 5:\n");
        String first="Я к вам пишу — чего же боле?\n" +
            "Что я могу еще сказать?\n" +
            "Теперь, я знаю, в вашей воле\n" +
            "Меня презреньем наказать.";
        String second = "У лукоморья дуб зелёный;\n" +
                "Златая цепь на дубе том:\n" +
                "И днём и ночью кот учёный\n" +
                "Всё ходит по цепи кругом;\n" +
                "Идёт направо — песнь заводит,\n" +
                "Налево — сказку говорит.";
        String third="Я помню чудное мгновенье:\n" +
                "Передо мной явилась ты,\n" +
                "Как мимолетное виденье,\n" +
                "Как гений чистой красоты.";
        String[] strings1 = first.split("\n");
        String[] strings2 = second.split("\n");
        String[] strings3 = third.split("\n");
        List<String> listPuhkin= new ArrayList<>();
        for (String s : strings1)
        {
            listPuhkin.add(s);
        }
        for (String s : strings2)
        {
            listPuhkin.add(s);
        }
        for (String s : strings3)
        {
            listPuhkin.add(s);
        }
         Comparator<String> LINE_LENGTH_COMPARATOR = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        };
        Collections.sort(listPuhkin, LINE_LENGTH_COMPARATOR);
        for (String s : listPuhkin)
        {
            System.out.println(s);
        }

//        6. Задать два стека, поменять информацию местами.

//    12. Ввести строки из файла, записать в список ArrayList. Выполнить сортировку строк,
//    используяметод sort() из класса Collections.
        System.out.println("\nTask 12:\n");
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

//        13. Задан файл с текстом на английском языке. Выделить все различные слова. Слова,
//                отличающиеся только регистром букв, считать одинаковыми.
        System.out.println("\nTask 13:\n");
        String text="Advertisers study how people learn so that they can 'teach' them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea ... Here the same technique is being used as with the cool, refreshing drink.";
        String[] strings = text.split("\\W+");
        Integer count = 1;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
        }
        Map<Integer, String> map = new HashMap<>();
        for (String s : strings) {
            map.put(count++,s);
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

    }
}



