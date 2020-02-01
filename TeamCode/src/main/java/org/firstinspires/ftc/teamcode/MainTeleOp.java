package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;


/**
 * Created by ishanarya on 1/5/18.
*/

@TeleOp(name = "DriveTest")
public class MainTeleOp extends OpMode {

    private DcMotor driveLeftFront, driveLeftBack, driveRightFront, driveRightBack, drawerSlideLeft, drawerSlideRight;
    private CRServo intake1, intake2;
    private double intake1Position = 0.0;
    private double intake2Position = 0.0;
    private double speedModifier = 1;
    private double increment = 0.0;

    @Override
    public void init() {

        driveLeftFront = hardwareMap.dcMotor.get("dlf");
        driveLeftBack = hardwareMap.dcMotor.get("dlb");
        driveRightFront = hardwareMap.dcMotor.get("drf");
        driveRightBack = hardwareMap.dcMotor.get("drb");
        drawerSlideLeft = hardwareMap.dcMotor.get("dsl");
        drawerSlideRight = hardwareMap.dcMotor.get("dsr");
        intake1 = hardwareMap.crservo.get("ione");
        intake2 = hardwareMap.crservo.get("itwo");
        intake1.setPower(0);
        intake2.setPower(0);
    }

    @Override
    public void loop() {
        if (gamepad1.y) {
            speedModifier = 0.5;
        } else if (gamepad1.x) {
            speedModifier = 1;
        }

        if(gamepad1.left_bumper){
            intake1.setPower(0.7);
            intake2.setPower(0.7);
        }else if(gamepad1.right_bumper){
            intake1.setPower(-0.7);
            intake2.setPower(-0.7);
        }else{
            intake1.setPower(0);
            intake2.setPower(0);
        }

        if(gamepad1.dpad_left){
            driveLeftFront.setPower(-0.5);
            driveRightFront.setPower(0.5);
            driveRightBack.setPower(-0.5);
            driveLeftBack.setPower(0.5);
        }else if(gamepad1.dpad_right){
            driveLeftFront.setPower(0.5);
            driveRightFront.setPower(-0.5);
            driveRightBack.setPower(0.5);
            driveLeftBack.setPower(-0.5);
        }

        double r = Math.hypot(-gamepad1.left_stick_y, gamepad1.left_stick_x);
        double robotAngle = Math.atan2(gamepad1.left_stick_x, -gamepad1.left_stick_y) + Math.PI / 4;
        double rightX = gamepad1.right_stick_x;

        final double a = r * Math.sin(robotAngle) + rightX;
        final double b = r * Math.cos(robotAngle) - rightX;
        final double c = r * Math.cos(robotAngle) + rightX;
        final double d = r * Math.sin(robotAngle) - rightX;

        drawerSlideLeft.setPower(0.5 * gamepad1.left_trigger);
        drawerSlideRight.setPower(0.5 * gamepad1.left_trigger);
        drawerSlideLeft.setPower(-0.5 * gamepad1.right_trigger);
        drawerSlideRight.setPower(-0.5 * gamepad1.right_trigger);

        driveLeftFront.setPower(-a);
        driveRightFront.setPower(b);
        driveRightBack.setPower(d);
        driveLeftBack.setPower(-c);
//
//        driveLeftFront.setPower(-gamepad1.left_stick_x * speedModifier); //+
//        driveLeftBack.setPower(gamepad1.left_stick_x * speedModifier); //-
//        driveRightBack.setPower(gamepad1.left_stick_x * speedModifier); //+
//        driveRightFront.setPower(-gamepad1.left_stick_x * speedModifier); //-

        telemetry.addData("Gamepad 1 Left Stick X", gamepad1.left_stick_x);
        telemetry.addData("Gamepad 1 Left Stick Y", -gamepad1.left_stick_y);
        telemetry.addData("Gamepad 1 Right Stick X", gamepad1.right_stick_x);

        telemetry.addData("Left Front", -a);
        telemetry.addData("Right Front", b);
        telemetry.addData("Left Back", -c);
        telemetry.addData("Right Back", d);
    }
}