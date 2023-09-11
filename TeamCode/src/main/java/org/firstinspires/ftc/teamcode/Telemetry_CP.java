package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Telemetry_CP extends OpMode {
    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
    }

    @Override
    public void loop() {

        double forwardSpeed = gamepad1.right_stick_y;
        //turbo mode
        if(!gamepad1.a) {
            forwardSpeed *= 0.5;}
        else {
            forwardSpeed *=1;}

        telemetry.addData("Forward Speed", forwardSpeed);
        // crazy mode
        if(gamepad1.a) {
            telemetry.addData("Right Stick", gamepad1.right_stick_x);}
        else {
            telemetry.addData("Right Stick", gamepad1.right_stick_y);}
        telemetry.addData("B Button", gamepad1.b);
        telemetry.addData("Stick Difference", gamepad1.right_stick_y-gamepad1.left_stick_y);
        telemetry.addData("Trigger Sum",gamepad1.left_trigger+gamepad1.right_trigger);
        telemetry.update();
    }
}
