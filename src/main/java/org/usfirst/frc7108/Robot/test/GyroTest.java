package org.usfirst.frc7108.Robot.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.usfirst.frc7108.Robot.sensors.Gyro;
import java.io.*;

public class GyroTest {

    private static Gyro gyro;
    
    @Before
    public void setup() {
        // Construct classes here
        gyro = new Gyro();
    }

    @Test
   public void testTest() {
      String str = "Junit is working";
      assertEquals("Junit is working",str);
   }

   @Test
   public void basicAngleTest() {
    gyro.setAngle(90);
    assertEquals(gyro.getAngle(), 90, 0.0001);
   }

   @Test
   public void rotateTest() throws IOException{

        // Open a file to write data
        File file = new File("/home/tezerv/voltran_ws/data/anglechange.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw  = new BufferedWriter(fw);

        double angularVelocity =  3; // w in rad/s
        double dt = 0.02; // 20 ms constant loop
        double simTime = 0; // Start simulation from 0 seconds
        double endTime = 1; // The simulation time

        gyro.setRotation(angularVelocity*180/Math.PI);
        while(endTime >= simTime && gyro.getAngle() < 90) {
            gyro.updateGyro();
            simTime += dt;
            String data = String.format("%f %f %f", simTime, gyro.getAngle(), gyro.getRotation());
            bw.write(data);
            bw.newLine();
        }
        bw.close();
        assertEquals(90, gyro.getAngle(), 3);
    }

}