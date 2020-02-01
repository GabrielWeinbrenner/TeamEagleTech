package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name="TestAutonomous", group="Test")
public class TestAutonomous extends LinearOpMode {

    private DcMotor driveLeftFront, driveLeftBack, driveRightFront, driveRightBack, drawerSlideLeft, drawerSlideRight;
    private CRServo intake1, intake2;


    @Override
    public void runOpMode()throws InterruptedException{
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

        waitForStart();

        goForward(0.5);

        sleep(5000);

        stopDriving();

        intake1.setPower(0.5);
        intake2.setPower(0.5);

        sleep(1000);

        intake1.setPower(0);
        intake2.setPower(0);

        goForward(0.5);

        sleep(2000);

        stopDriving();

        strafeRight();

        sleep(1000);

        stopDriving();

        strafeLeft();

        sleep(3000);

        goBackward(-0.5);

        sleep(1000);

        stopDriving();
        turnLeft();

        sleep(1000);

        intake1.setPower(0.5);
        intake2.setPower(0.5);

        sleep(1000);

        intake1.setPower(0);
        intake2.setPower(0);

        goForward(0.5);

        sleep(1000);

        stopDriving();

        turnRight();

        sleep(1000);

        goForward(0.5);

        strafeRight();
        sleep(1000);

        stopDriving();

        sleep(1000);

        goBackward(-0.5);

        turnLeft();

        sleep(1000);

        intake1.setPower(0.5);
        intake2.setPower(0.5);

        sleep(1000);

        intake1.setPower(0);
        intake2.setPower(0);

        goForward(0.5);

        sleep(1000);

        stopDriving();

        turnRight();

        sleep(1000);

        goForward(0.5);

        strafeRight();
        sleep(1000);

        stopDriving();

        goBackward(-0.5);
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
