package com.demo.rpc.server;

import com.demo.rpc.client.HelloService;
import com.demo.rpc.client.HelloServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ZhangYuAng
 * @Date 2020/4/9 7:17 下午
 * @Description
 */
public class RPCServer {
    private ExecutorService threadPool;

    public RPCServer() {
        threadPool = Executors.newFixedThreadPool(10);
    }

    public void register(Object service, int port){
        try {
            System.out.println("server starts...");
            ServerSocket server = new ServerSocket(port);
            Socket socket = null;
            while((socket = server.accept()) != null){
                System.out.println("client connected...");
                threadPool.execute(new Processor(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Processor implements Runnable{

        Socket socket;
        Object service;

        public Processor(Socket socket, Object service) {
            this.socket = socket;
            this.service = service;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String methodName = in.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) in.readObject();
                Object[] parameters = (Object[]) in.readObject();
                Method method = service.getClass().getMethod(methodName, parameterTypes);
                try {
                    Object result = method.invoke(service, parameters);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(result);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (IOException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();

        RPCServer server = new RPCServer();
        server.register(helloService, 50001);

    }

}
