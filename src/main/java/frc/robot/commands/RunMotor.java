package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Motor;

public class RunMotor extends Command {
    private final Motor motor;
    private final DoubleSupplier vSupplier;

    public RunMotor(Motor motor, DoubleSupplier velocitySupplier) {
        this.motor = motor;
        this.vSupplier = velocitySupplier;
        addRequirements(motor);
    }

    @Override 
    public void execute() {
        motor.setVelocity(vSupplier);
    }
}
