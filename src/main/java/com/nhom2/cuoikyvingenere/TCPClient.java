/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhom2.cuoikyvingenere;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 6789); //địa chỉ cục bộ(có thể thay = đ/c máy server);
            //số hiệu cổng phía server

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            //đọc dữ liệu do người dùng nhập vào -> gửi tới server -> nhận giá trị trở lại
            Scanner s = new Scanner(System.in);
            System.out.println("Nhap du lieu: ");
            String st = s.nextLine();
            //sau khi đọc 1 dòng dl, ghi dòng này  tới server
            System.out.println("Da gui cho Server" + st);
            out.println(st);
            out.flush();

            String line = reader.readLine();
            System.out.println("Da nhan tu Server " + line);

            reader.close(); //đóng luồng đọc
            out.close();    //_____luồng ghi
            socket.close(); // ____socket
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
