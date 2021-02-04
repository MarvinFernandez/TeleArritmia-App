package BITalino;


import java.util.ArrayList;
import java.util.Vector;

import javax.bluetooth.RemoteDevice;


import java.util.logging.Level;
import java.util.logging.Logger;

public class BitalinoDemo {

    public static Frame[] frame;
    

    public static void main(String[] args) {
        ArrayList<Integer> ECG = new ArrayList();
        ArrayList<Integer> time = new ArrayList();
        ArrayList<Integer> EDA = new ArrayList();
        BITalino bitalino = null;
        try {
            bitalino = new BITalino();
            // Code to find Devices
            //Only works on some OS
            Vector<RemoteDevice> devices = bitalino.findDevices();
            System.out.println(devices);

            //You need TO CHANGE THE MAC ADDRESS
            //You should have the MAC ADDRESS in a sticker in the Bitalino
            String macAddress = "20:18:06:13:01:09";
            
            //Sampling rate, should be 10, 100 or 1000
            int SamplingRate = 100;
            bitalino.open(macAddress, SamplingRate);

            // Start acquisition on analog channels A2 and A6
            // For example, If you want A1, A3 and A4 you should use {0,2,3}
            int[] channelsToAcquire = {1, 5};
            bitalino.start(channelsToAcquire);

            //Read in total 10000000 times
            for (int j = 0; j < 30; j++) {

                //Each time read a block of 10 samples 
                int block_size=100;
                frame = bitalino.read(block_size);

                System.out.println("size block: " + frame.length); //cada vez que imprime el block size es 1 segundo
                
                //Print the samples
                for (int i = 0; i < frame.length; i++) {
                    
                    
                    
                    /*System.out.println((j * block_size + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " "
                    //  + frame[i].analog[2] + " "
                    //  + frame[i].analog[3] + " "
                    //  + frame[i].analog[4] + " "
                    //  + frame[i].analog[5]
                    );
                    */
                    
                    time.add(j*block_size+i);
                    ECG.add(frame[i].analog[0]);
                    EDA.add(frame[i].analog[1]);
                  

                }
            }
            
            for(int k = 0; k< time.size();k++){
                System.out.println("tiempo:"+time.get(k)+"ECG:" + ECG.get(k)+ "EDA: "+ EDA.get(k));
            }
            
            //stop acquisition
            bitalino.stop();
        } catch (BITalinoException ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close bluetooth connection
                if (bitalino != null) {
                    bitalino.close();
                }
            } catch (BITalinoException ex) {
                Logger.getLogger(BitalinoDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
