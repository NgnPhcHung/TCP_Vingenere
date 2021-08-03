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
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author ASUS
 */
public class TCPServer {

    public static void main(String[] args) {
        try {
            //tạo đối tượng serversocket
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server dang nghe ne ...");
            //sử dụng vòng lập đế sử dụng liên tục -> típ nhận nhìu y/c từ nhìu client gửi tới
            while (true) {
                Socket socket = serverSocket.accept();
                // phương thức accept lắng nghe các y/c từ client gửi tới,
                //nếu có y/c nào đến sẽ tạo ra đối tượng Socket
                //sử dụng Buffer để đọc dữ liệu từ nguồn đầu vào = cách đệm & đọc liền mạch
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //tạo ra luồng ghi dữ liệu ra socket
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                //đọc dữ liệu từ luồng đọc
                String line = reader.readLine();
                //in dữ liệu này ra aka chuyển dữ liệu về phía client
                System.out.println("Da nhan tu Client " + line);
                System.out.println("Da gui toi Client:" + line.toUpperCase());

                out.println(line.toUpperCase());
                //sử dụng flush để data đc đẩy đi 0 nằm trong bộ đệm nữa
                out.flush();
                reader.close(); //đóng luồng đọc
                out.close();    //_____luồng ghi
                socket.close(); // ____socket
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
