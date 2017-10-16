/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tmp102_test;

import i2c_dev.I2CUtils;
import i2c_dev.drivers.TMP102Device;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yjkim
 */
public class TMP102_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            TMP102Device tmp102 = new TMP102Device();
/*  
            //
            // Register Read/Write Test...          
            //
            System.out.println("Current Temperature : " + ((tmp102.read(TMP102Device.TEMP_REG)>> 4) * 0.0625));
//            System.out.println("Temperature: " + String.format("0x%04X", tmp102.read(TMP102Device.TEMP_REG)));
            int value = tmp102.read(TMP102Device.CONFIG_REG);
            System.out.println("Config: " + String.format("0x%04X", value));
            System.out.println("Low Limit Temp: " + String.format("0x%04X", tmp102.read(TMP102Device.LOW_LIMIT_REG)));
            System.out.println("High Limit Temp: " + String.format("0x%04X", tmp102.read(TMP102Device.HIGH_LIMIT_REG)));
        
            value |= 0x0010;    // EXTENDED MODE
//            System.out.println(String.format("0x%04X", value));
            tmp102.write(TMP102Device.CONFIG_REG, value);
            I2CUtils.I2Cdelay(1000);
            System.out.println("Config: " + String.format("0x%04X", tmp102.read(TMP102Device.CONFIG_REG)));
            System.out.println("Current Temperature : " + ((tmp102.read(TMP102Device.TEMP_REG)>> 3) * 0.0625));
*/

            int value;
            
            System.out.println("Current Temperature : " + tmp102.readTempC());
            tmp102.setExtendedMode(true);
            System.out.println("Current Temperature : " + tmp102.readTempC());
            tmp102.setExtendedMode(false);
            value = tmp102.read(TMP102Device.CONFIG_REG);
            System.out.println("Config: " + String.format("0x%04X", value));
            System.out.println("Current Temperature : " + tmp102.readTempF());
            tmp102.setLowLimitTempC(-45.5);
            System.out.println("Low Limit Temperature : " + tmp102.readLowLimitTempC());
            tmp102.setHighLimitTempC(105.5);
            System.out.println("Low Limit Temperature : " + tmp102.readHighLimitTempC());
        } catch (IOException ex) {
            Logger.getLogger(TMP102_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
