
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author user
 */
public class TestNetSocket {
    public static void main(String [] args){
        try{
            if(args != null && args.length == 1){
                Integer portNo = Integer.parseInt(args[0]);
                ServerSocket server = new ServerSocket(portNo);
                System.out.println("port:"+ portNo + ",socketServer stared!");
                while(true){
                    Socket socket = server.accept();
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while(br.readLine() != null){
                        System.out.println("input is:" + br.readLine());
                    }
                }
                
                
            }else{
                System.err.println("无输入参数或参数长度不为1，请确认！");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } 
}
