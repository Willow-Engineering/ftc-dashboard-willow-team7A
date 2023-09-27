package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp()
public class Telemetry_CP extends OpMode {
    private DcMotor motor0;

    @Override

    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

        motor0 = hardwareMap.get(DcMotor.class,"motor0");
    }
    @Override

    public void loop() {

        double forwardSpeed = gamepad1.right_stick_y;
        //turbo mode
        if(!gamepad1.a) {
            forwardSpeed *= 0.5;}
        else {
            forwardSpeed *=1;}  //don't need, just here for completion

        telemetry.addData("Forward Speed: ", forwardSpeed);

        // crazy mode
        if(gamepad1.a) {
            telemetry.addData("Right Stick Y: ", gamepad1.right_stick_x);
            telemetry.addData("Right Stick X: ", gamepad1.right_stick_y);}
        else {
            telemetry.addData("Right Stick X: ", gamepad1.right_stick_x);
            telemetry.addData("Right Stick Y: ", gamepad1.right_stick_y);}

        //motor1 runs when B pressed
        if(gamepad1.b) {
            motor0.setPower(1);
        }
        else {
            motor0.setPower(0);
        }

      //the rest of the telemetry from Ch 3
        telemetry.addData("B Button: ", gamepad1.b);
        telemetry.addData("Stick Difference: ", gamepad1.right_stick_y-gamepad1.left_stick_y);
        telemetry.addData("Trigger Sum: ",gamepad1.left_trigger+gamepad1.right_trigger);
        telemetry.update();
    }
}
