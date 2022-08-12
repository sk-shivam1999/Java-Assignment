import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int pq;
        pq=sc.nextInt();
        File file=new File("Book1.xlsx");
        XSSFWorkbook wkbook;
        XSSFSheet sheet;
        try{
            FileInputStream excel=new FileInputStream(file);
            wkbook=new XSSFWorkbook(excel);
            sheet=wkbook.getSheet("Sheet1");
            int start=sheet.getFirstRowNum();
            int end=sheet.getLastRowNum();
            int[] locID=new int[end];
            String[] vNO=new String[end];
            String[] vCAT=new String[end];
            String[] avail=new String[end];
            int[] dCNO=new int[end];
            for(int i=start+1,p=0;i<=end;i++,p++){
                locID[p]= (int) sheet.getRow(i).getCell(0).getNumericCellValue();
                vNO[p]=sheet.getRow(i).getCell(1).getStringCellValue();
                vCAT[p]=sheet.getRow(i).getCell(2).getStringCellValue();
                avail[p]=sheet.getRow(i).getCell(3).getStringCellValue();
                dCNO[p]= (int) sheet.getRow(i).getCell(4).getNumericCellValue();

            }
            int[] diff=new int[end];
            for(int i=0;i<locID.length;i++){
                if(pq> locID[i])
                diff[i]= ((pq-locID[i]))*(pq-locID[i]);
                else
                diff[i]= (locID[i]-pq)*(locID[i]-pq);
            }
            ArrayList<String> res=new ArrayList<>();
            //System.out.println(locID[0]+", "+vNO[0]+", "+vCAT[0]+", "+avail[0]+", "+dCNO[0]);

            for(int i=0;i< diff.length;i++){
                for(int j=i+1;j< diff.length;j++){
                    if(diff[i]<diff[j] && avail[i].equals("yes")){
                        res.add(locID[i] + ", " + vNO[i] + ", " + vCAT[i] + ", " + avail[i] + ", " + dCNO[i]);
                    }
                }
            }



            if(diff[diff.length-2]<diff[diff.length-1] || avail[diff.length-2].equals("yes")){
                       res.add(locID[locID.length-2]+", "+vNO[locID.length-2]+", "+vCAT[locID.length-2]+", "+avail[locID.length-2]+", "+dCNO[locID.length-2]);
            }
            if(diff[diff.length-2]>diff[diff.length-1] && avail[diff.length-1].equals("yes")){
                res.add(locID[locID.length-1]+", "+vNO[locID.length-1]+", "+vCAT[locID.length-1]+", "+avail[locID.length-1]+", "+dCNO[locID.length-1]);
            }

            ArrayList<String> fres=new ArrayList<>();
            for(String t:res){
                if(!fres.contains(t)){
                    fres.add(t);
                }
            }

            for(int i=0;i<fres.size();i++){
                System.out.println(fres.get(i));
            }



//            for(int i=1;i<locID.length;i++) {
//                for (int j = i + 1; j < locID.length; j++) {
//                    if (locID[i] < locID[j] && avail[i].equals("yes")) {
//                        System.out.println(locID[i] + ", " + vNO[i] + ", " + vCAT[i] + ", " + avail[i] + ", " + dCNO[i]);
//
//                    }
//                }
//            }
//                    if(locID[locID.length-2]<locID[locID.length-1] || avail[locID.length-2].equals("yes")){
//                        System.out.println(locID[locID.length-2]+", "+vNO[locID.length-2]+", "+vCAT[locID.length-2]+", "+avail[locID.length-2]+", "+dCNO[locID.length-2]);
//
//            }

            /*
            for(int i=0;i<locID.length;i++){
                System.out.print(locID[i]+ " ");
            }
            System.out.println(" ");

            for (int i=0;i< vNO.length;i++){
                System.out.print(vNO[i]+ " ");
            }
            System.out.println(" ");

            for (int i=0;i< vCAT.length;i++){
                System.out.print(vCAT[i]+" ");
            }
            System.out.println(" ");

            for (int i=0;i< avail.length;i++){
                System.out.print(avail[i]+" ");
            }
            System.out.println(" ");

            for (int i=0;i< dCNO.length;i++){
                System.out.print(dCNO[i]+" ");
            }

             */






        }


        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // write your code here
    }
}
