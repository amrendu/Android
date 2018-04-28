package applabs.myclient;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by amreshkumar on 19/04/18.
 */

public class ClientSocket extends AsyncTask<Void,Void,String> {

    String dstAddress;
    int dstPort;
    String response;
    TextView responsetv;

    ClientSocket(String sAddress, int port, TextView responseTextView)
    {
        dstAddress=sAddress;
        dstPort=port;
        responsetv=responseTextView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        responsetv.setText(str);

    }

    @Override
    protected String doInBackground(Void... params) {

        Socket socket = null;
        try{
            socket = new Socket(dstAddress, dstPort);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];
            int bytesRead;
            InputStream inputStream = socket.getInputStream();

			/*
             * notice: inputStream.read() will block if no data return
			 */
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                response += byteArrayOutputStream.toString("UTF-8");
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();

        } catch (IOException e) {
            e.printStackTrace();
            response = "IOException: " + e.toString();

        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return response;


    }
}
