package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name="autonomousTest", group="Test")

public class autonomousTest extends LinearOpMode {
    private DcMotor driveLeftFront, driveLeftBack, driveRightFront, driveRightBack, drawerSlideLeft, drawerSlideRight;


    @Override
    public void runOpMode() throws InterruptedException {

        driveLeftFront = hardwareMap.dcMotor.get("dlf");
        driveLeftBack = hardwareMap.dcMotor.get("dlb");
        driveRightFront = hardwareMap.dcMotor.get("drf");
        driveRightBack = hardwareMap.dcMotor.get("drb");


        driveLeftBack.setPower(1);
        driveLeftFront.setPower(1);
        driveRightFront.setPower(1);
        driveRightBack.setPower(1);

        sleep(1000);

        driveLeftBack.setPower(0);
        driveLeftFront.setPower(0);
        driveRightFront.setPower(0);
        driveRightBack.setPower(0);
    }

}