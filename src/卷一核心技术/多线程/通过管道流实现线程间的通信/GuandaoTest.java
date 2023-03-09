package 卷一核心技术.多线程.通过管道流实现线程间的通信;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//发送数据
class SendThread implements Runnable {
    private PipedOutputStream outputStream = new PipedOutputStream();
    @Override
    public void run() {
        try {
            outputStream.write("管道对接成功！！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}

//接收数据
class RecieveThread implements Runnable {
    private PipedInputStream inputStream = new PipedInputStream();

    @Override
    public void run() {
        byte[] data = new byte[1024];
        try {
            int len = inputStream.read(data);
            System.out.println("对接情况：" + new String(data, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }
}

public class GuandaoTest {
    public static void main(String[] args) {
        SendThread sendThread = new SendThread();
        RecieveThread recieveThread = new RecieveThread();
        PipedOutputStream outputStream = sendThread.getOutputStream();
        try {//建立连接
            outputStream.connect(recieveThread.getInputStream());
            new Thread(sendThread).start();
            new Thread(recieveThread).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
