package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo in.csv (Contendo respectivamente o nome do produto, preço e quantidade separados por ,{virgula}): ");
		String strPath = sc.nextLine();
		File file = new File(strPath);
		List<Product> products = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String line = br.readLine();
			String[] info = line.split(",");
			
			while(line != null){
				products.add(new Product(info[0],Double.parseDouble(info[1]),Integer.parseInt(info[2])));
				line = br.readLine();
				if(line != null) {
					info = line.split(",");
				}
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		String newPath = file.getParent()+"\\out";
		boolean newFolder = new File(newPath).mkdir();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(newPath+"\\summary.csv"))){
			for(Product p : products){
				bw.write(p.toString());
				bw.newLine();
			}
		} catch(IOException e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}

}
