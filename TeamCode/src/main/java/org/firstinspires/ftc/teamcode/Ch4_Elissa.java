package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Ch4_Elissa extends OpMode {

    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

        int teamNumber = 19824;
        double motorSpeed = 0.5;
        boolean touchSensorPressed = true;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Touch Sensor", touchSensorPressed);
    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2.0;
        if(gamepad1.left_stick_y < -0.5) {
            telemetry.addData("Left Stick", " is negative and large");
        }
        else if(gamepad1.left_stick_y < 0){
            telemetry.addData("Left Stick", " is negative and small");
        }
        else if(gamepad1.left_stick_y < 0.5){
            telemetry.addData("Left Stick", " is positive and small");
        }
        else {
            telemetry.addData("Left Stick", " is positive and small");
        }
        if(!gamepad1.a) {
            telemetry.addData("A Button", "not pressed");
            telemetry.addData("Left Stick y", gamepad1.left_stick_y * .5);
            //turbo button
            telemetry.addData("Left Stick y", gamepad1.left_stick_y);
            telemetry.addData("Left Stick x", gamepad1.left_stick_x);
            //non crazy mode

        }
        else {
            telemetry.addData("A Button", "pressed");
            telemetry.addData("Left Stick y", gamepad1.left_stick_y * 1);
            //turbo button
            telemetry.addData("Left Stick y", gamepad1.left_stick_x);
            telemetry.addData("Left Stick x", gamepad1.left_stick_y);
            //crazy mode
        }
        telemetry.addData("Y Stick Difference", gamepad1.left_stick_y - gamepad1.right_stick_y);
        telemetry.addData("Left Trigger Sum", gamepad1.left_trigger + gamepad1.right_trigger);
        telemetry.addData("Left stick x", gamepad1.left_stick_x);
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        telemetry.addData("Right stick x", gamepad1.right_stick_x);
        telemetry.addData("Right stick y", gamepad1.right_stick_y);
        telemetry.addData("A button", gamepad1.a);
        telemetry.addData("B button", gamepad1.b);
        telemetry.addData("speed Forward", speedForward);
        telemetry.update();
    }
}
