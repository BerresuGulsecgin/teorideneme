package org.berre;

import java.sql.*;
import java.util.Scanner;

public class MusteriArama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arananMusteri;


        System.out.println("******************************");
        System.out.println("********MÜŞTERİ ARAMA*********");
        System.out.println("******************************");

        System.out.println();
        System.out.print("Aradığınız müşterinin adı: ");
        arananMusteri=sc.nextLine();

        findByName(arananMusteri);
    }

    private static void findByName(String arananMusteri) {
        String connectionString = "jdbc:postgresql://localhost:5432/Java12SatisV1?user=postgres&password=1234";

        String QUERY_MUSTERİ_SELECT = "select * from tblmusteri where ad ilike ?";


        try (Connection connection = DriverManager.getConnection(connectionString);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_MUSTERİ_SELECT);
        ) {
            //? yerlere değer atama
            preparedStatement.setString(1, "%"+arananMusteri+"%");

            //sorgu çalıştrma
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String ad=resultSet.getString("ad");
                String soyad=resultSet.getString("soyad");
                String telefon=resultSet.getString("telefon");
                String cinsiyet=resultSet.getString("cinsiyet");
                Long dtarih = resultSet.getLong("dtarih");

                System.out.printf("Adı: %-15s Soyad: %-15s Telefon: %-15s Cinsiyet: %-15s DTarihi: %-15s %n",ad,soyad,telefon,cinsiyet,dtarih);
            }

            resultSet.close();



        } catch (SQLException e) {
            System.out.println("save metodunda hata !!"+e);
        }

    }


}
