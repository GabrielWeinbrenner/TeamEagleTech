package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name="SecondAutonomous", group="Test")

public class SecondAutonomous extends LinearOpMode {
    private DcMotor driveLeftFront, driveLeftBack, driveRightFront, driveRightBack, drawerSlideLeft, drawerSlideRight;
    private CRServo intake1, intake2;
    private Servo servo1, servo2;

    @Override
    public void runOpMode()throws InterruptedException {


        driveLeftFront = hardwareMap.dcMotor.get("dlf");
        driveLeftBack = hardwareMap.dcMotor.get("dlb");
        driveRightFront = hardwareMap.dcMotor.get("drf");
        driveRightBack = hardwareMap.dcMotor.get("drb");

        drawerSlideLeft = hardwareMap.dcMotor.get("dsl");
        drawerSlideRight = hardwareMap.dcMotor.get("dsr");

        servo1 = hardwareMap.servo.get("servo1");
        servo2 = hardwareMap.servo.get("servo2");

        intake1.setPower(0);
        intake2.setPower(0);

        waitForStart();

        goForward(1);

        sleep(1500);

        stopDriving();

        strafeRight();

        sleep(1500);

        stopDriving();

        turnLeft();
        sleep(500);
        turnLeft();
        sleep(500);

        servo1.setPosition(120);
        servo2.setPosition(120);

        stopDriving();
        sleep(1000);

        goForward(1);

        sleep(2000);

        servo1.setPosition(0);
        servo2.setPosition(0);

        for(int i = 0; i < 3; i++) {
            goBackward(1);
            sleep(2000);
            stopDriving();
            turnLeft();
            sleep(1000);
            stopDriving();
            goForward(1);
            sleep(2000);
            stopDriving();
            intake1.setPower(1);
            intake2.setPower(1);
            goForward(1);
            sleep(100);
            stopDriving();
            goBackward(1);
            sleep(2000);
            stopDriving();
            turnLeft();
            sleep(1000);
            stopDriving();
            goForward(1);
            sleep(2000);
            stopDriving();
            turnLeft();
            sleep(1000);
            stopDriving();
            intake1.setPower(-0.5);
            intake2.setPower(-0.5);

        }

        goBackward(1);
        sleep(1500);
        stopDriving();
        stop();


    }

    public void strafeRight(){
        driveLeftFront.setPower(0.5);
        driveRightFront.setPower(-0.5);
        driveRightBack.setPower(0.5);
        driveLeftBack.setPower(-0.5);
    }

    public void strafeLeft(){
        driveLeftFront.setPower(-0.5);
        driveRightFront.setPower(0.5);
        driveRightBack.setPower(-0.5);
        driveLeftBack.setPower(0.5);
    }

    public void stopDriving(){
        driveLeftFront.setPower(0);
        driveRightFront.setPower(0);
        driveRightBack.setPower(0);
        driveLeftBack.setPower(0);
    }

    public void goForward(double speed){
        driveLeftFront.setPower(speed);
        driveRightFront.setPower(speed);
        driveRightBack.setPower(speed);
        driveLeftBack.setPower(speed);
    }

    public void goBackward(double speed){
        driveLeftFront.setPower(speed);
        driveRightFront.setPower(speed);
        driveRightBack.setPower(speed);
        driveLeftBack.setPower(speed);
    }

    public void turnRight(){
        driveLeftFront.setPower(0.5);
        driveRightFront.setPower(0);
        driveRightBack.setPower(0);
        driveLeftBack.setPower(0.5);
    }

    public void turnLeft(){
        driveLeftFront.setPower(0);
        driveRightFront.setPower(0.5);
        driveRightBack.setPower(0.5);
        driveLeftBack.setPower(0);
    }

    }
