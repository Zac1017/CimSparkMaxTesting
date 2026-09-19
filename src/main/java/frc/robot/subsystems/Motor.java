package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Motor extends SubsystemBase{
    
    private final SparkMax motor = new SparkMax(0, MotorType.kBrushed);

    public Motor() {
        SparkMaxConfig motorConfig = new SparkMaxConfig();

        motorConfig.smartCurrentLimit(40).
            idleMode(IdleMode.kCoast).
            inverted(false);

        motor.configure(motorConfig, 
            ResetMode.kResetSafeParameters, 
            PersistMode.kPersistParameters
        );
    }

    public void setVelocity(DoubleSupplier velocity) {
        motor.set(velocity.getAsDouble() * Constants.Drive.maxRPS);
        SmartDashboard.putNumber("Motor Velocity", velocity.getAsDouble());
    }
}
