package org.usfirst.frc7108.Robot.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.usfirst.frc7108.Robot.sensors.Gyro;
import java.io.*;

public class GyroTest {

    private static Gyro gyro;
    
    // Setup before tests
    @Before
    public void setup() {
        // Construct gyro class here
        gyro = new Gyro();
    }

    // Test if JUNit is working
    @Test
   public void testTest() {
      String str = "Junit is working";
      assertEquals("Junit is working",str);
   }

   // Test if we can set and get the angle correctly
   @Test
   public void basicAngleTest() {
    gyro.setAngle(90);
    assertEquals(gyro.getAngle(), 90, 0.0001);
   }

   // Test if our robot can turn to a specific angle 
   @Test
   public void rotateTest() throws IOException {

        // Open a file to write data
        File file = new File("/home/tezerv/voltran_ws/data/anglechange.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw  = new BufferedWriter(fw);

        final double angularVelocity =  3; // w in rad/s, this is static for this test
        final double dt = 0.02; // 20 ms constant loop
        double simTime = 0; // Start simulation from 0 seconds
        final double endTime = 1; // The simulation time
        final double angleToStop = 90; // Turn until this angle

        gyro.setRotation(angularVelocity*180/Math.PI);
        while(endTime >= simTime && gyro.getAngle() < angleToStop) {
            gyro.updateGyro(); // read new data from gyro
            simTime += dt; // Update simulation time every loop
            String data = String.format("%f %f %f", simTime, gyro.getAngle(), gyro.getRotation()); // Format the data
            bw.write(data); // Write data to file
            bw.newLine(); // Add newline for better reading
        }
        bw.close(); // Don't forget to close the file!
        assertEquals(90, gyro.getAngle(), 3); // if the angle has reached to target, test is passed
    }

}